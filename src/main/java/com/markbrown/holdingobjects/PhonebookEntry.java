package com.markbrown.holdingobjects;

import java.util.Comparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

/**
 * Created by markbrown on 5/16/17.
 */
public class PhonebookEntry {

    private static final Logger logger = LoggerFactory.getLogger(PhonebookEntry.class);
    private enum RANDOM_FIRST_NAMES {ALEX, ANNE, BOB, BELINDA, CARLA, CHRIS, DELILAH, DAN, EVAN, ELLIE, FRAN, FELIX, GAVIN, GRACE, HELEN, HARRY, ILDA, IYASU, JAMES, JANE};
    private enum RANDOM_LAST_NAMES {JACKSON, ANDERSON, LOUIS, FLORENCE, BROWN, HILL, DEAN, EDWARDS, CLINTON, BUSH, NIXON, GALE, ALDRIN, GREENE, FORD, CARTER, TRUMP, JEFFERSON, YOUNG, WASHINGTON, ADAMS};
    private int areaCode;
    private int corporateCode;
    private int localCode;


    public PhonebookEntry() {}

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

    

}
