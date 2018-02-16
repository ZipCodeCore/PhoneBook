package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonTest {


    @Test
    public void getPersonNameTest() {
        //Given
        Person human = new Person("Eric", "302-999-1234");

        //When
        String expectedName = "Eric";
        String expectedNumber = "302-999-1234";
        String actual = human.getPersonName() + human.getPhoneNumbers();


        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

//@Test
//    public void addNumbersTest() {
//        //Given
//    Person human = new Person("Eric", "302-999-1234");
//
//    //When
//    human.addNumbers("302-222-9876");
//    String expectedNumber = "302-222-1234";
//    String actual = human.getPhoneNumbers();
//
//    Assert.assertTrue(actual.contains(expectedNumber));
//}

@Test
    public void printNameTest(){
        //Given
    Person human = new Person("Eric", "302-999-1234");

    //When
    String expectedName = "Eric";
    String actual = human.getPersonName();

    Assert.assertTrue(actual.contains(expectedName));
}

//@Test
//    public void printNumbersTest(){
//        //Given
//    Person human = new Person("Eric", "302-999-1234");
//    human.addNumbers("302-222-9876");
//
//    //When
//    String expectedNumbers = "";
//
//}


}

