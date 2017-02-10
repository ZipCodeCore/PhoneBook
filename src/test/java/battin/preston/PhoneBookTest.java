package battin.preston;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/7/17.
 */
public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() throws InvalidPhoneNumberFormat{

        phoneBook = new PhoneBook();
        phoneBook.addEntry("Bob", "(302)-722-3221");
    }

    @Test
    public void lookUpTest() {

        String expected = "[(302)-722-3221]";
        String actual = "";
       try {
           actual = phoneBook.lookUp("Bob");
       }catch (RecordNotPresent e){
           Assert.fail();
       }
        Assert.assertEquals("Testing adding a person", expected, actual);

    }

    @Test
    public void addEntryTest () {

        try {

            phoneBook.addEntry("Euge", "(434)-567-7890");
        }catch (InvalidPhoneNumberFormat e){
            Assert.fail();
        }
        String expected = "[(434)-567-7890]";
        String actual = "";
        try {
             actual = phoneBook.lookUp("Euge");
        }catch (RecordNotPresent e){Assert.fail(); System.out.println(e.getMessage());
        }
        Assert.assertEquals("Testing adding an entry", expected, actual);
    }

    @Test
    public void removeEntryTest(){

        try {
            phoneBook.addEntry("Euge", "(434)-567-7890");
        }catch (InvalidPhoneNumberFormat e){
            Assert.fail();
        }
        try {
            phoneBook.removeEntry("Bob");
        }catch (RecordNotPresent e){
            Assert.fail();
        }
       int expected = 1;
       int actual = phoneBook.getEntries().size();
        Assert.assertEquals("Testing removing an item", expected, actual);
    }

    @Test
    public void printEntryNumbersTest(){

        String expected = "[Bob]";
        String actual = "";
        try{
            actual= phoneBook.printAllNames().toString();
        }catch(RecordNotPresent e){
            Assert.fail();
        }
        Assert.assertEquals("Testing print all values", expected,actual);
    }

    @Test
    public void printAllEntriesTest() {

       try{
           phoneBook.addEntry("Euge", "(434)-567-7890");
       }catch (InvalidPhoneNumberFormat e){
           Assert.fail();
       }
        String expected = "Bob [(302)-722-3221]" + "\n" + "Euge [(434)-567-7890]" + "\n";
        String actual = "";
       try{
           actual= phoneBook.printAllEntries();
       }catch (RecordNotPresent e){
           Assert.fail();
       }
        Assert.assertEquals("Testing all entries print", expected, actual);
    }

    @Test
    public void reverseLookUpTest(){

        String expected = "Bob";
        String actual = "";
       try{
           actual = phoneBook.reverseLookUp("(302)-722-3221");
       }catch (InvalidPhoneNumberFormat e){
           Assert.fail();

       }
        Assert.assertEquals("Testing looking up by value", expected, actual);
    }

    @Test
    public void removeNumberTest(){

       try{
           phoneBook.getEntry("Bob").removeNumber("(302)-722-3221");
       }catch (RecordNotPresent e){

           Assert.fail();
       }
        String expected = "[]";
        String actual = "";
       try{
           actual = phoneBook.getEntry("Bob").getPhoneNumbers().toString();
       }catch (RecordNotPresent e){
           Assert.fail();
       }
        Assert.assertEquals("Testing removing a number", expected, actual);
    }

    @Test(expected = InvalidPhoneNumberFormat.class)
    public void reverseLookUpExceptionTest() throws InvalidPhoneNumberFormat{

      phoneBook.reverseLookUp("");

    }

    @Test(expected = InvalidPhoneNumberFormat.class)
    public void addEntryExceptionTest() throws InvalidPhoneNumberFormat{

        phoneBook.addEntry("Kevin", "");
    }

    @Test(expected = RecordNotPresent.class)
    public void lookUpExceptionTest() throws RecordNotPresent{

        phoneBook.lookUp("Bob1");
    }

    @Test(expected = RecordNotPresent.class)
    public void removeEntryExceptionTest() throws RecordNotPresent{

        phoneBook.lookUp("");
    }

    @Test(expected = RecordNotPresent.class)
    public void getEntryExceptionTest() throws RecordNotPresent{

        phoneBook.getEntry("");
    }

    @Test(expected = RecordNotPresent.class)
    public void printAllNamesExceptionTest() throws RecordNotPresent{

        phoneBook.getEntries().clear();
        phoneBook.printAllNames();
    }

    @Test(expected = RecordNotPresent.class)
    public void printAllEntriesExceptionTest() throws RecordNotPresent{

        phoneBook.getEntries().clear();
        phoneBook.printAllEntries();
    }

}
