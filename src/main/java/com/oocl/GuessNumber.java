package com.oocl;

import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        String expectedResult = game.generateRandomNumber();
        String calculatedResult="";
        int gameCounter = 1;
        while(gameCounter<=6) {
            String userInput = game.getUserInput();
            while (!game.checkUserInput(userInput) && gameCounter<=6){
                System.out.println("Wrong Input, Input again!");
                userInput = game.getUserInput();
                gameCounter++;
            }
            if (game.checkUserInput(userInput) && gameCounter<=6){
                calculatedResult = game.calculateResult(userInput, expectedResult);
                System.out.print(calculatedResult);
                if (calculatedResult.equals("4A0B")){
                    System.out.print("\nYou win!");
                    break;
                }
                gameCounter++;
            }

        }
    }



    public String calculateResult(String inputNumber, String expectedNumber) {
        String returnString="";
        int valueA = 0;
        int valueB = 0;

        for (int index = 0; index<inputNumber.length(); index ++ ) {
            for (int secondIndex = 0; secondIndex<expectedNumber.length(); secondIndex++){
                if (inputNumber.charAt(index) == expectedNumber.charAt(secondIndex)) {
                    valueB++;
                    if (inputNumber.charAt(index) == expectedNumber.charAt(index)) {
                        valueA++;
                        valueB--;
                    }
                }
            }
        }
        return String.format("%dA%dB",valueA,valueB);
    }

    public String generateRandomNumber() {
        List<Integer> numbers = new ArrayList();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += numbers.get(i).toString();
        }
        System.out.println(result);
        return result;
    }

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter a 4-digit number: ");
        String userInput = in.nextLine();
        //System.out.println(userInput);
        //in.close();1
        return userInput;
    }

    public boolean checkUserInput(String userInput) {
        int requiredLengthOfInput = 4;
        List<String> checkDistinct;
        if (userInput.length()!=requiredLengthOfInput){
            //System.out.println(userInput.length());
            return false;
        }
        checkDistinct = Arrays.asList(userInput.split(""));
        if (checkDistinct.size()!=checkDistinct.stream().distinct().count()){
            return false;
        }
        return true;
    }
}
