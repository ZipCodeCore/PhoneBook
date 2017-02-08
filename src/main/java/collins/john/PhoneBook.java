package collins.john;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by johncollins on 2/7/17.
 */
public class PhoneBook
{
    Map<String, Entries> phoneBook;
    String k;

    public PhoneBook()
    {
        phoneBook = new TreeMap<String, Entries>()
        {
        };
    }

    /*
     //working first version
    public void addEntry(String name, String number) {
        Entries contactNumbers = new Entries(number);
        phoneBook.put(name, contactNumbers);
    }
    */


    public void addEntry(String name, String number)
    {
        boolean isNewName = true;
        boolean isNewNumber = false;
        for (Map.Entry<String, Entries> entry : phoneBook.entrySet())
        {
            if (entry.getKey().toString().equals(name))
            {
                isNewName = false;

                for (int i = 0; i < entry.getValue().getNumbers().size(); i++)
                {
                    if (!entry.getValue().getNumbers().get(i).toString().equals(number))
                    {
                        isNewNumber = true;
                    }
                }
            }
            if (isNewNumber)
            {
                entry.getValue().getNumbers().add(number);
            }
        }
        if (isNewName)
        {
            Entries contactNumbers = new Entries(number);
            phoneBook.put(name, contactNumbers);
        }
    }

        public void removeEntry(String name)
        {
            phoneBook.remove(name);
        }

    public void removeEntryPhoneNumber(String name, String number)
    {
        int targetIndex = -1;
        boolean isNewName = true;
        boolean isTargetNumber = false;
        for (Map.Entry<String, Entries> entry : phoneBook.entrySet())
        {
            if (entry.getKey().toString().equals(name))
            {
                isNewName = false;

                for (int i = 0; i < entry.getValue().getNumbers().size(); i++)
                {
                    if (entry.getValue().getNumbers().get(i).toString().equals(number))
                    {
                        isTargetNumber = true;
                        targetIndex = i;
                    }
                }
            }
            if (isTargetNumber)
            {
                entry.getValue().getNumbers().remove(targetIndex);
            }
        }
        if (isNewName)
        {
            System.out.println("Can't find name");
        }
    }


    public String lookup(String name)
    {
        String numbers = phoneBook.get(name).phoneNumbers.toString();
        return numbers;
    }

    public String printEntriesKeys()
    {
        return phoneBook.keySet().toString();

    }

    public String printEntries()
    {
        Set keys = phoneBook.keySet();
        String x = "";
        for (Object key : keys
                )
        {
            x += key + "    " + phoneBook.get(key).getNumbers().toString() + "\n";// cite: http://www.java2novice.com/java-collections-and-util/treemap/iterate/
        }
        if (x.equals(""))
        {
            x = "Phonebook is empty";
        }
        return x;
    }

    public String reverseLookup(String searchNumber)
    {
        Set keys = phoneBook.keySet();
        String targetKey = "Does not exist";
        for (Object key : keys
                )
        {
            for (int i = 0; i < phoneBook.get(key).phoneNumbers.size(); i++)
            {
                if (searchNumber.equals(phoneBook.get(key).phoneNumbers.get(i).toString()))
                {
                    targetKey = key.toString();
                }
            }
        }
        return targetKey;
    }


}
