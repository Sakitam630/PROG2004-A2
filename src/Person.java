/**
 * Person class represents a base entity for individuals in the theme park system.
 * This abstract base class provides common attributes and behaviors for both
 * employees and visitors, demonstrating strong cohesion and single responsibility.
 * Part2: Made abstract to prevent direct instantiation - only concrete subclasses
 * (Employee, Visitor) can be instantiated.
 */
public abstract class Person {
    // Instance variables with appropriate access modifiers for encapsulation
    private String firstName;
    private String lastName;
    private int age;
    private String contactNumber;
    
    /**
     * Default constructor
     * Initializes a Person object with default values
     */
    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.contactNumber = "";
    }
    
    /**
     * Parameterized constructor
     * Initializes a Person object with specified values
     * @param firstName The person's first name
     * @param lastName The person's last name
     * @param age The person's age
     * @param contactNumber The person's contact number
     */
    public Person(String firstName, String lastName, int age, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contactNumber = contactNumber;
    }
    
    // Getters with clear documentation
    
    /**
     * Gets the person's first name
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Gets the person's last name
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Gets the person's full name
     * @return The full name (first name + last name)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Gets the person's age
     * @return The age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Gets the person's contact number
     * @return The contact number
     */
    public String getContactNumber() {
        return contactNumber;
    }
    
    // Setters with validation for data integrity
    
    /**
     * Sets the person's first name
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName.trim();
        }
    }
    
    /**
     * Sets the person's last name
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        }
    }
    
    /**
     * Sets the person's age with validation
     * @param age The age to set (must be non-negative)
     */
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
    
    /**
     * Sets the person's contact number
     * @param contactNumber The contact number to set
     */
    public void setContactNumber(String contactNumber) {
        if (contactNumber != null) {
            this.contactNumber = contactNumber.trim();
        }
    }
    
    /**
     * Returns a string representation of the Person
     * @return String containing person's details
     */
    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Contact: %s", 
                           getFullName(), age, contactNumber);
    }
}
