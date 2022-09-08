package com.project.smartStopWatch.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "Sisselogimine")
    public Boolean login(LoginRequest loginRequest) {
        return loginService.checkUserExists(loginRequest);
    }
}
