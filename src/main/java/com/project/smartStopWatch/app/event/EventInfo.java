package com.project.smartStopWatch.app.event;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EventInfo {
    private List<HeatRow> heatRows = new ArrayList<>();
}
