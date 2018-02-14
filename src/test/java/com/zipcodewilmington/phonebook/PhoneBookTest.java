package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

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
    public void addAndLookUpTest1(){

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Bob", "8743845682"));
        List n = testPhoneBook.lookUp("Bob");
        assertTrue((n.equals("8743845682")));
    }

    @Test
    public void addTestAndLookUpTest2() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sally", "8345636538");
        List n = testPhoneBook.lookUp("Sally");
        assertTrue((n.equals("8345636538")));

    }

    @Test
    public void removeTest1(){

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Joe", "7473549123");
        testPhoneBook.add("Mat", "6484759803");
        testPhoneBook.remove("Mat");
         List actual = testPhoneBook.lookUp("Mat");
        assertEquals(null, actual);

    }

    @Test
    public void removeTest2(){

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sue", "9845032923");
        testPhoneBook.add("Gary", "1632742724");
        testPhoneBook.add("Vince", "2745958293");
        testPhoneBook.remove("Vince");
        List actual = testPhoneBook.lookUp("Vince");
        assertEquals(null, actual);

    }

    @Test
    public void listNameTest1(){
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sue", "9845032923");
        testPhoneBook.add("Gary", "1632742724");
        testPhoneBook.add("Vince", "2745958293");

        String[] actual = testPhoneBook.listName();
        String[] expected = { "Gary", "Sue", "Vince"};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void listNameTest2(){
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Eric", "9845032923");
        testPhoneBook.add("Jack", "1632742724");
        testPhoneBook.add("Jane", "2745958293");

        String[] actual = testPhoneBook.listName();
        String[] expected = { "Eric", "Jack", "Jane"};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void listNameAndNumberTest1(){

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Valkyr", "9845032923");
        testPhoneBook.add("Banshee", "1632742724");
        testPhoneBook.add("Frost", "2745958293");

        String actual = testPhoneBook.listNameAndNumbers();
        String expected = "Banshee: 1632742724\nFrost: 2745958293\nValkyr: 9845032923\n";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void listNameAndNumberTest2(){

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Saryn", "83342983745");
        testPhoneBook.add("Nidus", "01258246954");
        testPhoneBook.add("Titania", "2850349549");
        testPhoneBook.add("Harrow", "8934998234");

        String actual = testPhoneBook.listNameAndNumbers();
        String expected = "Harrow: 8934998234\nNidus: 01258246954\nSaryn: 83342983745\nTitania: 2850349549\n";
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void reverseLookUpTest1() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sally", "8345636538");
        String r = testPhoneBook.reverseLookUp("8345636538");
        assertTrue((r.equals("Sally")));
    }

    @Test
    public void reverseLookUpTest2() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Sally", "8345636538");
        testPhoneBook.add("Bob", "8374862467");
        testPhoneBook.add("Harrow", "8934998234");
        String r = testPhoneBook.reverseLookUp("8934998234");
        assertTrue((r.equals("Harrow")));
    }


}
