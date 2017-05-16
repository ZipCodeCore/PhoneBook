package io.github.aaronclong.holdingobjects;

import java.util.HashMap;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneBook {
  private HashMap<String, PhoneNumber> phoneBook;

  public PhoneBook() {
    phoneBook = new HashMap<>();
  }

  public void add(String name, PhoneNumber phoneNumber) {
    phoneBook.put(name, phoneNumber);
  }

  public PhoneNumber lookup(String name) {
    return phoneBook.get(name);
  }
  
}
