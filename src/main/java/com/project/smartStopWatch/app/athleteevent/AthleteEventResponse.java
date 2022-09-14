package com.project.smartStopWatch.app.athleteevent;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.athlete.event.AthleteEvent} entity
 */
@Data
public class AthleteEventResponse implements Serializable {
    private final Integer id;
}