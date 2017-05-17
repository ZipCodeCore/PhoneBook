import java.util.ArrayList;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookEntry {

    private String name;
    private ArrayList<String> phoneNumbers = new ArrayList<String>();
    private String phoneNumber;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addNumber(String phoneNumber) {
        this.phoneNumbers.add(formatPhoneNumber(phoneNumber));
    }

    public ArrayList<String> getFormattedPhoneNumbers() {
        return phoneNumbers;
    }


    public String formatPhoneNumber(String phoneNumber) {
        String formattedPhoneNumber = "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
                + phoneNumber.substring(6, 10);
        return formattedPhoneNumber;
    }

    public PhoneBookEntry(String name) {
        this.name = name;
    }

}
