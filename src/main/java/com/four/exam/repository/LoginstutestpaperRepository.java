package com.four.exam.repository;

import com.four.exam.entity.Loginstutestpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface LoginstutestpaperRepository extends JpaRepository<Loginstutestpaper,Integer> {
    List<Loginstutestpaper> findAllBySnumberAndTpid(String snumber,int tpid);
    //查询登录学生答题情况
    @Query(value = "select f.*,t.tqbigtitle,t.tqscore  from loginstutestpaper f left outer join testquestions t on f.tpid=t.tpid and f.tqnum=t.tqnum where f.snumber=? order by t.tqbigtitle",nativeQuery = true)
    List<Map<String, Object>> findBySnumber(String snumber);
    //查询非登录学生答题情况
    @Query(value = "select f.*,t.tqbigtitle,t.tqscore  from stutestpaper f left outer join testquestions t on f.tpid=t.tpid and f.tqnum=t.tqnum where f.sname=? order by t.tqbigtitle",nativeQuery = true)
    List<Map<String, Object>> findBysname(String sname);
    //根据试卷的id 查询所有的数据
    List<Loginstutestpaper> findByTpidOrderByTqnumAsc(int tpid);
}
