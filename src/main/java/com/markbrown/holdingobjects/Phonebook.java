package com.markbrown.holdingobjects;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Created by markbrown on 5/16/17.
 */
public class Phonebook {

    private final static Logger logger = LoggerFactory.getLogger(Phonebook.class);

    private Map<String, String> phonebookEntries = new TreeMap<String, String>();


    public Phonebook() {}

    public Map<String, String> getPhonebookEntries() {return phonebookEntries;}

    public void addEntryToPhonebook(PhonebookEntry phonebookEntry) {
        getPhonebookEntries().put(phonebookEntry.getPhoneBookName(), phonebookEntry.getPhoneNumber());
    }

    public void removeEntryFromPhonebook(PhonebookEntry phonebookEntry) {
        getPhonebookEntries().remove(phonebookEntry.getPhoneBookName());
    }

    public String lookup(String lastNameFirstName) {
        String matchingPhoneNumberEntry = getPhonebookEntries().get(lastNameFirstName);
        if (matchingPhoneNumberEntry == null) {
            logger.warn("Person not listed in phonebook.");
            return "Person not listed in phonebook.";
        }
        else {
            return matchingPhoneNumberEntry;
        }
    }

    public static void printAllNames(Phonebook phonebook) {
        for (Map.Entry<String, String> entry: phonebook.getPhonebookEntries().entrySet()) {
            logger.info(entry.getKey());
        }
    }

    public static void printAllEntries(Phonebook phonebook) {
        for (Map.Entry<String, String> entry: phonebook.getPhonebookEntries().entrySet()) {
            logger.info(entry.getKey() + " --- " + entry.getValue());
        }
    }
}
