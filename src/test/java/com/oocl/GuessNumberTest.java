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

}
