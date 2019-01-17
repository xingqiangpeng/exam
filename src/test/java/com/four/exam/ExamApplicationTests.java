package com.four.exam;

import com.four.exam.entity.User;
import com.four.exam.repository.UserRepository;
import org.hibernate.validator.constraints.pl.REGON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamApplicationTests {
    @Resource
    private UserRepository userRepository;
    @Test
    public void contextLoads() {
        User user=new User();
        user.setUsername("dh");
        user.setUsertel("15116441625");
        user.setUserpwd("666");
        user.setUsermessage("管理员");
//        user.setUid(1);
        userRepository.save(user);
    }

}

