package com.project.smartStopWatch.app.athleteevent;

import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/athleteevent")
public class AthleteEventController {

    @Resource
    private AthleteEventService athleteEventService;

//    @PatchMapping("/settings")
//    @Operation(summary = "Update athlete event settings from edit button")
//    public void updateAthleteEventSettings(@RequestBody AthleteEventDto1 request) {
//        athleteEventService.updateAthleteEventSettings(request);
//    }
}
