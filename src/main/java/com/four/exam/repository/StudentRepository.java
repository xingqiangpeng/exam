package com.four.exam.repository;

import com.four.exam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findBySdepLike(String str);
    List<Student> findBySnameLike(String str);
    List<Student> findBySnameLikeAndScreatdateBetween(String str1,String str2,String str3);
    List<Student> findBySnumberAndSpassword(String snumber,String spassword);

}
