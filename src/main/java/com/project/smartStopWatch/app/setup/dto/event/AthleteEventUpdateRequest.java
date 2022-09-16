package com.project.smartStopWatch.app.setup.dto.event;

import lombok.Data;

import java.io.Serializable;

@Data
public class AthleteEventUpdateRequest implements Serializable {
    private final Integer athleteEventId;
    private final Integer athleteId;
    private final Integer strokeId;
    private final Integer eventLength;
}