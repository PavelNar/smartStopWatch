package com.project.smartStopWatch.app.login;

import com.project.smartStopWatch.app.login.dto.LoginRequest;
import com.project.smartStopWatch.app.login.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/register/user")
    @Operation(summary = "Uue kasutaja registreerimine")
    public LoginResponse registerNewUser(@RequestBody @Valid LoginRequest request) {
        return loginService.registerNewUser(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Sisselogimine")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

}
