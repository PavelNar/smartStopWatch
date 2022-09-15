package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
public class AthleteEventRequest implements Serializable {
    private final Integer athleteId;
    private final Integer eventId;
    private final Integer strokeId;
    @NotNull
    private final Instant startTime;
    private final Instant finishTime;
    @NotNull
    private final Integer heatNumber;
    @NotNull
    private final Integer laneNumber;
    @NotNull
    private final Integer eventLength;
    @NotNull
    private final Integer splitLength;
    @NotNull
    private final Integer splitCounter;
    @NotNull
    private final Boolean isActive;
}