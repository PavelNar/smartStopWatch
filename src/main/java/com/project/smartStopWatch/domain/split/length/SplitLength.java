package com.project.smartStopWatch.domain.split.length;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "split_length")
public class SplitLength {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "meters", nullable = false)
    private Integer meters;

    @NotNull
    @Column(name = "time_delay", nullable = false)
    private Integer timeDelay;

}