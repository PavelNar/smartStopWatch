package com.project.smartStopWatch.domain.event.heat;

import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStopRequest;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HeatMapper {

    @Mapping(source = "hasStarted", target = "heatButtonStatus", qualifiedByName = "hasStartedToButtonStatus")
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "start", target = "heatStartTimeMilliseconds", qualifiedByName = "timestampToMilliseconds")
    @Mapping(source = "end", target = "heatFinishTimeMilliseconds", qualifiedByName = "timestampToMilliseconds")
    HeatRow heatToHeatRow(Heat heat);


    List<HeatRow> heatsToHeatRows(List<Heat> heat);

    @Named("hasStartedToButtonStatus")
    static String hasStartedToButtonStatus(Boolean hasStarted) {
        return hasStarted ? "Stop" : "Start";
    }

    @Named("timestampToMilliseconds")
    static Long timestampToMilliseconds(Instant instant) {
        return instant == null ? null : instant.toEpochMilli();
    }

}
