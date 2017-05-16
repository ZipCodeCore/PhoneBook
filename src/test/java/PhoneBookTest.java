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
    public void addEntryTest(){
        Map<String, String> phoneInfo = new HashMap<>();
        phoneInfo.put("Sarah Silverman", "(302)-434-1849");
        phoneInfo.put("Ben Burger", "(802)-453-3582");
        phoneInfo.put("Lisa Knelly", "(732)-914-8849");
        phoneInfo.put("Steve Johns", "(412)-791-1823");
        String name = "Dan Alixk";
        String number = "(492)-797-1823";

        int expected = 5;
        PhoneBook phoneBook = new PhoneBook();
        //When
        Map actual = phoneBook.addEntry(name,number);
        //Then
        Assert.assertEquals("An extra entry in the hashmap, increases the size from 4 to 5 ", expected, actual.size());

    }


    @Test
    public void removeEntryTest(){

    }



}
