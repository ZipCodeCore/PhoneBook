package zygmundfelt.dan.holdingobjects;


public class Person implements Comparable {

    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int compareTo(Object other) {
        Person otherPerson = (Person) other;
        if(lastName.equalsIgnoreCase(otherPerson.getLastName())) {
            return firstName.compareTo(otherPerson.getFirstName());
        } else {
            return lastName.compareTo(otherPerson.getLastName());
        }
    }
}
