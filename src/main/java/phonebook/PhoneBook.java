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
    Logger logger = Logger.getLogger("*");

    // Map<String, String> phoneInfo = new TreeMap<>();
//    Map<String, ArrayList<Object>> phoneInfo = new HashMap<>();
    Map<String, List<String>> phoneInfo = new TreeMap<>();

    Scanner in = new Scanner(System.in);

    {
        // A list of entries to play with
        phoneInfo.put("Sarah Silverman", new ArrayList<>());
        phoneInfo.get("Sarah Silverman").add(("(302)-434-1849"));
        phoneInfo.get("Sarah Silverman").add(("(302)-544-1084"));
        phoneInfo.put("Ben Berger", new ArrayList<>());
        phoneInfo.get("Ben Berger").add(("(802)-453-3582"));
        phoneInfo.put("Lisa Knelly", new ArrayList<>());
        phoneInfo.get("Lisa Knelly").add(("(732)-914-8849"));
        phoneInfo.put("Steve Johns", new ArrayList<>());
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

    //unsure how to populate Treemap so I created  signature that takes in one and uses the putAll method.
    public String lookUp(String name) {
        String output = phoneInfo.get(name).toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");

        return output;
    }

    //Originally going to be voided methods, I decided to return the entire hashmap after it's populated
    public Map addEntry(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {

        try {
            name = in.nextLine();
            phoneNumber = in.nextLine();
            checkNumberFormat(phoneNumber);
            if (phoneInfo.get(name) != null) {
                phoneInfo.get(name).add(phoneNumber);
            } else {
                phoneInfo.put(name, new ArrayList<>());
                phoneInfo.get(name).add(phoneNumber);
            }
            return phoneInfo;
        } catch (InvalidPhoneNumberFormatException e) {
            logger.warning(phoneNumber + " is not a valid number");
            return null;
        }
    }

    //Originally going to be voided methods, I decided to return the entire hashMap after a entry is removed.
    public Map removeNumberFromEntry(String number) {
        for (Map.Entry<String, List<String>> outerLoop : phoneInfo.entrySet()) {
            for (String listedNumber : outerLoop.getValue()) {
                if (listedNumber.equals(number)) {
                    phoneInfo.get(outerLoop.getKey()).remove(listedNumber);
                    return phoneInfo;
                }
            }
        }
        return null;
    }

    public Map removeRecord(String name) {

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
        for (Map.Entry<String, List<String>> outerLoop : phoneInfo.entrySet()) {
            for (String listedNumber : outerLoop.getValue()) {
                if (listedNumber.equals(number)) {
                    return outerLoop.getKey();
                }
            }
        }
        return null;
    }

    public PhoneBook checkNumberFormat(String number) throws InvalidPhoneNumberFormatException {
        return new PhoneBook(number);
    }


}
