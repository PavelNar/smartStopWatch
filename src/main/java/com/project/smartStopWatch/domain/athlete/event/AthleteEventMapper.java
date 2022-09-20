package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AthleteEventMapper {


    @Mapping(source = "athlete.id", target = "athleteId")
    @Mapping(source = "id", target = "athleteEventId")
    @Mapping(source = "eventLength", target = "athleteEventLength")
    @Mapping(target = "athleteName", qualifiedByName = "athleteEventToName")
    @Mapping(source = "stroke.id", target = "strokeId")
    @Mapping(source = "stroke.type", target = "strokeType")
    @Mapping(source = "startTime", target = "hasStarted", qualifiedByName = "startTimeToHasStartedStatus")
    @Mapping(source = "finishTime", target = "hasFinished", qualifiedByName = "finishTimeToHasFinishedStatus")
    @Mapping(source = "splitCounter", target = "lastSplitCount")
    @Mapping(target = "distanceCovered", qualifiedByName = "athleteEventToDistanceCovered")
    AthleteEventDto athleteEventToAthleteEventDto(AthleteEvent athleteEvent);

    List<AthleteEventDto> athleteEventsToAthleteEventDtos(List<AthleteEvent> athleteEvents);

    @Named("startTimeToHasStartedStatus")
    static Boolean startTimeToHasStartedStatus(Instant startTime) {
        return startTime != null;
    }

    @Named("finishTimeToHasFinishedStatus")
    static Boolean finishTimeToHasFinishedStatus(Instant finishTime) {
        return finishTime != null;
    }

    @Named("athleteEventToDistanceCovered")
    static Integer athleteEventToDistanceCovered(AthleteEvent athleteEvent) {
        return athleteEvent.getSplitCounter() * athleteEvent.getSplitLength();
    }

    @Named("athleteEventToName")
    static String athleteEventToName(AthleteEvent athleteEvent) {
        if (athleteEvent.getAthlete() == null) {
            return "name";
        } else {
            return athleteEvent.getAthlete().getName();
        }
    }


}
