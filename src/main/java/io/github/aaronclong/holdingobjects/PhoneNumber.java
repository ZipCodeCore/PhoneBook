package io.github.aaronclong.holdingobjects;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneNumber {
  private final int areaCode;
  private final int centralOfficeCode;
  private final int phoneLineCode;

  private String formattedNumber;

  private PhoneNumber(int theArea, int theOffice, int theLine) {
    areaCode = theArea;
    centralOfficeCode = theOffice;
    phoneLineCode = theLine;
    formatNumber();
  }

  static PhoneNumber registerNumber(int areaCode, int centralOfficeCod,
                                    int phoneLineCode) throws Exception {
    if (!isValidDigitRange(areaCode, 100, 999)) {
      throw new Exception("Not Valid");
    }
    if (!isValidDigitRange(centralOfficeCod, 100, 999)) {
      throw new Exception("Not Valid");
    }
    if (!isValidDigitRange(phoneLineCode, 1000, 9999)) {
      throw new Exception("Not Valid");
    }
    return new PhoneNumber(areaCode, centralOfficeCod, phoneLineCode);
  }

  @Override
  public String toString() {
    return formattedNumber;
  }

  private void formatNumber() {
    formattedNumber = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
  }

  private static boolean isValidDigitRange(int digit, int startLimit, int endLimit) {
    return digit >= startLimit && digit <= endLimit;
  }
}
