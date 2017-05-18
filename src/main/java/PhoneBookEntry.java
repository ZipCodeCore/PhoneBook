import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookEntry {
    private static final Logger logger = LoggerFactory.getLogger(PhoneBookEntry.class);

    private String name;
    private ArrayList<String> phoneNumbers = new ArrayList<String>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        try {
            addNumberToEntry(phoneNumber);
        }
        catch(InvalidPhoneNumberFormatException e){
            logger.debug(phoneNumber + "is not a valid phone number");
        }
    }

    public void addNumberToEntry(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if (phoneNumber.length() < 14) {
            phoneNumber = formatPhoneNumber(phoneNumber);
        }
        this.phoneNumbers.add(phoneNumber);
    }

    public StringBuilder getFormattedPhoneNumbers() {
        StringBuilder formattedPhoneNumbers = new StringBuilder();
        for(int i = 0; i < phoneNumbers.size() - 1; i++) {
            formattedPhoneNumbers.append(phoneNumbers.get(i));
            formattedPhoneNumbers.append(", ");
        }
        formattedPhoneNumbers.append(phoneNumbers.get(phoneNumbers.size() - 1));
        return formattedPhoneNumbers;
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
