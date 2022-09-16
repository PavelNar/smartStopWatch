package com.project.smartStopWatch.app.stopper.dto.dashboard;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class HeatRow {
    private Integer heatNumber;
    private Boolean hasStarted = false;
    private String heatStatus = "Start";
    private Instant heatStartTimeStamp;
    private List<AthleteEventDto> athleteEvents;
}
