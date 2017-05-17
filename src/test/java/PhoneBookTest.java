import com.sun.prism.impl.Disposer;
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

    @Test(expected = InvalidPhoneNumberFormatException.class)
    public void testInvalidPhoneNumberFormatException() throws InvalidPhoneNumberFormatException {
        ArrayList<String> joePhoneNumbers = new ArrayList<String>();
        joePhoneNumbers.add("-1");
        phoneBook.addEntry("Joe", joePhoneNumbers);
    }

    @Test(expected = RecordNotPresent.class)
    public void testRecordNotPresent() throws RecordNotPresent {
        String inputName = "Mark";
        phoneBook.lookup(inputName);
    }


    @Test
    public void lookupTest() throws RecordNotPresent{
        //Given
        String inputName = "Aurora";
        String expected = inputName + "'s phone number is: " + "(845)-333-5454, (555)-345-7859";

        //When
        String actual = phoneBook.lookup(inputName);

        //Then
        Assert.assertEquals("should return phone number for inputName",expected, actual);

    }

    @Test
    public void addEntryTest() throws InvalidPhoneNumberFormatException{

        //Given
        String inputName = "Sally";
        ArrayList<String> sallyPhoneNumbers = new ArrayList<String>();
        sallyPhoneNumbers.add("(234)-777-5454");

        //When
        phoneBook.addEntry(inputName, sallyPhoneNumbers);
        String actual = phoneBook.phoneList.get(inputName).toString();
        actual = actual.substring(1, actual.length()-1);

        //Then
        Assert.assertEquals("Entry should have been added", sallyPhoneNumbers.get(0), actual);

    }

    @Test
    public void addToExistingEntryTest() throws InvalidPhoneNumberFormatException, RecordNotPresent{
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
    public void lastPhoneNumberAddedTest() throws RecordNotPresent{
        //Given
        String inputName = "Aurora";
        String expected = "(555)-345-7859";

        //When
        String actual = phoneBook.lastPhoneNumberAdded(inputName);

        //Then
        Assert.assertEquals("phone numbers should match", expected, actual);
    }

    @Test
    public void removeRecordTest() throws RecordNotPresent{

        //Given
        String inputName = "Aurora";

        //When
        phoneBook.removeRecord(inputName);
        String actual = phoneBook.lookup(inputName);

        //Then
        Assert.assertEquals("Entry should have been removed", null, actual);

    }

    @Test
    public void removeOnePhoneNumberFromEntryTest() throws InvalidPhoneNumberFormatException, RecordNotPresent{
        //Given
        String inputName = "Aurora";
        String phoneNumberToBeRemoved = "(845)-333-5454";

        //When
        phoneBook.removeOnePhoneNumberFromEntry(inputName, phoneNumberToBeRemoved);
        boolean actual = phoneBook.isPhoneNumberListed(inputName, phoneNumberToBeRemoved);

        //Then
        Assert.assertEquals("Phone number should have been removed", false, actual);
    }

    @Test
    public void isPhoneNumberListedTest() throws InvalidPhoneNumberFormatException, RecordNotPresent{
        //Given
        String inputName = "Aurora";
        String phoneNumberToBeChecked = "(845)-333-5454";

        //When
        boolean actual = phoneBook.isPhoneNumberListed(inputName, phoneNumberToBeChecked);

        //Then
        Assert.assertEquals("Phone number should not be listed", true, actual);
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
    public void reverseLookupTest() throws InvalidPhoneNumberFormatException, RecordNotPresent{
        //Given
        String inputNumber = "(845)-333-5454";
        String expected = inputNumber + " belongs to : " + "Aurora";

        //When
        String actual = phoneBook.reverseLookup(inputNumber);

        //Then
        Assert.assertEquals("should return name for phone number entered", expected, actual);

    }

}
