package com.zipcodewilmington;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    PhoneNumber phoneNumber;

    @Before
    public void initialize() throws InvalidPhoneNumberFormatException {
        phoneNumber = new PhoneNumber("(302)598-6245");
    }

    @Test (expected = InvalidPhoneNumberFormatException.class) //Then
    public void phoneNumberConstructorTest() throws InvalidPhoneNumberFormatException {
        //When
        PhoneNumber number = new PhoneNumber("-1");
    }

    @Test
    public void getAreaCodeTest(){
        //Given
        String expected = "302";

        //When
        String actual = phoneNumber.getAreaCode();

        //Then
        assertEquals("Area code is 302", expected, actual);
    }

    @Test
    public void getCentralOfficeCodeTest(){
        //Given
        String expected = "598";

        //When
        String actual = phoneNumber.getCentralOfficeCode();

        //Then
        assertEquals("Central office code is 598", expected, actual);
    }

    @Test
    public void getPhoneLineCodeTest(){
        //Given
        String expected = "6245";

        //When
        String actual = phoneNumber.getPhoneLineCode();

        //Then
        assertEquals("Phone line code should be 6245", expected, actual);
    }

    @Test
    public void toStringTest(){
        //Given
        String expected = "(302)598-6245";

        //When
        String actual = phoneNumber.toString();

        //Then
        assertEquals("Correct string is (302)598-6245", expected, actual);
    }
}
