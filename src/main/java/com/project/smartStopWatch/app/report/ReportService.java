package com.project.smartStopWatch.app.report;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportService {

    @Resource
    private AthleteService athleteService;

    public void deleteAthlete(Integer athleteId) {
        athleteService.deleteAthlete(athleteId);
    }

    public AthleteInfo findAthleteByName(Integer userId, String athleteName) {
        return athleteService.findAthleteByName(userId ,athleteName);
    }

}
