package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

   private PhoneBook testPhoneBook;

   @Before
   public void createPhone(){
      this.testPhoneBook = new PhoneBook();
   }

   @Test
   public void testAddEntry(){
      String expected = "111111111";
      String name = "Albert";
      testPhoneBook.addEntry(name, expected);
      String actual = testPhoneBook.entryLookup(name);
      Assert.assertEquals(expected, actual);

   }

   @Test
   public void testRemoveEntry(){
      String expected = null;
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.removeEntry(name, number);
      String actual = testPhoneBook.entryLookup(name);
      Assert.assertEquals(expected, actual);

   }

   @Test
   public void testEntryLookup(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.entryLookup(name);
      String expected = testPhoneBook.entryLookup(name);
      String actual = testPhoneBook.entryLookup(name);
      Assert.assertEquals(expected, actual);

   }

   @Test
   public void testEntryListNames(){

   }

   @Test
   public void testEntryListNumbers(){

   }

   @Test
   public void testEntryListAll(){

   }

   @Test
   public void testReverseEntry(){

   }


}
