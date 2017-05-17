import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBookTest {

	PhoneBook phoneBook;

	@Before
	public void startup()
	{
		phoneBook = new PhoneBook();
	}

	@Test
	public void testLookup()
	{
		//: Given
		PhoneBookEntry thomas = new PhoneBookEntry("thomas", "(302) - 333 - 3333");
		String expected = thomas.getContactNumber();

		//: When
		String actual = phoneBook.lookup(thomas);

		//: Then
		assertEquals("These two entries should be equal.", expected, actual);
	}

}
