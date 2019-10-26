package edu.ncsu.csc216.pack_scheduler.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods of the ArrayStack class
 * @author Lauren Haleigh Tucker (lhtucker)
 *
 */
public class ArrayStackTest {
	
	private ArrayStack<String> stack;
	private String s1 = "Test string 1";
	private String s2 = "Test string 2";
	private String s3 = "Test string 3";
	private String s4 = "Test string 4";
	private String s5 = "Test string 5";
	private String s6 = "Test string 6";
	private int initCapacity = 5;
	

	/**
	 * Sets up the ArrayStack object for testing
	 */
	@Before
	public void setUp() {
		stack = new ArrayStack<String>(initCapacity);
	}
	
	/**
	 * Tests the push method
	 */
	@Test
	public void testPush() {
		assertEquals(stack.size(), 0);
		stack.push(s1);
		assertEquals(stack.size(), 1);
		stack.push(s2);
		stack.push(s3);
		assertEquals(stack.size(), 3);
		assertEquals(stack.pop(), s3);
	}
	
	/**
	 * Tests the pop method
	 */
	@Test
	public void testPop() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		stack.push(s5);
		
		assertEquals(stack.size(), 5);
		stack.pop();
		assertEquals(stack.size(), 4);
		assertEquals(stack.pop(), s4);
		
	}
	
	/**
	 * Tests the isEmpty method
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());
	}

	/**
	 * Tests the size method
	 */
	@Test
	public void testSize() {
		assertEquals(stack.size(), 0);
		stack.push(s1);
		assertEquals(stack.size(), 1);
		stack.push(s2);
		assertEquals(stack.size(), 2);
	}

	/**
	 * Tests the setCapacity method
	 */
	@Test
	public void testSetCapacity() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		stack.push(s5);
		try {
			stack.push(s6);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(stack.size(), 5);
		}
		
		stack.setCapacity(6); 
		
		try {
			stack.push(s6);
		} catch (Exception e) {
			//DO SOMETHING
		}
		
	}

}