package com.four.exam.repository;

import com.four.exam.entity.Questionbank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionbankRepository extends JpaRepository<Questionbank,Integer> {
    List<Questionbank> findAllByQboutlineContains(String str);
    List<Questionbank> findAllByQbtextIsLikeAndQbtypeIsLikeAndQbcreatetimeBetween(String qbtext, String qbtype, String starttime, String endtime);
}
