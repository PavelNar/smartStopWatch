package com.project.smartStopWatch.domain.event.heat;

import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatRow2;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HeatMapper {

    @Mapping(source = "hasStarted", target = "heatButtonStatus", qualifiedByName = "hasStartedToButtonStatus")
    @Mapping(source = "start", target = "heatStartTimeMilliseconds", qualifiedByName = "timestampToMilliseconds")
    HeatRow heatToHeatRow(Heat heat);


    List<HeatRow> heatsToHeatRows(List<Heat> heat);



    @Named("hasStartedToButtonStatus")
    static String hasStartedToButtonStatus(Boolean hasStarted) {
        return hasStarted ? "Stop" : "Start";
    }

    @Named("timestampToMilliseconds")
    static Long timestampToMilliseconds(Instant start) {
        return start.toEpochMilli();
    }

}
