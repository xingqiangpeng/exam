package com.four.exam;

import com.four.exam.entity.Stutestpaper;
import com.four.exam.repository.StudentRepository;
import com.four.exam.repository.StutestpaperRepository;
import com.four.exam.repository.TestpaperRepository;
import com.four.exam.repository.TestquestionsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamApplicationTests {
    @Resource
    private TestpaperRepository testpaperRepository;
    @Resource
    private TestquestionsRepository testquestionsRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @Test
    public void contextLoads() {
        System.out.println(testquestionsRepository.findtimu(1));
    }
    @Test
    public void contextLoads1() {
        System.out.println(studentRepository.findBySnumberAndSpassword("777777", "666666"));
    }

    @Test
    public void dfafaf(){
        Stutestpaper stutestpaper=new Stutestpaper();
        stutestpaper.setSname("fff");
        stutestpaper.setTpwritemessage("fff");
        stutestpaper.setTpid(1);
        stutestpaper.setTqnum(1);
        stutestpaper.setStpanswer("fdf");
        stutestpaper.setStpscore(0);
//        System.out.println(stutestpaperRepository.findBynames(3,"邓欢"));
        String str="ffasdfsd/ninin.txt";
        System.out.println(str.substring(str.indexOf("/")+1,str.length()));
    }

    @Test
    public void ss(){
        String str="asdasdasd";
        for (int i = 0; i < str.split("").length; i++) {
            System.out.println(str.split("")[i]);
        }

    }

}

