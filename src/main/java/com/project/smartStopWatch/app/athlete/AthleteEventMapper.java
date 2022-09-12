package com.project.smartStopWatch.app.athlete;

import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteEventMapper {
    @Mapping(source = "athleteId", target = "athlete.id")
    @Mapping(source = "athleteName", target = "athlete.name")
    AthleteEvent athleteEventDtoToAthleteEvent(AthleteEventDto athleteEventDto);

    @InheritInverseConfiguration(name = "athleteEventDtoToAthleteEvent")
    AthleteEventDto athleteEventToAthleteEventDto(AthleteEvent athleteEvent);

    @InheritConfiguration(name = "athleteEventDtoToAthleteEvent")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AthleteEvent updateAthleteEventFromAthleteEventDto(AthleteEventDto athleteEventDto, @MappingTarget AthleteEvent athleteEvent);
}
