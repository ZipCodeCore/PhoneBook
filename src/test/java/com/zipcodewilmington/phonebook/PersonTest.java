package com.zipcodewilmington.phonebook;


import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;


class PersonTest {
//need to generate test to add an entry to phbook
        PhBook = new PhBook(addEntry);
        name = new Person("name", "number");}

    }

    @Test
    void removeEntry1() {
            Person.add("name", "number");
            Person.remove("name");
            Assert.assertFalse(Person.entryCheck("name"));
}

    @Test
    void getEntry() {
            Person.add("name", "number");
            Assert.assertEquals("name".getPhNumber(), Person.get("name"));
}

    @Test
    void listAll() {
//need to set parameters for test
}

    @Test
    void getPhNumber1() {
//not sure of the syntax how to set keys and values in array list and return
}
}