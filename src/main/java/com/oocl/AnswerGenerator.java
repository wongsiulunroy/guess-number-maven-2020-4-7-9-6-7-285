package com.oocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerGenerator {

    public String generateRandomNumber() {
        List<Integer> numbers = new ArrayList();
        for (int index = 0; index < 10; index++) {
            numbers.add(index);
        }
        Collections.shuffle(numbers);
        String result = "";
        for (int index = 0; index < 4; index++) {
            result += numbers.get(index).toString();
        }
        System.out.println(result);
        return result;
    }
}
