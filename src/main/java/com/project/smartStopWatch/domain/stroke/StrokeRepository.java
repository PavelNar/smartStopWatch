package com.project.smartStopWatch.domain.stroke;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StrokeRepository extends JpaRepository<Stroke, Integer> {

    @Query("select s from Stroke s where s.id = ?1")
    Stroke findStrokeByStrokeId(Integer strokeId);

}