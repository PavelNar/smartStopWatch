package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.athlete.AthleteEventDto;
import com.project.smartStopWatch.domain.event.EventService;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;

    @GetMapping("/id")
    public EventInfo getAthletesEventInfo(Integer eventId) {
        // Loome ajutiselt (ainult arenduse ajaks) tagastatava objekti
        // Mõte selles, et see teenus hakkaks koheselt tagastama mingit vastust,
        // eesmägiga, et frond-arendaja saaks koheselt asuda arendama nii,
        // et ta saaks siis päringule mingi vastuse.
        EventInfo result = createMockData();

        // loome mingi sisendist sõltuva kontrolli, millega saab errori visata
        if (eventId == 0) {
            throw new BusinessException("Mingi error bla bla bla", "Mingi detailne error bla bla");
        }

        return result;
    }

    private EventInfo createMockData() {
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

    @PostMapping("/global/settings")
    @Operation(summary = "Fill global settings")
    public EventResponse createGlobalSettings(EventRequest request) {
        return eventService.createGlobalSettings(request);
    }


}
