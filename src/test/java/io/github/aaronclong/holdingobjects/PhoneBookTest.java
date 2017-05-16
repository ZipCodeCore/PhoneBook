package io.github.aaronclong.holdingobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

  @Test
  public void testLookupForNonExistingItem() {
    assertNull("Confirming null on non-existing item", phoneBook.lookup("Dennis"));
  }

  @Test
  public void testReverseLookupForNullOnNonExistingItem() {
    phoneBook.add("Dennis", phoneNumber);
    assertEquals("Confirming that none existing elements return null", "Dennis",
            phoneBook.reverseLookup(phoneNumber));
  }

  @Test
  public void testReverseLookupForNullOnNoEntry() {
    assertNull("Confirming that none existing elements return null", phoneBook.reverseLookup(phoneNumber));
  }
}
