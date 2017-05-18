# Holding Objects Lab:

Fork and clone this repository to complete your lab. Submit each part with a Pull Request for a separate branch.

## Unit Tests

You are expected to write unit tests for your code. Be sure to write the tests before implementing the functionality being tested. Tests must be thorough and address all possible paths through each method.

## Submission

Your completed lab must be submitted via GitHub. Labs are not complete unless they include UML diagrams of all implemented classes, as well as unit tests for all features.

## Instructions:

### Part I:

Create a PhoneBook class that holds names and phone numbers in sorted order. You can use an associative data type (one which stores items as keys paired with values).

Your PhoneBook class should have a lookup() method which allows you to look up a person's phone number based on their name. PhoneBook should also have methods to add and remove entries, or to list all names or all entries (names and phone numbers).

### Part II:

Add a `reverseLookup()` method to PhoneBook. This method should allow you to look up names by the phone number associated with them.

### Part III: 

Some people have more than one phone number. Refactor your PhoneBook class to map names to lists of phone numbers. You should modify your add() and remove() methods to handle adding or removing individual numbers, and create a removeRecord method for removing an entire entry from your PhoneBook.

### Exceptions:

Update your Phonebook from parts 1-3. Any methods that accept a phone number should throw an InvalidPhoneNumberFormat exception if an invalid phone number format is used. At a minimum you must support phone numbers in `(###) ###-####` format; you may choose to support other formats but they must be documented. No method should add an invalid phone number to your phonebook. If either lookup method or the remove method is called with an argument that does not exist in the phonebook (either a phone number or a contact) then a RecordNotPresent exception should be thrown. There may be some methods that could throw more than one type of exception. Your tests should account for the possibility of exceptions and test for those exceptions that are expected.
