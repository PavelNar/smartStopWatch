package com.project.smartStopWatch.app.login;

import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserMapper;
import com.project.smartStopWatch.domain.user.UserRepository;
import com.project.smartStopWatch.domain.user.UserService;
import com.project.smartStopWatch.domain.user.role.RoleService;
import org.mapstruct.control.MappingControl;
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
    private RoleService roleService;

    @Resource
    private UserRepository userRepository;


    @Transactional
    public LoginResponse registerNewUser(LoginRequest request) {
        return userService.registerNewUser(request);
        // TODO: 08.09.2022 kasutades roleService otsid ülesse andmebaasist rolli (role) kasutades selleks roleRepositoryt
        // TODO: 08.09.2022 lood uue objekti klassist UserRole ja paned sinna külge useri ja role
        // TODO: 08.09.2022 kasutades userRoleService ja sealt edasi userRoleRepository salvestad andmebaasi userrole
        // TODO: 08.09.2022 tagastad userresponce objekti mille sisse lisad userId
    }
    public LoginResponse checkUserExists(LoginRequest loginRequest) {
        User user = userMapper.loginRequestToUser(loginRequest);
        User userExists = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        return userMapper.userToLoginResponse(userExists);
    }

}
