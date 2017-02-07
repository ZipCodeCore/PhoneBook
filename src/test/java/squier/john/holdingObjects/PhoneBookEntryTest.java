package squier.john.holdingObjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class PhoneBookEntryTest {

    PhoneBookEntry phoneBookEntry1, phoneBookEntry2, phoneBookEntry3;

    @Before
    public void setup() {
        phoneBookEntry1 = new PhoneBookEntry("John Squier", new PhoneNumber("333-333-3333"));
        phoneBookEntry2 = new PhoneBookEntry("John Squier", new PhoneNumber("333-333-3333"));
        phoneBookEntry3 = new PhoneBookEntry("Mike Wolfe", new PhoneNumber("111-111-1111"));
    }

    @Test
    public void getPhoneNumberTest() {
        PhoneNumber expected = new PhoneNumber("333-333-3333");
        PhoneNumber actual = phoneBookEntry1.getPhoneNumber();
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void equalsOtherTest() {
        Assert.assertTrue(phoneBookEntry1.equals(phoneBookEntry2));
    }

    @Test
    public void notEqualsOtherTest() {
        Assert.assertFalse(phoneBookEntry1.equals(phoneBookEntry3));
    }

    @Test
    public void toStringTest() {
        String expected = "John Squier: 333-333-3333";
        String actual = phoneBookEntry1.toString();
        Assert.assertEquals(expected, actual);
    }
}
