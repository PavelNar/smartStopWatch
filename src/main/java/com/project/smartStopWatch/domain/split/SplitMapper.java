package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(constant = "true", target = "isActive")
    @Mapping(target = "athleteEvent")
    Split athleteEventToSplit(AthleteEvent athleteEvent);

}
