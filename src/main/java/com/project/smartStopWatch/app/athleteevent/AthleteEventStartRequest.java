package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AthleteEventStartRequest implements Serializable {
    private final Integer eventId;
    @NotNull
    private final Integer heatNumber;
}