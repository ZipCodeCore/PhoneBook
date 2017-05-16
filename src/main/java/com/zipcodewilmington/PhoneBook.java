package com.zipcodewilmington;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

public class PhoneBook
{
    private TreeMap<String, PhoneNumber> phoneBook;
    private static final Logger logger = LoggerFactory.getLogger(PhoneBook.class);

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, PhoneNumber>();
    }

    public PhoneBook(String name, PhoneNumber number){
        this();
        phoneBook.put(name, number);
    }

    public String lookup(String name){
        PhoneNumber result = phoneBook.get(name);
        return result.toString();
    }

    public boolean add(String name, String phoneNumber){
        try{
            phoneBook.put(name, new PhoneNumber(phoneNumber));
            return true;
        } catch (InvalidPhoneNumberFormatException e){
            logger.warn(phoneNumber + " is an invalid Phone Number, " + name + "'s number was not added");
            return false;
        }
    }

    public boolean remove(String name){
        if(phoneBook.size() > 0 && phoneBook.keySet().contains(name)) {
            phoneBook.remove(name);
            return true;
        } else {
            logger.warn("\"" + name + "\" not found, remove operation failed");
            return false;
        }

    }

    public String listNames(){
        StringBuilder sb = new StringBuilder();
        for(String key: phoneBook.keySet()){
            sb.append(key + "\n");
        }
        return sb.toString();
    }

    public String listEntries(){
        StringBuilder sb = new StringBuilder();
        for(String key: phoneBook.keySet()){
            sb.append(key + ": " + phoneBook.get(key) + "\n");
        }
        return sb.toString();
    }

    public int size(){
        return phoneBook.size();
    }


}
