package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.event.EventRequest;
import com.project.smartStopWatch.app.event.EventResponse;
import com.project.smartStopWatch.app.event.SplitDto;
import com.project.smartStopWatch.app.event.StrokeDto;
import com.project.smartStopWatch.domain.athlete.event.Event;
import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.stroke.Stroke;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

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

    List<StrokeDto> strokeListToStrokeDtoList(List<Stroke> strokes);

    List<SplitDto> splitLengthListToSplitDtoList(List<SplitLength> splits);
}
