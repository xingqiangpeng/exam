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
    }

    @Test
    public void ss(){
        String str="asdasdasd";
        for (int i = 0; i < str.split("").length; i++) {
            System.out.println(str.split("")[i]);
        }

    }
}

