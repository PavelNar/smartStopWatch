package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.user.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public User registerNewUser(UserRequest request) {
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
        return user;
    }
}
