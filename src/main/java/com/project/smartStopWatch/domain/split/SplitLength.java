package com.project.smartStopWatch.domain.split;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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