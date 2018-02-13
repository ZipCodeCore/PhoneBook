package com.zipcodewilmington.phonebook;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {


    PhoneBook phoneBook;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();

    }
    @Test
    public void testAddContact(){
        phoneBook.addContact("Genya", "6578356767");
        boolean genyaIsInPhoneBook = phoneBook.getContactsList().keySet().contains("Genya");
        assertTrue(genyaIsInPhoneBook);

    }
    @Test
    public void testRemoveContact(){
        phoneBook.removeContact("Pete Jones");
        boolean peteJonesHasBeenRemoved = !phoneBook.getContactsList().containsKey("Pete Jones");
        assertTrue(peteJonesHasBeenRemoved);
    }
    @Test
    public void testLookUpContactByName(){
        phoneBook.lookUpContactByName("Nala Bits");
        String expected = "2345578122";
        String actual = phoneBook.getContactsList().get("Nala Bits");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testListAllByName(){

    }

}

}
