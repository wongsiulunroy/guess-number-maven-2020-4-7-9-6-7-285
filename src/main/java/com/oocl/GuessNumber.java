package com.oocl;

import java.util.*;

public class GuessNumber {
    public static final int MAX_GAME_PLAY = 6;
    public static final String WRONG_INPUT_MESSAGE = "Wrong Input, Input again!";
    public static final String CORRECT_OUTPUT = "4A0B";
    public static final String WIN_MESSAGE = "\nYou win!";

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        AnswerGenerator answerGenerator = new AnswerGenerator();
        InputReader inputReader = new InputReader();
        String expectedResult = answerGenerator.generateRandomNumber();
        String calculatedResult = "";
        int gameCounter = 1;
        while (isGameOn(gameCounter)) {
            String userInput = inputReader.getUserInput();
            while (!isInputValid(game, userInput) && isGameOn(gameCounter)) {
                System.out.println(WRONG_INPUT_MESSAGE);
                userInput = inputReader.getUserInput();
                gameCounter++;
            }
            if (isInputValid(game, userInput) && isGameOn(gameCounter)) {
                calculatedResult = game.calculateResult(userInput, expectedResult);
                System.out.print(calculatedResult);
                if (calculatedResult.equals(CORRECT_OUTPUT)) {
                    System.out.print(WIN_MESSAGE);
                    break;
                }
                gameCounter++;
            }
        }
    }

    private static boolean isInputValid(GuessNumber game, String userInput) {
        return game.checkUserInput(userInput);
    }

    private static boolean isGameOn(int gameCounter) {
        return gameCounter <= MAX_GAME_PLAY;
    }


    public String calculateResult(String inputNumber, String expectedNumber) {
        int valueA = 0;
        int valueB = 0;
        for (int index = 0; index < inputNumber.length(); index++) {
            for (int secondIndex = 0; secondIndex < expectedNumber.length(); secondIndex++) {
                if (inputNumber.charAt(index) == expectedNumber.charAt(index)) {
                    valueA++;
                    break;
                } else if (inputNumber.charAt(index) == expectedNumber.charAt(secondIndex)){
                    valueB++;
                }
            }
        }
        return String.format("%dA%dB", valueA, valueB);
    }

    public boolean checkUserInput(String userInput) {
        int requiredLengthOfInput = 4;
        List<String> checkDistinct;
        if (userInput.length() != requiredLengthOfInput) {
            //System.out.println(userInput.length());
            return false;
        }
        checkDistinct = Arrays.asList(userInput.split(""));
        if (checkDistinct.size() != checkDistinct.stream().distinct().count()) {
            return false;
        }
        return true;
    }
}
