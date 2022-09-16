package com.project.smartStopWatch.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.userName = ?1 and u.password = ?2")
    Optional<User> findByUserNameAndPassword(String userName, String password);

    @Query("select u from User u where u.userName = ?1")
    Optional<User> findByUserName(String userName);

    @Query("select u from User u where u.id = ?1")
    User findUserByUserId(Integer userId);

}