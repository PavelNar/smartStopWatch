package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.stroke.Stroke;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stroke_id", nullable = false)
    private Stroke stroke;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @NotNull
    @Column(name = "event_length", nullable = false)
    private Integer eventLength;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "split_length_id", nullable = false)
    private SplitLength splitLength;

    @Column(name = "number_of_athletes")
    private Integer numberOfAthletes;

    @NotNull
    @Column(name = "number_of_heats", nullable = false)
    private Integer numberOfHeats;

    @NotNull
    @Column(name = "number_of_lanes", nullable = false)
    private Integer numberOfLanes;

    @Column(name = "heat_interval_seconds")
    private Integer heatIntervalSeconds;

}