package com.four.exam.controller;

import com.four.exam.entity.Questionbank;
import com.four.exam.repository.QuestionbankRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class ShitiBJController {
    @Resource
    private QuestionbankRepository questionbankRepository;

    @RequestMapping("tikuxinzeng.do")
    public Object tikuJiazai(String qboutline,String qbtype,String qbtext,String qboptions,String qbanswer,String qbdifficulty){
        Questionbank q=new Questionbank();
        q.setQboutline(qboutline);
        q.setQbtype(qbtype);
        q.setQbtext(qbtext);
        q.setQboptions(qboptions);
        q.setQbanswer(qbanswer);
        q.setQbdifficulty(qbdifficulty);
        q.setQbcreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return  questionbankRepository.save(q);
    }

    @RequestMapping("tikubianji.do")
    public void tiku(Questionbank questionbank){
        questionbankRepository.save(questionbank);
    }
}
