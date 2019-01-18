package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Testpaper;
import com.four.exam.repository.TestpaperRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@RestController
public class TestpaperController {
    @Resource
    private TestpaperRepository testpaperRepository;
    //查找发布与未发布的
    @RequestMapping("testpaperdata.do")
    public Object testpaperdata(){
        return testpaperRepository.findbytpfabu1();
    }
    //跟新
    @RequestMapping("updatetestpaperdata.do")
    public int testpaperdata1(String name1){
        ArrayList<Testpaper> testpaperList  =
                JSON.parseObject(name1, new TypeReference<ArrayList<Testpaper>>(){});
        return testpaperRepository.save(testpaperList.get(0)).getTpid();
    }
    //删除
    @RequestMapping("deletetestpaperdata.do")
    public String deletetestpaperdata(String id){
        Optional<Testpaper> byId = testpaperRepository.findById(Integer.parseInt(id));
        String str= byId.get().getTpfabu();
        if(str.equals("已完成")||str.equals("进行中")){
            return "已完成或者进行中，无法删除";
        }else {
            testpaperRepository.deleteTestQuestionsBytpid(Integer.parseInt(id));
            testpaperRepository.deleteById(Integer.parseInt(id));

        }
        return "删除成功";
    }
    //请求所有
    @RequestMapping("findallstestpaperdata.do")
    public Object findalltestpaperdata(){
         return testpaperRepository.findAlls();
    }
    //请求指定的进行中，已完成的
    @RequestMapping("findfabutestpaperdata.do")
    public Object findfabutestpaperdata(String fabu){
        return testpaperRepository.findByTpfabu(fabu);
    }
}
