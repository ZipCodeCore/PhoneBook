package ibikunle.tolani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook phoneBook ;


    @Before
    public void setUp() {
         phoneBook = new PhoneBook();


    }


    @Test
    public void lookUpTest() {
        //Lookup non existing, look up in an empty phone book
        phoneBook.add("Tolani", "610-444-4444");
        String expected = "610-444-4444";
        String actual = phoneBook.lookUp("Tolani");
        Assert.assertEquals("I am expecting 610-444-4444", expected, actual);
    }
        @Test
       public void reverseLookUpTest(){
            phoneBook.add("Tolani", "610-444-4444");
            String expected = "Tolani";
            String actual = phoneBook.reverseLookUp("610-444-4444");
            Assert.assertEquals("I am expecting Tolani",expected,actual);
        }

    @Test
    public void lookUpNonExistingNumberTest(){
        String expected = "Does not exist";
        String actual = phoneBook.lookUp("Tolani");
        Assert.assertNull(null);
    }

    @Test
    public void addTest(){
        phoneBook.add("Dr.G","610-888-2321");
        //add duplicate value . add to empty phone book ; adding multiple values , add invalid entry
        int expected =  1 ;
        int actual =  phoneBook.size();
        Assert.assertEquals("I am expecting to add one person to the phoneBook",expected,actual);
    }

    @Test
    public void addDuplicateValueTest(){
        phoneBook.add("Dr.G","610-888-2321");
        phoneBook.add("Dr.G","610-888-2321");
        int expected = 1;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting a duplicate value",expected,actual);
    }

    @Test
    public void addMultipleValuesTest(){
        phoneBook.add("Dr.G","610-888-2321");
        phoneBook.add("Preston da JuiceMan","610-777-7777");
        phoneBook.add("Milton","610-444-4444");
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
    public void removeFromEmptyPhoneBookTest(){
        phoneBook.add("Preston da JuiceMan","610-777-7777");
        phoneBook.remove("Preston da JuiceMan");
        phoneBook.remove("Jane Doe");
        Assert.assertNull(null);
    }

    @Test
    public void removeLastItem(){
        phoneBook.add("Preston da JuiceMan","610-777-7777");
        phoneBook.remove("Preston da JuiceMan");
        int expected = 0;
        int actual = phoneBook.size();
        Assert.assertEquals("I am expecting 0",expected,actual);
    }

    @Test
    public void removeASingleNumberTest(){
        phoneBook.add("Preston da JuiceMan","610-777-7777");
        phoneBook.add("Preston da JuiceMan","610-888-8888");
        phoneBook.removeASingleNumber("Preston da JuiceMan","610-888-8888");
        int expected = 0;
        int actual = phoneBook.get("Preston da JuiceMan").size();
        Assert.assertEquals(" I am expecting the number to be removed",expected,actual);

    }
}
