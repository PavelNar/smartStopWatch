package com.project.smartStopWatch.app.login;

import com.project.smartStopWatch.app.login.LoginRequest;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserMapper;
import com.project.smartStopWatch.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;


    public Boolean checkUserExists(LoginRequest loginRequest) {
        User user = userMapper.loginRequestToUser(loginRequest);
        Boolean userExist = userRepository.existsByUser(user.getUserName(), user.getPassword());
        return userExist;
    }
}
