package com.four.exam.web;

import com.four.exam.entity.Student;
import com.four.exam.entity.Stutestscore;
import com.four.exam.entity.Stutestscore2;
import com.four.exam.repository.StudentRepository;
import com.four.exam.repository.StutestpaperRepository;
import com.four.exam.repository.Stutestscore2Repository;
import com.four.exam.repository.StutestscoreRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class StuTestScoreController {
    @Resource
    private StutestscoreRepository stutestscoreRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @Resource
    private Stutestscore2Repository stutestscore2Repository;
    @RequestMapping("ancha.do")
    public String ancha(String pjnumber,String pjshiid,String sum){
        List<Student> bySnumber = studentRepository.findBySnumber(pjnumber);
        if(bySnumber.size()!=0)
        {
            int sid=bySnumber.get(0).getSid();
            List<Stutestscore> bySidAndTpid = stutestscoreRepository.findBySidAndTpid(sid, new Integer(pjshiid));
            if(bySidAndTpid.size()!=0)
            {
                int ssid=bySidAndTpid.get(0).getStsid();
                Stutestscore stutestscore=new Stutestscore();
                stutestscore.setStsid(ssid);
                stutestscore.setSid(sid);
                stutestscore.setTpid(new Integer(pjshiid));
                stutestscore.setStsscore(new Double(sum));
                stutestscoreRepository.save(stutestscore);
                return "分数保存成功";
            }
            else {
                Stutestscore stutestscore1=new Stutestscore();
                stutestscore1.setSid(sid);
                stutestscore1.setTpid(new Integer(pjshiid));
                stutestscore1.setStsscore(new Double(sum));
                stutestscoreRepository.save(stutestscore1);
                return "插入成功";
            }

        }
        return "404";
    }
    @RequestMapping("noancha.do")
    public String noCha(String sname,String pjshiid,String sum){
        List<Map<String, Object>> maps = stutestpaperRepository.selFindMessage(sname);
        if(maps.size()!=0){
            String str= maps.get(0).get("tpwritemessage").toString();
            List<Stutestscore2> bt = stutestscore2Repository.findByInformationAndTpid(str, new Integer(pjshiid));
            if(bt.size()!=0)
            {
                int stid=bt.get(0).getStsid();
                Stutestscore2 stutestscore2=new Stutestscore2();
                stutestscore2.setStsid(stid);
                stutestscore2.setInformation(str);
                stutestscore2.setTpid(new Integer(pjshiid));
                stutestscore2.setStsscore(new Double(sum));
                stutestscore2Repository.save(stutestscore2);
                return "分数保存成功";
            }
            else{
                Stutestscore2 stutestscore2=new Stutestscore2();
                stutestscore2.setInformation(str);
                stutestscore2.setTpid(new Integer(pjshiid));
                stutestscore2.setStsscore(new Double(sum));
                stutestscore2Repository.save(stutestscore2);
                return "插入成功";
            }
        }
        return "404";
    }
}
