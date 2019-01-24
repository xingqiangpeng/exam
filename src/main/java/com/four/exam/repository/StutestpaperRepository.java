package com.four.exam.repository;

import com.four.exam.entity.Stutestpaper;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StutestpaperRepository extends JpaRepository<Stutestpaper,Integer> {
    @Query(value = "select * from (select s.stpid,s.sname,s.stpanswer,s1.* from Stutestpaper s left outer join (select t.tpid,t.tqnum,t.tqscore,q.qbtype,q.qbtext,q.qbanswer,q.qboptions from Testquestions t left outer join questionbank q on t.qbid=q.qbid  where tpid=?) \n" +
            "s1 on s.tpid=s1.tpid and s.tqnum=s1.tqnum where s.sname=?) u CROSS JOIN (select tpname from testpaper where tpid=?) r",nativeQuery = true)
    List<Map<String,Object>> findBynames(int tpid,String sname,int id);
    @Query(value = "select * from (select s.lstpid,s.snumber,s.lstpanswer,s1.*  from loginstutestpaper s left outer join (select t.tpid,t.tqnum,t.tqscore,q.qbtype,q.qbtext,q.qbanswer,q.qboptions from Testquestions t left outer join questionbank q on t.qbid=q.qbid  where tpid=?) \n" +
            "s1 on s.tpid=s1.tpid and s.tqnum=s1.tqnum where s.snumber=?) u CROSS JOIN (select tpname from testpaper where tpid=?) r",nativeQuery = true)
    List<Map<String,Object>> findBynames2(int tpid,String snumber,int id);
    @Modifying
    @Query("update Stutestpaper set stpscore=?1 where stpid=?2")
    int updateBysnumber(double name,int id);
    @Modifying
    @Query("update Loginstutestpaper set lstpgetscore=?1 where lstpid=?2")
    int updateBysnumber2(double name,int id);
}
