package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.athlete.event.AthleteEvent} entity
 */
@Data
public class AthleteEventDto1 implements Serializable {

    private final Integer eventId;
    @NotNull
    private final Integer eventLength;
    @Size(max = 255)
    @NotNull
    private final String athleteName;
    private final Integer strokeId;
    @NotNull
    private final Integer heatNumber;
    @NotNull
    private final Integer laneNumber;
}