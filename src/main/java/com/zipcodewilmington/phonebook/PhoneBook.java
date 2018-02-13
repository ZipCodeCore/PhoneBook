package com.zipcodewilmington.phonebook;

import java.util.Set;
import java.util.TreeMap;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap phMap;

    public PhoneBook() {
        this.phMap = new TreeMap();
    }

    public void add(String name, String number) {
        phMap.put(name, number);
    }

    public void remove(String name) {

        phMap.remove(name);
    }
    public String lookup(String name) {
        return (String)phMap.get(name);

    }
    public Set listNames () {
        return phMap.keySet();
    }
    public Set listRecords() {
        return phMap.entrySet();
    }
}

