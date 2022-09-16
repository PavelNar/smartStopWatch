package com.project.smartStopWatch.app.stopper.dto.dashboard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StopperDashboard {
    private Integer numberOfLanes;
    private List<HeatRow> heatRows = new ArrayList<>();
}
