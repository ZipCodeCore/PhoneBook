package battin.preston;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prestonbattin on 2/7/17.
 */
public class Entries {

    private List<String> phoneNumbers = new ArrayList();

    Entries(String number){

        phoneNumbers.add(number);
    }

    public List getPhoneNumbers() {
        return phoneNumbers;
    }

    public void removeNumber(String number){

        phoneNumbers.remove(number);
    }
}
