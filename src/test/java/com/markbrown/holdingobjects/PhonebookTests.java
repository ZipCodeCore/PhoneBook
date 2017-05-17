package com.markbrown.holdingobjects;

import org.junit.Test;
import org.junit.Assert;

public class PhonebookTests {

    @Test
    public void testAdditionOfEntryToPhoneBook() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntry = new PhonebookEntry();
        phonebookEntry.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntry.addValidPhoneNumberToEntry(302, 598,1987);

        //When
        phonebook.addEntryToPhonebook(phonebookEntry);

        //Assert
        Assert.assertTrue(phonebook.getPhonebookEntries().size() == 1);
    }

    @Test
    public void testRemovalOfEntryToPhoneBook() {
        //Given
        Phonebook phonebook = new Phonebook();
        PhonebookEntry phonebookEntryOne = new PhonebookEntry();
        PhonebookEntry phonebookEntryTwo = new PhonebookEntry();

        phonebookEntryOne.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntryOne.addValidPhoneNumberToEntry(302, 598,1987);
        phonebookEntryTwo.addValidPhonebookNameToEntry("Krusty", "Krab");
        phonebookEntryTwo.addValidPhoneNumberToEntry(302, 598,1987);
        phonebook.addEntryToPhonebook(phonebookEntryOne);
        phonebook.addEntryToPhonebook(phonebookEntryTwo);

        //When
        phonebook.removeEntryFromPhonebook(phonebookEntryTwo);

        //Assert
        Assert.assertTrue(phonebook.getPhonebookEntries().size() == 1);
    }

    @Test
    public void testLookUpEntry() {
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
        String expectedOutput = "(302)-598-1987";

        //When
        String actualOutput = phonebook.lookup("Krusty, Krab");

        //Assert
        Assert.assertTrue(expectedOutput.equals(actualOutput));
    }

    @Test
    public void testLookUpEntryCanBeAbsent() {
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
        String expectedOutput = "(302)-598-1987";

        //When
        String actualOutput = phonebook.lookup("Summer, Sandy");

        //Assert
        Assert.assertTrue(!expectedOutput.equals(actualOutput));
    }

}
