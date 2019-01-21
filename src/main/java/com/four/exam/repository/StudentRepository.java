package com.four.exam.repository;

import com.four.exam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findBySnumberAndSpassword(String snumber,String spassword);
}
