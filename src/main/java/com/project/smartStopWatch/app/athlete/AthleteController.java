package com.project.smartStopWatch.app.athlete;

import com.project.smartStopWatch.domain.athlete.AthleteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class AthleteController {

    @Resource
    private AthleteService athleteService;

    @GetMapping("/search")
    @Operation(summary = "Find athlete by name")
    public AthleteResponce findAthleteByName(@Valid AthleteRequest request) {
        return athleteService.findAthleteByName(request);
    }
}
