package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PersonTest {

    @Test
    public void testSetName() {
        Person person = new Person("Alice", "2152224444");
        person.setName("Alice");
       assertTrue(person.getName().equalsIgnoreCase("Alice"));
    }


    @Test
    public void testGetName() {
        Person person = new Person("Bo", "3156662222");
        person.setName("Bo");
        assertTrue(person.getName().equalsIgnoreCase("Bo"));
    }

    @Test
    public void testSetPhoneNumber() {
        Person person = new Person("Joe", "1234567890");
        person.setPhoneNumber("1234567890");
        assertTrue(person.getPhoneNumber().equals("1234567890"));
    }


    @Test
    public void testGetPhoneNumber() {
        Person person = new Person("Chris", "0987654321");
        person.setPhoneNumber("0987654321");
        assertTrue(person.getPhoneNumber().equals("0987654321"));
    }




}



