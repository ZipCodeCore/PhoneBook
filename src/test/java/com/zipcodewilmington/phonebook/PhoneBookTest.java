package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    // constructor
    String name = "Jess";
    String number = "1234567";
    String nameA = "Alice";
    String numberA = "1111111";
    String nameB = "Sean";
    String numberB = "2222222";

    private PhoneBook phoneBook = new PhoneBook();
    // instance


   @Before
   public void setUp(){
       phoneBook = new PhoneBook();
   }

   @Test
   public boolean testAddAContact() {
    //instance of new phone book
//    phoneBook.addAContact(name, number);
//    Assert.assertTrue(phoneBook.addAContact(name, number).equals(name, number));
       TreeMap.containsKey(String);
       Assert.assertTrue(phoneBook.addAContact(name));

   }
@Test
    public void removeAContact(String name){
       //Given
        String expected = "Null";

        //When
        phoneBook.addAContact(expected);
        tmap.add(name);
        //first must add a name to map

        phoneBook.lookupContactName(expected);
        String actual = phoneBook.removeAContact();
        tmap.remove(name);
        //Then
        Assert.assertTrue(expected, actual);
    }
    @Test
    public void testLookupContactName (){
       //Given
       phoneBook.lookupContactName("Jess");
       String expected = "1234567";

       //When
       String actual = phoneBook.lookupContactName("Jess");

       //Then
       Assert.assertEquals(expected, actual);
    }

    @Test
    public void printOut(){
        System.out.println(phoneBook.listOfAllNames());

    }
}




