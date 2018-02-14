package com.zipcodewilmington.phonebook;

class Person {

    private String personName;
    private String phoneNumber;

    public Person(String personName, String phoneNumber) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
