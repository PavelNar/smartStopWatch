package com.project.smartStopWatch.domain.user;

import com.project.smartStopWatch.app.login.dto.LoginRequest;
import com.project.smartStopWatch.app.login.dto.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(constant = "2", target = "role.id")
    @Mapping(constant = "true", target = "isActive")
    User loginRequestToUser(LoginRequest request);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    LoginResponse userToLoginResponse(User user);

}
