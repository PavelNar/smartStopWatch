package com.project.smartStopWatch.domain.athlete;
import com.project.smartStopWatch.app.athlete.AthleteRequest;
import com.project.smartStopWatch.app.athlete.AthleteInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteMapper {

    @Mapping(constant = "true", target = "isActive")
    Athlete athleteRequestToAthlete(AthleteRequest athleteRequest);

    @Mapping(constant = "false", target = "isActive")
    Athlete athleteRequestDeleteToAthlete(AthleteRequest athleteRequest);

    AthleteRequest athleteToAthleteRequest(Athlete athlete);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteRequest(AthleteRequest athleteRequest, @MappingTarget Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    Athlete AthleteResponseToAthlete(AthleteInfo athleteInfo);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "id", target = "athleteId")
    AthleteInfo athleteToAthleteResponse(Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Athlete updateAthleteFromAthleteResponse(AthleteInfo athleteInfo, @MappingTarget Athlete athlete);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "athleteId", target = "id")
    Athlete athleteInfoToAthlete(AthleteInfo info);

}
