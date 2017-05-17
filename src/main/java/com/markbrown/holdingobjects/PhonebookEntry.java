package com.markbrown.holdingobjects;

import java.io.IOException;
import java.util.Comparator;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by markbrown on 5/16/17.
 */
public class PhonebookEntry implements Comparable<PhonebookEntry> {

    private enum RANDOM_FIRST_NAMES {ALEX, ANNE, BOB, BELINDA, CARLA, CHRIS, DELILAH, DAN, EVAN, ELLIE, FRAN, FELIX, GAVIN, GRACE, HELEN, HARRY, ILDA, IYASU, JAMES, JANE};
    private enum RANDOM_LAST_NAMES {JACKSON, ANDERSON, LOUIS, FLORENCE, BROWN, HILL, DEAN, EDWARDS, CLINTON, BUSH, NIXON, GALE, ALDRIN, GREENE, FORD, CARTER, TRUMP, JEFFERSON, YOUNG, WASHINGTON, ADAMS};
    private String phoneBookName;
    private String phoneNumber;

    public PhonebookEntry() {}

    public void addValidPhonebookNameToEntry(String lastName, String firstName) throws InvalidInputException {
        if (NumberUtils.isParsable(lastName) || NumberUtils.isParsable(firstName)) {
            throw new InvalidInputException("Name input is not valid");
        }
        phoneBookName = (lastName + ", " + firstName);
    }

    public void addValidPhoneNumberToEntry(int areaCode, int corporateCode, int localCode) throws InvalidInputException {
        if (!("(" + areaCode + ")-" + corporateCode + "-" + localCode).matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidInputException("Phone number input is not valid");
        }
        phoneNumber = "(" + areaCode + ")-" + corporateCode + "-" + localCode;
    }

    public String getPhoneBookName() {return phoneBookName;}
    public String getPhoneNumber() {return phoneNumber;}

    public static int generateRandomAreaCode() {
        return (int) Math.floor(Math.random()*900) + 100;
    }


    public static int generateRandomCorporateCode() {
        return (int) Math.floor(Math.random()*900) + 100;
    }


    public static int generateRandomLocalCode() {
        return (int) Math.floor(Math.random()*9000) + 1000;
    }


    public static String generateRandomPhoneNumber() {
        return ("(" + generateRandomAreaCode() + ")-" + generateRandomCorporateCode() + "-" + generateRandomLocalCode());
    }


    public static String generateRandomName() {
        return generateRandomLastName() + ", " + generateRandomFirstName();
    }


    private static String generateRandomFirstName() {
        RANDOM_FIRST_NAMES[] names = RANDOM_FIRST_NAMES.values();
        Random random = new Random();
        return names[random.nextInt(names.length)].toString();
    }


    private static String generateRandomLastName() {
        RANDOM_LAST_NAMES[] names = RANDOM_LAST_NAMES.values();
        Random random = new Random();
        return names[random.nextInt(names.length)].toString();
    }

    public int compareTo(PhonebookEntry otherPhonebookEntry) {
        int index = 0;
        while (index != Math.min(this.phoneBookName.length(), otherPhonebookEntry.phoneBookName.length())) {
            if (this.phoneBookName.charAt(index) == otherPhonebookEntry.phoneBookName.charAt(index)) {
                if (index == this.phoneBookName.length() - 1) {
                    return -1;
                } else if (index == otherPhonebookEntry.phoneBookName.length() - 1) {
                    return 1;
                } else if (index == this.phoneBookName.length() - 1 && index == otherPhonebookEntry.phoneBookName.length() - 1) {
                    return 0;
                }
                index++;
            }
            else {
                if (this.phoneBookName.charAt(index) - otherPhonebookEntry.phoneBookName.charAt(index) > 0) {
                    return 1;
                }
                else {return -1;}
            }
        }
        return this.phoneBookName.charAt(index) - otherPhonebookEntry.phoneBookName.charAt(index);
    }

}
