package com.project.smartStopWatch.app.stopper.dto.heat;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class HeatRow2 implements Serializable {
    @NotNull
    private final Integer heatNumber;
    @NotNull
    private final Boolean hasStarted;
    @NotNull
    private final Boolean hasFinished;
}