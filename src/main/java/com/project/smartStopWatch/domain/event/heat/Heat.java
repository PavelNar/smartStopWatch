package com.project.smartStopWatch.domain.event.heat;

import com.project.smartStopWatch.domain.event.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "heat")
public class Heat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull
    @Column(name = "heat_number", nullable = false)
    private Integer heatNumber;

    @Column(name = "start")
    private Instant start;

    @Column(name = "\"end\"")
    private Instant end;

    @NotNull
    @Column(name = "has_started", nullable = false)
    private Boolean hasStarted = false;

    @NotNull
    @Column(name = "has_finished", nullable = false)
    private Boolean hasFinished = false;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}