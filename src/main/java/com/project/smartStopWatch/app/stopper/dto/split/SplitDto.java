package com.project.smartStopWatch.app.stopper.dto.split;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.split.Split} entity
 */
@Data
public class SplitDto implements Serializable {
    @NotNull
    private final Instant start;
    private final Instant end;
}