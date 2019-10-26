/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course.validator;

/**
 * @author Lauren Haleigh Tucker (lhtucker)
 *
 */
public class InvalidTransitionException extends Exception {
    /** ID used for serialization **/
	private static final long serialVersionUID = 1L;
	/**
	 * This method creates an InvalidTransitionException
	 * with a message that gets sent to the Exception
	 * class.
	 */
	InvalidTransitionException() {
		super("Invalid FMS Transition.");
	}
	/**
	 * Creates an exception with a message that can 
	 * be passed to the Exception. 
	 * @param message is the message written in the exception
	 */
	InvalidTransitionException(String message) {
		super(message);
	}
}
