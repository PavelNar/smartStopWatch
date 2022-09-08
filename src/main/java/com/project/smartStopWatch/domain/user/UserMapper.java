package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.LoginRequest;
import com.project.smartStopWatch.app.user.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "userName")
    User userRequestToUser(UserRequest request);

    @Mapping(source = "username", target = "userName")
    User loginRequestToUser(LoginRequest loginRequest);

//    @Mapping(source = "id", target = "userId")
//    LoginResponse userToLoginResponse(User user);
}
