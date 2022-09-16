package com.project.smartStopWatch.app.setup;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.app.setup.dto.event.AthleteEventUpdateRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsResponse;
import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
import com.project.smartStopWatch.app.setup.dto.split.StrokeDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Resource
    private SetupService setupService;

    @PostMapping("/event")
    @Operation(summary = "Create new event from settings")
    public EventSettingsResponse createEventFromSettings(@RequestBody EventSettingsRequest request) {
        return setupService.createEventFromSettings(request);
    }

    @PatchMapping("/athlete-event")
    @Operation(summary = "Update athlete event settings from edit button")
    public void updateAthleteEvent(@RequestBody AthleteEventUpdateRequest request) {
        setupService.updateAthleteEvent(request);
    }

    @PostMapping("/athlete")
    @Operation(summary = "Add athlete")
    public AthleteInfo addAthlete(String name, Integer trainerUserId) {
        return setupService.addAthlete(name, trainerUserId);
    }

    @GetMapping("/stroke")
    @Operation(summary = "Get stroke dropdown info")
    public List<StrokeDto> findAllStrokes() {
        return setupService.findAllStrokes();
    }

    @GetMapping("/split")
    @Operation(summary = "Get splits dropdown info")
    public List<SplitLengthDto> findAllSplits() {
        return setupService.findAllSplits();
    }

}

