import org.junit.Assert;
import org.junit.Test;



/**
 * Created by aurorabanuelos on 5/16/17.
 */
public class PhoneBookTest {

    @Test
    public void lookupTest(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String inputName = "Aurora";
        String expected = inputName + "'s phone number is: " + "(845)-333-5454";

        //When
        String actual = phoneBook.lookup(inputName);

        //Then
        Assert.assertEquals("should return phone number for inputName",expected, actual);

    }

    @Test
    public void addEntryTest(){

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String inputName = "Aurora";
        String inputNumber = "(845)-333-5454";

        //When
        phoneBook.addEntry(inputName, inputNumber);
        String actual = phoneBook.phoneList.get(inputName);


        //Then
        Assert.assertEquals("Entry should have been added", inputNumber, actual);

    }

    @Test
    public void removeEntryTest(){

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String inputName = "Aurora";
        String inputNumber = "(845)-333-5454";

        //When
        phoneBook.removeEntry(inputName);
        String actual = phoneBook.phoneList.get(inputName);


        //Then
        Assert.assertEquals("Entry should have been removed", null, actual);

    }

    @Test
    public void listAllNamesTest(){

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Aurora\nKaren";

        //When

        String actual = phoneBook.listAllNames();


        //Then
        Assert.assertEquals("Strings should be equal", expected, actual);

    }

    @Test
    public void listAllEntriesTest(){

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Aurora: (845)-333-5454\nKaren: (234)-435-4433";

        //When

        String actual = phoneBook.listAllEntries();


        //Then
        Assert.assertEquals("Strings should be equal", expected, actual);

    }


}
