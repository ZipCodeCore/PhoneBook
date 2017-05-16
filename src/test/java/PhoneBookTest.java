import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by aurorabanuelos on 5/16/17.
 */
public class PhoneBookTest {

    public PhoneBook phoneBook;


    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        ArrayList<String> auroraPhoneNumbers = new ArrayList<String>();
        ArrayList<String> karenPhoneNumbers = new ArrayList<String>();

        auroraPhoneNumbers.add("(845)-333-5454");
        auroraPhoneNumbers.add("(555)-345-7859");
        karenPhoneNumbers.add("(234)-435-4433");

        phoneBook.phoneList.put("Aurora", auroraPhoneNumbers);
        phoneBook.phoneList.put("Karen", karenPhoneNumbers);
    }


    @Test
    public void lookupTest(){
        //Given
        String inputName = "Aurora";
        String expected = inputName + "'s phone number is: " + "(845)-333-5454 , (555)-345-7859";

        //When
        String actual = phoneBook.lookup(inputName);

        //Then
        Assert.assertEquals("should return phone number for inputName",expected, actual);

    }

    @Test
    public void addEntryTest(){

        //Given
        String inputName = "Sally";
        ArrayList<String> sallyPhoneNumbers = new ArrayList<String>();
        sallyPhoneNumbers.add("(234)-777-5454");

        //When
        phoneBook.addEntry(inputName, sallyPhoneNumbers);
        String actual = phoneBook.phoneList.get(inputName).toString();

        //Then
        Assert.assertEquals("Entry should have been added", sallyPhoneNumbers, actual);

    }

    @Test
    public void addToExistingEntryTest(){
        //Given
        String inputName = "Aurora";
        String additionalPhoneNumber = "(278)-234-5555";

        //When
        phoneBook.addToExistingEntry(inputName, additionalPhoneNumber);
        String actual = phoneBook.lastPhoneNumberAdded(inputName);

        //Then
        Assert.assertEquals("New phone number should be added to listing", additionalPhoneNumber, actual);
    }

    @Test
    public void lastPhoneNumberAddedTest(){
        //Given
        String inputName = "Aurora";
        String expected = "(555)-345-7859";

        //When
        String actual = phoneBook.lastPhoneNumberAdded(inputName);

        //Then
        Assert.assertEquals("phone numbers should match", expected, actual);
    }

    @Test
    public void removeEntryTest(){

        //Given
        String inputName = "Aurora";

        //When
        phoneBook.removeEntry(inputName);
        String actual = phoneBook.phoneList.get(inputName).toString();

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
        String expected = "Aurora: (845)-333-5454, (555)-345-7859\nKaren: (234)-435-4433";

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
