package com.project.smartStopWatch.app.stopper.dto.dashboard;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class AthleteEventDto implements Serializable {
    private Integer athleteId;
    private Integer athleteEventId;
    private Integer athleteEventLength;
    private String athleteName;
    private Integer strokeId;
    private String strokeType;
    private Boolean hasStarted;
    private Instant startTime;
    private Integer lastSplitCount;
    private Instant lastSplitTime;
    private Integer distanceCovered;
    private Boolean hasFinished;
    private Instant finishTime;
    private Integer laneNumber;
    private Integer heatNumber;
}