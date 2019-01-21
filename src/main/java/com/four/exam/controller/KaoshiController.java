package com.four.exam.controller;

import com.four.exam.entity.Questionbank;
import com.four.exam.repository.QuestionbankRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class KaoshiController {
    @Resource
    private QuestionbankRepository questionbankRepository;

    @RequestMapping("examinformation.do")
    public void test(HttpServletRequest request) {
        System.out.println(request.getParameter("tpname"));
    }

    /**
     * 通过@RequestBody接收参数
     */
    @ResponseBody
    @RequestMapping(value = "addtestpaper", method = RequestMethod.POST)
    public void getSections(ServletRequest request) {
        System.out.println("wjll");
        //用ServletRequest接收参数
        String tpname=request.getParameter("tpname");
        String tpbeizhu=request.getParameter("tpbeizhu");
        String tptype=request.getParameter("tptype");
        String tpwritemessage=request.getParameter("tpwritemessage");
        String tpstarttime=request.getParameter("tpstarttime");
        String tpendtime=request.getParameter("tpendtime");
        String tpdatitime=request.getParameter("tpdatitime");
        System.out.println(tptype+","+tpname+","+tpbeizhu+","+tpwritemessage+","+tpstarttime+","+tpendtime+","+tpdatitime);
        //处理参数
    }

    @RequestMapping("singlequestionsselectbyqbid.do")
    public void singlequestionsselectbyqbid(Iterable<Integer> ids){
        System.out.println("我进来了");
        System.out.println(ids.toString());
        System.out.println(questionbankRepository.findAllById(ids));
       /* for (int i = 0; i < ids.length; i++) {
            Iterable<Integer> iterable;
            System.out.println(ids[i]);
            System.out.println(questionbankRepository.findById(ids[i]).toString());
//            System.out.println(questionbankRepository.findAll());
        }*/

    }
}
