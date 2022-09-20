package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.setup.dto.event.AthleteEventUpdateRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsRequest;
import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import com.project.smartStopWatch.domain.event.Event;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.stroke.StrokeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteEventService {

    @Resource
    private AthleteService athleteService;

    @Resource
    private StrokeService strokeService;

    @Resource
    private AthleteEventRepository athleteEventRepository;


    public void createAndAddAthleteEvents(Event event, EventSettingsRequest request) {
        List<AthleteEvent> athleteEvents = new ArrayList<>();
        int athleteCounter = 0;
        for (int heatNumber = 1; heatNumber <= event.getNumberOfHeats(); heatNumber++) {
            for (int laneNumber = 1; laneNumber <= event.getNumberOfLanes(); laneNumber++) {
                AthleteEvent athleteEvent = new AthleteEvent();
                athleteEvent.setEvent(event);
                athleteEvent.setEventLength(request.getEventLength());
                athleteEvent.setStroke(getStrokeById(request));
                athleteEvent.setLaneNumber(laneNumber);
                athleteEvent.setHeatNumber(heatNumber);
                athleteEvent.setIsActive(true);
                athleteEvent.setSplitCounter(0);
                athleteEvent.setSplitCountRequired(request.getEventLength() / event.getSplitLength().getMeters());
                athleteEvent.setSplitLength(event.getSplitLength().getMeters());
                athleteEvents.add(athleteEvent);
                athleteCounter++;
                if (athleteCounter == request.getNumberOfAthletes()) {
                    athleteEventRepository.saveAll(athleteEvents);
                    return;
                }
            }
        }
    }

    public void updateAthleteEventSettings(AthleteEventUpdateRequest request) {
        Athlete athlete = athleteService.findById(request.getAthleteId());
        Stroke stroke = strokeService.findById(request.getStrokeId());

        AthleteEvent athleteEvent = athleteEventRepository.findById(request.getAthleteEventId()).get();
        athleteEvent.setAthlete(athlete);
        athleteEvent.setStroke(stroke);
        athleteEvent.setEventLength(request.getEventLength());
        athleteEvent.setSplitCounter(0);
        athleteEvent.setSplitCountRequired(request.getEventLength() / athleteEvent.getEvent().getSplitLength().getMeters());
        athleteEventRepository.save(athleteEvent);
    }

    public List<AthleteEvent> findActiveAthleteEventsBy(Integer eventId, Integer heatNumber) {
        return athleteEventRepository.findEventsBy(true, eventId, heatNumber);
    }

    public void updateAthleteEventsWithTimeStamp(Instant timestamp, List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            athleteEvent.setStartTime(timestamp);
        }
        athleteEventRepository.saveAll(athleteEvents);
    }

    public AthleteEvent increaseAthleteEventSplitCounter(AthleteEvent athleteEvent) {
        athleteEvent.setSplitCounter(athleteEvent.getSplitCounter() + 1);
        athleteEventRepository.save(athleteEvent);
        return athleteEvent;
    }

    public void decreaseAthleteEventSplitCounter(AthleteEvent athleteEvent) {
        athleteEvent.setSplitCounter(athleteEvent.getSplitCounter() - 1);
        athleteEventRepository.save(athleteEvent);
    }

    public void updateAthleteEventFinishTime(Instant timestamp, AthleteEvent athleteEvent) {
        athleteEvent.setFinishTime(timestamp);
        athleteEventRepository.save(athleteEvent);
    }

    public AthleteEvent findAthleteEventBy(Integer athleteEventId) {
        return athleteEventRepository.findById(athleteEventId).get();
    }

    public void clearFinishedTimeStamp(AthleteEvent athleteEvent) {
        athleteEvent.setFinishTime(null);
        athleteEventRepository.save(athleteEvent);
    }

    private Stroke getStrokeById(EventSettingsRequest request) {
        return strokeService.findById(request.getStrokeId());
    }

    public List<AthleteEvent> findActiveAthleteEventsBy(Integer eventId) {
        return athleteEventRepository.findAthleteEventsBy(true, eventId);
    }

    public void updateAthleteEventLastSplitTime(Instant timestamp, AthleteEvent athleteEvent) {
        athleteEvent.setLastSplitTime(timestamp);
        athleteEventRepository.save(athleteEvent);
    }
}
