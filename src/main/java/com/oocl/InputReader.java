package com.oocl;

import java.util.Scanner;

public class InputReader {
    public static final String INPUT_PROMPT_MESSAGE = "\nEnter a 4-digit number: ";

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print(INPUT_PROMPT_MESSAGE);
        return in.nextLine();
    }
}


