package com.four.exam.repository;

import com.four.exam.entity.Testquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TestquestionsRepository extends JpaRepository<Testquestions,Integer> {

}
