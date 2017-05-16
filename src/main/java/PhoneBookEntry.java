/**
 * Created by gregoryfletcher on 5/16/17.
 */
public class PhoneBookEntry {

	private String contactName;

	private String contactNumber;

	public PhoneBookEntry()
	{}

	public PhoneBookEntry(String contactName, String contactNumber)
	{
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String phoneNumber) {
		this.contactNumber = contactNumber;
	}

}
