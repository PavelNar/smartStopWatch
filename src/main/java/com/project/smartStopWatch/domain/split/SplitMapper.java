package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.stopper.dto.split.SplitDto;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(constant = "true", target = "isActive")
    @Mapping(target = "athleteEvent")
    @Mapping(source = "event.id", target = "eventId")
    Split athleteEventToSplit(AthleteEvent athleteEvent);

    @Mapping(source = "start", target = "start", qualifiedByName = "timestampToMilliseconds")
    @Mapping(source = "end", target = "end", qualifiedByName = "timestampToMilliseconds")
    SplitDto splitToSplitDto(Split splits);
    List<SplitDto> splitListToSplitDtoList(List<Split> splits);

    @Named("timestampToMilliseconds")
    static Long timestampToMilliseconds(Instant instant) {
        return instant == null ? null : instant.toEpochMilli();
    }
}
