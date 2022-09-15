package com.project.smartStopWatch.app.split;

import com.project.smartStopWatch.domain.split.Split;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SplitRepository extends JpaRepository<Split, Integer> {
}