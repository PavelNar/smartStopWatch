package com.project.smartStopWatch.domain.event.heat;

import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HeatMapper {

    @Mapping(source = "hasStarted", target = "heatButtonStatus", qualifiedByName = "hasStartedToButtonStatus")
    HeatRow heatToHeatRow(Heat heat);


    List<HeatRow> heatsToHeatRows(List<Heat> heat);


    @Named("hasStartedToButtonStatus")
    static String hasStartedToButtonStatus(Boolean hasStarted) {
        return hasStarted ? "Stop" : "Start";
    }

}
