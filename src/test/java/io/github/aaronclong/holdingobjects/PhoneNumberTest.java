package io.github.aaronclong.holdingobjects;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneNumberTest {
  @Test
  public void checkNumberConstruction() {
    try {
      PhoneNumber num = PhoneNumber.registerNumber(200, 300, 4000);
      assertNotNull("Confirming number Construction", num);
    } catch(Exception e) {
      fail("Failed number Construction" + e.toString());
    }
  }

  @Test(expected = InvalidNumberException.class)
  public void checkThrowForInvalidNumber() throws InvalidNumberException {
    PhoneNumber.registerNumber(1, 2, 300);
  }
}
