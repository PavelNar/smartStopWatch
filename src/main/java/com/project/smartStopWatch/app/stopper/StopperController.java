package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stopper")
public class StopperController {

    @Resource
    private StopperService stopperService;

    @PostMapping("/start")
    @Operation(summary = "Heat start")
    private void startHeat(HeatStartRequest startRequest) {
        Instant timestamp = Instant.now();
        stopperService.startHeat(timestamp, startRequest);
    }

    @PostMapping("/split")
    @Operation(summary = "TODO: Stopper split click event (Rain vaatab seda)")
    private void splitClick(Integer athleteEventId) {
        Instant timestamp = Instant.now();
        stopperService.splitClick(timestamp, athleteEventId);
    }

    @GetMapping("/dashboard")
    @Operation(summary = "TODO: Get stopper dashboard info (TOP PRIORITY - hetkel tagastab vaid mock andmed)")
    public StopperDashboard getStopperDashboard(Integer eventId) {
        // Loome ajutiselt (ainult arenduse ajaks) tagastatava objekti
        // Mõte selles, et see teenus hakkaks koheselt tagastama mingit vastust,
        // eesmägiga, et frond-arendaja saaks koheselt asuda arendama nii,
        // et ta saaks siis päringule mingi vastuse.
        StopperDashboard result = new StopperDashboard();
        // loome mingi sisendist sõltuva kontrolli, millega saab errori visata
        if (eventId == 0) {
            throw new BusinessException("Mingi error bla bla bla", "Mingi detailne error bla bla");
        } else if (eventId == 1) {
            result = createMockDataStarted();
        } else {
            result = createMockDataNotStarted();
        }

        // TODO: SEE ON TEIE KÕIGE TÄHTSAM TEENUS, MIS ON VAJA ASAP ära implementeerida
        //  return stopperService.getStopperDashboard(eventId);
        return result;

    }

    private StopperDashboard createMockDataStarted() {
        StopperDashboard result = new StopperDashboard();
        result.setNumberOfLanes(3);
        result.getHeatRows().add(createHeatRowOne());
        result.getHeatRows().add(createHeatRowNotStarted(2));
        result.getHeatRows().add(createHeatRowNotStarted(3));
        return result;
    }
    private StopperDashboard createMockDataNotStarted() {
        StopperDashboard result = new StopperDashboard();
        result.setNumberOfLanes(3);
        result.getHeatRows().add(createHeatRowNotStarted(1));
        result.getHeatRows().add(createHeatRowNotStarted(2));
        result.getHeatRows().add(createHeatRowNotStarted(3));
        return result;
    }

    private HeatRow createHeatRowOne() {
        Instant startTime = Instant.now().minus(4, ChronoUnit.MINUTES);
        HeatRow heatRow = new HeatRow();
        heatRow.setHeatNumber(1);
        heatRow.setHeatStatus("Stop");
        heatRow.setHasStarted(true);
        heatRow.setHeatStartTimeStamp(startTime);
        List<AthleteEventDto> athleteEvents = new ArrayList<>();
        Instant plus1Minute = startTime.plus(1, ChronoUnit.MINUTES);
        Instant plus2Minutes = startTime.plus(2, ChronoUnit.MINUTES);
        Instant plus3Minutes = startTime.plus(3, ChronoUnit.MINUTES);
        athleteEvents.add(createAthleteEvent(1, 1, 100, true, startTime, plus1Minute, 100, true, startTime));
        athleteEvents.add(createAthleteEvent(2, 1, 200, true, startTime, plus2Minutes, 150, false, null));
        athleteEvents.add(createAthleteEvent(3, 1, 500, true, startTime, plus3Minutes, 200, false, null));
        heatRow.setAthleteEvents(athleteEvents);
        return heatRow;
    }

    private HeatRow createHeatRowNotStarted(int heat) {
        HeatRow heatRow = new HeatRow();
        heatRow.setHeatNumber(heat);
        heatRow.setHeatStatus("Start");
        heatRow.setHasStarted(false);
        List<AthleteEventDto> athleteEvents = new ArrayList<>();
        athleteEvents.add(createAthleteEvent(1 * heat, heat, 200, false, null, null, 0, false, null));
        athleteEvents.add(createAthleteEvent(2 * heat, heat, 200, false, null, null, 0, false, null));
        athleteEvents.add(createAthleteEvent(3 * heat, heat, 200, false, null, null, 0, false, null));
        heatRow.setAthleteEvents(athleteEvents);
        return heatRow;
    }



    private AthleteEventDto createAthleteEvent(int number, int heat, int athleteEventLength, boolean hasStarted, Instant startTime, Instant lastSplitTime, int lastSplitLength, boolean hasFinished, Instant finishTime) {
        Instant now = Instant.now();
        AthleteEventDto athleteEvent = new AthleteEventDto();
        athleteEvent.setAthleteId(number * heat);
        athleteEvent.setAthleteEventId(number * heat);
        athleteEvent.setAthleteName("name " + number);
        athleteEvent.setStrokeId(1);
        athleteEvent.setStrokeType("Freestyle");
        athleteEvent.setAthleteEventLength(athleteEventLength);
        athleteEvent.setHasStarted(hasStarted);
        athleteEvent.setStartTime(startTime);
        athleteEvent.setLastSplitTime(lastSplitTime);
        athleteEvent.setLastSplitLength(lastSplitLength);
        athleteEvent.setHasFinished(hasFinished);
        athleteEvent.setFinishTime(finishTime);
        return athleteEvent;
    }

}
