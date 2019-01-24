package com.four.exam.web;

import com.four.exam.entity.Testquestions;
import com.four.exam.repository.TestquestionsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class TestQuestionController {
    @Resource
    private TestquestionsRepository testquestionsRepository;

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
