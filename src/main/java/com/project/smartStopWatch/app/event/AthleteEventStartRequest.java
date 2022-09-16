package com.project.smartStopWatch.app.event;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class AthleteEventStartRequest implements Serializable {
    private final Integer id;
    @NotNull
    private final Integer heatNumber;
}