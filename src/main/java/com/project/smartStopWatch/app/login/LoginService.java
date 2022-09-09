package com.project.smartStopWatch.app.login;

import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserMapper;
import com.project.smartStopWatch.domain.user.UserRepository;
import com.project.smartStopWatch.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;


    @Transactional
    public LoginResponse registerNewUser(LoginRequest request) {
        return userService.registerNewUser(request);
    }
    public LoginResponse checkUserExists(LoginRequest loginRequest) {
        User user = userMapper.loginRequestToUser(loginRequest);
        User userExists = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        return userMapper.userToLoginResponse(userExists);
    }
}
