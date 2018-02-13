package com.zipcodewilmington.phonebook;

public class Person {

    //variables

    /*we made these private bc we don't want the user to be able to change the data. Another reason we want to do this
     is that you want to "hide" how you store the information from the users.

    */
    private String name;
    private String phoneNumber;

    //constructor
    public Person(String name, String number) {
        this.name= name;
        this.phoneNumber = number;
    }
    //"everything else"
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }


}
