package com.four.exam.repository;

import com.four.exam.entity.Stutestscore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StutestscoreRepository extends JpaRepository<Stutestscore,Integer> {
    //List<Stutestscore> findBySidAndTpid(Integer snumber, Integer tpid);
    List<Stutestscore> findBySidAndTpid(Integer sid,Integer tpid);
    //通过试卷id获取到每个人的总分
    List<Stutestscore> findByTpid(Integer tpid);

}
