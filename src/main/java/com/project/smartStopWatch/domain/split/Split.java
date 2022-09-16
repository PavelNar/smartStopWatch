package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.athlete.athleteevent.AthleteEvent;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "split")
public class Split {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "start", nullable = false)
    private Instant start;

    @Column(name = "\"end\"")
    private Instant end;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "athlete_event_id", nullable = false)
    private AthleteEvent athleteEvent;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}