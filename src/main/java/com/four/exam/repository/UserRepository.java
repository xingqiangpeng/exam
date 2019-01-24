package com.four.exam.repository;

import com.four.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsernameAndUserpwd(String username,String password);
    User findByUidAndUserpwd(int uid,String password);
    @Transactional
    @Modifying
    @Query("update User u set u.userpwd=?1 where u.uid=?2")
    int updateUser(String userpwd,int uid);
    @Query(value = "select count(*) from testpaper",nativeQuery = true)
    int countShi();
    @Query(value = "select count(*) from Questionbank",nativeQuery = true)
    int countTi();
}
