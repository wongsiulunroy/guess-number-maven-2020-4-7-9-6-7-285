package com.oocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        String expectedResult = game.generateRandomNumber();
        String calculatedResult="";
        int gameCounter = 1;
        while(gameCounter<=6) {
            String userInput = game.getUserInput();
            if (game.checkUserInput(userInput)){
                calculatedResult = game.calculateResult(userInput, expectedResult);
                System.out.print(calculatedResult);
                if (calculatedResult.equals("4A0B")){
                    System.out.print("\nYou win!");
                    break;
                }
                gameCounter++;
            }else {
                System.out.println("Wrong Input");
                break;
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
        if (userInput.length()!=requiredLengthOfInput){
            //System.out.println(userInput.length());
            return false;
        }
        return true;
    }
}
