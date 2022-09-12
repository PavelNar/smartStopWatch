package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.athlete.AthleteEventDto;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class HeatRow {
    private Boolean hasStarted = false;
    private String heatStatus = "Start";
    private Instant heatStartTimeStamp;
    private List<AthleteEventDto> athleteEvents;
}
