package collins.john;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johncollins on 2/7/17.
 */
public class Entries {
    List<String> phoneNumbers;

    public Entries(String pNumber){
        phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(pNumber);
    }
    public List getNumbers(){
        return phoneNumbers;
    }

}
