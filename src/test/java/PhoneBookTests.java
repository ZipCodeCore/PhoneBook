import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void addEntryTest() {

        phonebook.add(name, phoneNumber);

        Assert.assertEquals(1, phonebook.listAllEntries().size());
    }

    @Test
    public void removeEntryTest() {

        phonebook.add(name, phoneNumber);

        phonebook.remove(name);

        Assert.assertEquals(0, phonebook.listAllEntries().size());
    }

    @Test
    public void listAllEntriesTest() {

        phonebook.add(name, phoneNumber);
        phonebook.add("George Smith", "2344563434");

        TreeMap result = phonebook.listAllEntries();

        String resultString = "{Cameron Sima=2154673127, George Smith=2344563434}";

        Assert.assertEquals(result.getClass(), TreeMap.class);
        Assert.assertEquals(phoneNumber, result.get("Cameron Sima"));

        // results are sorted alphabetically
        Assert.assertEquals(resultString, result.toString());
    }

    @Test
    public void listAllNamesTest() {

        phonebook.add(name, phoneNumber);

        Collection<String> allNames = phonebook.listAllNames();

        String resultPhoneNumber = allNames.toArray()[0].toString();

        Assert.assertEquals(1, allNames.size());
        Assert.assertEquals(phoneNumber, resultPhoneNumber);
    }

    @Test
    public void lookupTest() {
        phonebook.add(name, phoneNumber);

        String result = phonebook.lookup("Cameron Sima");

        Assert.assertEquals(phoneNumber, result);
    }

}
