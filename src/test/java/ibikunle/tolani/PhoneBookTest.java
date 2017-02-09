package ibikunle.tolani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook phoneBook ;


    @Before
    public void setUp() {
         phoneBook = new PhoneBook();

    }g


    @Test
    public void lookUpTest() throws InvalidPhoneNumberFormatException {
        //Lookup non existing, look up in an empty phone book
        phoneBook.add("Tolani", "(610)-444-4444");
        String expected = "(610)-444-4444";
        String actual = phoneBook.lookUp("Tolani");
        Assert.assertEquals("I am expecting 610-444-4444", expected, actual);
    }
        @Test
       public void reverseLookUpTest() throws InvalidPhoneNumberFormatException {
            phoneBook.add("Tolani", "(610)-444-4444");
            String expected = "Tolani";
            String actual = phoneBook.reverseLookUp("(610)-444-4444");
            assertEquals("I am expecting Tolani",expected,actual);
        }

    @Test
    public void lookUpNonExistingNumberTest(){
        String expected = "Does not exist";
        //String actual = phoneBook.lookUp("Tolani");
        Assert.assertNull(null);
    }

    @Test
    public void addTest() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Dr.G","(610)-888-2321");
        //add duplicate value . add to empty phone book ; adding multiple values , add invalid entry
        int expected =  1 ;
        int actual =  phoneBook.size();
        Assert.assertEquals("I am expecting to add one person to the phoneBook",expected,actual);
    }

    @Test
    public void addDuplicateValueTest() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Dr.G","(610)-888-2321");
        phoneBook.add("Dr.G","(610)-888-2321");
        int expected = 1;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting one value",expected,actual);
    }

    @Test
    public void addMultipleValuesTest() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Dr.G","(610)-888-2321");
        phoneBook.add("Preston da JuiceMan","(610)-777-7777");
        phoneBook.add("Milton","(610)-444-4444");
        int expected = 3;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting three values to be added",expected,actual);
    }
    @Test
    public void removeTest(){
        // remove last value; // remove
        int expected = 0;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting to remove one person from the phone book",expected,actual);
    }
    @Test
    public void removeFromEmptyPhoneBookTest() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Preston da JuiceMan","(610)-777-7777");
        phoneBook.remove("Preston da JuiceMan");
        phoneBook.remove("Jane Doe");
        Assert.assertNull(null);
    }

    @Test
    public void removeLastItem() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Preston da JuiceMan","(610)-777-7777");
        phoneBook.remove("Preston da JuiceMan");
        int expected = 0;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting 0",expected,actual);
    }

    @Test
    public void removeASingleNumberTest() throws InvalidPhoneNumberFormatException {
        phoneBook.add("Preston da JuiceMan", "(610)-777-7777");
        phoneBook.add("Preston da JuiceMan", "(610)-888-8888");
        phoneBook.removeASingleNumber("(610)-888-8888");
        assertEquals(1,phoneBook.get("Preston da JuiceMan").size());

   }
}
