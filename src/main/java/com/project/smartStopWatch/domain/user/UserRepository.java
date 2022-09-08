package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where u.userName = ?1 and u.password = ?2")
    boolean existsByUser(String userName, String password);


}