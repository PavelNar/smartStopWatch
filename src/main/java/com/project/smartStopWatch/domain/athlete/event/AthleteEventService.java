package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventSettingsRequest;
import com.project.smartStopWatch.app.event.AthleteEventStartRequest;
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


    public void saveAllAthleteEvents(AthleteEvent athleteEvent) {
        athleteEventRepository.save(athleteEvent);
    }

    public void updateAthleteEventSettings(AthleteEventSettingsRequest request) {
        Optional<AthleteEvent> athleteEvent = athleteEventRepository.findByHeatNumberAndLaneNumber(request.getHeatNumber(), request.getLaneNumber());
        athleteEvent.get().setEventLength(request.getEventLength());

        Integer splitLength = athleteEvent.get().getEvent().getSplitLength().getMeters();
        athleteEvent.get().setSplitCounter(request.getEventLength() / splitLength);

        Athlete athlete = athleteService.findByName(request.getAthleteName());
        athleteEvent.get().setAthlete(athlete);

        Stroke stroke = strokeService.findById(request.getStrokeId());
        athleteEvent.get().setStroke(stroke);

        athleteEventRepository.save(athleteEvent.get());

    }

    public void startHeat(Instant timestamp, AthleteEventStartRequest startRequest) {
        List<AthleteEvent> byHeatNumber = athleteEventRepository.findByHeatNumber(startRequest.getHeatNumber());
    }
}
