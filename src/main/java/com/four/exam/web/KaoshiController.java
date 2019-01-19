package com.four.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class KaoshiController {
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
        System.out.println(tptype+","+tpname+","+tpbeizhu+","+tpwritemessage);
        //处理参数
    }

}
