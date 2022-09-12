package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.athlete.AthleteRequest;
import com.project.smartStopWatch.app.athlete.AthleteResponce;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AthleteService {

    @Resource
    private AthleteMapper athleteMapper;

    @Resource
    private AthleteRepository athleteRepository;

    public AthleteResponce findAthleteByName(AthleteRequest request) {
        Optional<Athlete> name = athleteRepository.findByName(request.getName());
        ValidationService.validateAthleteExists(name);
        return athleteMapper.athleteToAthleteResponse(name.get());
    }
}
