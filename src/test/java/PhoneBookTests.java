import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by cameronsima on 5/16/17.
 */
public class PhoneBookTests {

    PhoneBook phonebook;
    String name;
    String phoneNumber;

    @Before
    public void setUp() {
        phonebook = new PhoneBook();
        name = "Cameron Sima";
        phoneNumber = "2154673127";
    }

    @Test
    public void addNumberTest() {

        phonebook.add(name, phoneNumber);

        Assert.assertEquals(1, phonebook.listAllEntries().size());
    }

    @Test
    public void removeNumberTest() {

        phonebook.add(name, phoneNumber);

        phonebook.remove(name, phoneNumber);
        
        // should return {Cameron Sima=[]}; phone number arraylist is empty
        Assert.assertEquals(0, phonebook.listAllEntries().get(name).size());
    }

    @Test
    public void removeEntryTest() {
        phonebook.add(name, phoneNumber);

        phonebook.removeEntry(name);

        // should return {Cameron Sima=[]}; phone number arraylist is empty
        Assert.assertEquals(0, phonebook.listAllEntries().size());
    }

    @Test
    public void listAllEntriesTest() {

        phonebook.add(name, phoneNumber);
        phonebook.add("George Smith", "2344563434");

        TreeMap result = phonebook.listAllEntries();

        String resultString = "{Cameron Sima=[2154673127], George Smith=[2344563434]}";

        Assert.assertEquals(result.getClass(), TreeMap.class);

        // results are sorted alphabetically
        Assert.assertEquals(resultString, result.toString());
    }

    @Test
    public void listAllNamesTest() {

        phonebook.add(name, phoneNumber);

        Collection<String> allNames = phonebook.listAllNames();

        String resultPhoneNumber = allNames.toArray()[0].toString();

        Assert.assertEquals(1, allNames.size());
        Assert.assertEquals(name, resultPhoneNumber);
    }

    @Test
    public void lookupTest() {
        phonebook.add(name, phoneNumber);

        ArrayList<String> result = phonebook.lookup("Cameron Sima");

        Assert.assertEquals(phoneNumber, result.get(0));
    }

    @Test
    public void reverseLookupTest() {

        phonebook.add(name, phoneNumber);

        String actualdResult = phonebook.reverseLookup(phoneNumber);
        String expectedResult = "Cameron Sima";

        Assert.assertEquals(expectedResult, actualdResult);
    }

}


