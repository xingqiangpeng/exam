package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Student;
import com.four.exam.entity.Testpaper;
import com.four.exam.entity.User;
import com.four.exam.repository.StudentRepository;
import com.four.exam.repository.TestpaperRepository;
import com.four.exam.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
public class TestpaperController {
    @Resource
    private TestpaperRepository testpaperRepository;
    @Resource
    private StudentRepository studentRepository;
    //查找发布与未发布的
    @RequestMapping("testpaperdata.do")
    public Object testpaperdata() {
        return testpaperRepository.findbytpfabu1();
    }

    //跟新
    @RequestMapping("updatetestpaperdata.do")
    public int testpaperdata1(String name1) {
        ArrayList<Testpaper> testpaperList =
                JSON.parseObject(name1, new TypeReference<ArrayList<Testpaper>>() {
                });
        return testpaperRepository.save(testpaperList.get(0)).getTpid();
    }

    //删除
    @RequestMapping("deletetestpaperdata.do")
    public String deletetestpaperdata(String id) {
        Optional<Testpaper> byId = testpaperRepository.findById(Integer.parseInt(id));
        String str = byId.get().getTpfabu();
        if (str.equals("已完成") || str.equals("进行中")) {
            return "已完成或者进行中，无法删除";
        } else {
            testpaperRepository.deleteTestQuestionsBytpid(Integer.parseInt(id));
            testpaperRepository.deleteById(Integer.parseInt(id));

        }
        return "删除成功";
    }

    //请求所有
    @RequestMapping("findallstestpaperdata.do")
    public Object findalltestpaperdata() {return testpaperRepository.findAlls();}

    //请求指定的进行中，已完成的
    @RequestMapping("findfabutestpaperdata.do")
    public Object findfabutestpaperdata(String fabu) { return testpaperRepository.findByTpfabu(fabu); }

    //查看安排考试的学生
    @RequestMapping("findsrcroBytpid.do")
    public Object findsrcroBytpid(String tpid) {return testpaperRepository.findsrcroBytpid(Integer.parseInt(tpid));}

    //查看非安排考试的学生
    @RequestMapping("findsrcroBytpids.do")
    public Object findsrcroBytpids(String tpid) { return testpaperRepository.findsrcroBytpids(Integer.parseInt(tpid)); }

    //通过id找，同时发布状态不为已结束
    @RequestMapping("findbyid.do")
    public Object findbyid(String id) {return testpaperRepository.findByTpidAndTpfabuNot(Integer.parseInt(id), "已结束");}

    //通过id找，同时发布状态不为已结束
    @RequestMapping("findbyids.do")
    public String findbyids(String id,String kouling) {
        Testpaper test = testpaperRepository.findByTpidAndTpfabuNot(Integer.parseInt(id), "已结束");
        String[] splits = test.getTpwritemessage().split("/");
        for (int i=0;i<splits.length;i++){
            String[] split = splits[i].split(":");
            if(split[0].equals("口令")&&split[1].equals(kouling)){
                return "1";
            }
        }
        return "0";
    }
    //安排登录检查同户是否存在
    @RequestMapping("finduserbyunamepwd.do")
    public String finduserby(String username,String pwd,String id) {
        List<Student> students = studentRepository.findBySnumberAndSpassword(username, pwd);
        if (students.size()>0) {
            Student student = students.get(0);
            Optional<Testpaper> byId = testpaperRepository.findById(Integer.parseInt(id));
            String tpwritemessage = byId.get().getTpwritemessage();
            String[] arr1 = tpwritemessage.split(";");
            List<String> sdep=new ArrayList<>();
            List<String> snumber=new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                String[] arr2 = arr1[i].split(":");
                if(arr2[0].equals("sdep")){
                    sdep.add(arr2[1]);
                }
                if(arr2[0].equals("snumber")){
                    snumber.add(arr2[1]);
                }
            }
            if(sdep.contains(student.getSdep())||snumber.contains(student.getSnumber())){
                return student.getSid()+"";
            }
        }
        return "0";
    }

}
