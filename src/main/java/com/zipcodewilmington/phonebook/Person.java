package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Person {
    private String name;
    private String number;
    private ArrayList<String> listOfNumbers;
    public Person() {

    }

    public Person(String thisName, String thisNumber, ArrayList<String> thisListOfNumbers) {
        name = thisName;
        number = thisNumber;
        listOfNumbers = thisListOfNumbers;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListOfNumbers() {
        return listOfNumbers;
    }

    public void setListOfNumbers(ArrayList<String> listOfNumbers){
        this.listOfNumbers = listOfNumbers;
    }

    // at some point a better way is using stringbuilder.
    @Override
    public String toString() {
        return "com.zipcodewilmington.phonebook.Person{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
