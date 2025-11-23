/**
 * RideInterface defines the contract for ride management operations.
 * This interface demonstrates abstraction by defining what operations
 * a Ride must support without specifying how they are implemented.
 * Supports queue management, ride history tracking, and ride cycle operations.
 */
public interface RideInterface {
    
    /**
     * Adds a visitor to the waiting queue for the ride.
     * @param visitor The Visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);
    
    /**
     * Removes a visitor from the waiting queue.
     * @param visitor The Visitor to remove from the queue
     * @return true if removal was successful, false otherwise
     */
    boolean removeVisitorFromQueue(Visitor visitor);
    
    /**
     * Prints all visitors currently waiting in the queue.
     * Displays visitors in the order they were added (FIFO).
     */
    void printQueue();
    
    /**
     * Adds a visitor to the ride history after they have taken the ride.
     * @param visitor The Visitor to add to the history
     */
    void addVisitorToHistory(Visitor visitor);
    
    /**
     * Checks if a visitor exists in the ride history.
     * @param visitor The Visitor to check
     * @return true if the visitor is in the history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);
    
    /**
     * Returns the total number of visitors in the ride history.
     * @return The count of visitors who have taken the ride
     */
    int numberOfVisitors();
    
    /**
     * Prints all visitors who have taken the ride (ride history).
     * Displays complete ride history with visitor details.
     */
    void printRideHistory();
    
    /**
     * Runs one cycle of the ride.
     * Processes visitors from the queue, validates requirements,
     * and moves them to ride history.
     */
    void runOneCycle();
}
