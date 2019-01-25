package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Loginstutestpaper;
import com.four.exam.entity.Stutestpaper;
import com.four.exam.repository.LoginstutestpaperRepository;
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

@Transactional
@RestController
public class StutestpaperController {
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @Resource
    private Stutestscore2Repository stutestscore2Repository;
    @Resource
    private StutestscoreRepository stutestscoreRepository;

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

    @RequestMapping("findbynames.do")
    public Object findbynames(String name,String id){
        return stutestpaperRepository.findBynames(Integer.parseInt(id),name,Integer.parseInt(id));
    }
    @RequestMapping("findbynames2.do")
    public Object findbynames2(String snumber,String id){
        System.out.println(snumber+","+id);
        return stutestpaperRepository.findBynames2(Integer.parseInt(id),snumber,Integer.parseInt(id));
    }
    @RequestMapping("updateBysnumber.do")
    public Object updateBysnumber(String data){
        ArrayList<Map<String,String>> list =
                JSON.parseObject(data, new TypeReference<ArrayList<Map<String,String>>>() {
                });
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
          stutestpaperRepository.updateBysnumber(Double.parseDouble(list.get(i).get("stpscore")) ,Integer.parseInt(list.get(i).get("stpid")));
        }
        return "插入成功";
    }
    @RequestMapping("updateBysnumber2.do")
    public Object updateBysnumber2(String data){
        ArrayList<Map<String,String>> list =
                JSON.parseObject(data, new TypeReference<ArrayList<Map<String,String>>>() {
                });
        for (int i = 0; i < list.size(); i++) {
            stutestpaperRepository.updateBysnumber2(Double.parseDouble(list.get(i).get("stpscore")) ,Integer.parseInt(list.get(i).get("lstpid")));
        }
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
        //找到所有这张试卷的安排的考生
        List<Map<String, Object>> maps = stutestpaperRepository.selFindAllLogin(new Integer(sjid));
        //定义一个集合装数据
        List<Map<String, Object>> selfindall2=new ArrayList<>();

        for (int i = 0; i < maps.size(); i++) {
            //获取到学生的id
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
