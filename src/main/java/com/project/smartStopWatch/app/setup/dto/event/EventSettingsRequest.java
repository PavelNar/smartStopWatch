package com.project.smartStopWatch.app.setup.dto.event;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class EventSettingsRequest implements Serializable {
    private final Integer userId;
    private final Integer strokeId;
    @NotNull
    private final Integer eventLength;
    private final Integer splitLengthId;
    private final Integer numberOfAthletes;
    @NotNull
    private final Integer numberOfLanes;
    @NotNull
    private final Integer numberOfHeats;
}