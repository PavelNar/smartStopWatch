package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventDto;
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
