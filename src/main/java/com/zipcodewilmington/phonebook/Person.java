package com.zipcodewilmington.phonebook;

/**
 * Created by pat on 2/12/18.
 */
public class Person {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Person() {
        this.name = "empty";
        this.number = "0000000000";
    }

}
