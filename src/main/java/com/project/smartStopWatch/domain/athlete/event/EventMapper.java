package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.event.EventRequest;
import com.project.smartStopWatch.app.event.EventResponse;
import com.project.smartStopWatch.app.event.GlobalSettingsDropdownDto;
import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.stroke.Stroke;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface EventMapper {
    @Mapping(source = "strokeId", target = "stroke.id")
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


    GlobalSettingsDropdownDto globalSettingsDropDownToGlobalSettingsDropDownDto(List<SplitLength> all, List<Stroke> all1);
}
