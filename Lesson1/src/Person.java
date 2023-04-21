/**
 * A simple model of a person. A person has a name and age and can speak.
 * 
 * @author CSC 142
 *
 */
public class Person {
	// instance fields that describe the state
	// of the object
	// any variable must be declared before being
	// used
	// declaration:
	// access modifier (public/private) + type + name
	private int age;
	private String name;

	// scope of a variable: where the variable can be used in code
	// for an instance field:
	// it can be used anywhere within its class
	// and possibly outside its class if labeled public
	// However, if private, it is available in the class only

	// constructor: a special method called to create an object = instantiate the
	// class
	// constructor name: the same as the name of the class -> here Person
	// access modifier (always public unless you don't want a user to instantiate
	// the class)
	// + name (same name as the class)
	// + list of parameters between () and separated by commas if more than one
	// { code }
	/**
	 * Creates a person given a name and age
	 * 
	 * @param n the name of the person
	 * @param a the age of the person
	 */
	public Person(String n, int a) {
		name = n;
		age = a;
	}

	// instance method
	// signature = access modifier (public/private) + return type + name + (list of
	// parameters)
	// { code }
	/**
	 * Prints the name and age of the person
	 */
	public void speak() {
		System.out.println("My name is " + name + ". My age is " + age + ".");

	}
}
