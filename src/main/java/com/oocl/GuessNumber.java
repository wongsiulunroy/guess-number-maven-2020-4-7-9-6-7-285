package com.oocl;

import java.util.*;

public class GuessNumber {
    public static final int MAX_GAME_PLAY = 6;
    public static final String DELIMITER = "";
    public static final int MAX_LENGTH_DIGIT = 4;
    public static final String CORRECT_OUTPUT = "4A0B";

    public static boolean isInputValid(GuessNumber game, String userInput) {
        return game.checkUserInput(userInput);
    }

    public static boolean isGameOn(int gameCounter) {
        return gameCounter <= MAX_GAME_PLAY;
    }

    public static boolean isWin(String calculatedResult) {
        return calculatedResult.equals(CORRECT_OUTPUT);
    }

    public String calculateResult(String inputNumber, String expectedNumber) {
        int valueA = 0;
        int valueB = 0;
        for (int index = 0; index < inputNumber.length(); index++) {
            for (int secondIndex = 0; secondIndex < expectedNumber.length(); secondIndex++) {
                if (inputNumber.charAt(index) == expectedNumber.charAt(index)) {
                    valueA++;
                    break;
                } else if (inputNumber.charAt(index) == expectedNumber.charAt(secondIndex)) {
                    valueB++;
                }
            }
        }
        return String.format("%dA%dB", valueA, valueB);
    }

    public boolean checkUserInput(String userInput) {
        List<String> checkDistinct;
        if (userInput.length() != MAX_LENGTH_DIGIT) {
            return false;
        }
        checkDistinct = Arrays.asList(userInput.split(DELIMITER));
        if (checkDistinct.size() != checkDistinct.stream().distinct().count()) {
            return false;
        }
        return true;
    }
}
