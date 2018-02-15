package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {
    @Test
    public void addAndLookUpTest1() {

        PhoneBook testPhoneBook = new PhoneBook();
        String expected = "8387474747";
        testPhoneBook.add("Bob", "8743845682", "8387474747");
        String actual = testPhoneBook.lookUp("Bob").get(1).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTestAndLookUpTest2() {

        PhoneBook testPhoneBook = new PhoneBook();
        String expected = "8345636538";
        testPhoneBook.add("Sally", "8345636538");
        String actual = testPhoneBook.lookUp("Sally").get(0).toString();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeTest1() {

        PhoneBook testPhoneBook = new PhoneBook();

        testPhoneBook.add("Joe", "7473549123");
        testPhoneBook.add("Mat", "6484759803");
        testPhoneBook.remove("Mat");
        String expected = "Joe: [7473549123]\n";
        String actual = testPhoneBook.listNameAndNumbers();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeTest2() {
        //Given
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sue", "9845032923");
        testPhoneBook.add("Gary", "1632742724");
        testPhoneBook.add("Vince", "2745958293");
        testPhoneBook.remove("Vince");
        String expected = "Gary: [1632742724]\nSue: [9845032923]\n";

        //When
        String actual = testPhoneBook.listNameAndNumbers();
        //Expected
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void listNameTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sue", "9845032923");
        testPhoneBook.add("Gary", "1632742724");
        testPhoneBook.add("Vince", "2745958293");

        String[] actual = testPhoneBook.listName();
        String[] expected = {"Gary", "Sue", "Vince"};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void listNameTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Eric", "9845032923");
        testPhoneBook.add("Jack", "1632742724");
        testPhoneBook.add("Jane", "2745958293");

        String[] actual = testPhoneBook.listName();
        String[] expected = {"Eric", "Jack", "Jane"};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void listNameAndNumberTest1() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Valkyr", "9845032923");
        testPhoneBook.add("Banshee", "1632742724");
        testPhoneBook.add("Frost", "2745958293");

        String actual = testPhoneBook.listNameAndNumbers();
        String expected = "Banshee: [1632742724]\nFrost: [2745958293]\nValkyr: [9845032923]\n";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void listNameAndNumberTest2() {

        PhoneBook testPhoneBook = new PhoneBook();
        List<String> testNumbers = new ArrayList<String>();

        testPhoneBook.add("Saryn", "83342983745");
        testPhoneBook.add("Nidus", "01258246954");
        testPhoneBook.add("Titania", "2850349549");
        testPhoneBook.add("Harrow", "8934998234");

        String actual = testPhoneBook.listNameAndNumbers();
        String expected = "Harrow: [8934998234]\nNidus: [01258246954]\nSaryn: [83342983745]\nTitania: [2850349549]\n";
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void reverseLookUpTest1() {

        PhoneBook testPhoneBook = new PhoneBook();

        testPhoneBook.add("Alex", "7473549123");
        testPhoneBook.add("Gayl", "6484759803");
        testPhoneBook.remove("Alex");
        String expected = "Gayl: [6484759803]\n";
        String actual = testPhoneBook.listNameAndNumbers();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void reverseLookUpTest2() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sally", "8345636538");
        testPhoneBook.add("Bob", "8374862467");
        testPhoneBook.add("Harrow", "8934998234");
        testPhoneBook.remove("Bob");
        String expected = "Harrow: [8934998234]\nSally: [8345636538]\n";
        String actual = testPhoneBook.listNameAndNumbers();
        Assert.assertEquals(expected, actual);
    }


}
