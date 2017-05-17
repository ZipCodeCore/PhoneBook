import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBookTest {

	PhoneBook phoneBook;
	PhoneBookEntry thomas;

	@Before
	public void startup()
	{
		phoneBook = new PhoneBook();
		thomas = new PhoneBookEntry("thomas", "(302) - 333 - 3333");
	}

	@Test
	public void testLookup()
	{
		//: Given
		String expected = thomas.getContactNumber();

		//: When
		String actual = phoneBook.lookup(thomas);

		//: Then
		assertEquals("These two entries should be equal.", expected, actual);
	}

	@Test
	public void testAddPhoneBookEntryToPhoneBook()
	{
		//: Given
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		PhoneBookEntry expected = thomas;

		//: When
		PhoneBookEntry actual = phoneBook.getPhoneBookEntryFromPhoneBook(thomas);

		//: Then
		assertEquals("These two entries should be the same.", expected, actual);
	}

	@Test
	public void testRemovePhoneBookEntryFromPhoneBook()
	{
		//: Given
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		phoneBook.removePhoneBookEntryFromPhoneBook(thomas);
		PhoneBookEntry expected = null;

		//: When
		PhoneBookEntry actual = phoneBook.getPhoneBookEntryFromPhoneBook(thomas);

		//: Then
		assertEquals("There should be nothing there.", expected, actual);
	}

}
