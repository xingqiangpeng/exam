package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Questionbank;
import com.four.exam.repository.QuestionbankRepository;
import com.four.exam.utils.BeanMapUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TikuController {
    @Resource
    private QuestionbankRepository questionbankRepository;

    /**
     * 页面加载时获取到所有的数据
     * @return
     */
    @RequestMapping("tiku.do")
    public Object tikuJiazai(){
        return  questionbankRepository.findAll();
    }

    /**
     * 删除单个题库数据
     * @param qbid 前台传回对应的qbid数据
     */
    @RequestMapping("tikudeleteone.do")
    public void tikuDeleteOne(int qbid){
        questionbankRepository.deleteById(qbid);
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping("tikudeleteall.do")
    public void tikuDeleteAll(String[] ids){
        for (int i = 0; i < ids.length; i++) {
            questionbankRepository.deleteById(Integer.parseInt(ids[i]));
        }
    }

    /**
     * 通过模糊查询到大纲所对应的数据
     * @param qboutline 前台传回的模糊查询字段
     * @return
     */
    @RequestMapping("tikuchaoutline.do")
    public Object tikuChaOutline(String qboutline){
        return questionbankRepository.findAllByQboutlineContains(qboutline);
    }

    /**
     * 通过模糊查询查询到数据
     * @param qbtext 题目内容
     * @param qbtype 题目类型
     * @param starttime 创建的开始时间
     * @param endtime 创建的结束时间
     * @return
     */
    @RequestMapping("tikuchaxun.do")
    public Object tikuchaxunAll(String qbtext,String qbtype,String starttime,String endtime){
        if(qbtype.equals("全部"))
            qbtype="%%";
        else
            qbtype="%"+qbtype+"%";
        if(qbtext==null||qbtext.length()==0)
            qbtext="%%";
        else
            qbtext="%"+qbtext+"%";
        if(starttime==null||starttime.length()==0)     starttime="0";
        if(endtime==null||endtime.length()==0)       endtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return questionbankRepository.findAllByQbtextIsLikeAndQbtypeIsLikeAndQbcreatetimeBetween(qbtext,qbtype,starttime,endtime);
    }
    @RequestMapping("tikufindine.do")
    public Object tikuFindOne(Integer qbid){
        return questionbankRepository.findById(qbid);
    }

    @RequestMapping("saveallquestionbank.do")
    public void saveAllQuestionBank(String allstu) throws Exception {
        List<Map<String, Object>> listMap = JSON.parseObject(allstu, new TypeReference<List<Map<String,Object>>>(){});
        for (int i = 0; i < listMap.size(); i++) {
            Questionbank qb=(Questionbank) BeanMapUtils.mapToBean(listMap.get(i), Questionbank.class);
            qb.setQbcreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            questionbankRepository.save(qb);
        }
    }
}
