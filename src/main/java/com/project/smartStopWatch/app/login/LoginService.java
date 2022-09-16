package com.project.smartStopWatch.app.login;

import com.project.smartStopWatch.app.login.dto.LoginRequest;
import com.project.smartStopWatch.app.login.dto.LoginResponse;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserMapper;
import com.project.smartStopWatch.domain.user.UserRepository;
import com.project.smartStopWatch.domain.user.UserService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

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

    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        ValidationService.validateUserExists(user);
        return userMapper.userToLoginResponse(user.get());
    }

}
