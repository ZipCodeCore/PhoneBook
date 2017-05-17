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
    public void removeTestForSize(){
        //Given
        book.add(name1, num1);
        book.add(name2, num2);
        int expected = 1;

        //When
        book.remove("Chris Kim");
        int actual = book.size();

        //Then
        assertEquals("Size of phonebook ought to be 1 after remove", expected, actual);
    }

    @Test
    public void removeTestInvalidInput(){
        //Given
        book.add(name1, num1);
        book.add(name2, num2);
        int expected = 2;

        //When
        book.remove("Tim Kim");
        int actual = book.size();

        //Then
        assertEquals("Tim Kim is not in phone book, size should be 2", expected, actual);
    }

    @Test
    public void removeTestInvalidInputReturnsFalse(){
        //Given is in @Before

        //When
        boolean actual = book.remove("Tim Kim");

        //Then
        assertFalse("Tim Kim is not in phone book, remove(\"Tim Kim\") should return false" , actual);
    }

    @Test
    public void listNamesTest(){
        //Given
        book.add(name1, num1);
        book.add(name2, num2);
        String expected = "Chris Kim\nKirby Kim\n";

        //When
        String actual = book.listNames();

        //Then
        assertEquals("The return value should be \"Chris Kim\\nKirby Kim\n\"", expected, actual);
    }

    @Test
    public void listEntriesTest(){
        //Given
        book.add(name1, num1);
        book.add(name2, num2);
        String expected = "Chris Kim: (302)598-6245\nKirby Kim: (302)731-1176\n";

        //When
        String actual = book.listEntries();

        //Then
        assertEquals("The return value should be \"Chris Kim: (302)598-6245\\nKirby Kim: (302)731-1176\\n\";", expected, actual);
    }

    @Test
    public void reverseLookupTest(){
        //Given
        book.add(name1, num1);
        book.add(name2, num2);
        String expected = "Chris Kim";

        //When
        String actual = book.reverseLookup("(302)598-6245");

        //Then
        assertEquals("The result of the lookup should be \"Chris Kim\"", expected, actual);
    }

}
