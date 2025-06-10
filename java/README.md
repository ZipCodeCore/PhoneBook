# Phone Book
* **Objective** - To implement a `PhoneBook` class which maps a `name` to many `phoneNumber`
* **Purpose** - To establish familiarity with Java's `Map` interface.

## Modeling Abstraction in Software

Software developers use data structures to build abstractions that model real-world objects in their programs. For example, a phonebook can be modeled as a collection of key-value pairs, where the keys are names and the values are phone numbers. In Java, there are several common data structures that can be used to implement a phonebook, including arrays, ArrayLists, and HashMaps.

Arrays are a simple data structure that can be used to store a fixed number of elements of the same type. However, arrays have several limitations, including a fixed size and the need to manually manage the elements in the array.

ArrayLists are a more flexible data structure that can be used to store a variable number of elements of the same type. ArrayLists can grow or shrink dynamically as elements are added or removed, and they provide several methods for adding, removing, and accessing elements.

HashMaps are a key-value data structure that can be used to store a collection of key-value pairs. Each key in a HashMap must be unique, and it is used to retrieve the corresponding value. HashMaps provide several methods for adding, removing, and accessing elements, and they can be used to implement a phonebook by storing names as keys and phone numbers as values.

By using an object of type `Map` to implement the phonebook, you can easily add, remove, and retrieve entries in an efficient and flexible way.

## Map Interface in Java

In Java, the `Map` interface is used to represent a collection of key-value pairs. Each key in a Map must be unique, and it is used to retrieve the corresponding value. The Map interface provides several methods for adding, removing, and retrieving elements from the collection.

Here are some of the key features of the Map interface:

- Keys and values: A Map consists of a set of key-value pairs. The keys are used to retrieve the corresponding values.
- Unique keys: Each key in a Map must be unique. If you try to add a key that already exists in the Map, the existing value will be overwritten.
- No duplicate keys: Although values can be duplicated, keys cannot. Each key in a Map must be unique.
- Null keys and values: A Map can contain null keys and values.
- Iteration: You can iterate over the keys or values in a Map using the `keySet()`, `values()`, or `entrySet()` methods.

Here is an example of how to use the Map interface in Java:

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Create a new HashMap
        Map<String, Integer> map = new HashMap<>();

        // Add some key-value pairs to the map
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Retrieve a value from the map using a key
        int age = map.get("Bob");
        System.out.println("Bob's age is " + age);

        // Iterate over the keys in the map
        for (String name : map.keySet()) {
            System.out.println(name + " is " + map.get(name) + " years old");
        }
    }
}
```

In this example, a `HashMap` is used to store a collection of key-value pairs. 
The `put()` method is used to add elements to the Map, and the `get()` method is used to retrieve a value from the Map using a key. 
The `keySet()` method is used to iterate over the keys in the Map.

## Getting Started
* Fork and clone this repository to complete your lab. Submit each part with a Pull Request for a separate branch.

## Instructions:

### Building a basic `PhoneBook` class
* Create a `PhoneBook` class that holds names and phone numbers.
* You can use an [associative data type](https://en.wikipedia.org/wiki/Associative_array) (one which stores items as keys paired with values).

* Your PhoneBook class should have the following method
	* `void add(String name, String phoneNumber)`
		* adds an entry to the composite associate data type
	* `void addAll(String name, String... phoneNumbers)`
		* adds many phone numbers to a single name entry
	* `void remove(String name)`
		* removes an entry to the composite associate data type
	* `Boolean hasEntry(String name)`
		* removes an entry to the composite associate data type		
	* `List<String> lookup(String name)`
		* returns a phone number for the respective input `name`
	* `String reverseLookup(String phoneNumber)`
		* returns a name for the respective input `phoneNumber`
	* `String getAllContactNames()`
		* returns a list of all names in this `PhoneBook`
