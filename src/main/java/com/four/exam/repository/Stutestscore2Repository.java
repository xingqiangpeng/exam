package com.four.exam.repository;

import com.four.exam.entity.Student;
import com.four.exam.entity.Stutestscore2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Stutestscore2Repository extends JpaRepository<Stutestscore2,Integer> {
    List<Stutestscore2> findByInformationAndTpid(String information, int tpid);
}
