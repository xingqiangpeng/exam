package com.four.exam.repository;

import com.four.exam.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TestpaperRepository extends JpaRepository<Testpaper,Integer> {
    List<Testpaper> findAllByTpname(String tpname);
}
