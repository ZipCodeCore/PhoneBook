package com.zipcodewilmington.phonebook;

import java.util.Scanner;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    public static void main (String[] args) {
        displayMenu();
    }
// function to lookup contact name.
    public static void callContact(String name) {
        System.out.println("Calling " + name);
    }

    public static void displayMenu() {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter name (1, 2, or 3");
        System.out.println("1. Find Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Find Number");

        // Reading string of characters, from the scanner.
        int choice = in.nextInt();
        in.nextLine();

        switch(choice) {
            case 1:
                System.out.println("\nWho to lookup?? (Firstname Lastname)");
                String name = in.nextLine();

                callContact(name);
                break;

            case 2:
                System.out.println("\nWho to delete? (Firstname Lastname)");

                System.out.println(("\nNumber of person you are looking for? (999888777"));
                break;

            default:
                System.out.println("\nWhat is the name of the person whose phone number you are searching? (Firstname Lastname) ");
                break;
        }
    }
}
