package com.four.exam.repository;

import com.four.exam.entity.Testquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface TestquestionsRepository extends JpaRepository<Testquestions,Integer> {
    @Transactional
    @Modifying
    @Query("select t.qbid as qbid,t.tqid as tqid,t.tpid as tpid,t.tqbigtitle as tqbigtitle,t.tqnum as tqnum,t.tqscore as tqscore,q.qbtype as qbtpye,q.qbtext as qbtext,q.qboptions as qboptions from Testquestions t left outer join Questionbank q on t.qbid=q.qbid where t.tpid=:tpid order by t.tqnum asc")
    List<Map<String,Object>> findtimu(int tpid);
    @Query("select new map(tq.tpid as tpid,tq.tqbigtitle as tqbigtitle,tq.tqnum as tqnum,tq.qbid as qbid,tq.tqscore as tqscore,qb.qbtype as qbtype,qb.qbanswer as qbanswer) from Testquestions tq,Questionbank qb where tq.qbid=qb.qbid and tq.tpid=:tpid order by tq.tqnum")
    List<Map<String,Object>> findtimu1(int tpid);
}
