package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * filename: Entry.java
 * project: phonebok
 * author: https://github.com/vvmk
 * date: 2/12/18
 */
public class Entry {
    private String name;
    private ArrayList<String> numbers;

    public Entry(String name, String... nums) {
        this.name = name;
        numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(nums));
    }

    /**
     * slightly format and return all numbers recorded for this entry
     * @return the numbers for this entry
     */
    public String listNumbers() {
        StringBuilder sb = new StringBuilder();
        for (String n : numbers) {
            sb.append(n);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * add a new number to this entry
     * @param number the number to be added
     * @return true if success else false
     */
    public boolean addNumber(String number) {
        return numbers.add(number);
    }

    /**
     * attempt to remove a number from this entry
     * @param number the number to remove
     * @return true if success
     */
    public boolean remove(String number) {
        return numbers.remove(number);
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
    public ArrayList<String> getNumbersAslist() {
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
        for (String n : numbers) {
            sb.append(String.format("%1$-15s %2$s \n", name, n));
        }
        return sb.toString();
    }
}
