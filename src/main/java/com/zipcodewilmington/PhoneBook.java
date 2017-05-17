package com.zipcodewilmington;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class PhoneBook {
    private TreeMap<String, ArrayList<PhoneNumber>> phoneBook;
    private static final Logger logger = LoggerFactory.getLogger(PhoneBook.class);

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, ArrayList<PhoneNumber>>();
    }

    public PhoneBook(String name, PhoneNumber number) {
        this();
        ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
        list.add(number);
        phoneBook.put(name, list);
    }

    public ArrayList<PhoneNumber> lookup(String name) throws RecordNotFoundException{
        if(!phoneBook.containsKey(name)) throw new RecordNotFoundException();
        else return phoneBook.get(name);
    }

    public boolean add(String name, String phoneNumber) {
        ArrayList<PhoneNumber> phoneList;
        if (phoneBook.containsKey(name)) phoneList = phoneBook.get(name);
        else phoneList = new ArrayList<PhoneNumber>();

        try {
            phoneList.add(new PhoneNumber(phoneNumber));
            phoneBook.put(name, phoneList);
            logger.info("Putting " + phoneList + "into key " + name);
            return true;
        } catch (InvalidPhoneNumberFormatException e) {
            logger.warn(phoneNumber + " is an invalid Phone Number, " + name + "'s number was not added");
            return false;
        }
    }

    public boolean remove(String name, String phoneNumber) throws RecordNotFoundException {
        if (phoneBook.size() > 0 && phoneBook.keySet().contains(name)) {
            int listSize = phoneBook.get(name).size();
            safeRemove(listSize, name, phoneNumber);
            return true;
        } else {
            logger.warn("\"" + name + "\" not found, remove operation failed");
            throw new RecordNotFoundException("\"" + name + "\" not found, remove operation failed");
        }
    }

    private void safeRemove(int listSize, String name, String phoneNumber){
        if(listSize == 1) phoneBook.remove(name);
        else phoneBook.get(name).remove(phoneNumber);
    }

    public String listNames() {
        StringBuilder sb = new StringBuilder();
        for (String key : phoneBook.keySet()) {
            sb.append(key + "\n");
        }
        return sb.toString();
    }

    public String listEntries() {
        StringBuilder sb = new StringBuilder();
        for (String key : phoneBook.keySet()) {
            sb.append(key + ":\n");
            for(PhoneNumber phoneNumber: phoneBook.get(key)){
                sb.append("  " + phoneNumber.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public int size() {
        return phoneBook.size();
    }

    public String reverseLookup(String number) throws RecordNotFoundException, InvalidPhoneNumberFormatException{
        if (!number.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        Set<Map.Entry<String, ArrayList<PhoneNumber>>> entrySet = phoneBook.entrySet();
        for (Map.Entry<String, ArrayList<PhoneNumber>> entry : entrySet) {
            for(PhoneNumber phoneNumber: entry.getValue()){
                if(phoneNumber.toString().equals(number)){
                    return entry.getKey();
                }
            }
        }
        logger.warn(number + " does not belong to any record in this phonebook");
        throw new RecordNotFoundException(number + " does not belong to any record in this phonebook");
    }

}
