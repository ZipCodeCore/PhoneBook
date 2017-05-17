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
