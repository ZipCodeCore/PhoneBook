package com.zipcodewilmington.phonebook;

//the class
public class Person {
    private String name;
    private String number;

    public Person(String name, String number){
        this.name = name;
        this.number = number;

    }
    //creating get methods
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
