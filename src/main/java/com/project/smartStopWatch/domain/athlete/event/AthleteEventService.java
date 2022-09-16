package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventSettingsRequest;
import com.project.smartStopWatch.app.athleteevent.AthleteEventStartRequest;
import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.stroke.StrokeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteEventService {

    @Resource
    private AthleteEventRepository athleteEventRepository;

    @Resource
    private AthleteService athleteService;

    @Resource
    private StrokeService strokeService;

    @Resource
    private AthleteEventMapper athleteEventMapper;


    public void saveAllAthleteEvents(AthleteEvent athleteEvent) {
        athleteEventRepository.save(athleteEvent);
    }

    public void updateAthleteEventSettings(AthleteEventSettingsRequest request) {
        AthleteEvent athleteEvent = athleteEventRepository.findById(request.getAthleteEventId()).get();
        athleteEvent.setEventLength(request.getEventLength());

        Athlete athlete = athleteService.findById(request.getAthleteId());
        athleteEvent.setAthlete(athlete);

        Stroke stroke = strokeService.findById(request.getStrokeId());
        athleteEvent.setStroke(stroke);

        athleteEventRepository.save(athleteEvent);
    }

    public void startHeat(Instant timestamp, AthleteEventStartRequest startRequest) {
        List<AthleteEvent> athleteEvents = athleteEventRepository.findByEventIdAndHeatNumber(startRequest.getEventId(), startRequest.getHeatNumber());

        for (AthleteEvent athleteEvent : athleteEvents) {
            athleteEvent.setStartTime(timestamp);
        }
        athleteEventRepository.saveAll(athleteEvents);
    }
}
