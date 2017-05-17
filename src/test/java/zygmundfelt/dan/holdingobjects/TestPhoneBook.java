package zygmundfelt.dan.holdingobjects;

import org.junit.*;

import java.util.ArrayList;

public class TestPhoneBook {

    PhoneBook phoneBook;
    PhoneBook emptyPhoneBook;

    @Before
    public void initialize() {
        phoneBook = new PhoneBook();
        emptyPhoneBook = new PhoneBook();
        try {
            phoneBook.addRecord("Zygmund-Felt,Dan", "(555) 555-5555");
            phoneBook.addRecord("Zygmund-Felt,Dan", "(888) 888-8888");
            phoneBook.addRecord("Smith,Stan", "(333) 555-3333");
            phoneBook.addRecord("Ated,Hyphen", "(123) 456-7890");
            phoneBook.addRecord("Villain,MetalFace", "(267) 867-5309");
            phoneBook.addRecord("Villain,MetalFace", "(215) 867-5309");
        } catch (Exception e) {

        }
    }

    @Test
    public void addTest() {
        emptyPhoneBook.addRecord("Zyg,Dan", "(123) 456-7890");
        int expected = 1;

        int actual = emptyPhoneBook.map.size();

        Assert.assertEquals(expected,actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberFormatTest() {
        emptyPhoneBook.addRecord("Dan,Dan", "Dan,Dan");
    }

    @Test
    public void addMultipleToSameNameTest() {
        emptyPhoneBook.addRecord("Zyg,Dan", "(123) 456-7890");
        emptyPhoneBook.addRecord("Zyg,Dan", "(987) 654-3210");
        int expected = 2;

        int actual = emptyPhoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected,actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberFormatInMiddleOfListOfAdds() {
        emptyPhoneBook.addRecords("Zyg,Dan", "(867) 530-9123", "(123) 456-7890", "blahblahblah", "(321) 654-7890");
    }

    @Test
    public void addRecordsNewRecordTest() {
        emptyPhoneBook.addRecords("Zyg,Dan", "(123) 456-7890", "(987) 654-3210", "(654) 321-9800");
        int expected = 3;

        int actual = emptyPhoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected, actual);
    }

    @Test //TODO - not a great test
    public void removeRecordByNameValidTest() {
        ArrayList<String> expected = phoneBook.map.get("Villain,MetalFace");

        ArrayList<String> actual = phoneBook.removeRecordByName("Villain,MetalFace");

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void removeRecordByNameNonexistentTest() {
        phoneBook.removeRecordByName("Puft,Stay");
    }

    @Test
    public void removePhoneNumberValidTest() {
        String expected = "[(555) 555-5555]";

        phoneBook.removePhoneNumber("(888) 888-8888");
        String actual = phoneBook.map.get("Zygmund-Felt,Dan").toString();

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void removeNonexistentPhoneNumberTest() {
        phoneBook.removePhoneNumber("(321) 654-0987");
    }

    @Test
    public void lookUpValidEntryTest() {
        String name = "Ated,Hyphen";
        ArrayList<String> expected = phoneBook.map.get("Ated,Hyphen");

        ArrayList<String> actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void lookUpNonexistentEntryTest() {
        phoneBook.lookUp("Ated,NoSuch");
    }

    @Test
    public void allNamesToStringNonemptyTest() {
        String expected = "Ated,Hyphen\nSmith,Stan\nVillain,MetalFace\nZygmund-Felt,Dan\n";

        String actual = phoneBook.allNamesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allNamesToStringEmptyTest() {
        String expected = "";

        String actual = emptyPhoneBook.allNamesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allEntriesToStringNonemptyTest() {
        String expected = "Ated,Hyphen: [(123) 456-7890]\n" +
        "Smith,Stan: [(333) 555-3333]\n" +
        "Villain,MetalFace: [(267) 867-5309, (215) 867-5309]\n" +
        "Zygmund-Felt,Dan: [(555) 555-5555, (888) 888-8888]\n";
        String actual = phoneBook.allEntriesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allEntriesToStringEmptyTest() {
        String expected = "";

        String actual = emptyPhoneBook.allEntriesToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpValidPhoneNumberTest() {
        String expected = "Smith,Stan";

        String actual = phoneBook.reverseLookUp("(333) 555-3333");

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void reverseLookUpNonexistentNumberTest() {
        phoneBook.reverseLookUp("(111) 222-3333");
    }

}
