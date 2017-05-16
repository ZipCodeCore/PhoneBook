import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by anthonyjones on 5/16/17.
 */
public class PhoneBookTest {

    @Test
    public void lookUpTest() {
        //Given
        Map<String, String> phoneInfo = new HashMap<>();
        phoneInfo.put("Sarah Silverman", "(302)-434-1849");
        String id = "Sarah Silverman";
        String expected = "(302)-434-1849";
        PhoneBook phoneBook = new PhoneBook();
        //When
        String actual = phoneBook.lookUp(phoneInfo, id);
        //Then
        Assert.assertEquals("The number of Sarah is \"(302)-434-1849\" ", expected, actual);
    }

    @Test
    public void




}
