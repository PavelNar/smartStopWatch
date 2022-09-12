package com.project.smartStopWatch.app.athlete;

import com.project.smartStopWatch.domain.athlete.AthleteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class AthleteController {

    @Resource
    private AthleteService athleteService;

    @PostMapping("/search")
    @Operation(summary = "Find athlete by name")
    public AthleteInfo findAthleteByName(@RequestBody @Valid AthleteRequest request) {
        return athleteService.findAthleteByName(request);
    }
}
