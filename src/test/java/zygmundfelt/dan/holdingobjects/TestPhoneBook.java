package zygmundfelt.dan.holdingobjects;

import org.junit.*;

public class TestPhoneBook {

    PhoneBook phoneBook;

    private void loadEntries() {
        phoneBook = new PhoneBook();
        phoneBook.add("Zygmund-Felt,Dan", 5555555555L);
        phoneBook.add("FlagDymz,And", 3335553333L);
        phoneBook.add("Ated,Hyphen", 1234567890L);
        phoneBook.add("Villain,MetalFace", 2678675309L);
    }

    @Test
    public void addTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Zyg,Dan", 1234567890L);
        int expected = 1;

        int actual = phoneBook.map.size();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void lookUpValidEntryTest() {
        loadEntries();
        String name = "Ated,Hyphen";
        long expected = 1234567890L;

        long actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUpNonexistentEntryTest() {
        loadEntries();
        String name = "Ated,NoSuch";
        Long expected = null;

        Long actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPersonsNonemptyTest() {
        loadEntries();
        String expected = "Ated,Hyphen\nFlagDymz,And\nVillain,MetalFace\nZygmund-Felt,Dan\n";

        String actual = phoneBook.getAllPersons();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPersonsEmptyTest() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "";

        String actual = phoneBook.getAllPersons();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllEntriesNonemptyTest() {
        loadEntries();
        String expected = "Ated,Hyphen: 1234567890\nFlagDymz,And: 3335553333\nVillain,MetalFace: 2678675309\nZygmund-Felt,Dan: 5555555555\n";

        String actual = phoneBook.getAllEntries();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllEntriesEmptyTest() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "";

        String actual = phoneBook.getAllEntries();

        Assert.assertEquals(expected, actual);
    }

}
