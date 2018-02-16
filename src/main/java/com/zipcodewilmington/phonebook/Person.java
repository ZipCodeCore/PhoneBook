package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {

    private String personName;
    private ArrayList<String> phoneNumbers;

    public Person(String personName){
        this.personName = personName;
        this.phoneNumbers = new ArrayList<>();
        phoneNumbers
    }


    public String getPersonName() {
        return personName;
    }


//public String addNumbers(){
//        return null;
//}


   //find a way to print each item in the ArrayList in order
   public String getPhoneNumbers() {
       return phoneNumbers.toString();
   }
//       StringBuilder sb = new StringBuilder();
//       for(int i = 0; i < phoneNumbers.size(); i++){
//           if(i == phoneNumbers.size()){
//               sb.append();
//           }
//       }
//        return phoneNumbers;
//    }









    }




