package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.domain.athlete.AthleteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportService {

    @Resource
    private AthleteService athleteService;


//  Hetkel on küsimus, et mis te selle teenusega soovite täpsemalt saavutada?
//  Kus te soovite seda teenust oma veebilehel kasutada?
//    public AthleteInfo findAthleteByName(String name) {
//        return athleteService.findAthlete(name);
//    }

    public void deleteAthlete(Integer athleteId) {
        athleteService.deleteAthlete(athleteId);
    }

}
