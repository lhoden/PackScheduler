package edu.ncsu.csc216.pack_scheduler.course;

/**
 * A custom exception class that extends 
 * Exception. It outputs a specific message defining
 * the area where two classes or events occur at the same
 * time. A conflict exists because a student cannot be 
 * in two places at once. This adds more practicality 
 * to WolfScheduler.
 * @author Lauren Haleigh Tucker (lhtucker)
 */
public class ConflictException extends Exception {
    /** ID used for serialization **/
	private static final long serialVersionID = 1L;
    /**
     * This method serves as the constructor for
     * ConflictException.
     * @param message is an error message.
     */
	public ConflictException(String message) {
		super(message);
	}
	/**
	 * Sub constructor for ConflictException
	 * with no parameters.
	 */
	public ConflictException() {
	    this("Schedule conflict.");
	}
}