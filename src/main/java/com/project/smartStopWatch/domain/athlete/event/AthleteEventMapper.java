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
    @Mapping(expression = "java(athleteEventToName(athleteEvent))", target = "athleteName")
    @Mapping(source = "stroke.id", target = "strokeId")
    @Mapping(source = "stroke.type", target = "strokeType")
    @Mapping(source = "startTime", target = "hasStarted", qualifiedByName = "startTimeToHasStartedStatus")
    @Mapping(source = "finishTime", target = "hasFinished", qualifiedByName = "finishTimeToHasFinishedStatus")
    @Mapping(source = "splitCounter", target = "lastSplitCount")
    @Mapping(expression = "java(athleteEventToDistanceCovered(athleteEvent))", target = "distanceCovered")
    @Mapping(source = "startTime", target = "startTimeMilliseconds", qualifiedByName = "startTimeToHasStartedStatus2")
//    @Mapping(source = "lastSplitTime", target = "distanceCoveredTimeMilliseconds", qualifiedByName = "timestampToMilliseconds")
//    @Mapping(source = "finishTime", target = "finishTimeMilliseconds", qualifiedByName = "timestampToMilliseconds")
    AthleteEventDto athleteEventToAthleteEventDto(AthleteEvent athleteEvent);

    List<AthleteEventDto> athleteEventsToAthleteEventDtos(List<AthleteEvent> athleteEvents);

    @Named("startTimeToHasStartedStatus")
    static Boolean startTimeToHasStartedStatus(Instant startTime) {
        return startTime != null;
    }

    @Named("startTimeToHasStartedStatus2")
    static Long startTimeToHasStartedStatus2(Instant time) {
        return time == null ? null : time.toEpochMilli();
    }

    @Named("finishTimeToHasFinishedStatus")
    static Boolean finishTimeToHasFinishedStatus(Instant finishTime) {
        return finishTime != null;
    }

//    @Named("timestampToMilliseconds")
//    static Long timestampToMilliseconds(Instant start) {
//        return start == null ? null : start.toEpochMilli();
//    }


//    default Long timestampToMilliseconds(Instant start) {
//        return start == null ? null : start.toEpochMilli();
//    }

    default String athleteEventToName(AthleteEvent athleteEvent) {
        if (athleteEvent.getAthlete() == null) {
            return "name";
        } else {
            return athleteEvent.getAthlete().getName();
        }
    }

    default Integer athleteEventToDistanceCovered(AthleteEvent athleteEvent) {
        return athleteEvent.getSplitCounter() * athleteEvent.getSplitLength();
    }

//    default String athleteEventToDistanceCoveredTime(AthleteEvent athleteEvent) {
//        Long start = athleteEvent.getStartTime().toEpochMilli();
//        Long last = athleteEvent.getLastSplitTime().toEpochMilli();
//
//        long resultInMilliseconds = start - last;
//        long millis = resultInMilliseconds % 1000;
//        long second = (resultInMilliseconds / 1000) % 60;
//        long minute = (resultInMilliseconds / (1000 * 60)) % 60;
//        long hour = (resultInMilliseconds / (1000 * 60 * 60)) % 24;
//
//        String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
//
//        return time;
//    }


}
