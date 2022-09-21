package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;


    @GetMapping("/athlete")
    @Operation(summary = "Find athlete by athleteId")
    public AthleteInfo findAthleteByName(Integer athleteId) {
        return reportService.findAthleteById(athleteId);
    }

    @DeleteMapping("/athlete")
    @Operation(summary = "Delete athlete with statistics from database")
    public void deleteAthlete(Integer athleteId) {
        reportService.deleteAthlete(athleteId);
    }

}
