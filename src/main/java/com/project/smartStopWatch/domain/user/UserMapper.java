package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.LoginRequest;
import com.project.smartStopWatch.app.login.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "userName")
    @Mapping(constant = "2", target = "role.id")
    User loginRequestToUser(LoginRequest request);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    LoginResponse userToLoginResponse(User user);
}
