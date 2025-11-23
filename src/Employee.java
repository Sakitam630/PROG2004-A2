/**
 * Employee class represents theme park staff members who operate rides.
 * Extends Person class to inherit common attributes while adding
 * employee-specific properties. Demonstrates inheritance and specialization.
 */
public class Employee extends Person {
    // Employee-specific instance variables
    private String employeeId;
    private String position;
    private double hourlyRate;
    private boolean isAvailable;
    
    /**
     * Default constructor
     * Initializes an Employee object with default values
     */
    public Employee() {
        super(); // Call parent constructor
        this.employeeId = "";
        this.position = "";
        this.hourlyRate = 0.0;
        this.isAvailable = true;
    }
    
    /**
     * Parameterized constructor
     * Initializes an Employee with all Person and Employee attributes
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param age The employee's age
     * @param contactNumber The employee's contact number
     * @param employeeId The unique employee ID
     * @param position The employee's position/role
     * @param hourlyRate The employee's hourly pay rate
     * @param isAvailable Whether the employee is currently available for work
     */
    public Employee(String firstName, String lastName, int age, String contactNumber,
                   String employeeId, String position, double hourlyRate, boolean isAvailable) {
        super(firstName, lastName, age, contactNumber); // Initialize Person attributes
        this.employeeId = employeeId;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.isAvailable = isAvailable;
    }
    
    // Getters for Employee-specific attributes
    
    /**
     * Gets the employee's unique ID
     * @return The employee ID
     */
    public String getEmployeeId() {
        return employeeId;
    }
    
    /**
     * Gets the employee's position/role
     * @return The position
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * Gets the employee's hourly pay rate
     * @return The hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    /**
     * Checks if the employee is available for work
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setters with validation for Employee-specific attributes
    
    /**
     * Sets the employee's unique ID
     * @param employeeId The employee ID to set
     */
    public void setEmployeeId(String employeeId) {
        if (employeeId != null && !employeeId.trim().isEmpty()) {
            this.employeeId = employeeId.trim();
        }
    }
    
    /**
     * Sets the employee's position/role
     * @param position The position to set
     */
    public void setPosition(String position) {
        if (position != null && !position.trim().isEmpty()) {
            this.position = position.trim();
        }
    }
    
    /**
     * Sets the employee's hourly pay rate with validation
     * @param hourlyRate The hourly rate to set (must be non-negative)
     */
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        }
    }
    
    /**
     * Sets the employee's availability status
     * @param available The availability status to set
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    /**
     * Calculates the employee's weekly pay based on standard 40-hour week
     * @return The weekly pay amount
     */
    public double calculateWeeklyPay() {
        return hourlyRate * 40;
    }
    
    /**
     * Assigns this employee to operate a ride (changes availability)
     */
    public void assignToRide() {
        this.isAvailable = false;
    }
    
    /**
     * Releases this employee from ride duty (changes availability)
     */
    public void releaseFromRide() {
        this.isAvailable = true;
    }
    
    /**
     * Returns a string representation of the Employee
     * @return String containing employee's details
     */
    @Override
    public String toString() {
        return String.format("Employee ID: %s, %s, Position: %s, Hourly Rate: $%.2f, Available: %s",
                           employeeId, super.toString(), position, hourlyRate, 
                           isAvailable ? "Yes" : "No");
    }
}
