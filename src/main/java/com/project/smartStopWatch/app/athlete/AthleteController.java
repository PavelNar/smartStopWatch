package com.project.smartStopWatch.app.athlete;

import com.project.smartStopWatch.domain.athlete.AthleteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/athlete")
public class AthleteController {

    @Resource
    private AthleteService athleteService;

    @PostMapping("/add")
    @Operation(summary = "Add athlete")
    public AthleteInfo addAthlete(@RequestBody @Valid AthleteRequest request) {
        return athleteService.addAthlete(request);
    }

    @GetMapping("/search")
    @Operation(summary = "Find athlete by name")
    public AthleteInfo findAthleteByName(@Valid AthleteRequest request) {
        return athleteService.findAthlete(request);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete athlete from database")
    public void deleteAthlete(Integer id) {
        athleteService.deleteAthlete(id);
    }
}
