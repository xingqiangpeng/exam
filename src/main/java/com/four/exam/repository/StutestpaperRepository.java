package com.four.exam.repository;

import com.four.exam.entity.Loginstutestpaper;
import com.four.exam.entity.Stutestpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface StutestpaperRepository extends JpaRepository<Stutestpaper,Integer> {
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



}
