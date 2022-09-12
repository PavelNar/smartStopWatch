package com.project.smartStopWatch.app.athlete;

import com.project.smartStopWatch.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.project.smartStopWatch.domain.athlete.Athlete} entity
 */
@Data
public class AthleteResponse implements Serializable {
    private final Integer id;
    @NotNull
    private final User user;
    @Size(max = 255)
    @NotNull
    private final String name;
}