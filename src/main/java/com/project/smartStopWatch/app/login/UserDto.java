package com.project.smartStopWatch.app.login;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotNull
    @Size(min = 3, max = 20, message = "Kasutajanimi peab olema vahemikus 3-20 tähemärki")
    private String userName;
    @NotNull
    @Size(min = 3, max = 255, message = "Parool peab olema vahemikus 3-255 tähemärki")
    private String password;
}
