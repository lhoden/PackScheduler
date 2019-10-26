package edu.ncsu.csc216.pack_scheduler.util;

/**
 * Creates a LinkedList with recursive functionality
 * 
 * @author Lauren Haleigh Tucker (lhtucker)
 *
 * @param <E>
 *            Generic parameter of the LinkedListRecursie
 */
public class LinkedListRecursive<E> {
	private int size;
	private ListNode front;

	/**
	 * The ListNode contains two parts: This element and the location to the
	 * next ListNode in the list
	 * 
	 * @author Lauren Haleigh Tucker (lhtucker)
	 *
	 */
	private class ListNode {
		E data;
		ListNode next;

		/**
		 * Constructs a ListNode with data and a link to the next ListNode in
		 * the list
		 * 
		 * @param data
		 *            this ListNode's data
		 * @param next
		 *            the location of the next ListNode
		 */
		ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * The recursive inner function of add(int,E). An element is added at
		 * the index location provided.
		 * 
		 * @param index
		 *            location to add the new element
		 * @param element
		 *            element to be added to the list
		 */
		void add(int index, E element) {
			int count = 0;
			if (index == count) {
				next = new ListNode(element, next);
				size++;
			} else {
				index--;
				next.add(index, element);
			}
		}

		/**
		 * Recursive inner method of the set(int,E) method. Sets the element at
		 * the index position to the element from the parameters.
		 * 
		 * @param index
		 *            location where element should be set
		 * @param element
		 *            new element to be set
		 * @return
		 */
		E set(int index, E element) {
			int count = 0;
			if (index == count) {
				E returnMe = next.data;
				next.data = element;
				return returnMe;
			} else {
				index--;
				return next.set(index, element);
			}
		}

		/**
		 * Recursive inner method of remove(int). Removes an element at a
		 * particular index.
		 * 
		 * @param index
		 *            location of element to be removed.
		 * @return the element that was removed.
		 */
		E remove(int index) {
			int count = 0;
			if (next != null) {
				if (index == count) {
					E returnMe = next.data;
					next = next.next;
					size--;
					return returnMe;
				} else {
					index--;
					next.remove(index);
				}
			}
			return null;
		}

		/**
		 * Recursive inner method of get(int). Returns the element located at
		 * the index location wihout removing it.
		 * 
		 * @param index
		 * @return
		 */
		E get(int index) {
			if (index == 1) {
				return next.data;
			} else {
				index--;
				return next.get(index);
			}

		}

		/**
		 * Removes a particular element from the list if it exists.
		 * 
		 * @param element
		 *            element we are looking for to remove.
		 * @return true if the element is able to be removed; false if
		 *         otherwise.
		 */
		boolean remove(E element) {
			if (next != null) {
				if (next.data.equals(element)) {
					next = next.next;
					size--;
					return true;
				} else {
					next.remove(element);
				}
			}
			return false;
		}

		/**
		 * Recursive inner method of contains(E). Determines whether the list
		 * contains a certain element.
		 * 
		 * @param element
		 *            element we are looking for in the list.
		 * @return true if the element already exists in the list.
		 */
		boolean contains(E element) {
			if (next == null) {
				return false;
			} else if (next.data == element) {
				return true;
			} else {
				return next.contains(element);
			}

		}

	}

	/**
	 * Constructs a new LinkedListRecursive list with a front element that is
	 * null and a size of 0.
	 */
	public LinkedListRecursive() {
		this.size = 0;
		front = null;
	}

	/**
	 * A LinkedList can tell if it is empty or not.
	 * 
	 * @return true if the list is empty.
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return size of the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Adds an element to the end of the recursive list. If the list is empty,
	 * the add is handled entirely within this method. If not, it is passed down
	 * and handled recursively by the inner ListNode class
	 * 
	 * @param element
	 *            element to add to the list
	 * @return true if the element can be added
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		add(size(), element);
		return true;
	}

	/**
	 * Adds an element to the list at a particular index. If the index is
	 * negative or is greater that the number of elements, an
	 * IndexOutOfBoundsException is thrown. If the element is null, then a
	 * NullPointerException is thrown. If the index is not 0, then the process
	 * is handled by the recursive inner method.
	 * 
	 * @param index
	 *            index to add the element to
	 * @param element
	 *            element to add to the list
	 */
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		if (front != null && front.contains(element)) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			front = new ListNode(element, front);
			size++;
		} else {
			front.add(index - 1, element);
		}
	}

	/**
	 * Finds the element at a particular index. If the searched index is less
	 * than 0 or greater than the number of elements in the list, an
	 * IndexOutOfBoundsException is thrown. If the index =/= 0, then the process
	 * is handled by the recursive inner function.
	 * 
	 * @param index
	 *            index of element we are looking for
	 * @return element at a particular index
	 */
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			E returnMe = front.data;
			return returnMe;
		} else {
			E returnMe = front.get(index);
			return returnMe;
		}

	}

	/**
	 * Removes an element from the list. if the element is not the first element
	 * in the list, the process is handled by the inner recursive method.
	 * 
	 * @param element
	 *            element we are looking to remove
	 * @return true if the element can be removed, false if not (meaning that
	 *         the element didn't exist in the list to begin with)
	 */
	public boolean remove(E element) {
		if (front != null) {
			if (front.data.equals(element)) {
				front = front.next;
				size--;
				return true;
			} else {
				return front.remove(element);
			}
		}
		return false;
	}

	/**
	 * Removes the element at a particular index. If the index is less than 0 or
	 * greater than the number of elements in the list, an
	 * IndexOutOfBoundsException is thrown. If the index =/= 0, the process is
	 * passed down to the inner recursive function.
	 * 
	 * @param index
	 *            index of element we are looking to remove
	 * @return element that is removed.
	 */
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			E returnMe = front.data;
			front = front.next;
			size--;
			return returnMe;
		} else {
			return front.remove(index - 1);
		}

	}

	/**
	 * Replaces the element at a particular index with a different index. If the
	 * index is less than 0 or greater than the number of elements in the list,
	 * an IndexOutOfBoundsException is thrown. If the element is null, a
	 * NullPointerException is thrown. If the index =/= 0, the process is passed
	 * down and handled by the inner recursive method.
	 * 
	 * @param index
	 *            index of element to be replaced
	 * @param element
	 *            element to be assigned to the index
	 * @return element that was replaced
	 */
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			E returnMe = front.data;
			front.data = element;
			return returnMe;
		}
		return front.set(index - 1, element);

	}

	/**
	 * Searches for an element in the list to determine if the list contains
	 * that element.
	 * 
	 * @param element
	 *            element to search for
	 * @return true if the list contains the element, false if otherwise;
	 */
	public boolean contains(E element) {
		if (element == null) {
			return false;
		}
		if (front == null) {
			return false;
		} else if (front.data == element) {
			return true;
		} else {
			return front.contains(element);
		}
	}

}