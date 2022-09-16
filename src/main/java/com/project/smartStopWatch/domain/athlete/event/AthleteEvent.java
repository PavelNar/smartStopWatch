package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.event.Event;
import com.project.smartStopWatch.domain.stroke.Stroke;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "athlete_event")
public class AthleteEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stroke_id", nullable = false)
    private Stroke stroke;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "finish_time")
    private Instant finishTime;

    @NotNull
    @Column(name = "heat_number", nullable = false)
    private Integer heatNumber;

    @NotNull
    @Column(name = "lane_number", nullable = false)
    private Integer laneNumber;

    @NotNull
    @Column(name = "event_length", nullable = false)
    private Integer eventLength;

    @NotNull
    @Column(name = "split_length", nullable = false)
    private Integer splitLength;

    @NotNull
    @Column(name = "split_counter", nullable = false)
    private Integer splitCounter;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}