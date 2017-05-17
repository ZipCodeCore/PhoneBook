package com.markbrown.holdingobjects;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.slf4j.*;

public class PhonebookTests {

    @Test
    public void testAdditionOfEntryToPhoneBook() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntry = new PhonebookEntry();
        phonebookEntry.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntry.addValidPhoneNumberToEntry(302, 598, 1987);
        phonebookEntry.addValidPhoneNumberToEntry(302, 789, 1123);
        int expectedOutcome = 2;

        //When
        phonebook.addEntryToPhonebook(phonebookEntry);
        int actualOutcome = phonebook.getPhonebookEntries().get("Squarepants, Spongebob").size();

        //Assert
        Assert.assertTrue(expectedOutcome == actualOutcome);
    }

    @Test
    public void testRemovalOfEntryFromPhoneBook() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntryOne = new PhonebookEntry();
        PhonebookEntry phonebookEntryTwo = new PhonebookEntry();

        phonebookEntryOne.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntryOne.addValidPhoneNumberToEntry(302, 598,1987);
        phonebookEntryOne.addValidPhoneNumberToEntry(444,555,8888);
        phonebookEntryOne.addValidPhoneNumberToEntry(234,678,9123);
        phonebookEntryTwo.addValidPhonebookNameToEntry("Krusty", "Krab");
        phonebookEntryTwo.addValidPhoneNumberToEntry(302, 598,1987);
        phonebook.addEntryToPhonebook(phonebookEntryOne);
        phonebook.addEntryToPhonebook(phonebookEntryTwo);
        int expectedOutput = 2;

        //When
        phonebook.removeEntryFromPhonebook("(444)-555-8888");
        int actualOutput = phonebook.getPhonebookEntries().get("Squarepants, Spongebob").size();

        //Assert
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemovalOfEntirePhoneBookEntry() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntryOne = new PhonebookEntry();
        PhonebookEntry phonebookEntryTwo = new PhonebookEntry();

        phonebookEntryOne.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntryOne.addValidPhoneNumberToEntry(302, 598,1987);
        phonebookEntryOne.addValidPhoneNumberToEntry(444,555,8888);
        phonebook.addEntryToPhonebook(phonebookEntryOne);
        String expectedOutput = "Person not listed in phonebook.";

        //When
        phonebook.removeEntireEntryFromPhonebook("Squarepants, Spongebob");
        String actualOutput = phonebook.lookup("Squarepants, Spongebob");
        System.out.println(actualOutput);
        //Assert
        Assert.assertTrue(expectedOutput.equals(actualOutput));
    }

    @Test
    public void testPrintAllNames() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntryTwo = new PhonebookEntry();
        phonebookEntryTwo.addValidPhonebookNameToEntry("Krusty", "Krab");
        phonebookEntryTwo.addValidPhoneNumberToEntry(302, 598,1987);
        phonebook.addEntryToPhonebook(phonebookEntryTwo);
        PhonebookEntry phonebookEntryThree = new PhonebookEntry();
        phonebookEntryThree.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntryThree.addValidPhoneNumberToEntry(598, 888,2212);
        phonebook.addEntryToPhonebook(phonebookEntryThree);
        PhonebookEntry phonebookEntryFour = new PhonebookEntry();
        phonebookEntryFour.addValidPhonebookNameToEntry("Dog", "Alpha");
        phonebookEntryFour.addValidPhoneNumberToEntry(777, 432,1134);
        phonebook.addEntryToPhonebook(phonebookEntryFour);
        int expectedOutput = 3;


        //When
        int actualOutput = phonebook.getPhonebookEntries().size();
        Phonebook.printAllNames(phonebook);

        //Assert
        Assert.assertTrue(expectedOutput == actualOutput);

    }

    @Test
    public void testPrintAllEntries() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntryTwo = new PhonebookEntry();
        phonebookEntryTwo.addValidPhonebookNameToEntry("Krusty", "Krab");
        phonebookEntryTwo.addValidPhoneNumberToEntry(302, 598,1987);
        phonebook.addEntryToPhonebook(phonebookEntryTwo);
        PhonebookEntry phonebookEntryThree = new PhonebookEntry();
        phonebookEntryThree.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntryThree.addValidPhoneNumberToEntry(598, 888,2212);
        phonebook.addEntryToPhonebook(phonebookEntryThree);
        PhonebookEntry phonebookEntryFour = new PhonebookEntry();
        phonebookEntryFour.addValidPhonebookNameToEntry("Dog", "Alpha");
        phonebookEntryFour.addValidPhoneNumberToEntry(777, 432,1134);
        phonebook.addEntryToPhonebook(phonebookEntryFour);
        int expectedOutput = 3;


        //When
        int actualOutput = phonebook.getPhonebookEntries().size();
        Phonebook.printAllEntries(phonebook);

        //Assert
        Assert.assertTrue(expectedOutput == actualOutput);

    }

}
