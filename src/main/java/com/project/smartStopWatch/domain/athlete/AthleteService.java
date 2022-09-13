package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.athlete.AthleteRequest;
import com.project.smartStopWatch.app.athlete.AthleteInfo;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
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

    @Resource
    private UserService userService;

    public AthleteInfo addAthlete(AthleteRequest request) {
        Athlete athlete = athleteMapper.athleteRequestToAthlete(request);
        User user = userService.findUserByUserId(request.getUserId());
        athlete.setUser(user);
        athleteRepository.save(athlete);
        return athleteMapper.athleteToAthleteResponse(athlete);
    }

    public AthleteInfo findAthlete(AthleteRequest request) {
        Optional<Athlete> name = athleteRepository.findByName(request.getName());
        ValidationService.validateAthleteExists(name);
        return athleteMapper.athleteToAthleteResponse(name.get());
    }

    public void deleteAthlete(AthleteRequest request) {
        // TODO: 13.09.2022 Muuta  
    }
}
