package com.four.exam.repository;

import com.four.exam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {
    /*@Modifying
    @Query(value = "insert into you_test1(yid,yname) value (?,?)",nativeQuery = true)
    int savaa(String yid,String yname);*/
    List<Student> findBySdepLike(String str);
    List<Student> findBySnameLike(String str);
    List<Student> findBySnameLikeAndScreatdateBetween(String str1,String str2,String str3);

}
