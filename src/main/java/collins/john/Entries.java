package collins.john;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johncollins on 2/7/17.
 */
public class Entries {
    List<String> phoneNumbers;

    public Entries(String number){
        phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(number);
    }
}
