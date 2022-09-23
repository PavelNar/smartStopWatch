package com.project.smartStopWatch.app.login.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be at least 3 characters")
    private String userName;

    @NotNull
    @Size(min = 3, max = 255, message = "Password must be at least 3 characters")
    private String password;
}
