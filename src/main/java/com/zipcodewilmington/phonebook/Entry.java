package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Objects;

/**
 * filename: Entry.java
 * project: phonebok
 * author: https://github.com/vvmk
 * date: 2/12/18
 */
public class Entry {
    private String name;
    private ArrayList<Number> numbers;

    public Entry(String name, String... nums) {
        this.name = name;
        for (String n : nums) {
            numbers.add(new Number(n));
        }
    }

    public ArrayList<Number> getNumbers() {
        return numbers;
    }

    //TODO: return numbers as JSON string
    public String getNumbersJSON() {
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean addNumber(String number, String description) {
        return numbers.add(new Number(description, number));
    }

    public boolean remove(String number) {
        return numbers.remove(new Number("dummy", number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(name, entry.name) &&
                Objects.equals(numbers, entry.numbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Number n : numbers)
            sb.append(n.toString());
        return sb.toString();
    }
}
