import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * Ride class represents theme park attractions/rides.
 * Manages ride information including operator assignment, capacity,
 * and operational status. Demonstrates composition through Employee relationship
 * and encapsulation of ride-specific business logic.
 * Part2: Implements RideInterface to provide queue management and ride history tracking.
 */
public class Ride implements RideInterface {
    // Instance variables for ride attributes
    private String rideName;
    private String rideType;
    private int maxCapacity;
    private int minimumAge;
    private double ticketPrice;
    private Employee operator; // Composition: Ride HAS-A Employee
    private boolean isOperational;
    
    // Part2: Queue to manage visitors waiting for the ride (FIFO - First In First Out)
    private Queue<Visitor> visitorQueue;
    
    // Part2: List to track ride history - visitors who have taken the ride
    private List<Visitor> rideHistory;
    
    /**
     * Default constructor
     * Initializes a Ride object with default values
     * Part2: Initializes empty queue and history collections
     */
    public Ride() {
        this.rideName = "";
        this.rideType = "";
        this.maxCapacity = 0;
        this.minimumAge = 0;
        this.ticketPrice = 0.0;
        this.operator = null;
        this.isOperational = false;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }
    
    /**
     * Parameterized constructor
     * Initializes a Ride with specified attributes
     * Part2: Initializes empty queue and history collections
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
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
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
    
    // ==================== RideInterface Implementation ====================
    
    /**
     * Adds a visitor to the waiting queue for the ride.
     * Validates visitor is not null before adding.
     * @param visitor The Visitor to add to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot add null visitor to queue.");
            return;
        }
        
        visitorQueue.offer(visitor);
        System.out.println("Success: Visitor " + visitor.getFullName() + 
                         " (ID: " + visitor.getVisitorId() + ") added to the queue for " + rideName + ".");
    }
    
    /**
     * Removes a specific visitor from the waiting queue.
     * @param visitor The Visitor to remove from the queue
     * @return true if removal was successful, false otherwise
     */
    @Override
    public boolean removeVisitorFromQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot remove null visitor from queue.");
            return false;
        }
        
        if (visitorQueue.isEmpty()) {
            System.out.println("Error: Queue is empty. No visitors to remove.");
            return false;
        }
        
        boolean removed = visitorQueue.remove(visitor);
        if (removed) {
            System.out.println("Success: Visitor " + visitor.getFullName() + 
                             " (ID: " + visitor.getVisitorId() + ") removed from the queue for " + rideName + ".");
        } else {
            System.out.println("Error: Visitor " + visitor.getFullName() + 
                             " (ID: " + visitor.getVisitorId() + ") not found in the queue.");
        }
        return removed;
    }
    
    /**
     * Prints all visitors currently waiting in the queue.
     * Displays visitors in FIFO order with their details.
     */
    @Override
    public void printQueue() {
        System.out.println("\n========== Visitor Queue for " + rideName + " ==========");
        
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty. No visitors waiting.");
        } else {
            System.out.println("Number of visitors in queue: " + visitorQueue.size());
            System.out.println("------------------------------------------------------");
            int position = 1;
            for (Visitor visitor : visitorQueue) {
                System.out.println("Position " + position + ": " + visitor.toString());
                position++;
            }
        }
        System.out.println("======================================================\n");
    }
    
    /**
     * Adds a visitor to the ride history after they have taken the ride.
     * @param visitor The Visitor to add to the history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot add null visitor to ride history.");
            return;
        }
        
        rideHistory.add(visitor);
        System.out.println("Success: Visitor " + visitor.getFullName() + 
                         " (ID: " + visitor.getVisitorId() + ") added to ride history.");
    }
    
    /**
     * Checks if a visitor exists in the ride history.
     * @param visitor The Visitor to check
     * @return true if the visitor is in the history, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            return false;
        }
        return rideHistory.contains(visitor);
    }
    
    /**
     * Returns the total number of visitors in the ride history.
     * @return The count of visitors who have taken the ride
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    
    /**
     * Prints all visitors who have taken the ride (ride history).
     * Displays complete ride history with visitor details.
     */
    @Override
    public void printRideHistory() {
        System.out.println("\n========== Ride History for " + rideName + " ==========");
        
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history available. No visitors have taken this ride yet.");
        } else {
            System.out.println("Total number of visitors: " + rideHistory.size());
            System.out.println("------------------------------------------------------");
            int count = 1;
            for (Visitor visitor : rideHistory) {
                System.out.println(count + ". " + visitor.toString());
                count++;
            }
        }
        System.out.println("======================================================\n");
    }
    
    /**
     * Runs one cycle of the ride.
     * Processes visitors from the queue based on ride capacity,
     * validates age requirements, and moves them to ride history.
     * Demonstrates polymorphism and complex business logic.
     */
    @Override
    public void runOneCycle() {
        System.out.println("\n========== Running One Cycle for " + rideName + " ==========");
        
        // Validate ride can operate
        if (!isOpen()) {
            System.out.println("Error: Ride cannot run. " + 
                             (operator == null ? "No operator assigned." : "Ride is not operational."));
            return;
        }
        
        if (visitorQueue.isEmpty()) {
            System.out.println("Error: No visitors in queue. Cannot run cycle.");
            return;
        }
        
        System.out.println("Ride is operational. Operator: " + operator.getFullName());
        System.out.println("Processing visitors from queue...");
        
        int processedCount = 0;
        int cycleCapacity = Math.min(maxCapacity, visitorQueue.size());
        
        for (int i = 0; i < cycleCapacity; i++) {
            Visitor visitor = visitorQueue.poll(); // Remove from front of queue
            
            if (visitor != null) {
                // Check age requirement
                if (!canVisitorRide(visitor)) {
                    System.out.println("  ✗ " + visitor.getFullName() + 
                                     " does not meet age requirement (min age: " + minimumAge + ")");
                    continue; // Skip this visitor but continue processing others
                }
                
                // Add to history
                rideHistory.add(visitor);
                processedCount++;
                System.out.println("  ✓ " + visitor.getFullName() + " took the ride successfully.");
            }
        }
        
        System.out.println("\nCycle complete!");
        System.out.println("  - Visitors processed: " + processedCount);
        System.out.println("  - Remaining in queue: " + visitorQueue.size());
        System.out.println("  - Total ride history: " + rideHistory.size());
        System.out.println("=========================================================\n");
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
                           "Operator: %s\nStatus: %s\nQueue Size: %d, History Size: %d",
                           rideName, rideType, maxCapacity, minimumAge, ticketPrice,
                           operatorInfo, status, visitorQueue.size(), rideHistory.size());
    }
}
