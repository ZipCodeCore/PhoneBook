package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addContactTest() {

        PhoneBook testPhoneBook = new PhoneBook();

        Contact contact1 = new Contact("Jerry");
        contact1.addPhoneNumber("1234");

        // Actual
        testPhoneBook.addContact("Jerry", "43234");

    }

    @Test
    public void getNumberOfContactsTest() {

        PhoneBook testPhoneBook = new PhoneBook();

        testPhoneBook.addContact("Jerry", "78998");
        testPhoneBook.addContact("Newman", "90980");
        testPhoneBook.addContact("Elaine", "432345");

        int expectedNumberOfContacts = 3;
        //int actualNumberOfContacts =
    }

    @Test
    public void lookupByNameTest() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact("Madeline", "898098");


        ArrayList expectedLookupByNameResult = new ArrayList();
        ArrayList actualLookupByNameResult = testPhoneBook.lookupByName("Madeline");

    }

    @Test
    public void lookupByNumberTest() {

        PhoneBook testPhoneBook = new PhoneBook();




    }

    @Test
    public void removeContactTest() {
        // Given
        String personNameToRemove = "Bob";
        int expectedListSize = 0;

        // When
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact(personNameToRemove, "23423");
        testPhoneBook.removeContact(personNameToRemove);



        Assert.assertEquals(expectedListSize, testPhoneBook.getNumberOfContacts());
    }

    @Test
    public void listAllContactsTest() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact("Kramer", "23423");

        Collection actualContactsList = testPhoneBook.listAllContacts();


        // Actual
        // Create object
        Collection expectedContactsList = new ArrayList<Contact>();
        Contact contact1 = new Contact("Kramer");


        contact1.addPhoneNumber("23423");

        // add contacts to expectedList
        expectedContactsList.add(contact1);


        Assert.assertEquals(expectedContactsList, actualContactsList);
        }




    }


    //addContact ---- done
    //removeContact ----- done
    //lookupByName ----- done
    //lookupByNumber
    //addPhoneNumber ---- done
    //removePhoneNumber ---- done
    //list all entries (names & phone numbers) ----- done


//    @Test
//    public void testGetName() {
//        // Given
//        String expectedName = "Bob";
//
//
//        // When
//        Person person = new Person("Bob", ;
//
//        // Then
//        String actualName = person.getName();
//        Assert.assertEquals(expectedName, actualName);
//
//    }


    //    @Test
//    public void testGetPhoneNumber() {
//        // Given
//        String expectedName = "Madeline";
//        String expectedPhoneNumber = "123";
//
//        // When
//        Person person = new Person(expectedName, expectedPhoneNumber);
//
//        // Then
//        String actualPhoneNumber = person.getPhoneNumber();
//        String actualName = person.getName();
//
//        Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber);
//        Assert.assertEquals(expectedName, actualName);
//    }
//

//
//
//
//    @Test
//    public void testLookup() {
//        PhoneBook testPB = new PhoneBook();
//        testPB.addPerson("bob", "123");
//
//        String actualPhoneNumber = testPB.lookupPhoneNumber("Bob");
//        Assert.assertEquals("123", actualPhoneNumber);
//
//    }


