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
        for (int laneNumber = 1; laneNumber < event.getNumberOfLanes() + 1; laneNumber++) {
            for (int heatNumber = 1; heatNumber < event.getNumberOfHeats() + 1; heatNumber++) {
                AthleteEvent athleteEvent = new AthleteEvent();
                athleteEvent.setEvent(event);
                athleteEvent.setEventLength(request.getEventLength());
                athleteEvent.setStroke(getStrokeById(request));
                athleteEvent.setLaneNumber(laneNumber);
                athleteEvent.setHeatNumber(heatNumber);
                athleteEvent.setIsActive(true);
                athleteEvent.setSplitCounter(request.getEventLength() / event.getSplitLength().getMeters());
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
        athleteEvent.setSplitCounter(request.getEventLength() / athleteEvent.getEvent().getSplitLength().getMeters());
        athleteEventRepository.save(athleteEvent);
    }

    public List<AthleteEvent> findAthleteEventsByEventIdAndHeatNumber(Integer eventId, Integer heatNumber) {
        return athleteEventRepository.findByEventIdAndHeatNumber(eventId, heatNumber);
    }

    public void updateAthleteEventsWithTimeStamp(Instant timestamp, List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            athleteEvent.setStartTime(timestamp);
        }
        athleteEventRepository.saveAll(athleteEvents);
    }

    private Stroke getStrokeById(EventSettingsRequest request) {
        return strokeService.findById(request.getStrokeId());
    }

}
