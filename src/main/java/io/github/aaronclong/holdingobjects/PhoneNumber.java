package io.github.aaronclong.holdingobjects;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneNumber {
    private final int areaCode;
    private final int centralOfficeCode;
    private final int phoneLineCode;

    private PhoneNumber(int theArea, int theOffice, int theLine) {
        areaCode = theArea;
        centralOfficeCode = theOffice;
        phoneLineCode = theLine;
    }

    public static PhoneNumber registerNumber(int areaCode, int centralOfficeCode, int phoneLineCode) {
        return new PhoneNumber(areaCode, centralOfficeCode, phoneLineCode);
    }

    @Override
    public String toString() {
        return String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
    }
}
