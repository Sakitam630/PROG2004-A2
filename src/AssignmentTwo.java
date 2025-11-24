public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
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
    
    /**
     * Part 4A: Demonstrates ride history management using LinkedList.
     * Shows adding visitors to history, checking if visitor exists, 
     * counting visitors, and printing history using Iterator.
     */
    public void partFourA() {
        System.out.println("\n============================================");
        System.out.println("    PART 4A: RIDE HISTORY DEMO");
        System.out.println("============================================\n");
        
        // Create an Employee to operate the ride
        Employee operator = new Employee(
            "Sarah", "Connor", 32, "555-2001",
            "EMP002", "Senior Ride Operator", 28.75, true
        );
        
        // Create a new Ride object
        Ride wildWestFalls = new Ride(
            "Wild West Falls Adventure Ride",
            "Water Ride",
            25,  // max capacity
            8,   // minimum age
            12.00,  // ticket price
            operator,
            true  // operational
        );
        
        wildWestFalls.setOperator(operator);
        
        System.out.println("Ride Created: " + wildWestFalls.getRideName());
        System.out.println("Type: Water Ride");
        System.out.println("\n--- Adding Visitors to Ride History ---\n");
        
        // Create and add minimum 5 Visitors to the ride history
        Visitor visitor1 = new Visitor(
            "Michael", "Chen", 28, "555-1001",
            "V101", "Gold", 90.00, 12
        );
        
        Visitor visitor2 = new Visitor(
            "Emma", "Wilson", 21, "555-1002",
            "V102", "Platinum", 150.00, 20
        );
        
        Visitor visitor3 = new Visitor(
            "Oliver", "Taylor", 19, "555-1003",
            "V103", "Standard", 60.00, 2
        );
        
        Visitor visitor4 = new Visitor(
            "Sophia", "Anderson", 26, "555-1004",
            "V104", "Gold", 85.00, 15
        );
        
        Visitor visitor5 = new Visitor(
            "James", "Thomas", 35, "555-1005",
            "V105", "Platinum", 200.00, 30
        );
        
        // Add visitors to ride history
        wildWestFalls.addVisitorToHistory(visitor1);
        wildWestFalls.addVisitorToHistory(visitor2);
        wildWestFalls.addVisitorToHistory(visitor3);
        wildWestFalls.addVisitorToHistory(visitor4);
        wildWestFalls.addVisitorToHistory(visitor5);
        
        System.out.println("\n--- Checking if a Visitor is in History ---\n");
        
        // Check if specific visitors are in the collection
        boolean isVisitor3InHistory = wildWestFalls.checkVisitorFromHistory(visitor3);
        System.out.println("Is " + visitor3.getFullName() + " in ride history? " + 
                         (isVisitor3InHistory ? "Yes" : "No"));
        
        // Check for a visitor not in history
        Visitor newVisitor = new Visitor(
            "Lucas", "Brown", 24, "555-1006",
            "V106", "Standard", 40.00, 1
        );
        boolean isNewVisitorInHistory = wildWestFalls.checkVisitorFromHistory(newVisitor);
        System.out.println("Is " + newVisitor.getFullName() + " in ride history? " + 
                         (isNewVisitorInHistory ? "Yes" : "No"));
        
        System.out.println("\n--- Number of Visitors in History ---\n");
        
        // Print the number of visitors in the collection
        int totalVisitors = wildWestFalls.numberOfVisitors();
        System.out.println("Total number of visitors who have taken " + 
                         wildWestFalls.getRideName() + ": " + totalVisitors);
        
        System.out.println("\n--- Printing All Visitors in History (using Iterator) ---\n");
        
        // Print all visitors in the collection (uses Iterator internally)
        wildWestFalls.printRideHistory();
        
        System.out.println("============================================");
        System.out.println("    PART 4A DEMO COMPLETED");
        System.out.println("============================================\n");
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
