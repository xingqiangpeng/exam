package com.four.exam.web;

import com.four.exam.repository.TestquestionsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Transactional
@RestController
public class TestquestionsController {
    @Resource
    private TestquestionsRepository testquestionsRepository;
    @RequestMapping("tqfindbytimu.do")
    public Object findbytimu(String tpid){
        System.out.println(tpid);
        System.out.println(testquestionsRepository.findtimu(Integer.parseInt(tpid)));
        return testquestionsRepository.findtimu(Integer.parseInt(tpid));
    }
}
