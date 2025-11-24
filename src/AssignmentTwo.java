public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
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
    
    /**
     * Part 4B: Demonstrates sorting ride history using Comparator interface.
     * Shows the collection before and after sorting to demonstrate the sorting effect.
     * Uses custom VisitorComparator with multi-criteria comparison.
     */
    public void partFourB() {
        System.out.println("\n============================================");
        System.out.println("    PART 4B: SORTING RIDE HISTORY DEMO");
        System.out.println("============================================\n");
        
        // Create an Employee to operate the ride
        Employee operator = new Employee(
            "Marcus", "Rodriguez", 35, "555-3001",
            "EMP003", "Lead Ride Operator", 32.00, true
        );
        
        // Create a new Ride object
        Ride batwingSpaceshot = new Ride(
            "Batwing Spaceshot",
            "Tower Ride",
            30,  // max capacity
            10,  // minimum age
            18.00,  // ticket price
            operator,
            true  // operational
        );
        
        batwingSpaceshot.setOperator(operator);
        
        System.out.println("Ride Created: " + batwingSpaceshot.getRideName());
        System.out.println("Type: Tower Ride");
        System.out.println("\n--- Adding Visitors to Ride History ---\n");
        
        // Create 5+ visitors with different membership types and ages for sorting demonstration
        Visitor visitor1 = new Visitor(
            "Alexander", "Smith", 45, "555-2001",
            "V201", "Standard", 55.00, 3
        );
        
        Visitor visitor2 = new Visitor(
            "Isabella", "Johnson", 28, "555-2002",
            "V202", "Platinum", 180.00, 25
        );
        
        Visitor visitor3 = new Visitor(
            "Benjamin", "Lee", 35, "555-2003",
            "V203", "Gold", 95.00, 18
        );
        
        Visitor visitor4 = new Visitor(
            "Charlotte", "Davis", 52, "555-2004",
            "V204", "Platinum", 250.00, 40
        );
        
        Visitor visitor5 = new Visitor(
            "William", "Garcia", 22, "555-2005",
            "V205", "Standard", 45.00, 2
        );
        
        Visitor visitor6 = new Visitor(
            "Amelia", "Martinez", 41, "555-2006",
            "V206", "Gold", 110.00, 22
        );
        
        // Add visitors to ride history
        batwingSpaceshot.addVisitorToHistory(visitor1);
        batwingSpaceshot.addVisitorToHistory(visitor2);
        batwingSpaceshot.addVisitorToHistory(visitor3);
        batwingSpaceshot.addVisitorToHistory(visitor4);
        batwingSpaceshot.addVisitorToHistory(visitor5);
        batwingSpaceshot.addVisitorToHistory(visitor6);
        
        System.out.println("\n--- Printing History BEFORE Sorting ---\n");
        
        // Print all visitors before sorting
        batwingSpaceshot.printRideHistory();
        
        System.out.println("\n--- Sorting Ride History ---\n");
        
        // Create the comparator
        VisitorComparator comparator = new VisitorComparator();
        System.out.println("Sorting criteria: " + comparator.getSortingDescription());
        
        // Sort the collection using the comparator
        batwingSpaceshot.sortRideHistory(comparator);
        
        System.out.println("\n--- Printing History AFTER Sorting ---\n");
        
        // Print all visitors after sorting to show the effect
        batwingSpaceshot.printRideHistory();
        
        System.out.println("============================================");
        System.out.println("Analysis of Sorting Results:");
        System.out.println("- Platinum members appear first (highest priority)");
        System.out.println("- Within Platinum: Age 52 before Age 28 (descending)");
        System.out.println("- Gold members appear second");
        System.out.println("- Within Gold: Age 41 before Age 35 (descending)");
        System.out.println("- Standard members appear last");
        System.out.println("- Within Standard: Age 45 before Age 22 (descending)");
        System.out.println("============================================");
        System.out.println("    PART 4B DEMO COMPLETED");
        System.out.println("============================================\n");
    }
    
    public void partFive() {
    }
    
    public void partSix() {
    }
    
    public void partSeven() {
    }
}
