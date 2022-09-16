package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.athleteevent.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteEventMapper {
    @Mapping(source = "athleteId", target = "athlete.id")
    @Mapping(source = "athleteName", target = "athlete.name")
    @Mapping(constant = "true", target = "isActive")
    AthleteEvent athleteEventDtoToAthleteEvent(AthleteEventDto athleteEventDto);

    @InheritInverseConfiguration(name = "athleteEventDtoToAthleteEvent")
    AthleteEventDto athleteEventToAthleteEventDto(AthleteEvent athleteEvent);

    @InheritConfiguration(name = "athleteEventDtoToAthleteEvent")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AthleteEvent updateAthleteEventFromAthleteEventDto(AthleteEventDto athleteEventDto, @MappingTarget AthleteEvent athleteEvent);


    AthleteEvent athleteEventRequestToAthleteEvent(AthleteEventRequest athleteEventRequest);

    @InheritInverseConfiguration(name = "athleteEventRequestToAthleteEvent")
    AthleteEventRequest athleteEventToAthleteEventRequest(AthleteEvent athleteEvent);

    @InheritConfiguration(name = "athleteEventRequestToAthleteEvent")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AthleteEvent updateAthleteEventFromAthleteEventRequest(AthleteEventRequest athleteEventRequest, @MappingTarget AthleteEvent athleteEvent);

    AthleteEvent athleteEventResponseToAthleteEvent(AthleteEventResponse athleteEventResponse);

    AthleteEventResponse athleteEventToAthleteEventResponse(AthleteEvent athleteEvent);


}
