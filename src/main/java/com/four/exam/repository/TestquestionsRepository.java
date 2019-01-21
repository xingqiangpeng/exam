package com.four.exam.repository;

import com.four.exam.entity.Testquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TestquestionsRepository extends JpaRepository<Testquestions,Integer> {
    @Query("select t.qbid as qbid,t.tqid as tqid,t.tqbigtitle as tqbigtitle,t.tqnum as tqnum,t.tqscore as tqscore,q.qbtype as qbtpye,q.qbtext as qbtext,q.qboptions as qboptions from Testquestions t left outer join Questionbank q on t.qbid=q.qbid where t.tpid=:tpid order by t.tqnum asc")
    List<Map<String,Object>> findtimu(int tpid);
}
