package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.domain.split.length.SplitLength;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
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

}