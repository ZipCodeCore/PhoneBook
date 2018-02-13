package com.zipcodewilmington.phonebook;

import apple.laf.JRSUIUtils;
import com.sun.tools.corba.se.idl.StringGen;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, String> tmap;

   PhoneBook(){

      this.tmap =new TreeMap<String, String>();

   }

   public void addAContact(String name, String number) {
       this.tmap.put(name, number);
   }

   public void removeAContact(String name, String number){
       this.tmap.remove(name, number);
   }
    public void lookupContact (String name, String number){

    }


       }

