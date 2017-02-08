package squier.john.holdingObjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class PhoneNumberTest {

    PhoneNumber phoneNumber1, phoneNumber2, phoneNumber3;

    @Before
    public void setup() {
        phoneNumber1 = new PhoneNumber("123-456-7890");
        phoneNumber2 = new PhoneNumber("123-456-7890");
        phoneNumber3 = new PhoneNumber("098-765-4321");
    }

    @Test
    public void toStringTest() {
        String expected = "123-456-7890";
        String actual = phoneNumber1.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equalsTrueTest() {
        Assert.assertTrue(phoneNumber1.equals(phoneNumber2));
    }

    @Test
    public void equalsFalseTest() {
        Assert.assertFalse(phoneNumber1.equals(phoneNumber3));
    }
}
