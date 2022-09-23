package com.project.smartStopWatch.app.stopper.dto.split;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
public class SplitDto implements Serializable {
    @NotNull
    private final Long start;
    private final Long end;
}