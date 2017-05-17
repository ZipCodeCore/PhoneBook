package com.markbrown.holdingobjects;

import org.junit.Test;
import org.junit.Assert;


/**
 * Unit test for PhonebookEntry Class
 */

public class PhonebookEntryTests  {

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
