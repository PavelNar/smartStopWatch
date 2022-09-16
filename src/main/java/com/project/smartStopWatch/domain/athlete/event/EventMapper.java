package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.setup.dto.event.EventSettingsRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface EventMapper {

    @Mapping(ignore = true, target = "stroke")
    @Mapping(source = "splitLengthId", target = "splitLength.id")
    @Mapping(expression = "java(Instant.now())", target = "dateTime")
    Event eventSettingsRequestToEvent(EventSettingsRequest eventSettingsRequest);

    @Mapping(source = "id", target = "eventId")
    EventSettingsResponse eventToEventResponse(Event event);

}
