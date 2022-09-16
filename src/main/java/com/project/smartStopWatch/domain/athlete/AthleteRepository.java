package com.project.smartStopWatch.domain.athlete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {

    @Query("select (count(a) > 0) from Athlete a where a.name = ?1 and a.isActive = ?2")
    boolean existsByNameAndIsActive(String name, Boolean isActive);

    @Query("select a from Athlete a where upper(a.name) = upper(?1)")
    Optional<Athlete> findByName(String name);

}