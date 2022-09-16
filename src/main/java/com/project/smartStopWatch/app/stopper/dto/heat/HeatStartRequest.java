package com.project.smartStopWatch.app.stopper.dto.heat;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class HeatStartRequest implements Serializable {
    @NotNull
    private final Integer eventId;
    @NotNull
    private final Integer heatNumber;
}