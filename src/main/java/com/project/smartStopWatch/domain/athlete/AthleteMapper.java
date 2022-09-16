package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {

    @Mapping(source = "id", target = "athleteId")
    @Mapping(source = "name", target = "athleteName")
    AthleteInfo athleteToAthleteResponse(Athlete athlete);

    List<AthleteInfo> athletesToAthleteInfos(List<Athlete> athletes);
}