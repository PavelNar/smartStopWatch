package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.LoginRequest;
import com.project.smartStopWatch.app.login.LoginResponse;
import com.project.smartStopWatch.app.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "userName")
    User loginRequestToUser(LoginRequest request);

    @Mapping(source = "id", target = "userId")
    LoginResponse userToLoginResponse(User user);
}
