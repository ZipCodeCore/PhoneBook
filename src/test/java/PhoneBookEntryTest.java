import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class PhoneBookEntryTest {

    @Test
    public void testPrintPhoneBookEntryToString(){

        // Given
        PhoneBookEntry Keanu = new PhoneBookEntry("Keanu Reeves", "1234567890");

        // When
        String expected = Keanu.toString();
        String actual = "Name : Keanu Reeves\nPhone Number : (123) 456-7890";

        // Then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testPhoneBookEntryIsValid(){

        // Given
        PhoneBookEntry Keanu = new PhoneBookEntry("Keanu Reeves", "1234567890");

        // Then
        Assert.assertNotNull(Keanu);
    }


}