public class Person {

    private String firstName;
    private String lastName;
    private int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    void printPerson() {

        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
    }
}