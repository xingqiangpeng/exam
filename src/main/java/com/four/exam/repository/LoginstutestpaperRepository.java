package com.four.exam.repository;

import com.four.exam.entity.Loginstutestpaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginstutestpaperRepository extends JpaRepository<Loginstutestpaper,Integer> {
    List<Loginstutestpaper> findAllBySnumberAndTpid(String snumber,int tpid);
}
