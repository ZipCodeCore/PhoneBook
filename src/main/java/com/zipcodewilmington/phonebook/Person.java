package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by pat on 2/12/18.
 */
public class Person {
    private String name;
    public ArrayList<String> numbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNumbers() {
        return this.numbers;
    }

    public void setNumbers(String... number) {
        this.numbers.clear();
        for (String newNumber: number) {
            this.numbers.add(newNumber);
        }
    }

    public void addNumberToNumbers(String... numbers) {
        for (String number : numbers)
            this.numbers.add(number);
    }

    public Person(String name, String... number) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        addNumberToNumbers(number);
    }

    public Person() {
        new Person("NO NAME", "000000000");
    }

}
