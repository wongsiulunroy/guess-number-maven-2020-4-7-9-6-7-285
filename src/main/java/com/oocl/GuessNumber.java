package com.oocl;

public class GuessNumber {
    public String calculateResult(String inputNumber) {
        String expectedNumber = "1234";
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
}
