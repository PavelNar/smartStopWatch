package com.project.smartStopWatch.user;

import com.project.smartStopWatch.login.LoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "userName")
    User userRequestToUser(UserRequest request);

    @Mapping(source = "username", target = "userName")
    User loginRequestToUser(LoginRequest loginRequest);
}
