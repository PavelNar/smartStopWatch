package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    @Resource
    private UserService userService;

    @Resource
    private AthleteMapper athleteMapper;

    @Resource
    private AthleteRepository athleteRepository;

    public AthleteInfo addAthlete(String name, Integer userId) {
        boolean athleteExists = athleteRepository.existsByNameAndIsActive(name, true);
        ValidationService.validateAthleteName(athleteExists, name);

        Athlete athlete = new Athlete();
        User user = userService.findUserByUserId(userId);
        athlete.setUser(user);
        athlete.setName(name);
        athlete.setIsActive(true);
        athleteRepository.save(athlete);
        return athleteMapper.athleteToAthleteInfo(athlete);
    }
    
    public void deleteAthlete(Integer request) {
        Athlete referenceById = athleteRepository.findById(request).get();
        referenceById.setIsActive(false);
        athleteRepository.save(referenceById);
    }

    public Athlete findById(Integer athleteId) {
        return athleteRepository.findById(athleteId).get();
    }

    public List<AthleteInfo> findActiveAthletesByUserId(Integer userId) {
        List<Athlete> athletes = athleteRepository.findActiveAthletesByUserId(userId, true);
        return athleteMapper.athletesToAthleteInfos(athletes);
    }

    public AthleteInfo findAthleteByName(String athleteName) {
        Optional<Athlete> athlete = athleteRepository.findByName(athleteName);
        ValidationService.validateAthleteName(athlete);
        AthleteInfo athleteInfo = athleteMapper.athleteToAthleteInfo(athlete.get());
        return athleteInfo;
    }
}
