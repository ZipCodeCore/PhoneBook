package com.zipcodewilmington.phonebook;
import java.util.ArrayList;


public class Listing {
    private String name;
    private ArrayList<String> numbersList;

    public Listing(String name, String number){
        this.name = name;
        this.numbersList = new ArrayList();
        numbersList.add(number);
    }

    public void addNumber (String newNumber){
        numbersList.add(" | " + newNumber);
    }

    public String printName(){
        return name;
    }

    public String printNumbers(){
        StringBuilder builder = new StringBuilder();
        for (String number : numbersList){
            builder.append(number);
        }
        return builder.toString();
    }

}
