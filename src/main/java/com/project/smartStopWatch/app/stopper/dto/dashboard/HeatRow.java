package com.project.smartStopWatch.app.stopper.dto.dashboard;

import lombok.Data;

import java.util.List;

@Data
public class HeatRow {
    private Integer heatNumber;
    private Boolean hasStarted;
    private Boolean hasFinished;
    private String heatButtonStatus;
    private Long heatStartTimeMilliseconds;
    private List<AthleteEventDto> athleteEvents;
}
