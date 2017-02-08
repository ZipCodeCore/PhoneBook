package ibikunle.tolani;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class PhoneBook extends TreeMap< String,ArrayList> {

    public String lookUp(String name) {

        return  this.get(name).toString(); // you cant cast an array to a string you need to call the method in order to do the same function
    }
    public String reverseLookUp(String number){
        String value = "";
        for (Object keys: this.keySet()) { // look through the keys saying we now have access to the to values from the key
            if(number.equals(this.get(keys))){ //checking to see if the the number you are passing through equals the number at the key
                value = (String) keys; //then you are setting value equal to that number and returning the number.
            }

        }
        return value;
    }

    public void add(String name, String phoneNumber) {

        // check if name is in the phone book if  at the is there the add number if not add a key and value to the phone book.

        if  (this.get(name).size()!=0||this.get(name) != null) { // if the size of the array is not equal zero or the value at the value is not equal to null. its already in the book.
            this.get(name).add(phoneNumber); // this is adding the value to the original Arraylist in the tree map
        } else {
            ArrayList<String> listOfNumbers = new ArrayList<String>();  // if this value is not in the arraylist add it to this new array list..
            listOfNumbers.add(phoneNumber);
            this.put(name, listOfNumbers); //putting this list inside of the treeMAP
        }
    }


    public void removeEntry(String name) {
        this.remove(name);


    }
    public void removeASingleNumber(String name,String phoneNumber){
//        ArrayList<String> temporaryHolder = new ArrayList<String>();
//       // for (Object key : this.keySet()) { // into the hash map through the keys into the array and then through the array and then removing the name and number.
//        //    if(key.equals(name)){
//        //        for (Object value:this.get(name)) {
//                    if (value == phoneNumber){
//                        temporaryHolder = this.get(name);
//                        temporaryHolder.remove(value);
//                    }
//
//                }
//
//            }
//            this.put(name,temporaryHolder);
//        }

   // for(Object key : this.keySet()){
     //   for (Object number:this.get(key)) {
      //      if(number == phoneNumber){
     //           this.get(key).remove(phoneNumber);
      //      }
      //
     //   }
   // }


    }

    public void listAllNames() {

        for (Object key : this.keySet()) { // this is printing all of the keys essentially the list names in the keySet
            System.out.println(key);
        }

    }

    public void listAllEntries() {
        for (Object key : this.keySet()) {
            System.out.println(key + " " + this.get(key)); // this prints the key and values . this. get key prints all the values.
        }
    }
}