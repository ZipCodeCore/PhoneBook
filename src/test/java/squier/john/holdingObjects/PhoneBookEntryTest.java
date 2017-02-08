package squier.john.holdingObjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John A. Squier
 */
public class PhoneBookEntryTest {

    PhoneBookEntry phoneBookEntry1, phoneBookEntry2, phoneBookEntry3;

    @Before
    public void setup() {
        phoneBookEntry1 = new PhoneBookEntry("John Squier", new PhoneNumber("333-333-3333"));
        phoneBookEntry1.addNumberToEntry(new PhoneNumber("444-444-4444"));

        phoneBookEntry2 = new PhoneBookEntry("Mike Wolfe", new PhoneNumber("111-111-1111"));

        phoneBookEntry3 = new PhoneBookEntry("Mike Wolfe", new PhoneNumber("111-111-1111"));
    }

    @Test
    public void getPhoneNumberTest() {
        PhoneNumber expected1 = new PhoneNumber("333-333-3333");
        PhoneNumber expected2 = new PhoneNumber("444-444-4444");
        List<PhoneNumber> expectedList = new ArrayList<>();
        expectedList.add(expected1);
        expectedList.add(expected2);

        List<PhoneNumber> actualList = phoneBookEntry1.getPhoneNumbers();
        PhoneNumber actual1 = actualList.get(0);
        PhoneNumber actual2 = actualList.get(1);
        Assert.assertTrue(expected1.equals(actual1)
                            && expected2.equals(actual2)
                            && expectedList.size() == actualList.size());
    }

    @Test
    public void equalsOtherTest() {
        Assert.assertTrue(phoneBookEntry2.equals(phoneBookEntry3));
    }

    @Test
    public void notEqualsOtherTest() {
        Assert.assertFalse(phoneBookEntry1.equals(phoneBookEntry3));
    }

    @Test
    public void toStringTest() {
        String expected = "John Squier: 333-333-3333\n444-444-4444\n";
        String actual = phoneBookEntry1.toString();
        Assert.assertEquals(expected, actual);
    }
}
