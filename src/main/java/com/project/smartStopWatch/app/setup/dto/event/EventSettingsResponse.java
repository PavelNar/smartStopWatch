package com.project.smartStopWatch.app.setup.dto.event;

import lombok.Data;

import java.io.Serializable;


@Data
public class EventSettingsResponse implements Serializable {
    private final Integer eventId;
}