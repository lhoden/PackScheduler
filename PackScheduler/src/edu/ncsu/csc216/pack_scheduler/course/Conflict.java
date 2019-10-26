package edu.ncsu.csc216.pack_scheduler.course;

/**
 * This is an interface that handles conflicts 
 * for the project. Provides an error formatting 
 * specific to handling areas where two events (or courses) 
 * have conflicting times. In this case, a student cannot be
 * two places at once. Therefore, an error is thrown.
 * @author Lauren Haleigh Tucker (lhtucker)
 */
public interface Conflict {

	/**
	 * Establishes a custom conflict exception
	 * @param conflict is a conflicting activity
	 * @throws ConflictException if there are any
	 * conflicts encountered
	 */
	void checkConflict(Activity conflict) throws ConflictException;
	
}