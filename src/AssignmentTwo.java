public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
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
    
    /**
     * Part 5: Demonstrates running one ride cycle.
     * Shows adding visitors to queue, running a cycle that moves visitors
     * from queue to ride history, and displays the state before and after.
     */
    public void partFive() {
        System.out.println("\n============================================");
        System.out.println("    PART 5: RUN ONE RIDE CYCLE DEMO");
        System.out.println("============================================\n");
        
        // Create an Employee to operate the ride
        Employee operator = new Employee(
            "Jennifer", "Thompson", 29, "555-4001",
            "EMP004", "Certified Ride Operator", 26.50, true
        );
        
        // Create a new Ride object with specific maxRider capacity
        Ride scoobyDooSpooky = new Ride(
            "Scooby-Doo Spooky Coaster",
            "Indoor Roller Coaster",
            20,  // max capacity
            7,   // minimum age
            14.00,  // ticket price
            operator,
            true  // operational
        );
        
        // Assign operator and set maxRider for this demonstration
        scoobyDooSpooky.setOperator(operator);
        scoobyDooSpooky.setMaxRider(4); // Only 4 riders per cycle for demonstration
        
        System.out.println("Ride Created: " + scoobyDooSpooky.getRideName());
        System.out.println("Type: Indoor Roller Coaster");
        System.out.println("Max Riders per Cycle: " + scoobyDooSpooky.getMaxRider());
        System.out.println("\n--- Adding 10+ Visitors to Queue ---\n");
        
        // Create and add minimum 10 Visitors to the Queue
        Visitor visitor1 = new Visitor(
            "Noah", "White", 15, "555-3001",
            "V301", "Standard", 50.00, 4
        );
        
        Visitor visitor2 = new Visitor(
            "Olivia", "Harris", 23, "555-3002",
            "V302", "Gold", 88.00, 10
        );
        
        Visitor visitor3 = new Visitor(
            "Liam", "Martin", 18, "555-3003",
            "V303", "Platinum", 145.00, 18
        );
        
        Visitor visitor4 = new Visitor(
            "Emma", "Garcia", 27, "555-3004",
            "V304", "Gold", 92.00, 14
        );
        
        Visitor visitor5 = new Visitor(
            "Ava", "Rodriguez", 20, "555-3005",
            "V305", "Standard", 48.00, 3
        );
        
        Visitor visitor6 = new Visitor(
            "Sophia", "Lopez", 31, "555-3006",
            "V306", "Platinum", 175.00, 22
        );
        
        Visitor visitor7 = new Visitor(
            "Mason", "Lee", 16, "555-3007",
            "V307", "Standard", 55.00, 5
        );
        
        Visitor visitor8 = new Visitor(
            "Isabella", "Walker", 25, "555-3008",
            "V308", "Gold", 95.00, 12
        );
        
        Visitor visitor9 = new Visitor(
            "Ethan", "Hall", 19, "555-3009",
            "V309", "Standard", 52.00, 6
        );
        
        Visitor visitor10 = new Visitor(
            "Mia", "Allen", 29, "555-3010",
            "V310", "Platinum", 160.00, 20
        );
        
        Visitor visitor11 = new Visitor(
            "Lucas", "Young", 22, "555-3011",
            "V311", "Gold", 90.00, 9
        );
        
        Visitor visitor12 = new Visitor(
            "Harper", "King", 24, "555-3012",
            "V312", "Standard", 54.00, 7
        );
        
        // Add visitors to queue
        scoobyDooSpooky.addVisitorToQueue(visitor1);
        scoobyDooSpooky.addVisitorToQueue(visitor2);
        scoobyDooSpooky.addVisitorToQueue(visitor3);
        scoobyDooSpooky.addVisitorToQueue(visitor4);
        scoobyDooSpooky.addVisitorToQueue(visitor5);
        scoobyDooSpooky.addVisitorToQueue(visitor6);
        scoobyDooSpooky.addVisitorToQueue(visitor7);
        scoobyDooSpooky.addVisitorToQueue(visitor8);
        scoobyDooSpooky.addVisitorToQueue(visitor9);
        scoobyDooSpooky.addVisitorToQueue(visitor10);
        scoobyDooSpooky.addVisitorToQueue(visitor11);
        scoobyDooSpooky.addVisitorToQueue(visitor12);
        
        System.out.println("\n--- Printing Queue BEFORE Running Cycle ---");
        
        // Print all visitors in the queue before cycle
        scoobyDooSpooky.printQueue();
        
        System.out.println("\n--- Running One Cycle ---");
        
        // Run one cycle (will process maxRider visitors from queue)
        scoobyDooSpooky.runOneCycle();
        
        System.out.println("\n--- Printing Queue AFTER Running Cycle ---");
        
        // Print all visitors in the queue after cycle
        scoobyDooSpooky.printQueue();
        
        System.out.println("\n--- Printing Ride History (Visitors Who Took the Ride) ---");
        
        // Print all visitors in the collection (ride history)
        scoobyDooSpooky.printRideHistory();
        
        System.out.println("============================================");
        System.out.println("Summary:");
        System.out.println("- Started with 12 visitors in queue");
        System.out.println("- Ran 1 cycle with max " + scoobyDooSpooky.getMaxRider() + " riders");
        System.out.println("- " + scoobyDooSpooky.getMaxRider() + " visitors took the ride");
        System.out.println("- " + (12 - scoobyDooSpooky.getMaxRider()) + " visitors remain in queue");
        System.out.println("- Total cycles run: " + scoobyDooSpooky.getNumOfCycles());
        System.out.println("============================================");
        System.out.println("    PART 5 DEMO COMPLETED");
        System.out.println("============================================\n");
    }
    
    /**
     * Part 6: Demonstrates exporting ride history to a CSV file.
     * Shows creating a ride, adding visitors to history, and exporting to file
     * with proper I/O exception handling.
     */
    public void partSix() {
        System.out.println("\n============================================");
        System.out.println("    PART 6: FILE EXPORT DEMO");
        System.out.println("============================================\n");
        
        // Create an Employee to operate the ride
        Employee operator = new Employee(
            "David", "Chen", 33, "555-5001",
            "EMP005", "Senior Ride Operator", 30.00, true
        );
        
        // Create a new Ride object
        Ride supermanEscape = new Ride(
            "Superman Escape",
            "Accelerator Coaster",
            18,  // max capacity
            14,  // minimum age
            20.00,  // ticket price
            operator,
            true  // operational
        );
        
        supermanEscape.setOperator(operator);
        
        System.out.println("Ride Created: " + supermanEscape.getRideName());
        System.out.println("Type: Accelerator Coaster");
        System.out.println("\n--- Adding Visitors to Ride History ---\n");
        
        // Create and add minimum 5 Visitors to the ride history
        Visitor visitor1 = new Visitor(
            "Daniel", "Wilson", 28, "555-4001",
            "V401", "Platinum", 195.00, 28
        );
        
        Visitor visitor2 = new Visitor(
            "Emily", "Moore", 32, "555-4002",
            "V402", "Gold", 105.00, 19
        );
        
        Visitor visitor3 = new Visitor(
            "Ryan", "Taylor", 25, "555-4003",
            "V403", "Standard", 58.00, 8
        );
        
        Visitor visitor4 = new Visitor(
            "Sarah", "Anderson", 29, "555-4004",
            "V404", "Platinum", 210.00, 35
        );
        
        Visitor visitor5 = new Visitor(
            "Michael", "Thomas", 23, "555-4005",
            "V405", "Gold", 98.00, 16
        );
        
        Visitor visitor6 = new Visitor(
            "Jessica", "Jackson", 27, "555-4006",
            "V406", "Standard", 62.00, 11
        );
        
        Visitor visitor7 = new Visitor(
            "Christopher", "White", 31, "555-4007",
            "V407", "Platinum", 225.00, 42
        );
        
        // Add visitors to ride history
        supermanEscape.addVisitorToHistory(visitor1);
        supermanEscape.addVisitorToHistory(visitor2);
        supermanEscape.addVisitorToHistory(visitor3);
        supermanEscape.addVisitorToHistory(visitor4);
        supermanEscape.addVisitorToHistory(visitor5);
        supermanEscape.addVisitorToHistory(visitor6);
        supermanEscape.addVisitorToHistory(visitor7);
        
        System.out.println("\n--- Current Ride History ---");
        
        // Display the current ride history
        supermanEscape.printRideHistory();
        
        System.out.println("\n--- Exporting Ride History to File ---\n");
        
        // Export the visitors to a CSV file
        String filename = "ride_history_export.csv";
        boolean exportSuccess = supermanEscape.exportRideHistory(filename);
        
        if (exportSuccess) {
            System.out.println("\n✓ File export completed successfully!");
            System.out.println("  You can open '" + filename + "' with any text editor or spreadsheet program.");
            System.out.println("  Each line contains visitor details in CSV format:");
            System.out.println("  Format: VisitorID,FirstName,LastName,Age,Contact,Membership,Balance,Visits");
        } else {
            System.out.println("\n✗ File export failed. Please check the error messages above.");
        }
        
        System.out.println("\n============================================");
        System.out.println("Data Persistence Benefits:");
        System.out.println("- Backup: Visitor data safely stored in file");
        System.out.println("- Portability: CSV format readable by multiple programs");
        System.out.println("- Analysis: Data can be imported to Excel/spreadsheet");
        System.out.println("- Recovery: Can restore data if system fails");
        System.out.println("- Audit: Historical record of ride usage");
        System.out.println("============================================");
        System.out.println("    PART 6 DEMO COMPLETED");
        System.out.println("============================================\n");
    }
    
    public void partSeven() {
    }
}
