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
    Map<String, ArrayList<PhoneNumber>> myPhoneMap = new TreeMap<String, ArrayList<PhoneNumber>>();


    public void addNumber(String name, String num)
    {
        try
        {
            ArrayList<PhoneNumber> myPhoneList = new ArrayList<PhoneNumber>();
            PhoneNumber myNum = new PhoneNumber(num);
            if(myPhoneMap.get(name) != null)
            {
                myPhoneMap.get(name).add(myNum);
            }
            else
            {
                myPhoneList.add(myNum);
                myPhoneMap.put(name, myPhoneList);
            }

        } catch (InvalidTypeException e)
        {
            e.printStackTrace();
        }

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
        String numbersFound = "";
        ArrayList<PhoneNumber> search = myPhoneMap.get(name);
        for(int i = 0; i < search.size(); i++)
        {
            numbersFound = numbersFound.concat(search.get(i).getPhoneNumber());
        }
        return numbersFound;
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

    public String reverseLookUp(String phoneNumber)
    {
       String returnName = "";
       for(String nameKey: myPhoneMap.keySet())
       {
           for(PhoneNumber aNum : myPhoneMap.get(nameKey))
           {
               if(aNum.getPhoneNumber().equals(phoneNumber))
               {
                   returnName = returnName.concat(nameKey);
               }
           }
       }
     return returnName;
    }

    public String removeNumberBySearch(String phoneNumber)
    {

        for(String nameKey: myPhoneMap.keySet())
        {
            for(PhoneNumber aNum : myPhoneMap.get(nameKey))
            {
                int index = 0;
                if(aNum.getPhoneNumber().equals(phoneNumber))
                {
                    myPhoneMap.get(nameKey).remove(index);
                    return myPhoneMap.get(nameKey).get(0).getPhoneNumber();
                }
            }
        }
        return null;
    }




 }


