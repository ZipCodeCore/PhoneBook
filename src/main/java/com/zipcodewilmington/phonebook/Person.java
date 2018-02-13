package com.zipcodewilmington.phonebook;

import java.util.*;

public class Person {

    private String name;
    private ArrayList<String> numberList;

    public Person(String name, String number) {
        this.name = name;
        this.numberList = new ArrayList();
        numberList.add(number);
    }

    public void addNumber(String numberToAdd) {
        numberList.add(numberToAdd);
    }

    public getAllPhoneNumbers() {
        return numberList;
    }

    public getName() {
        return name;
    }

    public static void main(String[] args) {
        Person mitch = new Person("Mitch", "22822288")
        System.out.println(mitch.name);
    }

}
