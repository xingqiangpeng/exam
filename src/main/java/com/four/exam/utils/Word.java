package com.four.exam.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Word {
    public static void testSimpleWrite(List<Map<String, Object>> list) throws Exception {
        //新建一个文档
        XWPFDocument doc = new XWPFDocument();
        //创建一个段落
        XWPFParagraph para = doc.createParagraph();

        //一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        run = para.createRun();
        run.setBold(true); //加粗
        run.setText(list.get(0).get("tpname") + "");
        run.addCarriageReturn();
        run.setText("第1大题"+"(" + list.get(0).get("qbtype") + ")");
        int dati = Integer.parseInt((String) list.get(0).get("tqbigtitle"));
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt((String) list.get(i).get("tqbigtitle")) != dati) {
                run = para.createRun();
                run.addCarriageReturn();
                run.setBold(true); //加粗
                run.setText("第" + list.get(i).get("tqbigtitle") + "大题");
                run = para.createRun();
                run.setText("(" + list.get(i).get("qbtype") + ")");
                dati = Integer.parseInt((String) list.get(i).get("tqbigtitle"));
            }
            run = para.createRun();
            switch ((String) list.get(i).get("qbtype")) {
                case "单选题":
                    run = zet(run, list.get(i));
                    break;
                case "多选题":
                    run = zet(run, list.get(i));
                    break;
                case "判断题":
                    run = pdt(run, list.get(i));
                    break;
                case "填空题":
                    run = pdt(run, list.get(i));
                    break;
                case "程序题":
                    run = cxt(run, list.get(i));
                    break;
                case "问答题":
                    run = jdt(run, list.get(i));
                    break;
            }
        }
        OutputStream os = new FileOutputStream("D:\\"+list.get(0).get("tpname")+".docx");
        //把doc输出到输出流
        doc.write(os);
        os.flush();
        close(os);
    }

    //选择题
    public static XWPFRun zet(XWPFRun xwpfRun, Map<String, Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  " + map.get("tqnum") + "、" + map.get("qbtext") + "（  ）");
        xwpfRun.addCarriageReturn();
        String[] qboptions = ((String) map.get("qboptions")).split("/");
        for (int i = 0; i < qboptions.length; i++) {
            xwpfRun.setText("    " + qboptions[i]);
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }

    //程序题
    public static XWPFRun cxt(XWPFRun xwpfRun, Map<String, Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  " + map.get("tqnum") + "、" + map.get("qbtext"));
        for (int i = 0; i < 11; i++) {
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }

    //简答题
    public static XWPFRun jdt(XWPFRun xwpfRun, Map<String, Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  " + map.get("tqnum") + "、" + map.get("qbtext"));
        for (int i = 0; i < 4; i++) {
            xwpfRun.addCarriageReturn();
        }
        return xwpfRun;
    }

    //判断题
    public static XWPFRun pdt(XWPFRun xwpfRun, Map<String, Object> map) throws Exception {
        xwpfRun.addCarriageReturn();
        xwpfRun.setText("  " + map.get("tqnum") + "、" + map.get("qbtext") + "（  ）");
        return xwpfRun;
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    static  void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
