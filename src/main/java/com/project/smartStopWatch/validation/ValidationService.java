package com.project.smartStopWatch.validation;


import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public class ValidationService {

    public static final String USERNAME_EXISTS = "Username already in use";
    public static final String INCORRECT_LOGIN_INPUT = "Username or password is incorrect.";
    public static final String ATHLETE_EXISTS = "Athlete does not exist";
    public static final String ACTIVE_ATHLETE_EXISTS = "Active athlete already exists";
    public static final String ATHLETE_NAME_TOO_LONG = "Athlete name is too long";
    public static final String HEAT_START_NOT_ALLOWED = "Heat start now allowed";
    public static final String NEW_SPLIT_NOT_ALLOWED = "New split is not allowed";
    public static final String SPLIT_PROCESSING_NOT_ALLOWED = "Split click process is not allowed";
    private static final String SPLIT_UNDO_NOT_ALLOWED = "Split undo process is not allowed";

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

    public static void validateStartHeatIsAllowedWithAthleteEvents(List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            if (athleteEvent.getStartTime() != null) {
                String name = athleteEvent.getAthlete().getName();
                throw new BusinessException(HEAT_START_NOT_ALLOWED, "Athlete '" + name + "' already has a heat start time registered. Cannot start new heat");
            }
        }

    }

    public static void validateAllowedAddSplit(AthleteEvent athleteEvent) {
        if (athleteEvent.getStartTime() == null) {
            String name = athleteEvent.getAthlete().getName();
            throw new BusinessException(NEW_SPLIT_NOT_ALLOWED, "Athlete '" + name + "' does not have a registered heat start time. Cannot add new split.");
        }

        if (athleteEvent.getAthlete() == null) {
            throw new BusinessException(NEW_SPLIT_NOT_ALLOWED, "No athlete assigned to the position. Cannot add new split.");
        }
    }

    public static void validateSplitClickAllowed(AthleteEvent athleteEvent) {
        if (athleteEvent.getSplitCounter() + 1 > athleteEvent.getSplitCountRequired()) {
            throw new BusinessException(SPLIT_PROCESSING_NOT_ALLOWED, "All Splits are completed. New splits are not allowed.");
        }
    }

    public static void validateUndoClickAllowed(AthleteEvent athleteEvent) {
        if (athleteEvent.getSplitCounter() - 1 < 0) {
            throw new BusinessException(SPLIT_UNDO_NOT_ALLOWED, "There are no more splits to remove. Undo split is not allowed.");
        }
    }
}
