package com.four.exam;

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
    @Test
    public void contextLoads() {
    }
    @Test
    public void contextLoads1() {
    }
}

