package com.zipcodewilmington.phonebook;

import java.util.TreeMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    TreeMap<String, Person> phoneBook;

    //Person bill = new Person("bill", "1234567890");
    //PhoneBook yellowPages = new PhoneBook(("bill", new Person("bill", "1234567890"));

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, Person>();
    }

    public PhoneBook(TreeMap<String, Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

//    public Person get(String name){
//        return this.phoneBook.get(name);
//    }

    public Person get(String name) {
        this.phoneBook.get(name);
        return
    }
        //overload with person object
    public void add(Person person){
        this.phoneBook.put(person.getName(), person);
    }

    public void add(String name, String number){
        this.phoneBook.put(name, new Person(name, number));

    }
}
