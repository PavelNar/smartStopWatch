package com.project.smartStopWatch.domain.split;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SplitLengthRepository extends JpaRepository<SplitLength, Integer> {
    @Query("select s from SplitLength s where s.id = ?1")
    SplitLength findSplitLengthBySplitLengthId(Integer id);


}