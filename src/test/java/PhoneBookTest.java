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
		thomas = new PhoneBookEntry("Thomas", "(302) - 333 - 3333");
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

	@Test
	public void testListAllPhoneBookEntryNames()
	{
		//: Given
		PhoneBookEntry rob = new PhoneBookEntry("Rob", "(302) - 555 - 5555");
		PhoneBookEntry bob = new PhoneBookEntry("Bob", "(302) - 444 - 4444");
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		phoneBook.addPhoneBookEntryToPhoneBook(rob);
		phoneBook.addPhoneBookEntryToPhoneBook(bob);
		String expected = "Bob,Rob,Thomas";

		//: When
		String actual = phoneBook.listAllPhoneBookEntryNames();

		//: Then
		assertEquals("These lists should be identical", expected, actual);
	}

	@Test
	public void testListAllPhoneBookEntries()
	{
		//: Given
		PhoneBookEntry rob = new PhoneBookEntry("Rob", "(302) - 555 - 5555");
		PhoneBookEntry bob = new PhoneBookEntry("Bob", "(302) - 444 - 4444");
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		phoneBook.addPhoneBookEntryToPhoneBook(rob);
		phoneBook.addPhoneBookEntryToPhoneBook(bob);
		String expected = "Bob, (302) - 444 - 4444, Rob, (302) - 555 - 5555, Thomas, (302) - 333 - 3333";

		//: When
		String actual = phoneBook.listAllPhoneBookEntries();

		//: Then
		assertEquals("These lists should be identical.", expected, actual);
	}

}
