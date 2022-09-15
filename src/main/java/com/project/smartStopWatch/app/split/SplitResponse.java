package com.project.smartStopWatch.app.split;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.split.Split} entity
 */
@Data
public class SplitResponse implements Serializable {
    private final Integer id;
}