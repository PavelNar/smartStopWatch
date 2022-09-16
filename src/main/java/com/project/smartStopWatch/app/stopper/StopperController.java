package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/split")
    @Operation(summary = "TODO: Stopper split click event")
    private void splitClick(Integer athleteEventId) {
        Instant timestamp = Instant.now();
        stopperService.splitClick(timestamp, athleteEventId);
    }

}
