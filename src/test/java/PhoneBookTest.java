import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.TreeMap;

/**
 * Created by brianmullin on 5/16/17.
 */

public class PhoneBookTest {

    PhoneBook phoneBook;
    //TreeMap<String, String> testPhoneBook = new TreeMap<String, String>();

    @Before
    public void setUp(){

        phoneBook = new PhoneBook();


    }

    @Test
    public void lookUpByNameTest(){
        //Given
        String entry = "Brian";
        String expectedNumber = "302-757-1634";

        //When
        phoneBook.addEntries(entry, expectedNumber);
        String actualNumber = phoneBook.lookUpByName("Brian");
        //Then
        Assert.assertEquals("The expected phone number is ", expectedNumber, actualNumber);


    }

    @Test
    public void addEntriesTest(){
        //Given
        String name = "Brian";
        String phoneNumber = "302-757-1634";


        //When
        phoneBook.addEntries(name, phoneNumber);
        String actualNumber = phoneBook.lookUpByName("Brian");

        //Then
        Assert.assertEquals("The expected phone number is ", expectedNumber, actualNumber);

    }

    @Test
    public void removeEntriesTest(){
        //Given

        //When

        //Then

    }

    @Test
    public void listAllEntriesTest(){
        //Given

        //When

        //Then

    }


}
