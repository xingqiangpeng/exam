package com.four.exam.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.four.exam.entity.Student;
import com.four.exam.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Resource
    private StudentRepository studentRepository;
    @RequestMapping("stuselAll.do")
    public Object stuselAll(){
        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }
    @RequestMapping("savestu.do")
    public void getStudent(HttpServletRequest req)
    {
        ArrayList<Student> list=JSON.parseObject(req.getParameter("sdata1"),new TypeReference<ArrayList<Student>>(){});
        studentRepository.save(list.get(0));
        System.out.println(list.get(0));
    }
    @RequestMapping("deleteAll.do")
    public void deleteAllStudent(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            Integer h=(new Integer(ids[i]));
            studentRepository.deleteById(h);

        }
    }
    @RequestMapping("deleteone.do")
    public void deleteOneStudent(String selsid){
        studentRepository.deleteById(new Integer(selsid));
    }
    @RequestMapping("insert.do")
    public  void inserintostudent(String stu){
        System.out.println(stu);
        Student student = JSONObject.parseObject(stu, Student.class);
        //JSONObject jsonObject = JSON.parseObject(stu);
        studentRepository.save(student);
        System.out.println(student);
    }
    @RequestMapping("tiaojian.do")
    public Object selectti(String seltiaojian){


        return studentRepository.findBySdepLike(seltiaojian);
    }
}
