
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
}