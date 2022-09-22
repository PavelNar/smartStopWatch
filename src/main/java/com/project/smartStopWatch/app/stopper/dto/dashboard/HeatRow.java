package com.project.smartStopWatch.app.stopper.dto.dashboard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class HeatRow {
    private UUID uuid = UUID.randomUUID();
    private Integer eventId;
    private Integer heatNumber;
    private Boolean hasStarted;
    private Boolean hasFinished;
    private String heatButtonStatus;
    private Long heatStartTimeMilliseconds;
    private Long heatFinishTimeMilliseconds;
    private List<AthleteEventDto> athleteEvents = new ArrayList<>();
}
