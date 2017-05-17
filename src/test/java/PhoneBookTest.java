

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vidyachandasekhar on 5/16/17.
 */


public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void addEntryTest() {

        //given
        String name = "Vidya";
        String number = "123-345-5678";

        //when
        phoneBook.addEntry(name, number);

        //then
        Assert.assertEquals("123-345-5678", phoneBook.lookUpName("Vidya"));
    }

    @Test
    public void deleteEntryTest() {

        //given @Before instance creation


        //when
        phoneBook.deleteEntry("Vidya");

        //then
        Assert.assertEquals(null, phoneBook.lookUpName("Vidya"));
    }

    @Test
    public void lookUpNameTest(){


        //: Given
        phoneBook.addEntry("Vidya", "123-345-5678");
        phoneBook.addEntry("Hari", "123-345-5678");
        phoneBook.addEntry("Pranav", "123-345-5678");
        phoneBook.addEntry("Adarsh", "123-345-5678");


        //: When

        String actual = phoneBook.lookUpName("Vidya");

        //: Then
        Assert.assertEquals("123-345-5678", actual);
    }


    @Test
    public void lookUpAllEntriesTest() {

        //given

        phoneBook.addEntry("Vidya", "123-345-5678");
        phoneBook.addEntry("Hari", "123-345-5678");
        phoneBook.addEntry("Pranav", "123-345-5678");
        phoneBook.addEntry("Adarsh", "123-345-5678");

        String exptectedValue = "Name : " + "Adarsh" + " Phone Number : " + "123-345-5678" + "\n"
                        + "Name : " + "Hari" + " Phone Number : " + "123-345-5678" + "\n"
                        + "Name : " + "Pranav" + " Phone Number : " + "123-345-5678" + "\n"
                        + "Name : " + "Vidya" + " Phone Number : " + "123-345-5678" + "\n";

        //when
        String contactList = phoneBook.lookUpAllEntries();

        //then
        Assert.assertEquals(contactList, exptectedValue);
    }



}


