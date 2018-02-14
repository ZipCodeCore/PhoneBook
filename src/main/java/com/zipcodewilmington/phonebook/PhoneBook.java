package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by leon on 1/23/18.
 */
//the class
public class PhoneBook {

    private String addName;
    private String addNumber;
    //has to be a person object to go into the array list
    ArrayList<Person> contactList = new ArrayList();

    public void setAddName(String name){
        this.addName = addName;

    }

    public void setAddNumber(String number){
        this.addNumber = addNumber;
    }

    public void setLookup(String name){
        this.lookup = lookup;
    }

    public void setRemove(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void setListNames(String name){
        this.name = name;
    }

    public void setListNumber(String number){
        this.number = number;
    }







    /*public void setAddName(String addName, String addNumber){
        contact.put(addName, addNumber);
    }

    public void setAddNumber(){

    }*/



















}
