package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.app.event.EventRequest;
import com.project.smartStopWatch.app.event.EventResponse;
import org.mapstruct.*;

import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface EventMapper {
    @Mapping(ignore = true, target = "stroke")
    @Mapping(source = "splitLengthId", target = "splitLength.id")
    @Mapping(expression = "java(Instant.now())", target = "dateTime")
    Event eventRequestToEvent(EventRequest eventRequest);

    @InheritInverseConfiguration(name = "eventRequestToEvent")
    EventRequest eventToEventRequest(Event event);

    @InheritConfiguration(name = "eventRequestToEvent")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event updateEventFromEventRequest(EventRequest eventRequest, @MappingTarget Event event);

    Event eventResponseToEvent(EventResponse eventResponse);

    EventResponse eventToEventResponse(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event updateEventFromEventResponse(EventResponse eventResponse, @MappingTarget Event event);
}
