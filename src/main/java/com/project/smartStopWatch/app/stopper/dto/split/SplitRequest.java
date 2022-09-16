package com.project.smartStopWatch.app.stopper.dto.split;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.split.Split} entity
 */
@Data
public class SplitRequest implements Serializable {
    @NotNull
    private final Instant start;
    private final Instant end;
    private final Integer athleteId;
    private final Integer athleteEventId;
    @NotNull
    private final Boolean isActive;
}