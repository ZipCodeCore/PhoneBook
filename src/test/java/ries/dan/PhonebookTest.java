package ries.dan;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by danries on 2/7/17.
 */
public class PhonebookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Before public void initialize(){
        phoneBook.addEntry("John","(302)985-5648");
    }

    @Test
    public void lookUpTest(){
        String expected = "(302)985-5648";
        String actual = phoneBook.lookUp("John");
        assertEquals("We expect to get the phone number back",expected,actual);
    }

    @Before public void addAnother(){
        phoneBook.addEntry("Carmelo","(302)999-6565");
    }

    @Test
    public void add(){
        int expected = 2;
        int actual = phoneBook.size();
        assertEquals("We expect to get an increased size in the phonebook due to adding a new entry",expected,actual);
    }

    @Test
    public void remove(){
        phoneBook.removeEntry("Carmelo");
        int expected = 1;
        int actual = phoneBook.size();
        assertEquals("We expect to get the size of the tree minus one for the number we removed",expected,actual);
    }

//    @Test
//    public void reverseLookUpTest(){
//        String expected = "John";
//        String actual = phoneBook.reverseLookUp("(302)985-5648");
//        assertEquals("we expect to get Johns name back for the reverse lookup",expected,actual);
//    }
}
