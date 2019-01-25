package com.four.exam;

import com.four.exam.entity.Stutestscore2;
import com.four.exam.repository.TestpaperRepository;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordTest {
    @Resource
    private TestpaperRepository testpaperRepository;
    @Test
    public void testSimpleWrite() throws Exception {
        List<Map<String,Object>> list = testpaperRepository.findTestpaersContent(1);
        System.out.println(list);
        //新建一个文档
        XWPFDocument doc = new XWPFDocument();
        //创建一个段落
        XWPFParagraph para = doc.createParagraph();

        //一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        run = para.createRun();
        run.setBold(true); //加粗
        run.setText(list.get(0).get("tpname")+"");
        run.addCarriageReturn();
        run.setText("第1大题");
        int dati=Integer.parseInt((String)list.get(0).get("tqbigtitle"));
        for (int i = 0; i < list.size(); i++) {
            if(Integer.parseInt((String)list.get(i).get("tqbigtitle"))!=dati){
                run = para.createRun();
                run.addCarriageReturn();
                run.setBold(true); //加粗
                run.setText("第"+list.get(i).get("tqbigtitle")+"大题");
                run=para.createRun();
                run.setText("("+list.get(i).get("qbtype")+")");
                dati=Integer.parseInt((String)list.get(i).get("tqbigtitle"));
            }
            run = para.createRun();
            switch ((String) list.get(i).get("qbtype")) {
                case "单选题":
                    run= zet(run,list.get(i));
                    break;
                case "多选题":
                    run= zet(run,list.get(i));
                    break;
                case "判断题":
                    run= pdt(run,list.get(i));
                    break;
                case "填空题":
                    run= pdt(run,list.get(i));
                    break;
                case "程序题":
                    run= cxt(run,list.get(i));
                    break;
            }
        }
        OutputStream os = new FileOutputStream("D:\\simpleWrite.docx");
        //把doc输出到输出流
        doc.write(os);
        this.close(os);
    }
    //选择题
    public static XWPFRun zet(XWPFRun xwpfRun,Map<String,Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  "+map.get("tqnum")+""+map.get("qbtext")+"（  ）");
        xwpfRun.addCarriageReturn();
        String[] qboptions = ((String) map.get("qboptions")).split("/");
        for (int i = 0; i < qboptions.length; i++) {
            xwpfRun.setText("    "+qboptions[i]);
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }
    //程序题
    public static XWPFRun cxt(XWPFRun xwpfRun,Map<String,Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  "+map.get("tqnum")+""+map.get("qbtext"));
        for (int i = 0; i < 11; i++) {
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }
    //简答题
    public static XWPFRun jdt(XWPFRun xwpfRun,Map<String,Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  "+map.get("tqnum")+""+map.get("qbtext"));
        for (int i = 0; i < 4; i++) {
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }
    //判断题
    public static XWPFRun pdt(XWPFRun xwpfRun,Map<String,Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  "+map.get("tqnum")+""+map.get("qbtext")+"（  ）");
        return xwpfRun;
    }
    /***
     * 写一个表格
     * @throws Exception
     */
    @Test
    public void testWriteTable() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        //创建一个5行5列的表格
        XWPFTable table = doc.createTable(5, 5);
        //这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。
//    table.addNewCol(); //给表格增加一列，变成6列
        table.createRow(); //给表格新增一行，变成6行
        List<XWPFTableRow> rows = table.getRows();
        //表格属性
        CTTblPr tablePr = table.getCTTbl().addNewTblPr();
        //表格宽度
        CTTblWidth width = tablePr.addNewTblW();
        width.setW(BigInteger.valueOf(8000));
        XWPFTableRow row;
        List<XWPFTableCell> cells;
        XWPFTableCell cell;
        int rowSize = rows.size();
        int cellSize;
        for (int i=0; i<rowSize; i++) {
            row = rows.get(i);
            //新增单元格
            row.addNewTableCell();
            //设置行的高度
            row.setHeight(500);
            //行属性
//       CTTrPr rowPr = row.getCtRow().addNewTrPr();
            //这种方式是可以获取到新增的cell的。
//       List<CTTc> list = row.getCtRow().getTcList();
            cells = row.getTableCells();
            cellSize = cells.size();
            for (int j=0; j<cellSize; j++) {
                cell = cells.get(j);
                if ((i+j)%2==0) {
                    //设置单元格的颜色
                    cell.setColor("ff0000"); //红色
                } else {
                    cell.setColor("0000ff"); //蓝色
                }
                //单元格属性
                CTTcPr cellPr = cell.getCTTc().addNewTcPr();
                cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
                if (j == 3) {
                    //设置宽度
                    cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
                }
                cell.setText(i + ", " + j);
            }
        }
        //文件不存在时会自动创建
        OutputStream os = new FileOutputStream("D:\\table.docx");
        //写入文件
        doc.write(os);
        this.close(os);
    }

    /**
     * 关闭输出流
     * @param os
     */
    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
