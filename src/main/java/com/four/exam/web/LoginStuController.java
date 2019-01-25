package com.four.exam.web;



import com.four.exam.entity.Loginstutestpaper;
import com.four.exam.entity.Stutestpaper;
import com.four.exam.repository.LoginstutestpaperRepository;
import com.four.exam.repository.StutestpaperRepository;
import com.four.exam.repository.TestquestionsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
public class LoginStuController {
    @Resource
    private LoginstutestpaperRepository loginstutestpaperRepository;
    @Resource
    private TestquestionsRepository testquestionsRepository;
    @Resource
    private StutestpaperRepository stutestpaperRepository;
    @RequestMapping("xuanon.do")
    public String getXuanScore(String pjnumber,String pjshiid){
        List<Map<String, Object>> maps = testquestionsRepository.findtimu1(new Integer(pjshiid));
        List<Loginstutestpaper> abs = loginstutestpaperRepository.findAllBySnumberAndTpid(pjnumber, new Integer(pjshiid));
        double score=0;
        for (int i = 0; i < maps.size(); i++) {
            for (int j = 0; j < abs.size(); j++) {
                //获取到试卷题目编号
                int tqn=new Integer(maps.get(i).get("tqnum").toString());
                //获取到题目类型
                String tqtil=maps.get(i).get("qbtype").toString();
                //获取到标准答案
                String answer=maps.get(i).get("qbanswer").toString();
                //获取到题目分数
                double tqscore=new Double(maps.get(i).get("tqscore").toString());
                //获取到学生写的答案
                String stuanswer=abs.get(j).getLstpanswer();
                    if(tqn==abs.get(j).getTqnum()){
                        switch (tqtil){
                            case "单选题":
                                if(answer.equals(stuanswer)){
                                    score+=tqscore;
                                    abs.get(j).setLstpgetscore(tqscore);
                                    loginstutestpaperRepository.save(abs.get(j));

                                }
                                else{
                                    abs.get(j).setLstpgetscore(0);
                                    loginstutestpaperRepository.save(abs.get(j));

                                };break;
                            case "多选题":
                                if(answer.length()==stuanswer.length())
                                {
                                   char[] cans=answer.toCharArray();
                                   char[] cstu=stuanswer.toCharArray();
                                   bubbleSort(cans);
                                   bubbleSort(cstu);
                                   String res1=new String(cans);
                                   String res2=new String(cstu);
                                   if(res1.equals(res2)){
                                       score+=tqscore;
                                       abs.get(j).setLstpgetscore(tqscore);
                                       loginstutestpaperRepository.save(abs.get(j));

                                   }
                                   else {
                                       abs.get(j).setLstpgetscore(0);
                                       loginstutestpaperRepository.save(abs.get(j));
                                   }

                                };break;
                            case "判断题":
                                if(answer.equals(stuanswer)){
                                    score+=tqscore;
                                    abs.get(j).setLstpgetscore(tqscore);
                                    loginstutestpaperRepository.save(abs.get(j));

                                }
                                else{
                                    abs.get(j).setLstpgetscore(0);
                                    loginstutestpaperRepository.save(abs.get(j));

                                };break;
                            case "填空题":
                                if(answer.equals(stuanswer)){
                                    score+=tqscore;
                                    abs.get(j).setLstpgetscore(tqscore);
                                    loginstutestpaperRepository.save(abs.get(j));

                                }
                                else{
                                    abs.get(j).setLstpgetscore(0);
                                    loginstutestpaperRepository.save(abs.get(j));

                                };break;


                        }

                    }
            }
        }

        return String.valueOf(score);
    };
    @RequestMapping("noxuan.do")
    public String getNoXuanScore(String sname,String pjshiid){
        List<Map<String, Object>> maps = testquestionsRepository.findtimu1(new Integer(pjshiid));
        List<Stutestpaper> abs = stutestpaperRepository.findAllBySnameAndTpid(sname, new Integer(pjshiid));
        double score=0;
        for (int i = 0; i < maps.size(); i++) {
            for (int j = 0; j < abs.size(); j++) {
                //获取到试卷题目编号
                int tqn=new Integer(maps.get(i).get("tqnum").toString());
                //获取到题目类型
                String tqtil=maps.get(i).get("qbtype").toString();
                //获取到标准答案
                String answer=maps.get(i).get("qbanswer").toString();
                //获取到题目分数
                double tqscore=new Double(maps.get(i).get("tqscore").toString());
                //获取到学生写的答案
                String stuanswer=abs.get(j).getStpanswer();
                if(tqn==abs.get(j).getTqnum()){
                    switch (tqtil){
                        case "单选题":
                            if(answer.equals(stuanswer)){
                                score+=tqscore;
                                abs.get(j).setStpscore(tqscore);
                                stutestpaperRepository.save(abs.get(j));

                            }
                            else{
                                abs.get(j).setStpscore(0);
                                stutestpaperRepository.save(abs.get(j));

                            };break;
                        case "多选题":
                            if(answer.length()==stuanswer.length())
                            {
                                char[] cans=answer.toCharArray();
                                char[] cstu=stuanswer.toCharArray();
                                bubbleSort(cans);
                                bubbleSort(cstu);
                                String res1=new String(cans);
                                String res2=new String(cstu);
                                if(res1.equals(res2)){
                                    score+=tqscore;
                                    abs.get(j).setStpscore(tqscore);
                                    stutestpaperRepository.save(abs.get(j));

                                }
                                else {
                                    abs.get(j).setStpscore(0);
                                    stutestpaperRepository.save(abs.get(j));
                                }

                            };break;
                        case "判断题":
                            if(answer.equals(stuanswer)){
                                score+=tqscore;
                                abs.get(j).setStpscore(tqscore);
                                stutestpaperRepository.save(abs.get(j));

                            }
                            else{
                                abs.get(j).setStpscore(0);
                                stutestpaperRepository.save(abs.get(j));

                            };break;
                        case "填空题":
                            if(answer.equals(stuanswer)){
                                score+=tqscore;
                                abs.get(j).setStpscore(tqscore);
                                stutestpaperRepository.save(abs.get(j));

                            }
                            else{
                                abs.get(j).setStpscore(0);
                                stutestpaperRepository.save(abs.get(j));

                            };break;


                    }

                }
            }
        }
        return String.valueOf(score);
    }

    //比较多选题方法
    public  void bubbleSort(char[] chs) {
        for (int x = 0; x < chs.length - 1; x++) {
            for (int y = 0; y < chs.length - 1 - x; y++) {
                if (chs[y] > chs[y + 1]) {
                    char ch = chs[y];
                    chs[y] = chs[y + 1];
                    chs[y + 1] = ch;
                }
            }
        }
    }
    @RequestMapping("findbtsumber.do")
    public Object findbtsumber(String snumber){
        return loginstutestpaperRepository.findBySnumber(snumber);
    }
    @RequestMapping("findbtsname.do")
    public Object findbtsname(String sname){
        return loginstutestpaperRepository.findBysname(sname);
    }

    @RequestMapping("findbttpid1.do")
    public Object findbttpid1(String tpid){
        return loginstutestpaperRepository.findByTpidOrderByTqnumAsc(Integer.parseInt(tpid));
    }
    @RequestMapping("findbttpid2.do")
    public Object findbttpid2(String tpid){
        return stutestpaperRepository.findByTpidOrderByTqnumAsc(Integer.parseInt(tpid));
    }
}
