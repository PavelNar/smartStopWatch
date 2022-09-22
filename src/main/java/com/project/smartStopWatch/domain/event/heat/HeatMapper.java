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
    HeatRow heatToHeatRow(Heat heat);


    List<HeatRow> heatsToHeatRows(List<Heat> heat);


    @Named("hasStartedToButtonStatus")
    static String hasStartedToButtonStatus(Boolean hasStarted) {
        return hasStarted ? "Stop" : "Start";
    }

    @Mapping(source = "eventId", target = "event.id")
    Heat heatStopRequestToHeat(HeatStopRequest heatStopRequest);

    @Mapping(source = "event.id", target = "eventId")
    HeatStopRequest heatToHeatStopRequest(Heat heat);

    @Mapping(source = "eventId", target = "event.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Heat updateHeatFromHeatStopRequest(HeatStopRequest heatStopRequest, @MappingTarget Heat heat);

    @Named("timestampToMilliseconds")
    static Long timestampToMilliseconds(Instant start) {
        return start == null ? null : start.toEpochMilli();
    }

}
