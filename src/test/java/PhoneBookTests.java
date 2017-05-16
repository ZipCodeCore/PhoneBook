import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrewwong on 5/16/17.
 */
public class PhoneBookTests {
    PhoneBook phoneBook;
    PhoneNumber phoneNumber;

    @Before
    public void initPhoneBook() {
        phoneBook = new PhoneBook();
        phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(856, 444, 4444);
    }

    @Test
    public void testAdd() {
        //Given
        String name = "John Doe";

        //When
        phoneBook.add(name, phoneNumber);

        //Then
        assertFalse(phoneBook.getContacts().isEmpty());
    }

    @Test
    public void testRemove() {
        //Given
        String name = "John Doe";
        phoneBook.add(name, phoneNumber);

        //When
        phoneBook.remove(name);

        //Then
        assertTrue(phoneBook.getContacts().isEmpty());
    }

    @Test
    public void testListAllNames() {
        //Given
        String name1 = "Chris Kim";
        String name2 = "Dennis Kalaygian";
        String name3 = "Aaron Long";
        PhoneNumber phoneNumber1 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1111);
        PhoneNumber phoneNumber2 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1112);
        PhoneNumber phoneNumber3 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1113);
        phoneBook.add(name1, phoneNumber1);
        phoneBook.add(name2, phoneNumber2);
        phoneBook.add(name3, phoneNumber3);
        String actual = "Aaron Long\n" + "Chris Kim\n" + "Dennis Kalaygian\n";

        //When
        String expected = phoneBook.listAllNames();

        //Then
        assertEquals("Incorrect list of names", actual, expected);
    }

    @Test
    public void testListAllEntries() {
        //Given
        String name1 = "Chris Kim";
        String name2 = "Dennis Kalaygian";
        String name3 = "Aaron Long";
        PhoneNumber phoneNumber1 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1111);
        PhoneNumber phoneNumber2 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1112);
        PhoneNumber phoneNumber3 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1113);
        phoneBook.add(name1, phoneNumber1);
        phoneBook.add(name2, phoneNumber2);
        phoneBook.add(name3, phoneNumber3);
        String actual = "Aaron Long - (111)-111-1113\n" + "Chris Kim - (111)-111-1111\n" + "Dennis Kalaygian - (111)-111-1112\n";

        //When
        String expected = phoneBook.listAllEntries();

        //Then
        assertEquals("Incorrect list of entries", actual, expected);
    }

    @Test
    public void testLookUp() {
        //Given
        String name1 = "Chris Kim";
        String name2 = "Dennis Kalaygian";
        String name3 = "Aaron Long";
        PhoneNumber phoneNumber1 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1111);
        PhoneNumber phoneNumber2 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1112);
        PhoneNumber phoneNumber3 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1113);
        phoneBook.add(name1, phoneNumber1);
        phoneBook.add(name2, phoneNumber2);
        phoneBook.add(name3, phoneNumber3);
        PhoneNumber expected = phoneNumber1;

        //When
        PhoneNumber actual = phoneBook.lookup(name1).get(0);

        //Then
        assertEquals("Incorrect phone number returned", actual, expected);
    }

    @Test
    public void testReverseLookUp(){
        //Given
        String name1 = "Chris Kim";
        String name2 = "Dennis Kalaygian";
        String name3 = "Aaron Long";
        PhoneNumber phoneNumber1 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1111);
        PhoneNumber phoneNumber2 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1112);
        PhoneNumber phoneNumber3 = PhoneNumberFactory.createPhoneNumberSafely(111, 111, 1113);
        phoneBook.add(name1, phoneNumber1);
        phoneBook.add(name2, phoneNumber2);
        phoneBook.add(name3, phoneNumber3);
        String expected = name2;

        //When
        String actual = phoneBook.reverseLookup(phoneNumber2);

        //Then
        assertEquals("Incorrect name returned", actual, expected);
    }
}


