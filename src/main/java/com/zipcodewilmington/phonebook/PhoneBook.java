package com.zipcodewilmington.phonebook;


import sun.invoke.empty.Empty;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    TreeMap<String, Person> phoneBook;

    //Person bill = new Person("bill", "1234567890");
    //PhoneBook yellowPages = new PhoneBook(("bill", new Person("bill", "1234567890"));

    public PhoneBook(TreeMap<String, Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, Person>();
    }

//    public Person get(String name){
//        return this.phoneBook.get(name);
//    }

    public String get(String name) {
        Person temp = this.phoneBook.get(name);
        return temp.getNumber();
    }

    public Person getPerson(String name) {
        Person temp = this.phoneBook.get(name);
        return temp;
    }
        //overload with person object
//    public void add(Person person){
//        this.phoneBook.put(person.getName(), person);
//    }

    public void add(String name, String number){
        this.phoneBook.put(name, new Person(name, number));
    }

    public void remove(String name){
        this.phoneBook.remove(name);
    }

    public void existenceCheck(String name) throws RuntimeException{
        //return this.phoneBook.containsKey(name);
        if (this.phoneBook.containsKey(name)){
            throw new RuntimeException();
        }
    }
    
    public String display(){
        StringBuilder displayAllNamesAndPhoneNumbers = new StringBuilder();
        for (String key : phoneBook.keySet()) {
            Person temp = getPerson(key);
            displayAllNamesAndPhoneNumbers.append(temp.getName() + " " + temp.getNumber() + "\n");
        }
        return displayAllNamesAndPhoneNumbers.toString().substring(0, displayAllNamesAndPhoneNumbers.length() -1);
    }
}
