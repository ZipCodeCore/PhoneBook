import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookEntryTest {

    @Test
    public void entryConstructorFormatsPhoneNumberTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        String expected = "(443) 540-1564";

        // when
        String actual = entry.getFormattedPhoneNumber();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void entryGetNameTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        String expected = "Sarah";

        // when
        String actual = entry.getName();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void entrySetNameTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        entry.setName("Misty");
        String expected = "Misty";

        // when
        String actual = entry.getName();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void entrySetPhoneNumberTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        entry.setPhoneNumber("3028675309");
        String expected = "(302) 867-5309";

        // when
        String actual = entry.getFormattedPhoneNumber();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void entryToStringTest() {
        // given
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        String expected = "Name: Sarah\nPhone Number: (443) 540-1564";

        //when
        String actual = entry.toString();

        // then
        Assert.assertEquals(expected, actual);
    }
}
