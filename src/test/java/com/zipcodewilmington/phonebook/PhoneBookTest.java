package com.zipcodewilmington.phonebook;

import org.junit.Test;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testSetAddName() {
        PhoneBook testing = new PhoneBook();
        String expected = "Nathaniel";

        testing.setAddName(expected);

        String actual = testing.getAddName();
        Assert.assertEquals(expected, actual);


    }


    @Test
    public void testSetAddNumber() {
        PhoneBook testing = new PhoneBook();
        String expected = "8567744733";

        testing.setAddNumber(expected);

        String actual = testing.getAddNumber();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetLookup() {
        PhoneBook testing = new PhoneBook();
        String expected = "Samantha";

        testing.setLookup(expected);

        String actual = testing.getLookup();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRemoveName() {
        Phonebook testing = new PhoneBook();
        String expected = "Removal";

        testing.setRemoveName(expected);

        String actual = testing.getRemoveName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRemoveNumber() {
        PhoneBook testing = new PhoneBook();
        String expected = "Remove Number";

        testing.setRemoveNumber(expected);

        String actual = testing.getRemoveNumber();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetListNames() {
        PhoneBook testing = new PhoneBook();
        String expected = "List of Names";

        testing.setListNames(expected);

        String actual = testing.getListNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetListNumber() {
        PhoneBook person = new PhoneBook();
        String expected = "List Number";

        person.setListNumber(expected);

        String actual = person.getListNumber();
        Assert.assertEquals(expected, actual);
    }




    }




