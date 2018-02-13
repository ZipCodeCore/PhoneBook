package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by pat on 2/12/18.
 */
public class Person{
    private String name;
    public ArrayList<String> numbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumbers() {
        StringBuilder temp = new StringBuilder();
        for (String number : numbers) {
            temp.append(number + " ");
        }
        return numbers.toString().substring(1, temp.toString().length());
    }

    public void setNumbers(String number) {
        this.numbers.clear();
        this.numbers.add(number);
    }

    public void addNumberToNumbers(String number){
        this.numbers.add(number);
    }

    public Person(String name, String number) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.numbers.add(number);
    }

    public Person() {
        new Person("NO NAME", "000000000");
    }

}
