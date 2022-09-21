package com.project.smartStopWatch.domain.athlete;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
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
        return athleteMapper.athleteToAthleteResponse(athlete);
    }

    public AthleteInfo findAthlete(String name) {
        Optional<Athlete> athlete = athleteRepository.findByName(name);
        ValidationService.validateAthleteName(athlete);
        return athleteMapper.athleteToAthleteResponse(athlete.get());
    }

    public void deleteAthlete(Integer request) {
        Athlete referenceById = athleteRepository.findById(request).get();
        referenceById.setIsActive(false);
        athleteRepository.save(referenceById);
    }

    public Athlete findByName(String athleteName) {
        Optional<Athlete> athlete = athleteRepository.findByName(athleteName);
        ValidationService.validateAthleteName(athlete);
        return athlete.get();
    }

    public Athlete findById(Integer athleteId) {
        return athleteRepository.findById(athleteId).get();
    }

    public List<AthleteInfo> findActiveAthletesByUserId(Integer userId) {
        List<Athlete> athletes = athleteRepository.findActiveAthletesByUserId(userId, true);
        return athleteMapper.athletesToAthleteInfos(athletes);
    }

    public AthleteInfo findAthleteById(Integer athleteId) {
        return athleteRepository.findById(athleteId).get();
    }
}
