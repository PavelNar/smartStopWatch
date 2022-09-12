package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.UserDto;
import com.project.smartStopWatch.app.login.LoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public LoginResponse registerNewUser(UserDto request) {
        User user = userMapper.userDtoToUser(request);
        userRepository.save(user);
        return userMapper.userToLoginResponse(user);
    }
}
