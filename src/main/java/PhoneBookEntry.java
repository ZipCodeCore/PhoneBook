import java.util.ArrayList;

/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBookEntry {

	private String contactName;

	private ArrayList<String> contactNumbers = new ArrayList<>();

	public PhoneBookEntry()
	{
	}

	public PhoneBookEntry(String contactName)
	{
		this.contactName = contactName;
	}

	public String getContactName() {
		return contactName;
	}

	public ArrayList<String> getContactNumbers()
	{
		return contactNumbers;
	}

	public void addNumberToContact(String phoneNumber) {
		this.getContactNumbers().add(phoneNumber);
	}

}
