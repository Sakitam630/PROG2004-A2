import java.util.Comparator;

/**
 * VisitorComparator implements the Comparator interface to provide custom sorting
 * for Visitor objects in the ride history.
 * 
 * Part4B: This comparator uses multiple instance variables for sophisticated comparison:
 * 1. Primary sort: By membership type (Platinum > Gold > Standard) - VIP members first
 * 2. Secondary sort: By age (descending) - Older visitors first within same membership tier
 * 
 * This demonstrates advanced understanding of Comparator interface and multi-criteria sorting
 * to prioritize premium members while considering visitor demographics.
 */
public class VisitorComparator implements Comparator<Visitor> {
    
    /**
     * Compares two Visitor objects using multiple criteria.
     * 
     * Primary comparison: Membership type (higher tier = higher priority)
     * Secondary comparison: Age (older = higher priority within same tier)
     * 
     * @param v1 The first Visitor to compare
     * @param v2 The second Visitor to compare
     * @return Negative if v1 should come before v2, positive if after, 0 if equal
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Validate inputs
        if (v1 == null && v2 == null) return 0;
        if (v1 == null) return 1;
        if (v2 == null) return -1;
        
        // Primary comparison: Membership type (Platinum = 3, Gold = 2, Standard = 1)
        int membershipComparison = getMembershipPriority(v2.getMembershipType()) - 
                                   getMembershipPriority(v1.getMembershipType());
        
        // If membership types are different, return based on membership priority
        if (membershipComparison != 0) {
            return membershipComparison;
        }
        
        // Secondary comparison: Age (descending order - older visitors first)
        // Within same membership tier, older visitors get priority
        return v2.getAge() - v1.getAge();
    }
    
    /**
     * Helper method to convert membership type to numerical priority.
     * Higher number = higher priority
     * 
     * @param membershipType The membership type string
     * @return Priority value (3=Platinum, 2=Gold, 1=Standard, 0=Unknown)
     */
    private int getMembershipPriority(String membershipType) {
        if (membershipType == null) return 0;
        
        switch (membershipType.toLowerCase()) {
            case "platinum":
                return 3;
            case "gold":
                return 2;
            case "standard":
                return 1;
            default:
                return 0;
        }
    }
    
    /**
     * Returns a string description of the sorting criteria
     * @return Description of sorting order
     */
    public String getSortingDescription() {
        return "Sorted by: 1) Membership Type (Platinum > Gold > Standard), " +
               "2) Age (Descending within same tier)";
    }
}
