package com.project.smartStopWatch.domain.event.heat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeatRepository extends JpaRepository<Heat, Integer> {


    @Query("select h from Heat h where h.isActive = ?1 and h.event.id = ?2")
    Heat findHeatBy(Boolean isActive, Integer eventId);

    @Query("select h from Heat h where h.isActive = ?1 and h.event.id = ?2 and h.heatNumber = ?3")
    Heat findHeatBy(Boolean isActive, Integer eventId, Integer heatNumber);

    @Query("select h from Heat h where h.isActive = ?1 and h.event.id = ?2")
    List<Heat> findHeatsBy(Boolean isActive, Integer eventId);

    @Query("select h from Heat h where h.event.id = ?1 and h.heatNumber = ?2")
    Heat findByEventIdAndHeatNumber(Integer id, Integer heatNumber);


}