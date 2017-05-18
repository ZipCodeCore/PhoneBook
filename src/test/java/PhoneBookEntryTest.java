import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookEntryTest {

    @Test
    public void makePhoneBookEntryTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        String expected = "Sarah";

        // when
        String actual = entry.getName();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addNumbersToEntryTest() throws InvalidPhoneNumberFormatException {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        entry.addNumber("8885551234");
        String expected = "(443) 540-1564, (888) 555-1234";

        // when
        String actual = entry.getFormattedPhoneNumbers().toString();

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void entrySetNameTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.setName("Misty");
        String expected = "Misty";

        // when
        String actual = entry.getName();

        // then
        Assert.assertEquals(expected, actual);
    }

}
