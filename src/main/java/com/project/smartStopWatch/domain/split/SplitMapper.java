package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.stopper.dto.split.SplitDto;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(constant = "true", target = "isActive")
    @Mapping(target = "athleteEvent")
    @Mapping(source = "event.id", target = "eventId")
    Split athleteEventToSplit(AthleteEvent athleteEvent);

    List<SplitDto> splitListToSplitDtoList(List<Split> splits);
}
