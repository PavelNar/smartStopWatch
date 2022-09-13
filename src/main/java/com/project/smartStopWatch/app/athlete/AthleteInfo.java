package com.project.smartStopWatch.app.athlete;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.athlete.Athlete} entity
 */
@Data
public class AthleteInfo implements Serializable {
    private final Integer userId;
    @Size(max = 255)
    @NotNull
    private final Integer athleteId;
}