package phonebook;

import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;


import exceptions.InvalidPhoneNumberFormatException;

/**
 * Created by anthonyjones on 5/16/17.
 */
public class PhoneBook {
    Logger logger = Logger.getLogger("*");

    Map<String, String> phoneInfo = new TreeMap<>();
    Scanner in = new Scanner(System.in);

    {
        phoneInfo.put("Sarah Silverman", "(302)-434-1849");
        phoneInfo.put("Ben Berger", "(802)-453-3582");
        phoneInfo.put("Lisa Knelly", "(732)-914-8849");
        phoneInfo.put("Steve Johns", "(412)-791-1823");
    }

    public PhoneBook() {
    }

    public PhoneBook(InputStream scannerIn) {
        in = new Scanner(scannerIn);
    }

    public PhoneBook(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
    }

    public String listAllEntries() {
        String entryLister = "";
        for (String keys : phoneInfo.keySet()) {
            entryLister += keys + " " + phoneInfo.get(keys) + "\n";
        }

        return entryLister.trim();
    }

    //unsure how to populate Hashmap so I created  signature that takes in one and uses the putAll method.
    public String lookUp(String name) {
        // phoneInfo.putAll(hashMap);
        return phoneInfo.get(name);
    }

    //Originally going to be voided methods, I decided to return the entire hashmap after it's populated
    public Map addEntry(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {

        try {
            name = in.nextLine();
            phoneNumber = in.nextLine();
            checkNumberFormat(phoneNumber);
            phoneInfo.put(name, phoneNumber);
            return phoneInfo;
        } catch (InvalidPhoneNumberFormatException e) {
            logger.warning(phoneNumber+" is not a valid number");
            return null;

        }

    }

    //Originally going to be voided methods, I decided to return the entire hashmap after a entry is removed.
    public Map removeEntry(String name) throws InvalidPhoneNumberFormatException {
        name = in.nextLine();
        phoneInfo.remove(name);
        return phoneInfo;
    }

    public String listAllNames() {

        String allNames = "";
        for (String keys : phoneInfo.keySet()) {
            allNames += keys + "\n";
        }

        return allNames.trim();
    }

    public String reverseLookUp(String number) {

        String listedName = "";
        for (String phoneNumber : phoneInfo.values()) {
            if (phoneNumber.equals(number)) {
                listedName = phoneNumber;
            }
        }
        return listedName.trim();
    }

    public PhoneBook checkNumberFormat(String number) throws InvalidPhoneNumberFormatException {



        return new PhoneBook(number);
    }


}
