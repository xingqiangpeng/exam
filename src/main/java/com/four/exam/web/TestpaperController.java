package com.four.exam.web;

import com.four.exam.entity.Testpaper;
import com.four.exam.repository.TestpaperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestpaperController {
    @Resource
    private TestpaperRepository testpaperRepository;
    @RequestMapping("testpaperdata.do")
    public Object testpaperdata(){
        return testpaperRepository.findbytpfabu1();
    }
}
