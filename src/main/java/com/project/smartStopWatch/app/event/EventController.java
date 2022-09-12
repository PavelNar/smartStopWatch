package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.athlete.AthleteEventDto;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @GetMapping("/id")
    public EventInfo getAthletesEventInfo(Integer eventId) {
        // Meie mock andmed
        EventInfo result = new EventInfo();
        result.getHeatRows().add(createHeatRows(1));
        result.getHeatRows().add(createHeatRows(2));
        result.getHeatRows().add(createHeatRows(3));
        return result;
    }

    private HeatRow createHeatRows(int heat) {
        HeatRow heatRow = new HeatRow();
        List<AthleteEventDto> athleteEvents = new ArrayList<>();
        athleteEvents.add(createAthleteEvent(1, 1, heat));
        athleteEvents.add(createAthleteEvent(2, 1, heat));
        athleteEvents.add(createAthleteEvent(3, 1, heat));
        heatRow.setAthleteEvents(athleteEvents);
        return heatRow;
    }


    private AthleteEventDto createAthleteEvent(int number, int lane, int heat) {
        AthleteEventDto athleteEvent = new AthleteEventDto();
        athleteEvent.setAthleteId(number * heat);
        athleteEvent.setEventLength(200);
        athleteEvent.setAthleteName("name " + number * heat);
        athleteEvent.setLaneNumber(lane);
        athleteEvent.setHeatNumber(heat);
        athleteEvent.setSplitCounter(0);
        athleteEvent.setSplitLength(50);
        athleteEvent.setStartTime(null);
        athleteEvent.setFinishTime(null);
        return athleteEvent;
    }
}