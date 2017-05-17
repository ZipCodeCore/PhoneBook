package phonebook;

import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;


import exceptions.InvalidPhoneNumberFormatException;
import exceptions.RecordNotPresent;

/**
 * Created by anthonyjones on 5/16/17.
 */
public class PhoneBook {
    public static final Logger logger = Logger.getLogger("*");

    Map<String, List<String>> phoneInfo = new TreeMap<String, List<String>>();

    Scanner in = new Scanner(System.in);

    {
        // A list of entries to play with
        phoneInfo.put("Sarah Silverman", new ArrayList<String>());
        phoneInfo.get("Sarah Silverman").add(("(302)-434-1849"));
        phoneInfo.get("Sarah Silverman").add(("(302)-544-1084"));
        phoneInfo.put("Ben Berger", new ArrayList<String>());
        phoneInfo.get("Ben Berger").add(("(802)-453-3582"));
        phoneInfo.put("Lisa Knelly", new ArrayList<String>());
        phoneInfo.get("Lisa Knelly").add(("(732)-914-8849"));
        phoneInfo.put("Steve Johns", new ArrayList<String>());
        phoneInfo.get("Steve Johns").add(("(412)-791-1823"));
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

        return entryLister.replace(",", "")
                .replace("[", "")
                .replace("]", "").trim();
    }

    //unsure how to populate TreeMap so I created  signature that takes in one and uses the putAll method.
    public String lookUp(String name) throws RecordNotPresent {


        if (!phoneInfo.containsKey(name)) {
            logger.warning("Cannot find " + name + " in the PhoneBook");
            throw new RecordNotPresent();
        } else {
            String output = phoneInfo.get(name).toString()
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "");
            return output;
        }
    }

    //Originally going to be voided methods, I decided to return the entire hashmap after it's populated
    public Map addEntry(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {

        name = in.nextLine();
        phoneNumber = in.nextLine();
        checkNumberFormat(phoneNumber);
        if (phoneInfo.get(name) != null) {
            phoneInfo.get(name).add(phoneNumber);
        } else {
            phoneInfo.put(name, new ArrayList<String>());
            phoneInfo.get(name).add(phoneNumber);
        }
        return phoneInfo;

    }

    public Map removeNumberFromEntry(String phoneNumber) throws RecordNotPresent, InvalidPhoneNumberFormatException {

        checkNumberFormat(phoneNumber);

        for (Map.Entry<String, List<String>> outerLoop : phoneInfo.entrySet()) {
            for (String listedNumber : outerLoop.getValue()) {
                if (listedNumber.equals(phoneNumber)) {
                    phoneInfo.get(outerLoop.getKey()).remove(listedNumber);
                    return phoneInfo;
                }
            }
        }
        logger.warning("The number " + phoneNumber + " doesn't exist in the PhoneBook");
        throw new RecordNotPresent();
    }

    public Map removeRecord(String name) throws RecordNotPresent {


        if (!phoneInfo.containsKey(name)) {
            logger.warning("Cannot remove " + name + " as the name does not exist in the PhoneBook");
            throw new RecordNotPresent();
        } else {
            name = in.nextLine();
            phoneInfo.remove(name);
            return phoneInfo;
        }
    }

    public String listAllNames() {
        String allNames = "";
        for (String keys : phoneInfo.keySet()) {
            allNames += keys + "\n";
        }
        return allNames.trim();
    }

    public String reverseLookUp(String phoneNumber) throws RecordNotPresent, InvalidPhoneNumberFormatException {

        checkNumberFormat(phoneNumber);

        for (Map.Entry<String, List<String>> outerLoop : phoneInfo.entrySet()) {
            for (String listedNumber : outerLoop.getValue()) {
                if (listedNumber.equals(phoneNumber)) {
                    return outerLoop.getKey();
                }
            }
        }
        logger.warning("The number " + phoneNumber + " doesn't exist in the PhoneBook");
        throw new RecordNotPresent();
    }

    public PhoneBook checkNumberFormat(String number) throws InvalidPhoneNumberFormatException {
        return new PhoneBook(number);
    }


}
