package io.github.aaronclong.holdingobjects;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneNumber {
  private final int areaCode;
  private final int centralOfficeCode;
  private final int phoneLineCode;

  private String formattedNumber;

  private PhoneNumber(int theArea, int theOffice, int theLine) throws InvalidNumberException {
    areaCode = theArea;
    centralOfficeCode = theOffice;
    phoneLineCode = theLine;
    formatNumber();
  }

  static PhoneNumber registerNumber(int areaCode, int centralOfficeCod,
                                    int phoneLineCode) throws InvalidNumberException {
    isValidDigitRange(areaCode, 100, 999);
    isValidDigitRange(centralOfficeCod, 100, 999);
    isValidDigitRange(phoneLineCode, 1000, 9999);
    return new PhoneNumber(areaCode, centralOfficeCod, phoneLineCode);
  }

  @Override
  public String toString() {
    return formattedNumber;
  }

  private void formatNumber() {
    formattedNumber = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
  }

  private static boolean isValidDigitRange(int digit, int startLimit, int endLimit)
          throws InvalidNumberException {
    boolean valid = digit >= startLimit && digit <= endLimit;
    if (!valid) {
      throw new InvalidNumberException();
    }
    return valid;
  }
}
