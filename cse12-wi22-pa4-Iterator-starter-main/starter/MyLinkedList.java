
/**
 * TODO: Add your file header
 * Name: Dhylan Patel, Yashwin Madakamutil
 * Email: ddpatel@ucsd.edu, ymadakamutil@ucsd.edu
 * Sources used: None
 * 
 * 2-4 sentence file description here
 * A file that contains the code for the generic MyLinkedList object
 * MyLinked List contains Node class.
 */
import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.Exception.*;

/**
 * Contains constructors and methods for Node class to create a list of nodes.
 * Has the size,head, and tail variables and allows MyLinkedList to reference
 * node class.
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/**
		 * Constructor to create singleton Node
		 * 
		 * @param element Element to add, can be null
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/**
		 * Set the parameter prev as the previous node
		 * 
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}

		/**
		 * Set the parameter next as the next node
		 * 
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * Set the parameter element as the node's data
		 * 
		 * @param element - new element
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/**
		 * Accessor to get the next Node in the list
		 * 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/**
		 * Accessor to get the prev Node in the list
		 * 
		 * @return the previous node
		 */
		public Node getPrev() {
			return this.prev;
		}

		/**
		 * Accessor to get the Nodes Element
		 * 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	// Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	// Creates 2 dummy Nodes and initializes size,head, and tail
	public MyLinkedList() {
		/* Add your implementation here */
		// TODO
		this.size = 0;
		// creates first dummy node
		this.head = new Node(null);
		// creates second dummy node
		this.tail = new Node(null);
		// sets indexes for dummy nodes
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
	}

	/**
	 * Returns size of the list
	 * 
	 * @param none
	 * @return size variable of list
	 */

	@Override
	public int size() {
		// need to implement the size method
		return this.size; // TODO
	}

	/**
	 * Utilizes getNth method to get and return data at index
	 * 
	 * @param index in question
	 * @return return data element stored in node at index
	 */

	@Override
	public E get(int index) {
		// check if the index is out of bounds
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		// return the data at index
		return getNth(index).data; // TODO
	}

	/**
	 * add a new node at a specific index of the list
	 * 
	 * @param index of new node and data for index
	 * @return nothing
	 */
	@Override
	public void add(int index, E data) {
		/* Add your implementation here */
		// TODO
		// create new node with input data
		Node newNode = new Node(data);
		// handle null data
		if (data == null)
			throw new NullPointerException();
		// handle if list is emmpty or adding to end of list cases
		else if (size == 0 || index == size) {
			newNode.setNext(tail);
			newNode.setPrev(tail.prev);
			newNode.prev.setNext(newNode);
			tail.setPrev(newNode);

		}
		// use getNth to get current node
		// insert newNode before the current node
		else {
			Node curNode = getNth(index);
			curNode.prev.setNext(newNode);
			newNode.setNext(curNode);
			newNode.setPrev(curNode.prev);
			curNode.setPrev(newNode);

		}
		size++;
	}

	/**
	 * add new node to end of list
	 * 
	 * @param data to be added
	 * @return true unless error is thrown
	 */
	public boolean add(E data) {
		// use add method(above) to add new node at end of list
		add(size, data);
		return true;
	}

	/**
	 * set the node data at certain index to have new value
	 * return previous data
	 * 
	 * @param index to change and data to set index node data to
	 * @return previous data held at node at index
	 */
	public E set(int index, E data) {
		// handle null case
		if (data == null) {
			throw new NullPointerException();
		}
		// handle out of bounds cases
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		// store data at previous node
		E replaced = get(index);
		// change data of node at index
		getNth(index).data = data;
		// return past data
		return replaced; // TODO
	}

	/**
	 * removes data at index
	 * returns data at previous index
	 * 
	 * @param index of node you want to remove
	 * @return data of node at index before removal
	 */
	public E remove(int index) {
		// get node to remove and store node
		Node curNode = getNth(index);
		curNode.prev.setNext(curNode.next);
		curNode.next.setPrev(curNode.prev);
		size--;
		// return past data
		return (E) curNode.data; // TODO\
		// to do decremeent size

	}

	/**
	 * resets the list
	 * 
	 * @param none
	 * @return nothing
	 */
	public void clear() {
		/* Add your implementation here */
		// returns list to default state
		this.size = 0;
		this.head = new Node(null);
		this.tail = new Node(null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
	}

	/**
	 * checks if list is empty
	 * 
	 * @param none
	 * @return true or false depending on if list is empty
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false; // TODO
	}

	/**
	 * return node at given index
	 * 
	 * @param index of node to return
	 * @return ndoe at given index
	 */
	protected Node getNth(int index) {
		// handle out of bounds cases
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		// initialize node to return
		Node nTH = this.head.next;
		// iterates through list to find node at index
		for (int i = 0; i < index; i++) {
			nTH = nTH.next;
		}
		return nTH; // TODO
	}

	/**
	 * Contains myListIterator Object
	 * Contains myListIterator methods
	 */
	protected class MyListIterator implements ListIterator<E> {
		// variables for MyListIterator
		Node left;
		Node right;
		int idx;
		boolean forward;
		boolean canRemoveOrSet;

		/**
		 * Contructor to create new MyListIterator Object
		 * 
		 * @param none
		 * @return none
		 */
		public MyListIterator() {
			this.canRemoveOrSet = false;
			this.idx = 0;
			this.forward = true;
			this.left = head;
			this.right = head.getNext();
		}

		/**
		 * Returns whether the current node has a node after it
		 * 
		 * @param none
		 * @return true pr false depending on if there is next
		 */
		public boolean hasNext() {
			if (!right.getNext().equals(tail)) {
				return true;
			} else
				return false;
		}

		/**
		 * Return the next element in the list and go forward
		 * 
		 * @param none
		 * @return next element in list
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E toReturn = right.data;
			left = left.getNext();
			right = right.getNext();
			forward = true;
			idx++;
			return toReturn;
		}

		/**
		 * Check if there is a node in the previous direction
		 * 
		 * @param none
		 * @return true of false if there is a node in prev direction
		 */
		public boolean hasPrevious() {
			if (!left.getPrev().equals(head)) {
				return true;
			} else
				return false;

		}

		/**
		 * move in prev direction and return prev element
		 * 
		 * @param none
		 * @return previous element
		 */
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException("no element going previous");
			}
			E toReturn = left.data;
			left = left.getPrev();
			right = left;
			forward = false;
			idx--;
			return toReturn;
		}

		/**
		 * return the index of the next node
		 * 
		 * @param none
		 * @return index of next
		 */
		public int nextIndex() {
			if (!hasNext()) {
				return size;
			} else
				return idx + 1;
		}

		/**
		 * return the index of prev node of -1 if at start
		 * 
		 * @param none
		 * @return index of previous or -1
		 */
		public int previousIndex() {
			if (!hasPrevious()) {
				return -1;
			} else
				return idx - 1;
		}

		/**
		 * insert a new element before next() element
		 * 
		 * @param element
		 * @return none
		 */
		public void add(E element) {
			if (element == null) {
				throw new NullPointerException();
			}
			Node newNode = new Node(element);
			newNode.setNext(right);
			newNode.setPrev(left);
			left.setNext(newNode);
			right.setPrev(newNode);
			right = newNode;
			next();
		}

		/**
		 * replace value of most recent prev/next call
		 * 
		 * @param element
		 * @return none
		 */
		public void set(E element) {
			if (element == null) {
				throw new NullPointerException();
			}
			if (!canRemoveOrSet) {
				throw new IllegalStateException();
			}
			if (forward) {
				right.setElement(element);
			} else if (!forward) {
				left.setElement(element);
			}
		}

		/**
		 * remove the last element node returned by most recent next/prev call
		 * 
		 * @param none
		 * @return none
		 */
		public void remove() {
			if (!canRemoveOrSet) {
				throw new IllegalStateException();
			}
			if (forward) {
				left.getNext().setPrev(left.getPrev());
				left.getPrev().setNext(left.getNext());
				left = left.getPrev();
			} else if (!forward) {
				right.getNext().setPrev(right.getPrev());
				right.getPrev().setNext(right.getNext());
				right = right.getPrev();
			}
		}
	}
}
