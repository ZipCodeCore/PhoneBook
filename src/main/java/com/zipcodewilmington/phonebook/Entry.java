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
        numbers = new ArrayList<>();
        for (String n : nums) {
            numbers.add(new Number(n));
        }
    }

    /**
     * slightly format and return all numbers recorded for this entry
     * @return the numbers for this entry
     */
    public String listNumbers() {
        StringBuilder sb = new StringBuilder();
        for (Number n : numbers) {
            sb.append(n.getNumber());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * add a new number to this entry
     * @param number the number to be added
     * @param description a description for this number i.e. mobile, home, etc.
     * @return true if success else false
     */
    public boolean addNumber(String number, String description) {
        return numbers.add(new Number(description, number));
    }

    /**
     * attempt to remove a number from this entry
     * @param number the number to remove
     * @return true if success
     */
    public boolean remove(String number) {
        return numbers.remove(new Number("dummy", number));
    }

    /**
     * getter for name prop
     * @return unformatted name as String
     */
    public String getName() {
        return name;
    }

    /**
     * return this entry's numbers as an arrayList to better facilitate JSONification
     * @return the ArrayList of Numbers belonging to this Entry
     */
    public ArrayList<Number> getNumbersaslist() {
        return this.numbers;
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
        for (Number n : numbers) {
            sb.append(String.format("%1$-15s %2$s \n", name, n.getNumber()));
        }
        return sb.toString();
    }
}
