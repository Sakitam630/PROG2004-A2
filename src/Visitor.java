/**
 * Visitor class represents theme park guests/members.
 * Extends Person class to inherit common attributes while adding
 * visitor-specific properties for membership and visit tracking.
 * Demonstrates inheritance and specialization for customer management.
 */
public class Visitor extends Person {
    // Visitor-specific instance variables
    private String visitorId;
    private String membershipType;
    private double accountBalance;
    private int visitCount;
    
    /**
     * Default constructor
     * Initializes a Visitor object with default values
     */
    public Visitor() {
        super(); // Call parent constructor
        this.visitorId = "";
        this.membershipType = "Standard";
        this.accountBalance = 0.0;
        this.visitCount = 0;
    }
    
    /**
     * Parameterized constructor
     * Initializes a Visitor with all Person and Visitor attributes
     * @param firstName The visitor's first name
     * @param lastName The visitor's last name
     * @param age The visitor's age
     * @param contactNumber The visitor's contact number
     * @param visitorId The unique visitor ID
     * @param membershipType The type of membership (e.g., Standard, Gold, Platinum)
     * @param accountBalance The visitor's account balance for park purchases
     * @param visitCount The number of times the visitor has visited the park
     */
    public Visitor(String firstName, String lastName, int age, String contactNumber,
                  String visitorId, String membershipType, double accountBalance, int visitCount) {
        super(firstName, lastName, age, contactNumber); // Initialize Person attributes
        this.visitorId = visitorId;
        this.membershipType = membershipType;
        this.accountBalance = accountBalance;
        this.visitCount = visitCount;
    }
    
    // Getters for Visitor-specific attributes
    
    /**
     * Gets the visitor's unique ID
     * @return The visitor ID
     */
    public String getVisitorId() {
        return visitorId;
    }
    
    /**
     * Gets the visitor's membership type
     * @return The membership type
     */
    public String getMembershipType() {
        return membershipType;
    }
    
    /**
     * Gets the visitor's account balance
     * @return The account balance
     */
    public double getAccountBalance() {
        return accountBalance;
    }
    
    /**
     * Gets the number of visits the visitor has made
     * @return The visit count
     */
    public int getVisitCount() {
        return visitCount;
    }
    
    // Setters with validation for Visitor-specific attributes
    
    /**
     * Sets the visitor's unique ID
     * @param visitorId The visitor ID to set
     */
    public void setVisitorId(String visitorId) {
        if (visitorId != null && !visitorId.trim().isEmpty()) {
            this.visitorId = visitorId.trim();
        }
    }
    
    /**
     * Sets the visitor's membership type with validation
     * @param membershipType The membership type to set
     */
    public void setMembershipType(String membershipType) {
        if (membershipType != null && !membershipType.trim().isEmpty()) {
            this.membershipType = membershipType.trim();
        }
    }
    
    /**
     * Sets the visitor's account balance with validation
     * @param accountBalance The account balance to set (must be non-negative)
     */
    public void setAccountBalance(double accountBalance) {
        if (accountBalance >= 0) {
            this.accountBalance = accountBalance;
        }
    }
    
    /**
     * Sets the visitor's visit count with validation
     * @param visitCount The visit count to set (must be non-negative)
     */
    public void setVisitCount(int visitCount) {
        if (visitCount >= 0) {
            this.visitCount = visitCount;
        }
    }
    
    /**
     * Adds funds to the visitor's account
     * @param amount The amount to add (must be positive)
     * @return true if successful, false otherwise
     */
    public boolean addFunds(double amount) {
        if (amount > 0) {
            this.accountBalance += amount;
            return true;
        }
        return false;
    }
    
    /**
     * Deducts funds from the visitor's account
     * @param amount The amount to deduct
     * @return true if successful (sufficient funds), false otherwise
     */
    public boolean deductFunds(double amount) {
        if (amount > 0 && this.accountBalance >= amount) {
            this.accountBalance -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * Increments the visit count when the visitor enters the park
     */
    public void recordVisit() {
        this.visitCount++;
    }
    
    /**
     * Checks if the visitor is eligible for VIP benefits
     * @return true if Gold or Platinum member, false otherwise
     */
    public boolean isVIPMember() {
        return membershipType.equalsIgnoreCase("Gold") || 
               membershipType.equalsIgnoreCase("Platinum");
    }
    
    /**
     * Checks if the visitor meets the age requirement for a ride
     * @param minimumAge The minimum age required
     * @return true if visitor meets age requirement, false otherwise
     */
    public boolean meetsAgeRequirement(int minimumAge) {
        return this.getAge() >= minimumAge;
    }
    
    /**
     * Returns a string representation of the Visitor
     * @return String containing visitor's details
     */
    @Override
    public String toString() {
        return String.format("Visitor ID: %s, %s, Membership: %s, Balance: $%.2f, Visits: %d",
                           visitorId, super.toString(), membershipType, 
                           accountBalance, visitCount);
    }
}
