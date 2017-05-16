import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mollyarant on 5/16/17.
 */
public class TestPhonebook {
    PhoneBook phoneBook;
    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
    }

    @Test
   public void testAddEntry() {


        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";

        //when:
        phoneBook.addEntry(contactName, phoneNumber);

        //then:
        Assert.assertEquals("(302)-555-9743", phoneBook.getContactInfo().get("Molly"));
    }

    @Test
    public void testRemoveEntry(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber);
        //when:
        phoneBook.removeEntry("Molly");

        //then:
        Assert.assertEquals(null, phoneBook.getContactInfo().get("Molly"));


    }

    @Test
    public void testLookUp(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber);
        //when:
        phoneBook.lookup("Molly");

        //then:
        Assert.assertEquals("(302)-555-9743", phoneBook.lookup("Molly"));


    }

    @Test
    public void testListAllEntries(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber);
        String contactName2= "Steven";
        String phoneNumber2= "(302)-555-2456";
        phoneBook.addEntry(contactName2,phoneNumber2);
        String expected= "Name: Molly Phone Number: (302)-555-9743\n" +
                "Name: Steven Phone Number: (302)-555-2456";
        //when:
        phoneBook.listAllEntries();

        //then:
        Assert.assertEquals(expected, phoneBook.listAllEntries());


    }

    @Test
    public void testListNames(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber);
        String contactName2= "Steven";
        String phoneNumber2= "(302)-555-2456";
        phoneBook.addEntry(contactName2,phoneNumber2);
        String expected= "Name: Molly\n" +
                "Name: Steven";
        //when:
        phoneBook.listAllNames();

        //then:
        Assert.assertEquals(expected, phoneBook.listAllNames());


    }





}
