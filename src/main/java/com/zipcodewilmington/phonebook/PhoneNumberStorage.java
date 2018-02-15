package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class PhoneNumberStorage {

    String name;
    ArrayList<String> phoneNumbers;

    public PhoneNumberStorage(String name, ArrayList<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public PhoneNumberStorage(String name, String phoneNumbers){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(phoneNumbers);
        new PhoneNumberStorage(name, temp);
    }
}
