package com.markbrown.holdingobjects;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;


/**
 * Created by markbrown on 5/16/17.
 */
public class Phonebook {

    private final static Logger logger = LoggerFactory.getLogger(Phonebook.class);

    private Map<String, ArrayList<String>> phonebookEntries = new TreeMap<String, ArrayList<String>>();

    public Phonebook() {}

    public Map<String, ArrayList<String>> getPhonebookEntries() {return phonebookEntries;}

    public void addEntryToPhonebook(PhonebookEntry phonebookEntry) {
        if (lookup(phonebookEntry.getPhoneBookName()).equals("Person not listed in phonebook.")) {
            phonebookEntries.put(phonebookEntry.getPhoneBookName(), phonebookEntry.getPhoneNumbers());
        } else {
            phonebookEntries.get(phonebookEntry.getPhoneBookName()).add(phonebookEntry.getPhoneNumbers().get(0));
        }

    }

    public void removeEntryFromPhonebook(String phoneNumberAsString) {
        String entry = reverseLookup(phoneNumberAsString);
        if (!entry.equals("Number not listed.")) {
            for (int index = 0; index < phonebookEntries.get(entry).size(); index++) {
                if (phonebookEntries.get(entry).get(index).equals(phoneNumberAsString)) {
                    phonebookEntries.get(entry).remove(index);
                }
            }
        } else {
            logger.warn("Number not found.");
        }
    }


    public String lookup(String lastNameFirstName) {
        if (!phonebookEntries.containsKey(lastNameFirstName)) {
            return "Person not listed in phonebook.";
        } else {
            String entry = "";
            for (int index = 0; index < phonebookEntries.get(lastNameFirstName).size(); index++) {
                entry += (phonebookEntries.get(lastNameFirstName).get(index) + " ");
            }
            return entry;
        }
    }


    public String reverseLookup(String phoneNumberAsString) {
        for (Map.Entry<String, ArrayList<String>> entry: getPhonebookEntries().entrySet()) {
            for (int index = 0; index < entry.getValue().size(); index++) {
                if (phoneNumberAsString.equals(entry.getValue().get(index))) {
                    return entry.getKey();
                }
            }
        }
        return "Number not listed.";
    }

    public void removeEntireEntryFromPhonebook(String lastNameFirstName) {
        if (!lastNameFirstName.equals("Person not listed in phonebook.")) {
            phonebookEntries.remove(lastNameFirstName);
        } else {
            logger.warn("Person not listed in phonebook.");
        }
    }

    public static void printAllNames(Phonebook phonebook) {
        for (Map.Entry<String, ArrayList<String>> entry: phonebook.getPhonebookEntries().entrySet()) {
            logger.info(entry.getKey());
        }
    }

    public static void printAllEntries(Phonebook phonebook) {
        for (Map.Entry<String, ArrayList<String>> entry: phonebook.getPhonebookEntries().entrySet()) {
            logger.info(entry.getKey() + " --- " + entry.getValue());
        }
    }

}
