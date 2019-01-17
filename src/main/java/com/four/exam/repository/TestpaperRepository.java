package com.four.exam.repository;

import com.four.exam.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TestpaperRepository extends JpaRepository<Testpaper,Integer> {
    //查询考试进行中信息以及参加了考试的人数
    @Query(value = "select t.*,s.sums from Testpaper t left outer join (select tpid,count(*) sums from stutestscore group by tpid) s on t.tpid=s.tpid   where t.tpfabu in ('未发布','发布中') ",nativeQuery = true)
    List<Map<String,Object>> findbytpfabu1();
}
