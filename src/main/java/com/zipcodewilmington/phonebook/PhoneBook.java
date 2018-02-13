package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, Person> personMap;

    public PhoneBook() {
        this.personMap = new TreeMap<String, Person>();
    }

    public void add(String name, String number){
        this.personMap.put(name, new Person(name, number));
    }

    public void add(Person person){
        this.personMap.put(person.getName(), person);
    }

    public String lookup(String name) {

    }
}

