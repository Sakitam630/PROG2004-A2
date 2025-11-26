import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    
    // Part4A: LinkedList to track ride history - visitors who have taken the ride
    private LinkedList<Visitor> rideHistory;
    
    // Part5: Maximum number of riders per cycle
    private int maxRider;
    
    // Part5: Number of times the ride has been run
    private int numOfCycles;
    
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
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1; // Default: at least 1 rider per cycle
        this.numOfCycles = 0; // Default: no cycles run yet
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
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxCapacity; // Part5: Use maxCapacity as default maxRider
        this.numOfCycles = 0; // Default: no cycles run yet
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
    
    /**
     * Part5: Gets the maximum number of riders per cycle
     * @return The maximum riders per cycle
     */
    public int getMaxRider() {
        return maxRider;
    }
    
    /**
     * Part5: Gets the number of cycles the ride has been run
     * @return The number of cycles
     */
    public int getNumOfCycles() {
        return numOfCycles;
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
     * Part5: Sets the maximum number of riders per cycle
     * @param maxRider The maximum riders per cycle (must be at least 1)
     */
    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
        }
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
     * Part4A: Prints all visitors who have taken the ride (ride history).
     * Displays complete ride history with visitor details.
     * Uses Iterator to traverse the LinkedList collection as required.
     */
    @Override
    public void printRideHistory() {
        System.out.println("\n========== Ride History for " + rideName + " ==========");
        
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history available. No visitors have taken this ride yet.");
        } else {
            System.out.println("Total number of visitors: " + rideHistory.size());
            System.out.println("------------------------------------------------------");
            
            // Part4A: Using Iterator to traverse the LinkedList
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(count + ". " + visitor.toString());
                count++;
            }
        }
        System.out.println("======================================================\n");
    }
    
    /**
     * Part5: Runs one cycle of the ride.
     * Processes visitors from the queue based on maxRider capacity,
     * validates age requirements, and moves them to ride history.
     * Increments numOfCycles counter after successful execution.
     */
    @Override
    public void runOneCycle() {
        System.out.println("\n========== Running One Cycle for " + rideName + " ==========");
        
        // Part5: Validate ride operator is assigned
        if (operator == null) {
            System.out.println("Error: Ride cannot run. No operator assigned.");
            return;
        }
        
        // Part5: Validate ride is operational
        if (!isOperational) {
            System.out.println("Error: Ride cannot run. Ride is not operational.");
            return;
        }
        
        // Part5: Validate there are waiting visitors
        if (visitorQueue.isEmpty()) {
            System.out.println("Error: No visitors in queue. Cannot run cycle.");
            return;
        }
        
        System.out.println("Ride is operational. Operator: " + operator.getFullName());
        System.out.println("Max riders per cycle: " + maxRider);
        System.out.println("Processing visitors from queue...\n");
        
        int processedCount = 0;
        // Part5: Use maxRider to determine how many visitors can ride in this cycle
        int cycleCapacity = Math.min(maxRider, visitorQueue.size());
        
        for (int i = 0; i < cycleCapacity; i++) {
            Visitor visitor = visitorQueue.poll(); // Remove from front of queue
            
            if (visitor != null) {
                // Check age requirement
                if (!canVisitorRide(visitor)) {
                    System.out.println("  ✗ " + visitor.getFullName() + 
                                     " does not meet age requirement (min age: " + minimumAge + ")");
                    continue; // Skip this visitor but continue processing others
                }
                
                // Part5: Add to history after taking the ride
                rideHistory.add(visitor);
                processedCount++;
                System.out.println("  ✓ " + visitor.getFullName() + " took the ride successfully.");
            }
        }
        
        // Part5: Increment cycle counter
        numOfCycles++;
        
        System.out.println("\n========== Cycle Complete! ==========");
        System.out.println("  - Cycle number: " + numOfCycles);
        System.out.println("  - Visitors processed this cycle: " + processedCount);
        System.out.println("  - Remaining in queue: " + visitorQueue.size());
        System.out.println("  - Total ride history: " + rideHistory.size());
        System.out.println("=========================================\n");
    }
    
    /**
     * Part4B: Sorts the ride history using a custom Comparator.
     * Uses Collections.sort() with the provided Comparator to reorder visitors.
     * Demonstrates advanced collections manipulation and use of Comparator interface.
     * 
     * @param comparator The Comparator to use for sorting the ride history
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (comparator == null) {
            System.out.println("Error: Cannot sort with null comparator.");
            return;
        }
        
        if (rideHistory.isEmpty()) {
            System.out.println("Info: Ride history is empty. Nothing to sort.");
            return;
        }
        
        // Use Collections.sort with the provided Comparator
        Collections.sort(rideHistory, comparator);
        System.out.println("Success: Ride history has been sorted using custom comparator.");
    }
    
    /**
     * Part6: Exports ride history to a CSV file.
     * Writes each visitor's details on a separate line in comma-separated format.
     * Implements comprehensive exception handling and resource management using try-with-resources.
     * 
     * CSV Format per line: visitorId,firstName,lastName,age,contactNumber,membershipType,accountBalance,visitCount
     * 
     * @param filename The name of the file to export to (relative or absolute path)
     * @return true if export was successful, false otherwise
     */
    public boolean exportRideHistory(String filename) {
        // Validate filename
        if (filename == null || filename.trim().isEmpty()) {
            System.out.println("Error: Cannot export to file. Filename is null or empty.");
            return false;
        }
        
        // Check if there's data to export
        if (rideHistory.isEmpty()) {
            System.out.println("Warning: Ride history is empty. No data to export.");
            return false;
        }
        
        // Use try-with-resources for automatic resource management
        // BufferedWriter provides efficient writing with buffering
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            
            // Write header line for better CSV structure
            writer.write("VisitorID,FirstName,LastName,Age,ContactNumber,MembershipType,AccountBalance,VisitCount");
            writer.newLine();
            
            // Export each visitor in the ride history
            int exportedCount = 0;
            for (Visitor visitor : rideHistory) {
                // Build CSV line for this visitor
                String csvLine = String.format("%s,%s,%s,%d,%s,%s,%.2f,%d",
                    visitor.getVisitorId(),
                    visitor.getFirstName(),
                    visitor.getLastName(),
                    visitor.getAge(),
                    visitor.getContactNumber(),
                    visitor.getMembershipType(),
                    visitor.getAccountBalance(),
                    visitor.getVisitCount()
                );
                
                writer.write(csvLine);
                writer.newLine();
                exportedCount++;
            }
            
            // Flush to ensure all data is written
            writer.flush();
            
            System.out.println("========================================");
            System.out.println("Export Successful!");
            System.out.println("  - File: " + filename);
            System.out.println("  - Records exported: " + exportedCount);
            System.out.println("  - Format: CSV (Comma-Separated Values)");
            System.out.println("========================================");
            
            return true;
            
        } catch (IOException e) {
            // Handle I/O exceptions with detailed error message
            System.err.println("========================================");
            System.err.println("Error: Failed to export ride history to file.");
            System.err.println("  - File: " + filename);
            System.err.println("  - Reason: " + e.getMessage());
            System.err.println("  - Possible causes:");
            System.err.println("    • File path is invalid");
            System.err.println("    • No write permission for directory");
            System.err.println("    • Disk space full");
            System.err.println("    • File is locked by another process");
            System.err.println("========================================");
            
            return false;
            
        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.err.println("========================================");
            System.err.println("Error: Unexpected error during export.");
            System.err.println("  - File: " + filename);
            System.err.println("  - Error: " + e.getClass().getSimpleName());
            System.err.println("  - Message: " + e.getMessage());
            System.err.println("========================================");
            
            return false;
        }
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
                           "Operator: %s\nStatus: %s\nMax Riders/Cycle: %d\n" +
                           "Queue Size: %d, History Size: %d, Cycles Run: %d",
                           rideName, rideType, maxCapacity, minimumAge, ticketPrice,
                           operatorInfo, status, maxRider,
                           visitorQueue.size(), rideHistory.size(), numOfCycles);
    }
}
