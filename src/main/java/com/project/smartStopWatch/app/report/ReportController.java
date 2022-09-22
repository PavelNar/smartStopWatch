package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
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

    @GetMapping("/athlete/stroke")
    @Operation(summary = "Find all strokes athlete has participated in")
    public List<Stroke> findAthleteStrokes(Integer athleteId) {
        return reportService.findAthleteStrokes(athleteId);
    }

    @GetMapping("/athlete/stroke/event")
    @Operation(summary = "Find all event lengths of chosen stroke athlete has participated in")
    public List<AthleteEventDto> findAthleteEvents(Integer strokeId, Integer athleteId) {
        return reportService.findAthleteEvents(strokeId, athleteId);
    }

    @GetMapping("/athlete/stroke/event/day")
    @Operation(summary = "Find by day events of chosen stroke and length athlete has participated in")
    public List<AthleteEvent> findAthleteEventsByDay(Instant day, Integer strokeId, Integer athleteId) {
        return reportService.findAthleteEventsByDay(day, strokeId, athleteId);
    }

    @GetMapping("/athlete/stroke/event/day/time")
    @Operation(summary = "Find by day and time events of chosen stroke and length athlete has participated in")
    public List<AthleteEvent> findAthleteEventsByDayAndTime(Instant day, Instant time, Integer strokeId, Integer athleteId) {
        return reportService.findAthleteEventsByDay(day, strokeId, athleteId);
    }
}
