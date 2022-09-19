package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteEventMapper {


    AthleteEventDto athleteEventToAthleteEventDto(AthleteEvent athleteEvents);



    List<AthleteEventDto> athleteEventsToAthleteEventDtos(List<AthleteEvent> athleteEvents);

}
