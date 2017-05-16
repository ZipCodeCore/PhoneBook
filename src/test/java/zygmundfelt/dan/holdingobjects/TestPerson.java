package zygmundfelt.dan.holdingobjects;

import org.junit.*;

public class TestPerson {

    @Test
    public void compareToDifferentFirstAndLastNameTest() {
        Person person1 = new Person("Dan", "Zygmund-Felt");
        Person person2 = new Person("Guillermo", "Scott-Herren");

        int result = person1.compareTo(person2);

        Assert.assertTrue(result > 0);
    }

    @Test
    public void compareToDifferentLastSameFirstNameTest() {
        Person person1 = new Person("Dan", "Zygmund-Felt");
        Person person2 = new Person("Dan", "Dumile");

        int result = person1.compareTo(person2);

        Assert.assertTrue(result > 0);
    }

    @Test
    public void compareToSameLastNameTest() {
        Person person1 = new Person("Dan", "Zygmund-Felt");
        Person person2 = new Person("Gabe", "Zygmund-Felt");

        int result = person1.compareTo(person2);

        Assert.assertTrue(result < 0);
    }

    @Test
    public void compareToSameFirstAndLastNameTest() {
        Person person1 = new Person("Dan", "Zygmund-Felt");
        Person person2 = new Person("Dan", "Zygmund-Felt");
        int expected = 0;

        int actual = person1.compareTo(person2);

        Assert.assertEquals(expected, actual);
    }

}
