package com.project.smartStopWatch.app.event.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EventInfo {
    private Integer numberOfLanes;
    private List<HeatRow> heatRows = new ArrayList<>();
}
