package com.project.smartStopWatch.app.event;

import lombok.Data;

import java.io.Serializable;


@Data
public class EventResponse implements Serializable {
    private final Integer eventId;
    private final Integer athleteEventId;
}