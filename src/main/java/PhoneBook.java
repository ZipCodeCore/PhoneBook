import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBook {

	TreeMap<String, PhoneBookEntry> phoneBook = new TreeMap<>();

	public void addPhoneBookEntryToPhoneBook (PhoneBookEntry phoneBookEntryName)
	{
		phoneBook.put(phoneBookEntryName.getContactNumber(), phoneBookEntryName);
	}

	public void removePhoneBookEntryFromPhoneBook (PhoneBookEntry phoneBookEntryName)
	{
		phoneBook.remove(phoneBookEntryName.getContactNumber());
	}

	public String listAllPhoneBookEntryNames ()
	{
		ArrayList<String> phoneBookEntryNames = new ArrayList<>();
		phoneBook.forEach((String, PhoneBookEntry) ->
			phoneBookEntryNames.add(PhoneBookEntry.getContactName()));
		String listOfPhoneBookEntryNames = "";
		return listOfPhoneBookEntryNames.join(", ", phoneBookEntryNames);
	}

	public String listAllPhoneBookEntries ()
	{
		ArrayList<String> phoneBookEntries = new ArrayList<>();
		phoneBook.forEach((String, PhoneBookEntry) ->
		{
			phoneBookEntries.add(PhoneBookEntry.getContactName());
			phoneBookEntries.add(PhoneBookEntry.getContactNumber());
		});
		String listOfPhoneBookEntries = "";
		return listOfPhoneBookEntries.join(", ", phoneBookEntries);
	}

	public PhoneBookEntry getPhoneBookEntryFromPhoneBook (PhoneBookEntry phoneBookEntryName)
	{
		return phoneBook.get(phoneBookEntryName.getContactNumber());
	}

	public String lookup(PhoneBookEntry phoneBookEntryName)
	{
		String phoneNumber = phoneBook.get(phoneBookEntryName.getContactNumber()).getContactNumber();
		return phoneNumber;
	}

	public String reverseLookup(String phoneNumber)
	{
		String phoneBookEntryName = phoneBook.get(phoneNumber).getContactName();
		return phoneBookEntryName;
	}
}
