package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Loginstutestpaper;
import com.four.exam.entity.Stutestpaper;
import com.four.exam.repository.LoginstutestpaperRepository;
import com.four.exam.repository.StutestpaperRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
public class StutestpaperController {
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @Resource
    private LoginstutestpaperRepository loginstutestpaperRepository;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @RequestMapping("saveallstutest.do")
    public Object saveallstutest(String data){
        ArrayList<Stutestpaper> stutestList =
                JSON.parseObject(data, new TypeReference<ArrayList<Stutestpaper>>() {
                });

        System.out.println(stutestList);
            stutestpaperRepository.saveAll(stutestList);

        return "插入成功";
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @RequestMapping("saveallloginstutest.do")
    public Object saveallloginstutest(String data){
        System.out.println(data);
        ArrayList<Loginstutestpaper> stutestList =
                JSON.parseObject(data, new TypeReference<ArrayList<Loginstutestpaper>>() {
                });
        try {
            loginstutestpaperRepository.saveAll(stutestList);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "插入成功";
    }
}
