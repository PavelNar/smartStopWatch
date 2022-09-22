package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import com.project.smartStopWatch.app.stopper.dto.split.SplitDto;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.stroke.Stroke;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;


    @GetMapping("/athlete")
    @Operation(summary = "Find athlete by athlete name and userId")
    public AthleteInfo findAthleteByName(Integer userId, String athleteName) {
        return reportService.findAthleteByName(userId, athleteName);
    }

    @DeleteMapping("/athlete")
    @Operation(summary = "Delete athlete with statistics from database")
    public void deleteAthlete(Integer athleteId) {
        reportService.deleteAthlete(athleteId);
    }

    @GetMapping("/athlete/stroke/event")
    @Operation(summary = "Find all event lengths of chosen stroke athlete has participated in")
    public List<AthleteEventDto> findAthleteEvents(Integer strokeId, Integer athleteId) {
        return reportService.findAthleteEvents(strokeId, athleteId);
    }

    @GetMapping("/athlete/event/splits")
    @Operation(summary = "Find all splits for chosen event")
    public List<SplitDto> findAthleteSplits(Integer athleteEventId) {
        return reportService.findAthleteSplits(athleteEventId);
    }
}