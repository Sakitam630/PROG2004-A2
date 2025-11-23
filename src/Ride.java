/**
 * Ride class represents theme park attractions/rides.
 * Manages ride information including operator assignment, capacity,
 * and operational status. Demonstrates composition through Employee relationship
 * and encapsulation of ride-specific business logic.
 */
public class Ride {
    // Instance variables for ride attributes
    private String rideName;
    private String rideType;
    private int maxCapacity;
    private int minimumAge;
    private double ticketPrice;
    private Employee operator; // Composition: Ride HAS-A Employee
    private boolean isOperational;
    
    /**
     * Default constructor
     * Initializes a Ride object with default values
     */
    public Ride() {
        this.rideName = "";
        this.rideType = "";
        this.maxCapacity = 0;
        this.minimumAge = 0;
        this.ticketPrice = 0.0;
        this.operator = null;
        this.isOperational = false;
    }
    
    /**
     * Parameterized constructor
     * Initializes a Ride with specified attributes
     * @param rideName The name of the ride
     * @param rideType The type/category of ride (e.g., Roller Coaster, Water Ride)
     * @param maxCapacity The maximum number of riders per session
     * @param minimumAge The minimum age requirement to ride
     * @param ticketPrice The price per ride ticket
     * @param operator The Employee operating the ride
     * @param isOperational Whether the ride is currently operational
     */
    public Ride(String rideName, String rideType, int maxCapacity, int minimumAge,
               double ticketPrice, Employee operator, boolean isOperational) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.maxCapacity = maxCapacity;
        this.minimumAge = minimumAge;
        this.ticketPrice = ticketPrice;
        this.operator = operator;
        this.isOperational = isOperational;
    }
    
    // Getters for all Ride attributes
    
    /**
     * Gets the ride's name
     * @return The ride name
     */
    public String getRideName() {
        return rideName;
    }
    
    /**
     * Gets the ride's type/category
     * @return The ride type
     */
    public String getRideType() {
        return rideType;
    }
    
    /**
     * Gets the ride's maximum capacity
     * @return The maximum capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }
    
    /**
     * Gets the ride's minimum age requirement
     * @return The minimum age
     */
    public int getMinimumAge() {
        return minimumAge;
    }
    
    /**
     * Gets the ride's ticket price
     * @return The ticket price
     */
    public double getTicketPrice() {
        return ticketPrice;
    }
    
    /**
     * Gets the employee operating the ride
     * @return The operator Employee object
     */
    public Employee getOperator() {
        return operator;
    }
    
    /**
     * Checks if the ride is operational
     * @return true if operational, false otherwise
     */
    public boolean isOperational() {
        return isOperational;
    }
    
    /**
     * Checks if the ride is open (has operator and is operational)
     * @return true if ride is open, false otherwise
     */
    public boolean isOpen() {
        return isOperational && operator != null && !operator.isAvailable();
    }
    
    // Setters with validation for all Ride attributes
    
    /**
     * Sets the ride's name
     * @param rideName The ride name to set
     */
    public void setRideName(String rideName) {
        if (rideName != null && !rideName.trim().isEmpty()) {
            this.rideName = rideName.trim();
        }
    }
    
    /**
     * Sets the ride's type/category
     * @param rideType The ride type to set
     */
    public void setRideType(String rideType) {
        if (rideType != null && !rideType.trim().isEmpty()) {
            this.rideType = rideType.trim();
        }
    }
    
    /**
     * Sets the ride's maximum capacity with validation
     * @param maxCapacity The maximum capacity to set (must be positive)
     */
    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        }
    }
    
    /**
     * Sets the ride's minimum age requirement with validation
     * @param minimumAge The minimum age to set (must be non-negative)
     */
    public void setMinimumAge(int minimumAge) {
        if (minimumAge >= 0) {
            this.minimumAge = minimumAge;
        }
    }
    
    /**
     * Sets the ride's ticket price with validation
     * @param ticketPrice The ticket price to set (must be non-negative)
     */
    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice >= 0) {
            this.ticketPrice = ticketPrice;
        }
    }
    
    /**
     * Assigns an employee to operate the ride
     * Updates both the ride's operator and the employee's availability status
     * @param operator The Employee to assign
     * @return true if assignment successful, false if employee unavailable or null
     */
    public boolean setOperator(Employee operator) {
        if (operator != null && operator.isAvailable()) {
            this.operator = operator;
            operator.assignToRide();
            return true;
        }
        return false;
    }
    
    /**
     * Removes the current operator from the ride
     * Updates the employee's availability status
     */
    public void removeOperator() {
        if (this.operator != null) {
            this.operator.releaseFromRide();
            this.operator = null;
        }
    }
    
    /**
     * Sets the operational status of the ride
     * @param operational The operational status to set
     */
    public void setOperational(boolean operational) {
        this.isOperational = operational;
    }
    
    /**
     * Opens the ride for operation (sets operational to true)
     * Requires an operator to be assigned
     * @return true if successfully opened, false if no operator assigned
     */
    public boolean openRide() {
        if (operator != null) {
            this.isOperational = true;
            return true;
        }
        return false;
    }
    
    /**
     * Closes the ride (sets operational to false)
     */
    public void closeRide() {
        this.isOperational = false;
    }
    
    /**
     * Checks if a visitor meets the age requirement for this ride
     * @param visitor The Visitor to check
     * @return true if visitor meets age requirement, false otherwise
     */
    public boolean canVisitorRide(Visitor visitor) {
        return visitor != null && visitor.getAge() >= this.minimumAge;
    }
    
    /**
     * Processes a ride ticket purchase for a visitor
     * @param visitor The Visitor purchasing the ticket
     * @return true if purchase successful, false otherwise
     */
    public boolean processRideTicket(Visitor visitor) {
        if (isOpen() && canVisitorRide(visitor) && visitor.deductFunds(ticketPrice)) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns a string representation of the Ride
     * @return String containing ride's details
     */
    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getFullName() : "No operator assigned";
        String status = isOpen() ? "Open" : (isOperational ? "Operational but no operator" : "Closed");
        
        return String.format("Ride: %s (%s)\nCapacity: %d, Min Age: %d, Price: $%.2f\n" +
                           "Operator: %s\nStatus: %s",
                           rideName, rideType, maxCapacity, minimumAge, ticketPrice,
                           operatorInfo, status);
    }
}
