package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class PhoneNumberStorage {

    public String name;
    public ArrayList<String> phoneNumbers;


    public PhoneNumberStorage(String name, ArrayList<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public PhoneNumberStorage(String name, String phoneNumbers){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(phoneNumbers);
        new PhoneNumberStorage(name, temp);
    }




    public String lookup(){
        return this.name;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
