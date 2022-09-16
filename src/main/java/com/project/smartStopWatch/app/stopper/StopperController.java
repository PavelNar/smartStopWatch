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
    @Operation(summary = "TODO: Get stopper dashboard info (TOP PRIORITY - hetkel tagastab vaif mock andmed)")
    public StopperDashboard getStopperDashboard(Integer eventId) {
        // Loome ajutiselt (ainult arenduse ajaks) tagastatava objekti
        // Mõte selles, et see teenus hakkaks koheselt tagastama mingit vastust,
        // eesmägiga, et frond-arendaja saaks koheselt asuda arendama nii,
        // et ta saaks siis päringule mingi vastuse.
        StopperDashboard result = createMockData();
        // loome mingi sisendist sõltuva kontrolli, millega saab errori visata
        if (eventId == 0) {
            throw new BusinessException("Mingi error bla bla bla", "Mingi detailne error bla bla");
        }

        // TODO: SEE ON TEIE KÕIGE TÄHTSAM TEENUS, MIS ON VAJA ASAP ära implementeerida
        //  return stopperService.getStopperDashboard(eventId);
        return result;

    }

    private StopperDashboard createMockData() {
        StopperDashboard result = new StopperDashboard();
        result.setNumberOfLanes(3);
        result.getHeatRows().add(createHeatRows(1));
        result.getHeatRows().add(createHeatRows(2));
        result.getHeatRows().add(createHeatRows(3));
        return result;
    }

    private HeatRow createHeatRows(int heat) {
        HeatRow heatRow = new HeatRow();
        heatRow.setHeatNumber(heat);
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
        athleteEvent.setAthleteEventId(number * heat);
        athleteEvent.setEventLength(200);
        athleteEvent.setAthleteName("name");
        athleteEvent.setLaneNumber(lane);
        athleteEvent.setHeatNumber(heat);
        athleteEvent.setStrokeId(1);
        athleteEvent.setStrokeType("Freestyle");
        athleteEvent.setSplitCounter(0);
        athleteEvent.setSplitLength(50);
        athleteEvent.setStartTime(null);
        athleteEvent.setFinishTime(null);
        return athleteEvent;
    }

}
