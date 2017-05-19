package zygmundfelt.dan.holdingobjects;

import org.junit.*;

import java.util.ArrayList;

public class TestPhoneBook {

    private PhoneBook phoneBook;
    private PhoneBook emptyPhoneBook;

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
            //Since this is a test class, I will permit myself a fake catch.
        }
    }

    @Test
    public void addTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Zyg,Dan", "(123) 456-7890");
        int expected = 1;

        int actual = emptyPhoneBook.map.size();

        Assert.assertEquals(expected,actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberStringTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Dan,Dan", "Dan,Dan");
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberTooLongTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Dan,Dan", "12345671234567");
    }

    @Test
    public void addValidPhoneNumberWithJustDigitsTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Jude,Hey", "4322342234");
        int expected = 1;

        int actual = emptyPhoneBook.map.size();

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberZeroFirstDigitTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Everdeen,Katniss", "0987654321");
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberGoodFormatZeroFirstDigitTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Melark,Peeta", "(089) 123-4321");
    }

    @Test
    public void addMultipleToSameNameTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecord("Zyg,Dan", "(123) 456-7890");
        emptyPhoneBook.addRecord("Zyg,Dan", "(987) 654-3210");
        int expected = 2;

        int actual = emptyPhoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected,actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void addInvalidPhoneNumberFormatInMiddleOfListOfAdds() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecords("Zyg,Dan", "(867) 530-9123", "(123) 456-7890", "blahblahblah", "(321) 654-7890");
    }

    @Test
    public void addRecordsNewRecordTest() throws InvalidPhoneNumberFormatException {
        emptyPhoneBook.addRecords("Zyg,Dan", "(123) 456-7890", "(987) 654-3210", "(654) 321-9800");
        int expected = 3;

        int actual = emptyPhoneBook.map.get("Zyg,Dan").size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecordByNameValidTest() throws RecordNotPresentException {
        ArrayList<String> expected = phoneBook.map.get("Villain,MetalFace");

        ArrayList<String> actual = phoneBook.removeRecordByName("Villain,MetalFace");

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void removeRecordByNameNonexistentTest() throws RecordNotPresentException {
        phoneBook.removeRecordByName("Puft,Stay");
    }

    @Test
    public void removePhoneNumberValidTest() throws RecordNotPresentException {
        String expected = "[(555) 555-5555]";

        phoneBook.removePhoneNumber("(888) 888-8888");
        String actual = phoneBook.map.get("Zygmund-Felt,Dan").toString();

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void removeNonexistentPhoneNumberTest() throws RecordNotPresentException {
        phoneBook.removePhoneNumber("(321) 654-0987");
    }

    @Test
    public void lookUpValidEntryTest() throws RecordNotPresentException {
        String name = "Ated,Hyphen";
        ArrayList<String> expected = phoneBook.map.get("Ated,Hyphen");

        ArrayList<String> actual = phoneBook.lookUp(name);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void lookUpNonexistentEntryTest() throws RecordNotPresentException {
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
    public void reverseLookUpValidPhoneNumberTest() throws RecordNotPresentException {
        String expected = "Smith,Stan";

        String actual = phoneBook.reverseLookUp("(333) 555-3333");

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RecordNotPresentException.class)
    public void reverseLookUpNonexistentNumberTest() throws RecordNotPresentException {
        phoneBook.reverseLookUp("(111) 222-3333");
    }

}
