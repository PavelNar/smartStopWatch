package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import com.project.smartStopWatch.app.stopper.dto.split.SplitDto;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.split.SplitService;
import com.project.smartStopWatch.domain.stroke.Stroke;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class ReportService {

    @Resource
    private AthleteService athleteService;

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private SplitService splitService;

    public void deleteAthlete(Integer athleteId) {
        athleteService.deleteAthlete(athleteId);
    }

    public AthleteInfo findAthleteByName(Integer userId, String athleteName) {
        return athleteService.findAthleteByName(userId ,athleteName);
    }

    public List<Stroke> findAthleteStrokes(Integer athleteId) {
        return null;
    }

    public List<AthleteEventDto> findAthleteEvents(Integer strokeId, Integer athleteId) {
        return athleteEventService.findAthleteEvents(strokeId, athleteId);
    }

    public List<AthleteEvent> findAthleteEventsByDay(Instant timestamp, Integer strokeId, Integer athleteId) {
        return null;
    }

    public List<SplitDto> findAthleteSplits(Integer athleteEventId) {
        return splitService.findAthleteSplits(athleteEventId);
    }
}
