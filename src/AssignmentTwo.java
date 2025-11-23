public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }
    
    /**
     * Part 3: Demonstrates Queue management with Ride and Visitor objects.
     * Creates a ride, adds visitors to queue, removes one, and prints the queue.
     */
    public void partThree() {
        System.out.println("============================================");
        System.out.println("    PART 3: QUEUE MANAGEMENT DEMO");
        System.out.println("============================================\n");
        
        // Create an Employee to operate the ride
        Employee operator = new Employee(
            "John", "Smith", 28, "555-1234",
            "EMP001", "Ride Operator", 25.50, true
        );
        
        // Create a new Ride object
        Ride rollerCoaster = new Ride(
            "DC Rivals HyperCoaster",
            "Roller Coaster",
            20,  // max capacity
            12,  // minimum age
            15.00,  // ticket price
            operator,
            true  // operational
        );
        
        // Assign operator to the ride
        rollerCoaster.setOperator(operator);
        
        System.out.println("Ride Created: " + rollerCoaster.getRideName());
        System.out.println("Operator: " + operator.getFullName());
        System.out.println("\n--- Adding Visitors to Queue ---\n");
        
        // Create and add minimum 5 Visitors to the Queue
        Visitor visitor1 = new Visitor(
            "Alice", "Johnson", 25, "555-0101",
            "V001", "Platinum", 100.00, 5
        );
        
        Visitor visitor2 = new Visitor(
            "Bob", "Williams", 18, "555-0102",
            "V002", "Gold", 75.00, 3
        );
        
        Visitor visitor3 = new Visitor(
            "Charlie", "Brown", 15, "555-0103",
            "V003", "Standard", 50.00, 1
        );
        
        Visitor visitor4 = new Visitor(
            "Diana", "Martinez", 22, "555-0104",
            "V004", "Gold", 80.00, 4
        );
        
        Visitor visitor5 = new Visitor(
            "Ethan", "Davis", 30, "555-0105",
            "V005", "Platinum", 120.00, 8
        );
        
        // Add visitors to queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        
        System.out.println("\n--- Removing a Visitor from Queue ---\n");
        
        // Remove a visitor from the queue
        rollerCoaster.removeVisitorFromQueue(visitor2);
        
        System.out.println("\n--- Printing Current Queue ---\n");
        
        // Print all Visitors in the Queue
        rollerCoaster.printQueue();
        
        System.out.println("============================================");
        System.out.println("    PART 3 DEMO COMPLETED");
        System.out.println("============================================\n");
    }
    
    public void partFourA() {
    }
    
    public void partFourB() {
    }
    
    public void partFive() {
    }
    
    public void partSix() {
    }
    
    public void partSeven() {
    }
}
