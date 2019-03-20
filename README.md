# Phone Book
* **Objective** - To implement a `PhoneBook` class which maps a `name` to many `phoneNumber`
* **Purpose** - To establish familiarity `Map`

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