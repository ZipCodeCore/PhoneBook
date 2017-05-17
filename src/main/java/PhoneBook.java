import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.StringReference;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class PhoneBook
{
    private static final Logger logger = Logger.getLogger(PhoneBook.class.getName());
    Map<String, String> myPhoneMap = new TreeMap<String, String>();


    public void addNumber(PhoneNumber newNumber)
    {
        myPhoneMap.put(newNumber.getName(), newNumber.getPhoneNumber());
    }


    public void addNumber(String name, String phoneNumber)
    {
        PhoneNumber newNumber = null;
        try
        {
            newNumber = new PhoneNumber(name, phoneNumber);
        } catch (InvalidTypeException e)
        {
            e.printStackTrace();
        }
        myPhoneMap.put(newNumber.getName(), newNumber.getPhoneNumber());

    }

    public void remove(String name)
    {
        if (myPhoneMap.containsKey(name))
        {
            myPhoneMap.remove(name);
        }

    }

    public String lookUp(String name)
    {
        String search = myPhoneMap.get(name);
        return search;
    }

    public String listAllNames()
    {
        String nameList = "";
        for (String nameKey : myPhoneMap.keySet())
        {
            nameList += nameKey + "\n";
        }
        return nameList;
    }

    public String  listAllEntries()
    {
        String entryList = "";
        for(String nameKey : myPhoneMap.keySet())
        {
            entryList += nameKey + " " + lookUp(nameKey)+"\n";
        }
       return entryList;
    }

    public String lookUpName(String phoneNumber)
    {
        for(String key: myPhoneMap.keySet())
        {
            if(myPhoneMap.get(key).equals(phoneNumber))
            {
                return key;
            }
        }
        return null;
    }



 }


