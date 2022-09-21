package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {

    @Mapping(source = "name", target = "athleteName")
    @Mapping(source = "id", target = "athleteId")
    AthleteInfo athleteToAthleteInfo(Athlete athlete);


    List<AthleteInfo> athletesToAthleteInfos(List<Athlete> athletes);

}