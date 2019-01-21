package com.four.exam.repository;

import com.four.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
//    List<User> findByUsernameAndUserpwd(String username,String userpwd);
}
