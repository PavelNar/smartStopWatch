package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStopRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;

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

    @PatchMapping("/stop")
    @Operation(summary = "Heat Stop")
    private void stopHeat(@RequestBody HeatStopRequest stopRequest) {
        stopperService.stopHeat(stopRequest);
    }

    @PostMapping("/split")
    @Operation(summary = "Stopper SPLIT click event")
    private void processSplitClick(Integer athleteEventId) {
        Instant timestamp = Instant.now();
        stopperService.processSplitClick(timestamp, athleteEventId);
    }

    @PatchMapping("/undo")
    @Operation(summary = "Stopper UNDO click event")
    private void processUndoClick(Integer athleteEventId) {
        stopperService.processUndoClick(athleteEventId);
    }

    @GetMapping("/dashboard")
    @Operation(summary = "Get stopper dashboard info")
    public StopperDashboard getStopperDashboard(Integer eventId) {
        return stopperService.getStopperDashboard(eventId);

    }
}
