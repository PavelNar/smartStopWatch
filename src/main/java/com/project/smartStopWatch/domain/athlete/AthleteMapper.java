package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.athlete.AthleteRequest;
import com.project.smartStopWatch.app.athlete.AthleteInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {
    Athlete athleteRequestToAthlete(AthleteRequest athleteRequest);

    AthleteRequest athleteToAthleteRequest(Athlete athlete);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteRequest(AthleteRequest athleteRequest, @MappingTarget Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    Athlete AthleteResponseToAthlete(AthleteInfo athleteInfo);

    @Mapping(source = "user.id", target = "userId")
    AthleteInfo athleteToAthleteResponse(Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteResponse(AthleteInfo athleteInfo, @MappingTarget Athlete athlete);
}
