package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import java.io.Serializable;

@Data
public class AthleteEventSettingsRequest implements Serializable {
    private final Integer athleteEventId;
    private final Integer athleteId;
    private final Integer strokeId;
    private final Integer eventLength;
}