package io.github.aaronclong.holdingobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneBook {
  private HashMap<String, ArrayList<PhoneNumber>> phoneBook;

  public PhoneBook() {
    phoneBook = new HashMap<>();
  }

  public void add(String name, PhoneNumber phoneNumber) {
    ArrayList<PhoneNumber> indexList;
    if (phoneBook.containsKey(name)) {
      indexList = phoneBook.get(name);
    } else {
      indexList = new ArrayList<>();
    }
    indexList.add(phoneNumber);
    phoneBook.put(name, indexList);
  }

  public ArrayList<PhoneNumber> lookup(String name) {
    return phoneBook.get(name);
  }

  public String reverseLookup(PhoneNumber number) {
    if (phoneBook.isEmpty()) {
      return null;
    }
    return traverseMapForValue(number);
  }

  private String traverseMapForValue(PhoneNumber number) {
    for (Entry<String, ArrayList<PhoneNumber>> set : phoneBook.entrySet()) {
      int index = set.getValue().indexOf(number);
      if (index > -1) {
        return set.getKey();
      }
    }
    return null;
  }

  public boolean remove(String name) {
    ArrayList<PhoneNumber> num = phoneBook.remove(name);
    if (num == null) {
      return false;
    }
    return true;
  }

  public boolean remove(String name, int index) {
    ArrayList<PhoneNumber> num = phoneBook.get(name);
    if (num == null) {
      return false;
    }
    num.remove(index);
    return true;
  }


}
