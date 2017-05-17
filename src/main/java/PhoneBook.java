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
		phoneBook.put(phoneBookEntryName.getContactName(), phoneBookEntryName);
	}

	public void removePhoneBookEntryFromPhoneBook (PhoneBookEntry phoneBookEntryName)
	{
		phoneBook.remove(phoneBookEntryName.getContactName());
	}

	public String listAllPhoneBookEntryNames ()
	{
		ArrayList<String> phoneBookEntryNames = new ArrayList<>();
		phoneBook.forEach((String, PhoneBookEntry) ->
			phoneBookEntryNames.add(String));
		String listOfPhoneBookEntryNames = "";
		return listOfPhoneBookEntryNames.join(", ", phoneBookEntryNames);
	}

	public String listAllPhoneBookEntries ()
	{
		ArrayList<String> phoneBookEntries = new ArrayList<>();
		phoneBook.forEach((String, PhoneBookEntry) ->
		{
			phoneBookEntries.add(String);
			phoneBookEntries.add(PhoneBookEntry.getContactNumber());
		});
		String listOfPhoneBookEntries = "";
		return listOfPhoneBookEntries.join(", ", phoneBookEntries);
	}

	public PhoneBookEntry getPhoneBookEntryFromPhoneBook (PhoneBookEntry phoneBookEntryName)
	{
		return phoneBook.get(phoneBookEntryName.getContactName());
	}

	public String lookup(PhoneBookEntry phoneBookEntryName)
	{
		String phoneNumber = phoneBookEntryName.getContactNumber();
		return phoneNumber;
	}



}
