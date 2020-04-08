package com.oocl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuessNumberTest{
    @Test
    public void should_output_1A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("1567");
        assertEquals("1A0B",result);
    }
    @Test
    public void should_output_0A2B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("2478");
        assertEquals("0A2B",result);
    }
    @Test
    public void should_output_1A2B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("0324");
        assertEquals("1A2B",result);
    }
    @Test
    public void should_output_0A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("5678");
        assertEquals("0A0B",result);
    }
    @Test
    public void should_output_0A4B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("4321");
        assertEquals("0A4B",result);
    }
    @Test
    public void should_output_4A0B (){
        GuessNumber guessnumber = new GuessNumber();
        String result = guessnumber.calculateResult("1234");
        assertEquals("4A0B",result);
    }

    @Test
    public void should_generate_some_number(){
        GuessNumber guessnumber = new GuessNumber();
        String randomNumber = guessnumber.generateRandomNumber();
    }



}
