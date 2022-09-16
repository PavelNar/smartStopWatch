package com.project.smartStopWatch.app.report;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;


//  Hetkel on küsimus, et mis te selle teenusega soovite täpsemalt saavutada?
//  Kus te soovite seda teenust oma veebilehel kasutada?
//    @GetMapping("/athlete")
//    @Operation(summary = "Find athlete by name")
//    public AthleteInfo findAthleteByName(String name) {
//        return reportService.findAthleteByName(name);
//    }

    @DeleteMapping("/athlete")
    @Operation(summary = "Delete athlete with statistics from database")
    public void deleteAthlete(Integer athleteId) {
        reportService.deleteAthlete(athleteId);
    }

}
