package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Stutestpaper;
import com.four.exam.repository.StutestpaperRepository;
import com.four.exam.repository.Stutestscore2Repository;
import com.four.exam.repository.StutestscoreRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StutestpaperController {
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @Resource
    private Stutestscore2Repository stutestscore2Repository;
    @Resource
    private StutestscoreRepository stutestscoreRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @RequestMapping("saveallstutest.do")
    public Object saveallstutest(String data){
        ArrayList<Stutestpaper> stutestList =
                JSON.parseObject(data, new TypeReference<ArrayList<Stutestpaper>>() {
                });
         stutestpaperRepository.saveAll(stutestList);
        return "插入成功";
    }
    @RequestMapping("selfindall.do")
    public Object selfindall(String sjid){
        List<Map<String, Object>> selfindall = stutestpaperRepository.selFindAll(new Integer(sjid));
        List<Map<String, Object>> selfindall1=new ArrayList<>();
        for (int i = 0; i < selfindall.size(); i++) {
            Object tpwritemessage = selfindall.get(i).get("tpwritemessage");
            if(stutestscore2Repository.findByInformationAndTpid(tpwritemessage.toString(),new Integer(sjid)).size()==0)
            {
                selfindall1.add(selfindall.get(i));
            }
            else {
                List<Map<String, Object>> maps = stutestpaperRepository.selFindScore(new Integer(sjid), tpwritemessage.toString());
                selfindall1.add(maps.get(0));

            }
        }
        return selfindall1;
    }
    @RequestMapping("selfindloginall.do")
    public Object selfindloginall(String sjid){
        List<Map<String, Object>> maps = stutestpaperRepository.selFindAllLogin(new Integer(sjid));
        List<Map<String, Object>> selfindall2=new ArrayList<>();
        for (int i = 0; i < maps.size(); i++) {
            Object object=maps.get(i).get("sid");
            int sid=new Integer(object.toString());
            if(stutestscoreRepository.findBySidAndTpid(sid,new Integer(sjid)).size()==0){
                selfindall2.add(maps.get(i));
            }
            else {
                List<Map<String, Object>> maps1 = stutestpaperRepository.selFindScoreLogin(new Integer(sjid), sid);
                for (int i1 = 0; i1 < maps1.size(); i1++) {
                    selfindall2.add(maps1.get(i1));
                }
            }


        }
        return selfindall2;
    }

}
