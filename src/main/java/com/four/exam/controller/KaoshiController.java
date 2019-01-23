package com.four.exam.controller;

import com.four.exam.entity.Questionbank;
import com.four.exam.entity.Student;
import com.four.exam.entity.Testpaper;
import com.four.exam.entity.Testquestions;
import com.four.exam.repository.QuestionbankRepository;
import com.four.exam.repository.StudentRepository;
import com.four.exam.repository.TestpaperRepository;
import com.four.exam.repository.TestquestionsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
     */
    @ResponseBody
    @RequestMapping(value = "addtestpaper", method = RequestMethod.POST)
    public Object test1(int tpid,String tpname,String tpbeizhu,String tptype,String tpwritemessage,String tpstarttime,String tpendtime,int tpdatitime,String tpfabu){
        System.out.println("asdasd");
        String id=tpid+"";
        Testpaper testpaper=new Testpaper();
        testpaper.setTpname(tpname);
        testpaper.setTpbeizhu(tpbeizhu);
        testpaper.setTptype(tptype);
        testpaper.setTpwritemessage(tpwritemessage);
        testpaper.setTpstartdate(tpstarttime);
        testpaper.setTpenddate(tpendtime);
        testpaper.setTpdatitime(tpdatitime);
        testpaper.setTpfabu(tpfabu);
        if (id==null){
            System.out.println(testpaperRepository.save(testpaper));
            return testpaperRepository.save(testpaper);
        }else{
            testpaper.setTpid(tpid);
            System.out.println(testpaper.toString());
            return testpaperRepository.save(testpaper);
        }
    }

    @RequestMapping("singlequestionsselectbyqbid.do")
    public void singlequestionsselectbyqbid(Integer[] ids){
        System.out.println("我进来了");
        System.out.println(ids.toString());
//        System.out.println(questionbankRepository.findAllById(ids[i]));
        for (int i = 0; i < ids.length; i++) {
//            Iterable<Integer> iterable;
            System.out.println(ids[i]);
            System.out.println(questionbankRepository.findById(ids[i]));
//            System.out.println(questionbankRepository.findAll());
        }
    }
    @RequestMapping("examineeselectbysid.do")
    public void examineeselectbysid(Integer[] ids){
        List<Student> list=new ArrayList<Student>();
        System.out.println("我进来了");
        System.out.println(ids.toString());
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
//            list.add(studentRepository.findById(ids[i]));
            System.out.println(studentRepository.findById(ids[i]));
        }
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
