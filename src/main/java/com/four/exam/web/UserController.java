package com.four.exam.web;


import com.alibaba.fastjson.JSONObject;
import com.four.exam.entity.User;
import com.four.exam.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    private UserRepository userRepository;
    @RequestMapping("person.do")
    public Object getPerson(String uid){
        System.out.println(uid);
        return userRepository.findById(new Integer(uid));
    }
    @RequestMapping("saveperson.do")
    public void savePerson(String psemess)
    {
        User user = JSONObject.parseObject(psemess, User.class);
        userRepository.save(user);
    }
    @RequestMapping("updatepwd.do")
    public String updateMi(String uid,String pwd1,String pwd2){
        User user=userRepository.findByUidAndUserpwd(new Integer(uid),pwd1);
        if(user==null)
        {
            return "初始密码错误";
        }
        else {

           if(userRepository.updateUser(pwd2,new Integer(uid))==1){
               return "密码重置成功";
           }
         return "请重新尝试";
        }

    }
}
