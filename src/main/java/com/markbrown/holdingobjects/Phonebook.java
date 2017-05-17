package com.markbrown.holdingobjects;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by markbrown on 5/16/17.
 */
public class Phonebook {

    private static final Logger logger = LoggerFactory.getLogger(Phonebook.class);

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
            return "Person not listed in phonebook.";
        }
        else {
            return matchingPhoneNumberEntry;
        }
    }
}
