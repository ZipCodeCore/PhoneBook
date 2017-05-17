import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBook
{

	TreeMap<String, PhoneBookEntry> phoneBook = new TreeMap<>();

	public void addPhoneBookEntryToPhoneBook (PhoneBookEntry entry)
	{
		phoneBook.put(entry.getContactName(), entry);
	}

	public void removePhoneBookEntryFromPhoneBook (PhoneBookEntry entry)
	{
		phoneBook.remove(entry.getContactName());
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
			phoneBookEntries.add(PhoneBookEntry.getContactName());
		});
		String listOfPhoneBookEntries = "";
		return listOfPhoneBookEntries.join(", ", phoneBookEntries);
	}

	public PhoneBookEntry getPhoneBookEntryFromPhoneBook (PhoneBookEntry entry)
	{
		return phoneBook.get(entry.getContactName());
	}

	public ArrayList<String> lookup(PhoneBookEntry entry)
	{
		ArrayList<String> phoneNumber = phoneBook.get(entry.getContactName()).getContactNumbers();
		return phoneNumber;
	}

	public String reverseLookup(String phoneNumber)
	{
		Iterator<String> iter = phoneBook.keySet().iterator();
		while(iter.hasNext())
		{
			String name = iter.next();
			if(phoneBook.get(name).getContactNumbers().contains(phoneNumber))
			{
				return name;
			}
		}
		return null;
	}
}
