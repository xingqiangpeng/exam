package com.four.exam.web;

import com.four.exam.entity.Stutestscore;
import com.four.exam.entity.Stutestscore2;
import com.four.exam.entity.Testpaper;
import com.four.exam.repository.Stutestscore2Repository;
import com.four.exam.repository.StutestscoreRepository;
import com.four.exam.repository.TestpaperRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExamFenXiController {
    @Resource
    private TestpaperRepository testpaperRepository;
    @Resource
    private StutestscoreRepository stutestscoreRepository;
    @Resource Stutestscore2Repository stutestscore2Repository;
    @RequestMapping("finall.do")
    public Object shiJuan(){
        //获得每张试卷
        List<Testpaper> all = testpaperRepository.findAll();
        //获得安排考试的每张试卷的总体数据
        List<Map<String, Object>> loginMessage = testpaperRepository.findLoginMessage();
        //获得不是安排考试的每张试卷的总体数据
        List<Map<String, Object>> mianMessage = testpaperRepository.findMianMessage();

        //定义一个集合
        List<Map<String,Object>> list=new ArrayList<>();

        //对安排考试的数据进行循环
        for (int i = 0; i < loginMessage.size(); i++) {
            //新建一个map集合
            Map<String,Object> map=new HashMap<>();
            //获取到试卷id
            int tpid=new Integer(loginMessage.get(i).get("tpid").toString());
            //获取到试卷分数
            double score=new Double(loginMessage.get(i).get("tpscore").toString());
            //获取到每张试卷的考试的人
            List<Stutestscore> byTpid = stutestscoreRepository.findByTpid(tpid);
            map.putAll(loginMessage.get(i));
            int j=0;
            for (int i1 = 0; i1 < byTpid.size(); i1++) {

                if(byTpid.get(i1).getStsscore()>=score)
                {
                    j++;
                }else {
                    j=j;
                }
            }
            map.put("pnum",(Object)j);
            //将数据添加到list中
            list.add(map);
        }
        //对安排考试的数据进行循环
        for (int i = 0; i < mianMessage.size(); i++) {
            //新建一个map集合
            Map<String,Object> map=new HashMap<>();
            //获取到试卷id
            int tpid=new Integer(mianMessage.get(i).get("tpid").toString());
            //获取到试卷分数
            double score=new Double(mianMessage.get(i).get("tpscore").toString());
            //获取到每张试卷的考试的人
            List<Stutestscore2> byTpid = stutestscore2Repository.findByTpid(tpid);
            map.putAll(mianMessage.get(i));
            int j=0;
            for (int i1 = 0; i1 < byTpid.size(); i1++) {

                if(byTpid.get(i1).getStsscore()>=score)
                {
                    j++;
                }else {
                    j=j;
                }
            }
            map.put("pnum",(Object)j);
            //将数据添加到list中
            list.add(map);
        }
        //定义一个集合
        List<Map<String,Object>> list1=new ArrayList<>();
        List<Map<String, Object>> allMessage = testpaperRepository.findAllMessage();
        for (int i = 0; i < allMessage.size(); i++) {
            Map<String,Object> map1=new HashMap<>();
            map1.putAll(allMessage.get(i));
            list1.add(map1);
        }
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return list;
    };
}
