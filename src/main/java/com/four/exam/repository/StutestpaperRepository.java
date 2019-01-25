package com.four.exam.repository;

import com.four.exam.entity.Loginstutestpaper;
import com.four.exam.entity.Stutestpaper;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface StutestpaperRepository extends JpaRepository<Stutestpaper,Integer> {
    //非登录考生的查询方式
    @Query(value = "select * from (select s.stpid,s.sname,s.stpanswer,s1.* from Stutestpaper s left outer join (select t.tpid,t.tqnum,t.tqscore,q.qbtype,q.qbtext,q.qbanswer,q.qboptions from Testquestions t left outer join questionbank q on t.qbid=q.qbid  where tpid=?) \n" +
            "s1 on s.tpid=s1.tpid and s.tqnum=s1.tqnum where s.sname=?) u CROSS JOIN (select tpname from testpaper where tpid=?) r",nativeQuery = true)
    List<Map<String,Object>> findBynames(int tpid,String sname,int id);
    //登录考生的查询方式
    @Query(value = "select * from (select s.lstpid,s.snumber,s.lstpanswer,s1.*  from loginstutestpaper s left outer join (select t.tpid,t.tqnum,t.tqscore,q.qbtype,q.qbtext,q.qbanswer,q.qboptions,t.tqbigtitle from Testquestions t left outer join questionbank q on t.qbid=q.qbid  where tpid=4) \n" +
            "s1 on s.tpid=s1.tpid and s.tqnum=s1.tqnum where s.snumber='777777') u CROSS JOIN (select tpname from testpaper where tpid=4) r order by tqbigtitle ",nativeQuery = true)
    List<Map<String,Object>> findBynames2(int tpid,String snumber,int id);
    @Modifying
    @Query("update Stutestpaper set stpscore=?1 where stpid=?2")
    int updateBysnumber(double name,int id);
    @Modifying
    @Query("update Loginstutestpaper set lstpgetscore=?1 where lstpid=?2")
    int updateBysnumber2(double name,int id);
    @Transactional
    @Modifying
   // @Query("select new map(e.empno as empno,e.ename as ename,e.job as job,e.sal as sal,d.dname as dname,d.loc as loc) from Emp e,Dept d where e.deptno=d.deptno and d.deptno=:deptno")
    //找到不是安排考试试卷的学生
    @Query("select new map(st.tpwritemessage as tpwritemessage,tp.tptype as tptype,tp.tpscore as tpscore) from Stutestpaper st,Testpaper tp where st.tpid=tp.tpid and st.tpid=?1 group by st.sname")
    List<Map<String,Object>> selFindAll(Integer tpid);
    //找到不是安排考试试卷的学生的总分
    @Query("select new map(st.tpwritemessage as tpwritemessage,tp.tptype as tptype,sc.stsscore as stsscore,tp.tpscore as tpscore) from Stutestpaper st,Testpaper tp,Stutestscore2 sc where st.tpid=tp.tpid and st.tpid=sc.tpid and st.tpwritemessage=sc.information and st.tpid=?1 and sc.information=?2 group by st.sname")
    List<Map<String,Object>> selFindScore(Integer tpid,String information);
    //找到安排考试试卷的学生
    @Query("select new map(s.sid as sid,st.snumber as snumber,s.sname as sname,s.sdep as sdep,tp.tptype as tptype,tp.tpscore as tpscore) from Loginstutestpaper st,Testpaper tp,Student s where st.tpid=tp.tpid and s.snumber=st.snumber and st.tpid=?1 group by st.snumber")
    List<Map<String,Object>> selFindAllLogin(Integer tpid);
    //找到安排考试试卷的学生的总分
   @Query("select new map(s.sid as sid,st.snumber as snumber,s.sname as sname,s.sdep as sdep,tp.tptype as tptype,tp.tpscore as tpscore,stu.stsscore as stsscore) from Loginstutestpaper st,Testpaper tp,Student s,Stutestscore stu where st.tpid=tp.tpid  and s.snumber=st.snumber   and st.tpid=?1 and s.sid=?2 group by st.snumber")
   List<Map<String,Object>> selFindScoreLogin(Integer tpid,Integer sid);
   //找到非安排考生的答题
   List<Stutestpaper> findAllBySnameAndTpid(String sname, int tpid);

   List<Stutestpaper> findByTpidOrderByTqnumAsc(int tpid);
}
