package com.four.exam.web;

import com.four.exam.entity.Student;
import com.four.exam.entity.Testpaper;
import com.four.exam.entity.Testquestions;
import com.four.exam.repository.QuestionbankRepository;
import com.four.exam.repository.StudentRepository;
import com.four.exam.repository.TestpaperRepository;
import com.four.exam.repository.TestquestionsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KaoshiController {
    @Resource
    private QuestionbankRepository questionbankRepository;
    @Resource
    private TestpaperRepository testpaperRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private TestquestionsRepository testquestionsRepository;
    @RequestMapping("examinformation.do")
    public void test(HttpServletRequest request) {
        System.out.println(request.getParameter("tpname"));
    }

    /**
     * 通过@RequestBody接收参数
     * 添加考试试卷
     */
    @ResponseBody
    @RequestMapping(value = "addtestpaper", method = RequestMethod.POST)
    public int test1(/*int tpid,*/String tpname,String tpbeizhu,String tptype,String tpwritemessage,String tpstarttime,String tpendtime,int tpdatitime,String tpfabu){
        System.out.println("asdasd");
        Testpaper testpaper=new Testpaper();
        testpaper.setTpname(tpname);
        testpaper.setTpbeizhu(tpbeizhu);
        testpaper.setTptype(tptype);
        testpaper.setTpwritemessage(tpwritemessage);
        testpaper.setTpstartdate(tpstarttime);
        testpaper.setTpenddate(tpendtime);
        testpaper.setTpdatitime(tpdatitime);
        testpaper.setTpfabu(tpfabu);
//        如果通过tpname查找的集合长度不为0意味着数据库中存在该字段名相同的数据，我们只需对齐进行更新即可，否则新增
        if (testpaperRepository.findAllByTpname(tpname).size()!=0){
            int tpid=testpaperRepository.findAllByTpname(tpname).get(0).getTpid();
            testpaper.setTpid(tpid);
            testpaperRepository.save(testpaper);
            return tpid;
        }else{
            testpaperRepository.save(testpaper);
            int tpid=testpaperRepository.findAllByTpname(tpname).get(0).getTpid();
            System.out.println(tpid);
            testpaper.setTpid(tpid);
            return tpid;
        }
    }

    /**
     *
     * @param tpid
     * @param tpscore
     * @param tpfabu
     * @return
     * 更新考试试卷表中的及格分数和发布状态
     */
    @ResponseBody
    @RequestMapping(value = "updatetestpaper", method = RequestMethod.POST)
    public int test1(int tpid,int tpscore,String tpfabu) {
        System.out.println("+++++++++++++++++++++");
        System.out.println(testpaperRepository.updateTpscoreAndTpfabuByTpid(tpid,tpscore,tpfabu));
        return testpaperRepository.updateTpscoreAndTpfabuByTpid(tpid,tpscore,tpfabu);
    }

    /**
     * 通过题库里面题目编号拿到题目信息
     * @param ids
     */
    @RequestMapping("singlequestionsselectbyqbid.do")
    public void singlequestionsselectbyqbid(Integer[] ids){
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
            System.out.println(questionbankRepository.findById(ids[i]));
        }
    }

    /**
     * 拿到指定的学生信息
     * @param ids
     */
    @RequestMapping("examineeselectbysid.do")
    public void examineeselectbysid(Integer[] ids){
        List<Student> list=new ArrayList<Student>();
        System.out.println(ids.toString());
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
            System.out.println(studentRepository.findById(ids[i]));
        }
    }

    /**
     * 查看从题库拿到的题目的试题内容
     * @param qbid
     */
    @RequestMapping("chakanshiti.do")
    public Object chakanshiti(int qbid){
        return questionbankRepository.findById(qbid);
    }

    /**
     * 页面已加载时获取到所有数据
     * @param tpid
     * @return
     */
    @RequestMapping("kaoshi1.do")
    public Object kaoshi111(Integer tpid){
        return testquestionsRepository.findTqAndQbByTpid(tpid);
    }

    /**
     * 更新数据库中的分数
     * @param tqid
     * @param tqscore
     * @return
     */
    @RequestMapping("changescore.do")
    public int changeScore(Integer tqid,Double tqscore){
        return testquestionsRepository.updateTqscoreBytqid(tqscore,tqid);
    }

    /**
     * 试题新增时将数据插入到对应的数据库中
     * @param tpid
     * @param tqbigtitile
     * @param tqnum
     * @param qbid
     * @param tqscore
     * 在插入的同时，将对应的题目序号更新
     * @param tqids
     * @param tqnums
     * @return
     */
    @RequestMapping("testpaperinsert.do")
    public Integer kaoshi222(String tpid,String tqbigtitile,String tqnum,String qbid,String tqscore,String tqids,String tqnums) {
        //题目序号的更新
        changeTqnum(tqids, tqnums);
        //插入对应的数据
        Testquestions tq=new Testquestions();
        tq.setTpid(Integer.parseInt(tpid));
        tq.setTqbigtitle(tqbigtitile);
        tq.setTqnum(Integer.parseInt(tqnum));
        tq.setQbid(Integer.parseInt(qbid));
        tq.setTqscore(Integer.parseInt(tqscore));
        testquestionsRepository.save(tq);
        Testquestions tq1=testquestionsRepository.findByTpidAndTqbigtitleAndTqnum(tq.getTpid(),tq.getTqbigtitle(),tq.getTqnum());
        return tq1.getTqid();
    }

    /**
     * 删除指定数据
     * @param tqid
     * 在删除的同时，将对应的题目序号更新
     * @param tqids
     * @param tqnums
     */
    @RequestMapping("testpaperdelete.do")
    public String testPaperDelete(Integer tqid,String tqids,String tqnums){
        //删除指定的数据
        testquestionsRepository.deleteById(tqid);
        //题目序号的更新
        changeTqnum(tqids, tqnums);
        return "删除成功！";
    }

    @RequestMapping("testpaperdeletebig.do")
    public String testPaperDeleteBig(String tpid,String tqbigtitle,String tqids,String tqnums,String tqbigtitles){
        //删除指定的数据
        System.out.println(testquestionsRepository.deleteByTqbigtitleAndTpids(Integer.parseInt(tpid),tqbigtitle));
        //题目序号和大题序号的更新
        String[] s1=tqids.split(",");
        String[] s2=tqnums.split(",");
        String[] s3=tqbigtitles.split(",");
        for (int i = 0; i < s1.length; i++) {
            if(s1[i]!="0"){
                testquestionsRepository.updateTqnumAndTqbigtitleBytqid(Integer.parseInt(s2[i]),Integer.parseInt(s1[i]),s3[i]);
            }
        }
        return "删除成功！";
    }

    /**
     * 对应的题目序号更新
     * @param tqids
     * @param tqnums
     */
    private void changeTqnum(String tqids, String tqnums) {
        String[] s1=tqids.split(",");
        String[] s2=tqnums.split(",");
        for (int i = 0; i < s1.length; i++) {
            if(s1[i]!="0"){
                testquestionsRepository.updateTqnumBytqid(Integer.parseInt(s2[i]),Integer.parseInt(s1[i]));
            }
        }
    }


}
