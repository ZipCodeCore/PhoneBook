import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeMap;


/**
 * Created by aurorabanuelos on 5/16/17.
 */
public class PhoneBookTest {

    public PhoneBook phoneBook;


    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        phoneBook.phoneList.put("Aurora", "(845)-333-5454");
        phoneBook.phoneList.put("Karen", "(234)-435-4433");
    }


    @Test
    public void lookupTest(){
        //Given
        String inputName = "Aurora";
        String expected = inputName + "'s phone number is: " + "(845)-333-5454";

        //When
        String actual = phoneBook.lookup(inputName);

        //Then
        Assert.assertEquals("should return phone number for inputName",expected, actual);

    }

    @Test
    public void addEntryTest(){

        //Given
        String inputName = "Sally";
        String inputNumber = "(234)-777-5454";

        //When
        phoneBook.addEntry(inputName, inputNumber);
        String actual = phoneBook.phoneList.get(inputName);

        //Then
        Assert.assertEquals("Entry should have been added", inputNumber, actual);

    }

    @Test
    public void removeEntryTest(){

        //Given
        String inputName = "Aurora";

        //When
        phoneBook.removeEntry(inputName);
        String actual = phoneBook.phoneList.get(inputName);

        //Then
        Assert.assertEquals("Entry should have been removed", null, actual);

    }

    @Test
    public void listAllNamesTest(){

        //Given
        String expected = "Aurora\nKaren";

        //When
        String actual = phoneBook.listAllNames();

        //Then
        Assert.assertEquals("Strings should be equal", expected, actual);

    }

    @Test
    public void listAllEntriesTest(){

        //Given
        String expected = "Aurora: (845)-333-5454\nKaren: (234)-435-4433";

        //When
        String actual = phoneBook.listAllEntries();

        //Then
        Assert.assertEquals("Strings should be equal", expected, actual);

    }

    @Test
    public void reverseLookupTest(){
        //Given
        String inputNumber = "(845)-333-5454";
        String expected = inputNumber + " belongs to : " + "Aurora";

        //When
        String actual = phoneBook.reverseLookup(inputNumber);

        //Then
        Assert.assertEquals("should return name for phone number entered", expected, actual);

    }

}
