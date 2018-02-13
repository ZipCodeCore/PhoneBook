package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    TreeMap<String, Person> phoneBook;

    public PhoneBook(TreeMap<String, Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, Person>();
    }


    public String get(String name) {
        Person temp = this.phoneBook.get(name);
        return temp.getNumbers();
    }

    public Person getPerson(String name) {
        Person temp = this.phoneBook.get(name);
        return temp;
    }

    public String reverseLookup(String phoneNumber){
        for (Person person: phoneBook.values()) {
            for (String number : person.numbers) {
                if (person.numbers.contains(number)){
                    return person.getName();
                }
            }
        }
        return null;
    }

    public void add(String name, String number){
        this.phoneBook.put(name, new Person(name, number));
    }

    //two add methods: one with strings that instantiates a person, one that takes a person and derives the name key
    public void addPerson(Person person){
        this.phoneBook.put(person.getName(), person);
    }

    public void remove(String name){
        this.phoneBook.remove(name);
    }

    public boolean existenceCheck(String name){
        System.out.println(phoneBook.containsKey(name));
        return this.phoneBook.containsKey(name);
    }

    public String display(){
        StringBuilder displayAllNamesAndPhoneNumbers = new StringBuilder();
        for (String key : phoneBook.keySet()) {
            Person temp = getPerson(key);
            //make sure my get numbers method is creating an organized string i can use with this method.
            displayAllNamesAndPhoneNumbers.append(temp.getName() + " " + temp.getNumbers().toString() + "\n");
        }
        System.out.println(displayAllNamesAndPhoneNumbers.toString());
        return displayAllNamesAndPhoneNumbers.toString().substring(0, displayAllNamesAndPhoneNumbers.length() -1);
    }


}
