package com.oocl;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GuessNumberTest{
    @Test
    public void should_output_1A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("1567","1234");
        assertEquals("1A0B",result);
    }
    @Test
    public void should_output_0A2B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("2478","1234");
        assertEquals("0A2B",result);
    }
    @Test
    public void should_output_1A2B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("0324","1234");
        assertEquals("1A2B",result);
    }
    @Test
    public void should_output_0A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("5678","1234");
        assertEquals("0A0B",result);
    }
    @Test
    public void should_output_0A4B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("4321","1234");
        assertEquals("0A4B",result);
    }
    @Test
    public void should_output_4A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("1234","1234");
        assertEquals("4A0B",result);
    }

    /*@Test
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
    }*/

    @Test
    public void should_read_input_from_user(){
        //GuessNumber guessnumber = new GuessNumber();
        InputReader inputReader = new InputReader();
        String SimulatedInput = "1379";
        InputStream in = new ByteArrayInputStream(SimulatedInput.getBytes());
        System.setIn(in);
        assertEquals("1379",inputReader.getUserInput());
    }

    @Test
    public void should_check_valid_input_less_than_4_digit(){
        GuessNumber guessnumber = new GuessNumber();
        InputReader inputReader = new InputReader();
        String SimulatedInput = "123";
        InputStream in = new ByteArrayInputStream(SimulatedInput.getBytes());
        System.setIn(in);
        boolean test = guessnumber.checkUserInput(inputReader.getUserInput());
        assertFalse(test);
    }
    @Test
    public void should_check_valid_input_duplicate_digit(){
        GuessNumber guessnumber = new GuessNumber();
        InputReader inputReader = new InputReader();
        String SimulatedInput = "1123";
        InputStream in = new ByteArrayInputStream(SimulatedInput.getBytes());
        System.setIn(in);
        boolean test = guessnumber.checkUserInput(inputReader.getUserInput());
        assertFalse(test);
    }



}
