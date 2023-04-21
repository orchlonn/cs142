/**
 * Client code using the Person class
 * 
 * @author CSC 142
 *
 */
public class PersonUser {
	public static void main(String[] args) {
		// Create a person with a name and age and make it speak
		// To instantiate the Person class, call the constructor with the new keyword
		Person p;
		p = new Person("Sara", 25);
		p.speak();
		// p.age = 30; is not a valid statement since age is private in Person
		// and is not available outside of the Person class
	}
}