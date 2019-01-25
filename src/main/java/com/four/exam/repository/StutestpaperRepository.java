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
    @Query(value = "select * from (select s.lstpid,s.snumber,s.lstpanswer,s1.*  from loginstutestpaper s left outer join (select t.tpid,t.tqnum,t.tqscore,q.qbtype,q.qbtext,q.qbanswer,q.qboptions,t.tqbigtitle from Testquestions t left outer join questionbank q on t.qbid=q.qbid  where tpid=?) \n" +
            "s1 on s.tpid=s1.tpid and s.tqnum=s1.tqnum where s.snumber=?) u CROSS JOIN (select tpname from testpaper where tpid=?) r order by tqbigtitle ",nativeQuery = true)
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
    @Query(value = "select  st.tpwritemessage, sname,tptype, tpscore from Stutestpaper st,Testpaper tp where st.tpid=tp.tpid and st.tpid=? group by st.sname",nativeQuery = true)
    List<Map<String,Object>> selFindAll(Integer tpid);
    //找到不是安排考试试卷的学生的总分
    @Query(value = "select h.tpwritemessage,sname,tptype, stsscore, tpscore,h.tpid from (select  st.tpwritemessage, sname,tptype, tpscore,tp.tpid from Stutestpaper st,Testpaper tp where st.tpid=tp.tpid  group by st.sname ) h,Stutestscore2 sc where h.tpwritemessage=sc.information and h.tpid=? and sc.information=?",nativeQuery = true)
    List<Map<String,Object>> selFindScore(Integer tpid,String information);
    //找到安排考试试卷的学生

    @Query(value = "select h.sid ,snumber,sname,sdep, tptype, tpscore from(select sid,s.snumber,sname,sdep,tpid from student s,LoginStuTestPaper l where s.snumber=l.snumber group by snumber) h,testpaper ts where h.tpid=ts.tpid and h.tpid=?",nativeQuery = true)
    List<Map<String,Object>> selFindAllLogin(Integer tpid);

    //找到安排考试试卷的学生的总分
   @Query(value = " select h.sid,snumber,sname,sdep,tptype,tpscore,stsscore from(select sid,s.snumber,sname,sdep,tpid from student s,LoginStuTestPaper l where s.snumber=l.snumber group by snumber) h,testpaper ts, stutestscore sc where h.tpid=ts.tpid and sc.sid=h.sid and h.tpid=? and h.sid=? ",nativeQuery = true)
   List<Map<String,Object>> selFindScoreLogin(Integer tpid,Integer sid);
   //找到非安排考生的答题
   List<Stutestpaper> findAllBySnameAndTpid(String sname, int tpid);

   List<Stutestpaper> findByTpidOrderByTqnumAsc(int tpid);
    //找到指定姓名的学生信息
    @Query(value = " select sname,tpwritemessage from stutestpaper where sname=?",nativeQuery = true)
    List<Map<String,Object>> selFindMessage(String sname);


}
