/*
Author: Miguel Aquino
Date: 4/15/2019
Purpose: A Person class that implements Comparable.
*/

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int compareTo(Person p) {
        int ret = lastName.compareTo(p.lastName);
        if (ret == 0) {
            ret = firstName.compareTo(p.firstName);
            if (ret == 0) {
                ret = age - p.age;
            }
        }
        return ret;
    }

    // mutator and accessor methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override   // notifying the compiler we're overriding a method; not required
    public String toString() {
        return "Name: " + firstName + " " + lastName
                + " age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        Person other = (Person) obj;
        return age == other.age && firstName.equals(other.firstName)
                && lastName.equals(other.lastName);
    }

    /*
    Purpose: Returns an exact and independent copy of the current Person object.
    Parameters: None
    Return: Copy of current Person object.
    */

    public Person copy() {
        Person personCopy = new Person(this.firstName, this.lastName, this.age);
        return personCopy;
    }
}
