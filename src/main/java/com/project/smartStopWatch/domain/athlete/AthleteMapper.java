package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.athlete.AthleteRequest;
import com.project.smartStopWatch.app.athlete.AthleteResponce;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {
    Athlete athleteRequestToAthlete(AthleteRequest athleteRequest);

    AthleteRequest athleteToAthleteRequest(Athlete athlete);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteRequest(AthleteRequest athleteRequest, @MappingTarget Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    Athlete AthleteResponseToAthlete(AthleteResponce athleteResponce);

    @Mapping(source = "user.id", target = "userId")
    AthleteResponce athleteToAthleteResponse(Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteResponse(AthleteResponce athleteResponce, @MappingTarget Athlete athlete);
}
