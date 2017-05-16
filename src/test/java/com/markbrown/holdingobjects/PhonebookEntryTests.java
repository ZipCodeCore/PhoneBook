package com.markbrown.holdingobjects;

import org.junit.Test;
import org.junit.Assert;

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

        String[] phoneNumbers = new String[100000];
        for (int index = 0; index < phoneNumbers.length; index++) {
            phoneNumbers[index] = PhonebookEntry.generateRandomPhoneNumber();
        }
        for (String phoneNumber : phoneNumbers) {
            Assert.assertTrue((phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")));
        }

    }




}
