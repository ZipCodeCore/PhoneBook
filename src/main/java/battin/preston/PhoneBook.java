package battin.preston;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by prestonbattin on 2/7/17.
 */
public class PhoneBook {

   private Map<String, Entries> entries = new TreeMap<>();


   public String lookUp(String name){

      return  entries.get(name).getPhoneNumbers().toString();
   }

   public String reverseLookUp(String value){

      for (String o : entries.keySet()) {

         if (entries.get(o).getPhoneNumbers().contains(value)) {

            return o.toString();
         }
      }
      return null;

   }

   public void addEntry(String name, String number){

      Entries entry = new Entries(number);

      entries.put(name, entry);
   }

   public void removeEntry(String name){

      entries.remove(name);
   }

   public Entries getEntry(String name){

      return entries.get(name);
   }

   public Set printAllNames() {

         return entries.keySet();

      }

   public String printAllEntries(){

      String stringEntry = "";

      for (String key :entries.keySet()) {

         stringEntry += key + " " + entries.get(key).getPhoneNumbers() + "\n";
      }

      return stringEntry;

   }


}
