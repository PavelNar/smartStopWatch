package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.athlete.event.AthleteEvent} entity
 */
@Data
public class AthleteEventDto implements Serializable {

    @NotNull
    private Integer athleteId;
    @Size(max = 255)
    @NotNull
    private String athleteName;
    @NotNull
    private Instant startTime;
    @NotNull
    private Instant finishTime;
    @NotNull
    private Integer heatNumber;
    @NotNull
    private Integer laneNumber;
    @NotNull
    private Integer eventLength;
    @NotNull
    private Integer splitLength;
    @NotNull
    private Integer splitCounter;
}