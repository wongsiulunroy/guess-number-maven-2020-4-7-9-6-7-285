package com.oocl;

public class App {
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
        while (GuessNumber.isGameOn(gameCounter)) {
            String userInput = inputReader.getUserInput();
            while (!GuessNumber.isInputValid(game, userInput) && GuessNumber.isGameOn(gameCounter)) {
                System.out.println(WRONG_INPUT_MESSAGE);
                userInput = inputReader.getUserInput();
                gameCounter++;
            }
            if (GuessNumber.isInputValid(game, userInput) && GuessNumber.isGameOn(gameCounter)) {
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
}
