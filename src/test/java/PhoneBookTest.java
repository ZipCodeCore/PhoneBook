import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class PhoneBookTest {


    @Test
    public void testPhoneBookCanAddEntry(){
        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();
        // When
        phoneBook.put("123456789", "Keanu Reeves");
        int expected = 1;
        // Then
        int actual = phoneBook.size();

        Assert.assertEquals("Added one to book",expected,actual);
    }
    @Test
    public void testPhoneBookCanRemoveEntry(){
        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();
        // When
        phoneBook.put("123456789", "Keanu Reeves");
        phoneBook.put("098765432", "Jimmy Greaves");
        int sizeBeforeRemove = phoneBook.size();
        // Then
        String removeOneEntry = phoneBook.remove("123456789");
        int sizeAfterRemove = phoneBook.size();

        Assert.assertNotEquals("Removed one" ,sizeAfterRemove,sizeBeforeRemove);
    }
    @Test
    public void testPhoneBookCanListAllEntries(){
        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();
        // When
        phoneBook.put("123456789", "Keanu Reeves");
        phoneBook.put("298765432", "Jimmy Greaves");
        phoneBook.put("398765432", "Diego Maradona");
        // Then
        Set set = phoneBook.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("Name: " + entry.getValue() + "\tNumber : " + entry.getKey() );
        }
    }
    @Test
    public void testLookUpByNameValue(){

        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        // When
        phoneBook.put("123456789", "Keanu Reeves");
        phoneBook.put("298765432", "Jimmy Greaves");
        phoneBook.put("398765432", "Diego Maradona");

        String expected = "Keanu Reeves";
        boolean actual = phoneBook.containsValue("Keanu Reeves");

        // Then
        Assert.assertTrue(actual);

    }
    @Test
    public void testLookUpByNamePhoneNumberKey(){

        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        // When

        phoneBook.put("123456789", "Keanu Reeves");
        phoneBook.put("298765432", "Jimmy Greaves");
        phoneBook.put("398765432", "Diego Maradona");
        boolean actual = phoneBook.containsKey("123456789");

        // Then
        Assert.assertTrue(actual);

    }
    @Test
    public void testLookUpByNamePhoneNumberKeyReturnKeyAndValue(){

        // Given
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        // When

        phoneBook.put("123456789", "Keanu Reeves");
        phoneBook.put("298765432", "Jimmy Greaves");
        phoneBook.put("398765432", "Diego Maradona");

        String expected = phoneBook.get("123456789");
        String actual = "Keanu Reeves";
        // Then

        Assert.assertEquals("Same same",expected,actual);

    }














}