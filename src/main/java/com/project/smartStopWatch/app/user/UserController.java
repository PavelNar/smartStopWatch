package com.project.smartStopWatch.app.user;

import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    @Operation(summary = "Uue kasutaja registreerimine")
    public User addUser(@RequestBody @Valid UserRequest request) {
        return userService.registerNewUser(request);
    }
}