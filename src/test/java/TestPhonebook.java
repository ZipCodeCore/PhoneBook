import com.sun.deploy.util.StringUtils;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

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
        ArrayList<String> expected= new ArrayList<String>();
        expected.add("(302)-555-9743");

        //when:
        phoneBook.addEntry(contactName, phoneNumber, phoneBook.getContactInfo());

        //then:
        Assert.assertEquals("Should add a new entry to the phonebook",expected, phoneBook.lookup(contactName, phoneBook.getContactInfo()));
    }
//
    @Test
    public void testRemoveRecord(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber, phoneBook.getContactInfo());
        //when:
        phoneBook.removeRecord("Molly", phoneBook.getContactInfo());

        //then:
        Assert.assertEquals("should return null if the key has been removed",null, phoneBook.getContactInfo().get("Molly"));


    }
    @Test
    public void testRemoveEntry(){
        //given:
        TreeMap<String, ArrayList<String>> contactInfo= phoneBook.getContactInfo();
        String contactName = "Molly";
        String number1="3025555555";
        String number2="3024444444";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(number2);
        phoneBook.addEntry(contactName, number1, contactInfo);
        phoneBook.addEntry(contactName, number2, contactInfo);

        //when:
        phoneBook.removeNumber("Molly", number1, phoneBook.getContactInfo());
        //then:
        Assert.assertEquals("Should return only one phone number", expected, phoneBook.getContactInfo().get("Molly"));
    }


    @Test
    public void testLookUp(){
        //given:
        TreeMap<String, ArrayList<String>> contactInfo= phoneBook.getContactInfo();
        String contactName = "Molly";
        String number1="3025555555";
        String number2="3024444444";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(number1);
        expected.add(number2);
        phoneBook.addEntry(contactName, number1, contactInfo);
        phoneBook.addEntry(contactName, number2, contactInfo);
        //when:
        phoneBook.lookup("Molly", contactInfo);

        //then:

        Assert.assertEquals("should return the phone number attached to the key",expected, phoneBook.lookup("Molly", contactInfo));
    }


    @Test
    public void testListAllEntries(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber,phoneBook.getContactInfo());
        String contactName2= "Steven";
        String phoneNumber2= "(302)-555-2456";
        phoneBook.addEntry(contactName2,phoneNumber2, phoneBook.getContactInfo());
        String expected= "Name: Molly Phone Number: [(302)-555-9743]\n" +
                "Name: Steven Phone Number: [(302)-555-2456]";
        //when:
        phoneBook.listAllEntries(phoneBook.getContactInfo());

        //then:
        Assert.assertEquals("Should return all info in the phonebook",expected, phoneBook.listAllEntries(phoneBook.getContactInfo()));


    }

    @Test
    public void testListNames(){
        //given:
        String contactName = "Molly";
        String phoneNumber= "(302)-555-9743";
        phoneBook.addEntry(contactName, phoneNumber, phoneBook.getContactInfo());
        String contactName2= "Steven";
        String phoneNumber2= "(302)-555-2456";
        phoneBook.addEntry(contactName2,phoneNumber2, phoneBook.getContactInfo());
        String expected= "Name: Molly\n" +
                "Name: Steven";
        //when:
        phoneBook.listAllNames(phoneBook.getContactInfo());

        //then:
        Assert.assertEquals("should return the list of names",expected, phoneBook.listAllNames(phoneBook.getContactInfo()));


    }





}
