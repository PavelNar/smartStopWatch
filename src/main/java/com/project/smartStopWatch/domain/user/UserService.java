package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.dto.LoginRequest;
import com.project.smartStopWatch.app.login.dto.LoginResponse;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public LoginResponse registerNewUser(LoginRequest request) {
        Optional<User> userName = userRepository.findByUserName(request.getUserName());
        ValidationService.validateUsernameExists(userName);
        User user = userMapper.loginRequestToUser(request);
        userRepository.save(user);
        return userMapper.userToLoginResponse(user);
    }

    public User findUserByUserId(Integer userId) {
        return userRepository.findUserByUserId(userId);
    }

}
