import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
		thomas = new PhoneBookEntry("Thomas");
	}

	@Test(expected = InvalidPhoneNumberFormatException.class)
	public void testInvalidPhoneNumberFormatException() throws InvalidPhoneNumberFormatException
	{
		phoneBook.reverseLookup("2");
	}

	@Test(expected = RecordNotFoundException.class)
	public void testRecordNotFoundException() throws RecordNotFoundException, InvalidPhoneNumberFormatException
	{
		phoneBook.reverseLookup("(302)-838-7728");
	}

	@Test
	public void testLookup()
	{
		//: Given
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		ArrayList<String> expected = thomas.getContactNumbers();

		//: When
		ArrayList<String> actual = phoneBook.lookup(thomas);

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
		phoneBook.removeRecord(thomas);
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
		PhoneBookEntry rob = new PhoneBookEntry("Rob");
		PhoneBookEntry bob = new PhoneBookEntry("Bob");
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
		PhoneBookEntry rob = new PhoneBookEntry("Rob");
		PhoneBookEntry bob = new PhoneBookEntry("Bob");
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		phoneBook.addPhoneBookEntryToPhoneBook(rob);
		rob.addNumberToContact("(302) 555 - 5555");
		phoneBook.addPhoneBookEntryToPhoneBook(bob);
		bob.addNumberToContact("(302) 444 - 4444");
		String expected = "Bob, (302) 444 - 4444, Rob, (302) 555 - 5555, Thomas, (302) 333 - 3333";

		//: When
		String actual = phoneBook.listAllPhoneBookEntries();

		//: Then
		assertEquals("These lists should be identical.", expected, actual);
	}

	@Test
	public void testReverseLookup() throws InvalidPhoneNumberFormatException
	{
		//: Given
		phoneBook.addPhoneBookEntryToPhoneBook(thomas);
		thomas.addNumberToContact("(302) 333 - 3333");
		String expected = "Thomas";

		//: When
 		String actual = phoneBook.reverseLookup("(302) 333 - 3333");

		//: Then
		assertEquals("These names should be the same.", expected, actual);
	}

}
