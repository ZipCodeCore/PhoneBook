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
		StringBuilder sb = new StringBuilder();
		phoneBook.forEach((String, PhoneBookEntry) ->
			sb.append(String + " "));
		return sb.toString();
	}

	public String listAllPhoneBookEntries ()
	{
		return "";
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
