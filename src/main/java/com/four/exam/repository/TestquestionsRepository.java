package com.four.exam.repository;

import com.four.exam.entity.Testquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface TestquestionsRepository extends JpaRepository<Testquestions,Integer> {
    @Query("select new map(t.tqid as tqid,t.tpid as tpid,t.tqbigtitle as tqbigtitle,t.tqnum as tqnum,t.tqscore as tqscore,q.qbid as qbid,q.qboutline as qboutline,q.qbtype as qbtype,q.qbtext as qbtext,q.qboptions as qboptions,q.qbanswer as qbanswer,q.qbdifficulty as qbdifficulty) " +
            "from Testquestions t inner join Questionbank q on q.qbid=t.qbid where t.tpid=:tpid order by t.tqbigtitle")
    List<Map<String,Object>> findTqAndQbByTpid(Integer tpid);

    Testquestions findByTpidAndTqbigtitleAndTqnum(Integer tpid,String tqbigtitle,Integer tqnum);

    @Transactional
    @Modifying
    @Query(value = "update Testquestions set tqnum=:tqnum where tqid=:tqid")
    int updateTqnumBytqid(int tqnum,int tqid);

    @Transactional
    @Modifying
    @Query(value = "update Testquestions set tqscore=:tqscore where tqid=:tqid")
    int updateTqscoreBytqid(double tqscore,int tqid);

    @Transactional
    @Modifying
    @Query(value = "update Testquestions set tqnum=:tqnum,tqbigtitle=:tqbigtitle where tqid=:tqid")
    int updateTqnumAndTqbigtitleBytqid(int tqnum,int tqid,String tqbigtitle);

    @Transactional
    @Modifying
    @Query(value = "delete from Testquestions where tpid=:tpid and tqbigtitle=:tqbigtitle")
    int deleteByTqbigtitleAndTpids(Integer tpid,String tqbigtitle);
    @Transactional
    @Modifying
    @Query("select t.qbid as qbid,t.tqid as tqid,t.tpid as tpid,t.tqbigtitle as tqbigtitle,t.tqnum as tqnum,t.tqscore as tqscore,q.qbtype as qbtpye,q.qbtext as qbtext,q.qboptions as qboptions from Testquestions t left outer join Questionbank q on t.qbid=q.qbid where t.tpid=:tpid order by t.tqnum asc")
    List<Map<String,Object>> findtimu(int tpid);
    @Query("select new map(tq.tpid as tpid,tq.tqbigtitle as tqbigtitle,tq.tqnum as tqnum,tq.qbid as qbid,tq.tqscore as tqscore,qb.qbtype as qbtype,qb.qbanswer as qbanswer) from Testquestions tq,Questionbank qb where tq.qbid=qb.qbid and tq.tpid=:tpid order by tq.tqnum")
    List<Map<String,Object>> findtimu1(int tpid);
}
