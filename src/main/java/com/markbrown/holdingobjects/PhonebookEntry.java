package com.markbrown.holdingobjects;

import java.io.IOException;
import java.util.Comparator;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;


/**
 * Created by markbrown on 5/16/17.
 */
public class PhonebookEntry {

    private String phoneBookName;
    private ArrayList<String> phoneNumbers = new ArrayList<String>();

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
        phoneNumbers.add("(" + areaCode + ")-" + corporateCode + "-" + localCode);
    }

    public String getPhoneBookName() {return phoneBookName;}
    public ArrayList<String> getPhoneNumbers() {return phoneNumbers;}

}
