package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventDto;
import com.project.smartStopWatch.app.athleteevent.AthleteEventRequest;
import com.project.smartStopWatch.app.athleteevent.AthleteEventResponse;
import com.project.smartStopWatch.domain.athlete.event.EventService;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;

    @GetMapping("/id")
    @Operation(summary = "Toob info koju et moodustada event vaade (nupud jne)")
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
//        athleteEvent.setAthleteId(number * heat);
        athleteEvent.setAthleteEventId(number * heat);
        athleteEvent.setEventLength(200);
        athleteEvent.setAthleteName("name");
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
    public EventResponse createGlobalSettings(@RequestBody EventRequest request) {
        return eventService.createGlobalSettings(request);
    }

    @PostMapping("/create/new/event")
    @Operation(summary = "add new event")
    public AthleteEventResponse createAthleteEvent(@RequestBody AthleteEventRequest request) {
        return eventService.createAthleteEvent(request);
    }

    @GetMapping("/global/strokes")
    @Operation(summary = "Get stroke dropdown info")
    public List<StrokeDto> findAllStrokes() {
        return eventService.findAllStrokes();
    }
    @GetMapping("/global/splits")
    @Operation(summary = "Get splits dropdown info")
    public List<SplitDto> findAllSplits() {
        return eventService.findAllSplits();
    }

    @PostMapping
    @Operation(summary = "ühe heati start")
    private void startHeat(Integer eventId, Integer heatNumber) {
        Instant timestamp = Instant.now();
//        eventService.startHeat(timestamp, eventId, heatNumber);
    }

}
