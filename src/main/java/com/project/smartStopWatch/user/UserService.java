package com.project.smartStopWatch.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public void registerNewUser(UserRequest request) {
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
    }
}
