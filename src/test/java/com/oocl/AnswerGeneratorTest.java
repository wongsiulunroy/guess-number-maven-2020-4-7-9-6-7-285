package com.oocl;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class AnswerGeneratorTest {

    @Test
    public void should_generate_some_number(){
        GuessNumber guessnumber = new GuessNumber();
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String randomNumber = answerGenerator.generateRandomNumber();
        List<String> checkNumberList;
        boolean nonRepeat = false;
        checkNumberList = Arrays.asList(randomNumber.split(""));
        if (checkNumberList.size() == checkNumberList.stream().distinct().count()){
            nonRepeat = true;
        }
        Assert.assertEquals(true, nonRepeat);
    }
}