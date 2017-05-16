package com.zipcodewilmington;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PhoneBookTest{

    PhoneBook book;
    String num1;
    String num2;
    String name1;
    String name2;

    @Before
    public void initialize() {
        book = new PhoneBook();
        num1 = "(302)731-1176";
        num2 = "(302)598-6245";
        name1 = "Kirby Kim";
        name2 = "Chris Kim";
    }

    @Test
    public void lookupTest(){
        String expected = "(302)731-1176";

        //When
        book.add(name1, num1);
        String actual = book.lookup("Kirby Kim");

        //Then
        assertEquals("Kirby Kim's phone number should correctly return (302)731-1176", expected, actual);
    }

    @Test
    public void addTestForSize(){
        //Given
        int expected = 1;

        //When
        book.add(name1, num1);
        int actual = book.size();

        //Then
        assertEquals("Size of Phonebook should be 1", expected, actual);
    }

    @Test
    public void addTestForEntry(){
        //Given
        String expected = "(302)731-1176";

        //When
        book.add(name1, num1);
        String actual = book.lookup("Kirby Kim");

        //Then
        assertEquals("The one entry should be Kirby Kim, (302)731-1176", expected, actual);
    }

    @Test
    public void removeTest(){
        //Given

        //When

        //Then
    }

    @Test
    public void listNamesTest(){
        //Given

        //When

        //Then
    }

    @Test
    public void listEntriesTest(){
        //Given

        //When

        //Then
    }

    @Test
    public void reverseLookupTest(){
        //Given

        //When

        //Then
    }
}
