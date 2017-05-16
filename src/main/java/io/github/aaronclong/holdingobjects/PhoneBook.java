package io.github.aaronclong.holdingobjects;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
  public String reverseLookup(PhoneNumber number) {
    if (phoneBook.isEmpty() || !phoneBook.containsValue(number)) { return null; }
    return traverseMapForValue(number);
  }

  private String traverseMapForValue(PhoneNumber number) {
    for (Entry<String, PhoneNumber> set : phoneBook.entrySet()) {
      if (number.equals(set.getValue())) {
        return set.getKey();
      }
    }
    return null;
  }

  public boolean remove(String name) {
    PhoneNumber num = phoneBook.get(name);
    if (num == null) { return false; }
    return true;
  }

}
