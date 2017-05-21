package kalaygian.dennis;

import org.junit.Test;


public class TestPhoneNumber {

    @Test(expected = InvalidPhoneNumberFormatException.class)
    public void testInvalidPhoneNumberFormatException() throws InvalidPhoneNumberFormatException {
        PhoneNumber invalidNumber = new PhoneNumber("THIS WONT WORK");
    }

}
