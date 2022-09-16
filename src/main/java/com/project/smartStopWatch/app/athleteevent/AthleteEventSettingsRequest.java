package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class AthleteEventSettingsRequest implements Serializable {

    private final Integer eventId;
    @NotNull
    private final Integer eventLength;
    @Size(max = 255)
    @NotNull
    private final String athleteName;
    private final Integer athleteId;
    private final Integer strokeId;
    @NotNull
    private final Integer heatNumber;
    @NotNull
    private final Integer laneNumber;
}