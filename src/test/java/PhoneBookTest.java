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
        String name = "Patrick";
        String phoneNumber = "302-761-9121";
        String expectedString = "The entry 'Patrick 302-761-9121' was added to phoneBook";

        //When
        String actualString = phoneBook.addEntries(name, phoneNumber);

        //Then
        Assert.assertEquals("The expected String is ", expectedString, actualString);

    }

    @Test
    public void removeEntriesTest(){
        //Given
        String name = "Squidward";
        String phoneNumber = "302-761-9222";
        String expectedString = "The entry 'Squidward 302-761-9222' was removed from phoneBook." +
                "It is now null.";
        //String expectedString = null;

        //When
        phoneBook.addEntries(name, phoneNumber);
        String actualString = phoneBook.removeEntries(name);

        //Then
        Assert.assertEquals("The expected String is ", expectedString, actualString);

    }

    @Test
    public void listAllEntriesTest(){
        //Given
        String name1 = "Spongebob";
        String name2 = "Mr.Krabs";
        String phoneNum1 = "1-800-pineapple";
        String phoneNum2 = "1-800-krabby";
        String expectedSet = "The full phoneBook list is: [Mr.Krabs=1-800-krabby, Spongebob=1-800-pineapple]";

        //When
        phoneBook.addEntries(name1, phoneNum1);
        phoneBook.addEntries(name2, phoneNum2);
        String actualSet = phoneBook.listAllEntries();

        //Then
        Assert.assertEquals("The expected String is ", expectedSet, actualSet);

    }


}
