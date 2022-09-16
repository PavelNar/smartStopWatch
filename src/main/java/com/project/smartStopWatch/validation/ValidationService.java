package com.project.smartStopWatch.validation;


import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;

import java.util.Optional;

public class ValidationService {

    public static final String USERNAME_EXISTS = "Username already in use";
    public static final String INCORRECT_LOGIN_INPUT = "Username or password is incorrect.";
    public static final String ATHLETE_EXISTS = "Athlete does not exist";
    public static final String ACTIVE_ATHLETE_EXISTS = "Active athlete already exists";
    public static final String ATHLETE_NAME_TOO_LONG = "Athlete name is too long";

    public static void validateUserExists(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException(INCORRECT_LOGIN_INPUT, INCORRECT_LOGIN_INPUT + " Try again.");
        }
    }

    public static void validateUsernameExists(Optional<User> user) {
        if (user.isPresent()) {
            throw new BusinessException(USERNAME_EXISTS, USERNAME_EXISTS);
        }
    }

    public static void validateAthleteName(Optional<Athlete> athlete) {
        if (athlete.isEmpty()) {
            throw new BusinessException(ATHLETE_EXISTS, ATHLETE_EXISTS);
        }
    }

    public static void validateAthleteName(boolean athleteExists, String name) {
        if (athleteExists) {
            throw new BusinessException(ACTIVE_ATHLETE_EXISTS, "Active athlete with '" + name + "' already exists");
        }
        if (name.length() > 255) {
            throw new BusinessException(ATHLETE_NAME_TOO_LONG, "Athlete name " + name + " is too long. Please use maximum 255 characters");
        }
    }
}
