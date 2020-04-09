package com.oocl;

import java.util.Scanner;

public class InputReader {

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter a 4-digit number: ");
        String userInput = in.nextLine();
        return userInput;
    }
}


