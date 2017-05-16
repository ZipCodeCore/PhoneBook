package io.github.aaronclong.holdingobjects;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneBookTest {
  private PhoneBook phoneBook;
  private PhoneNumber phoneNumber;

  @Before
  public void setUp() {
    try {
      phoneBook = new PhoneBook();
      phoneNumber = PhoneNumber.registerNumber(100, 500, 9000);
    } catch(InvalidNumberException e) {
    }
  }

  @Test
  public void testLookupForValidReturn() {
    phoneBook.add("Dennis", phoneNumber);
    assertEquals("Confirming same number Returned from PhoneBook", phoneNumber, phoneBook.lookup("Dennis"));
  }
}
