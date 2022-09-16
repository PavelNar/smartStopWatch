package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {

    @Mapping(source = "id", target = "athleteId")
    AthleteInfo athleteToAthleteResponse(Athlete athlete);

}