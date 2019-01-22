package com.four.exam.web;

import com.four.exam.entity.User;
import com.four.exam.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserRepository userRepository;
    @RequestMapping("login.do")
    public Object logined(String username,String password)
    {
       User u=userRepository.findByUsernameAndUserpwd(username,password);
       if(u==null){
           return null;
       }
       else {
           return u;
       }


    }
}
