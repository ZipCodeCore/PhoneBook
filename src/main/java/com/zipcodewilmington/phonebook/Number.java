package com.zipcodewilmington.phonebook;

import java.util.Objects;

/**
 * filename: Number.java
 * project: phonebok
 * author: https://github.com/vvmk
 * date: 2/12/18
 */
public class Number {
    private String description; //just metadata for demonstration only
    private String number;

    // can't think of a great reason for a default constructor atm
    public Number(String number) {
        this("mobile", number);
    }

    public Number(String description, String number) {
        this.description = description;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        //just check for numbers, assume they are unique and description is just metadata
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, number);
    }

    @Override
    public String toString() {
        return String.format("%s: %s \n", description, number);
    }
}
