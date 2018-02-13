package com.zipcodewilmington.phonebook;

class Person {

    private String personName;

    private String phoneNumber;

    public Person(String name, String phoneNumber){
        this.personName = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
