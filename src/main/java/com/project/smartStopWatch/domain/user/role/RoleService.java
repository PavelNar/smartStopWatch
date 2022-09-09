package com.project.smartStopWatch.domain.user.role;

import com.project.smartStopWatch.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;


    public void findRole(User user) {
        // TODO: 08.09.2022 kasutades roleService otsid ülesse andmebaasist rolli (role) kasutades selleks roleRepositoryt

    }
}
