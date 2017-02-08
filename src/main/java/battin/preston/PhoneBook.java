package battin.preston;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prestonbattin on 2/7/17.
 */
public class PhoneBook  {

   private Map<String, Entries> entries = new TreeMap<>();
   String regexStr = "^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8]" +
           "[02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9]" +
           "[02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$";

   Pattern pattern = Pattern.compile(regexStr);



   public String lookUp(String name) throws RecordNotPresent{

      if(entries.get(name) == null){

         throw new RecordNotPresent("Record Not Present");
      }

      return  entries.get(name).getPhoneNumbers().toString();
   }

   public String reverseLookUp (String number) throws InvalidPhoneNumberFormat{

      Matcher matcher = pattern.matcher(number);

      if (!matcher.matches()) {

         throw new InvalidPhoneNumberFormat("Incorrect Format");
      }

      for (String o : entries.keySet()) {

         if (entries.get(o).getPhoneNumbers().contains(number)) {

            return o.toString();
         }
      }
      return null;

   }

   public void addEntry(String name, String number) throws InvalidPhoneNumberFormat{

      Matcher matcher = pattern.matcher(number);

      if (!matcher.matches()) {

         throw new InvalidPhoneNumberFormat("Incorrect Format");
      }


      Entries entry = new Entries(number);

      entries.put(name, entry);
   }

   public void removeEntry(String name) throws RecordNotPresent{

      if(entries.get(name) == null){

         throw new RecordNotPresent("Record Not Present");
      }

      entries.remove(name);
   }

   public Entries getEntry(String name)throws RecordNotPresent{

      if(entries.get(name) == null){

         throw new RecordNotPresent("Record Not Present");
      }

      entries.remove(name);


      return entries.get(name);
   }

   public Set printAllNames() throws RecordNotPresent{

      if(entries.size() == 0){

         throw new RecordNotPresent("No Entries");
      }
         return entries.keySet();

      }

   public String printAllEntries() throws RecordNotPresent{

      if(entries.size() == 0){

         throw new RecordNotPresent("No Entries");
      }

      String stringEntry = "";

      for (String key :entries.keySet()) {

         stringEntry += key + " " + entries.get(key).getPhoneNumbers() + "\n";
      }

      return stringEntry;

   }

   public Map<String, Entries> getEntries() {
      return entries;
   }
}
