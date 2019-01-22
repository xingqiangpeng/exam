package com.four.exam.repository;

import com.four.exam.entity.Stutestscore2;
import com.four.exam.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface TestpaperRepository extends JpaRepository<Testpaper,Integer> {
    //查询考试进行中信息以及参加了考试的人数
    @Query(value = "select t.*,s.sums from Testpaper t left outer join (select tpid,count(*) sums from stutestscore group by tpid) s on t.tpid=s.tpid   where t.tpfabu in ('未发布','发布中') ",nativeQuery = true)
    List<Map<String,Object>> findbytpfabu1();
    //根据id删除试卷表对应的题目表
    @Modifying
    @Query("delete from Testquestions where tpid=:tpid")
    int deleteTestQuestionsBytpid(int tpid);
    List<Testpaper> findByTpfabu(String tpfabu);
    //查询所有
    @Modifying
    @Query(value = "select t.*,s.sums from Testpaper t left outer join (select tpid,count(*) sums from stutestscore group by tpid) s on t.tpid=s.tpid order by t.tpid desc",nativeQuery = true)
    List<Testpaper> findAlls();
    //根据试卷id查看学生的考试总得分一有安排的
    @Modifying
    @Query(value = "select s.stsid,s.tpid,s.stsscore,u.* from Stutestscore s left outer join Student u on s.sid=u.sid where s.tpid=? and ",nativeQuery = true)
    List<Map<String,Object>> findsrcroBytpid(int tpid);
    //根据试卷id查看学生的考试总得分二没有安排的
    @Modifying
    @Query("select s  from Stutestscore2 s  where s.tpid=:tpid")
    List<Stutestscore2> findsrcroBytpids(int tpid);
    Testpaper findByTpidAndTpfabuNot(int tpid,String tpfabu);
}