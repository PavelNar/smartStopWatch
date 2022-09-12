package com.project.smartStopWatch.app.event;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.Event} entity
 */
@Data
public class EventResponse implements Serializable {
    private final Integer id;
}