package com.project.smartStopWatch.validation;


import com.project.smartStopWatch.domain.athlete.Athlete;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.infrastructure.exception.BusinessException;
import com.project.smartStopWatch.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

public class ValidationService {

    public static final String USERNAME_EXISTS = "Username already in use";
    public static final String INCORRECT_LOGIN_INPUT = "Username or password is incorrect.";
    public static final String ATHLETE_EXISTS = "Athlete does not exist";

    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
    public static final String MINIMUM_DEPOSIT_REQUIREMENT = "Miinumum deposiidi nõue";
    public static final Integer MINIMUM_DEPOSIT_AMOUNT = 5;
    public static final String INVALID_LOGIN_CREDENTIALS = "Vale kasutajanimi või parool";

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

    public static void validateAthleteExists(Optional<Athlete> athlete) {
        if (athlete.isEmpty()) {
            throw new BusinessException(ATHLETE_EXISTS, ATHLETE_EXISTS);
        }
    }
//    public static void validatePasswordUserExists(List<UserRole> userRoles) {
//        if (userRoles.isEmpty()) {
//            throw new DataNotFoundException(INVALID_LOGIN_CREDENTIALS, "Vale kasutajanimi või parool. Proovi uuesti :)");
//        }
//    }
//
//    public static void validateAccountExists(Optional<Account> account, Integer accountId) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellist kontot ID'ga " + accountId + " ei leitud");
//        }
//    }
//
//
//    public static void validateEnoughBalance(Integer amount, Account account) {
//        if (account.getBalance() - amount < 0) {
//            throw new BusinessException(INSUFFICIENT_FUNDS, "Kontol " + account.getAccountNumber() +
//                    " pole piisavalt vahendeid. Kontojääk on: " + account.getBalance());
//        }
//    }
//
//    public static void validateDepositAmount(Integer amount) {
//        if (amount < MINIMUM_DEPOSIT_AMOUNT) {
//            throw new BusinessException(MINIMUM_DEPOSIT_REQUIREMENT, "Miinimum deposiit alates €" + MINIMUM_DEPOSIT_AMOUNT);
//        }
//    }

}
