package com.zipcodewilmington.phonebook;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

    public class PhoneBook {

        public TreeMap<String, String> record;

        public PhoneBook() { //constructor
            this.record = new TreeMap<String, String>();
        }

        public boolean add(String name, String number) {
            return record.put(name, number) != null;
        }

        public boolean delete(String name) {
            return record.remove(name) != null;
        }

        public String retrieveByName(String name) {
            return record.get(name);
        }

        public String retrieveByPhoneNumber(String number) {
            Set<String> contacts = record.keySet();

            for (String name : contacts) {
                if (record.get(name).equals(number)) {
                    return name;
                }
            }
            return "";
        }

        public String listAllNames() {
            StringBuilder list = new StringBuilder();
            for (String nameKey : record.keySet()) {
                list.append(nameKey + "\n");
            }
            return list.toString().trim();
        }

        public String listAllNamesAndNumbers() {

            Set<String> contacts = record.keySet();
            StringBuilder listAll = new StringBuilder();

            for (String name : contacts) {
                listAll.append(name + " " + record.get(name) + "\n");
                }
                return listAll.toString().trim();

        }

        public static void main(String[] args) {

        }

    }
