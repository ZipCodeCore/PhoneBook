package com.zipcodewilmington.phonebook;

public class Person {
    private String name;
    private String number;

    public Person() {

    }

    public Person(String thisName, String thisNumber) {
        name = thisName;
        number = thisNumber;
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
