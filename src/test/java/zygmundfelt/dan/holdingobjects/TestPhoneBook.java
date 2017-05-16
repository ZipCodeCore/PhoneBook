package zygmundfelt.dan.holdingobjects;

import org.junit.*;

import java.util.ArrayList;

public class TestPhoneBook {

    PhoneBook phoneBook;

    private void loadEntries() {
        phoneBook = new PhoneBook();
        phoneBook.addRecord("Zygmund-Felt,Dan", 5555555555L);
        phoneBook.addRecord("Zygmund-Felt,Dan", 8888888888L);
        phoneBook.addRecord("Smith,Stan", 3335553333L);
        phoneBook.addRecord("Ated,Hyphen", 1234567890L);
        phoneBook.addRecord("Villain,MetalFace", 2678675309L);
        phoneBook.addRecord("Villain,MetalFace", 2158675309L);
    }

    @Test
    public void addTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addRecord("Zyg,Dan", 1234567890L);
        int expected = 1;

        int actual = phoneBook.map.size();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addMultipleToSameNameTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addRecord("Zyg,Dan", 1234567890L);
        phoneBook.addRecord("Zyg,Dan", 9876543210L);
        int expected = 2;

        int actual = phoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addRecordsNewRecordTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addRecords("Zyg,Dan", 1234567890L, 9876543210L, 1236547890L);
        int expected = 3;

        int actual = phoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected, actual);
    }

    @Test //TODO - not a great test
    public void removeRecordByNameValidTest() {
        loadEntries();
        ArrayList<Long> expected = phoneBook.map.get("Villain,MetalFace");

        ArrayList<Long> actual = phoneBook.removeRecordByName("Villain,MetalFace");

        Assert.assertTrue(expected == actual);
    }

    public void removeRecordByNameNonexistentTest() {
        loadEntries();

        ArrayList<Long> result = phoneBook.removeRecordByName("Puft,Stay");

        Assert.assertTrue(result == null);
    }

    @Test
    public void removePhoneNumberValidTest() {
        loadEntries();
        String expected = "[5555555555]";

        phoneBook.removePhoneNumber(8888888888L);
        String actual = phoneBook.map.get("Zygmund-Felt,Dan").toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNonexistentPhoneNumberTest() {
        loadEntries();

        Assert.assertFalse(phoneBook.removePhoneNumber(3216540987L));
    }

    @Test
    public void removeNonexistentEntryTest() {
        loadEntries();
        Long expected = null;

        ArrayList<Long> actual = phoneBook.removeRecordByName("Millain,VetalFace");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUpValidEntryTest() {
        loadEntries();
        String name = "Ated,Hyphen";
        ArrayList<Long> expected = phoneBook.map.get("Ated,Hyphen");

        ArrayList<Long> actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUpNonexistentEntryTest() {
        loadEntries();
        String name = "Ated,NoSuch";
        ArrayList<Long> expected = null;

        ArrayList<Long> actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allNamesToStringNonemptyTest() {
        loadEntries();
        String expected = "Ated,Hyphen\nSmith,Stan\nVillain,MetalFace\nZygmund-Felt,Dan\n";

        String actual = phoneBook.allNamesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allNamesToStringEmptyTest() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "";

        String actual = phoneBook.allNamesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allEntriesToStringNonemptyTest() {
        loadEntries();
        String expected = "Ated,Hyphen: [1234567890]\nSmith,Stan: [3335553333]\nVillain,MetalFace: [2678675309, 2158675309]\nZygmund-Felt,Dan: [5555555555, 8888888888]\n";

        String actual = phoneBook.allEntriesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allEntriesToStringEmptyTest() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "";

        String actual = phoneBook.allEntriesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpValidPhoneNumberTest() {
        loadEntries();
        String expected = "Smith,Stan";

        String actual = phoneBook.reverseLookUp(3335553333L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpNonexistentNumberTest() {
        loadEntries();

        String result = phoneBook.reverseLookUp(1112223333L);

        Assert.assertTrue(result == null);
    }

}
