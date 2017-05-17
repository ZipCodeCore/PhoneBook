package com.markbrown.holdingobjects;

import org.junit.Test;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;

/**
 * Unit test for PhonebookEntry Class
 */

public class PhonebookEntryTests  {

    //Tests that randomly generated local code ranges between 1000 and 9999
    @Test
    public void testGenerateRandomLocalCodeRange() {

        int[] localCodes = new int[100000];
        for (int index = 0; index < localCodes.length; index++) {
            localCodes[index] = PhonebookEntry.generateRandomLocalCode();
        }
        for (int localCode : localCodes) {

            Assert.assertTrue(localCode > 999 && localCode < 10000);
        }

    }

    //Tests that randomly generated corporate code ranges between 100 and 999
    @Test
    public void testGenerateRandomCorporateCodeRange() {

        int[] corporateCodes = new int[100000];
        for (int index = 0; index < corporateCodes.length; index++) {
            corporateCodes[index] = PhonebookEntry.generateRandomCorporateCode();
        }
        for (int corporateCode : corporateCodes) {
            Assert.assertTrue(corporateCode > 99 && corporateCode < 1000);
        }

    }

    //Tests that randomly generated area code ranges between 100 and 999
    @Test
    public void testGenerateRandomAreaCodeRange() {

        int[] areaCodes = new int[100000];
        for (int index = 0; index < areaCodes.length; index++) {
            areaCodes[index] = PhonebookEntry.generateRandomAreaCode();
        }
        for (int areaCode : areaCodes) {
            Assert.assertTrue(areaCode > 99 && areaCode < 1000);
        }

    }

    @Test
    public void testRandomPhoneNumberHasProperSyntax() {

        String[] phonebookEntries = new String[100000];
        for (int index = 0; index < phonebookEntries.length; index++) {
            phonebookEntries[index] = PhonebookEntry.generateRandomPhoneNumber();
        }
        for (String phoneNumber : phonebookEntries) {
            Assert.assertTrue((phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")));
        }

    }

    @Test
    public void testPhoneBookEntrySorting() {
        //Given
        PhonebookEntry phonebookEntry1 = new PhonebookEntry();
        PhonebookEntry phonebookEntry2 = new PhonebookEntry();
        try {
            phonebookEntry1.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
            phonebookEntry2.addValidPhonebookNameToEntry("Krab", "Krusty");
            phonebookEntry1.addValidPhoneNumberToEntry(302, 590,1001);
            phonebookEntry2.addValidPhoneNumberToEntry(888,555,1100);
        } catch (InvalidInputException invalidInputException) {
        }

        //When
        int comparison = phonebookEntry1.compareTo(phonebookEntry2);

        //Then
        Assert.assertTrue(comparison == 1);
    }

    @Test (expected = InvalidInputException.class)
    public void testPhoneBookEntryExceptionInvalidName() {
        //Given
        PhonebookEntry phonebookEntry1 = new PhonebookEntry();

        //When
        phonebookEntry1.addValidPhonebookNameToEntry("8888", "Spongebob");
        phonebookEntry1.addValidPhoneNumberToEntry(302, 590,1001);
    }

    @Test (expected = InvalidInputException.class)
    public void testPhoneBookEntryExceptionInvalidAreaCode() {
        //Given
        PhonebookEntry phonebookEntry1 = new PhonebookEntry();

        //When
        phonebookEntry1.addValidPhonebookNameToEntry("Squarepants", "Spongebob");
        phonebookEntry1.addValidPhoneNumberToEntry(005, 590,1001);
    }

    @Test (expected = InvalidInputException.class)
    public void testPhoneBookEntryExceptionInvalidCorporateCode() {
        //Given
        PhonebookEntry phonebookEntry2 = new PhonebookEntry();

        //When
        phonebookEntry2.addValidPhonebookNameToEntry("Krab", "Krusty");
        phonebookEntry2.addValidPhoneNumberToEntry(888,077,1100);
    }

    @Test (expected = InvalidInputException.class)
    public void testPhoneBookEntryExceptionInvalidLocalCode() {
        //Given
        PhonebookEntry phonebookEntry2 = new PhonebookEntry();

        //When
        phonebookEntry2.addValidPhonebookNameToEntry("Krab", "Krusty");
        phonebookEntry2.addValidPhoneNumberToEntry(888,777,0100);
    }


}
