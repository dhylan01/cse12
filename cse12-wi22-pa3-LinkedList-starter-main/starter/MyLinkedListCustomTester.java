
/**
 * TODO: Add your file header
 * Name: Dhylan Patel, Yashwin Madakamutil
 * Email: ddpatel@ucsd.edu, ymadakamutil@ucsd.edu
 * Sources used: None
 * 
 * 2-4 sentence file description here
 * Contains custom tests
 * Contains MyLinkedListCustomTester class
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Tests custom tests and has setup for all
 * Does not overlap with Public tests
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	private MyLinkedList<Integer> emptyIntegerList;
	private MyLinkedList<String> StringListBasic;
	private MyLinkedList<Integer> IntegerListBasic;
	private String[] strData = { "1st string", "2nd string", "3rd string", "4th string" };
	private Integer[] intData = { 11, 23242, 344545, 13212123 };

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyIntegerList = new MyLinkedList<Integer>();
		StringListBasic = new MyLinkedList<>();
		IntegerListBasic = new MyLinkedList<>();
		emptyIntegerList = new MyLinkedList<>();
	}

	private void populateLinkedList() {
		MyLinkedList<String>.Node node0 = this.StringListBasic.new Node(this.strData[0]);
		MyLinkedList<String>.Node node1 = this.StringListBasic.new Node(this.strData[1]);
		MyLinkedList<String>.Node node2 = this.StringListBasic.new Node(this.strData[2]);
		MyLinkedList<String>.Node node3 = this.StringListBasic.new Node(this.strData[3]);

		this.StringListBasic.head.next = node0;
		node0.prev = this.StringListBasic.head;
		node0.next = node1;
		node1.prev = node0;
		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.next = this.StringListBasic.tail;
		this.StringListBasic.tail.prev = node3;
		this.StringListBasic.size = 4;

		MyLinkedList<Integer>.Node nodeI0 = this.IntegerListBasic.new Node(this.intData[0]);
		MyLinkedList<Integer>.Node nodeI1 = this.IntegerListBasic.new Node(this.intData[1]);
		MyLinkedList<Integer>.Node nodeI2 = this.IntegerListBasic.new Node(this.intData[2]);
		MyLinkedList<Integer>.Node nodeI3 = this.IntegerListBasic.new Node(this.intData[3]);

		this.IntegerListBasic.head.next = nodeI0;
		nodeI0.prev = this.IntegerListBasic.head;
		nodeI0.next = nodeI1;
		nodeI1.prev = nodeI0;
		nodeI1.next = nodeI2;
		nodeI2.prev = nodeI1;
		nodeI2.next = nodeI3;
		nodeI3.next = this.IntegerListBasic.tail;
		this.IntegerListBasic.tail.prev = nodeI3;
		this.IntegerListBasic.size = 4;
	}

	/**
	 * TODO: test the add method when data is null and maybe if input is invalid?
	 */
	@Test
	public void testAdd() {
		boolean found = false;
		this.populateLinkedList();
		try {
			StringListBasic.add(null);
		} catch (NullPointerException e) {

			found = true;
		}
		assert (found);
	}

	/**
	 * TODO: test the add with index method when data is null
	 * 
	 */
	@Test
	public void testAddWithIndexTestOne() {
		this.populateLinkedList();
		boolean found1 = false;

		try {
			StringListBasic.add(3, null);
		} catch (NullPointerException e) {
			found1 = true;
		}
		assert (found1);

	}

	@Test
	public void testFailures() {
		MyLinkedList<Integer> test = new MyLinkedList<>();
		test.add(0, 5);

		test.add(0, 20);
		int test2 = test.get(0);
		// test add to head
		assertEquals("test", 20, test2);
		test.add(2, 30);
		test.add(2, 10);
		// test add multiple
		assertEquals(10, (int) test.get(2));

		// test add to middle
		// curent list(20,5,10,30)
		test.add(2, 15);
		assertEquals(15, (int) test.get(2));
		// curent list(20,5,15,10,30)
		assertEquals(5, test.size());
		// test remove
		int sto = (int) test.remove(2);
		assertEquals(4, test.size());
		assertEquals(15, sto);
		assertEquals(10, (int) test.remove(2));
		assertEquals(30, (int) test.get(2));
	}

	/**
	 * TODO: test the add with index method when the index < 0
	 * (when index > size is covered in public)
	 */
	@Test
	public void testAddWithIndexTestTwo() {
		this.populateLinkedList();
		boolean found1 = false;

		try {
			StringListBasic.add(-1, "this should not work");
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}
		assert (found1);
	}

	/**
	 * TODO: test the get method when index < 0 and index >= elements in list
	 */
	@Test
	public void testGet() {
		this.populateLinkedList();
		boolean found1 = false;
		boolean found2 = false;
		try {
			IntegerListBasic.get(-1);
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}
		try {
			IntegerListBasic.get(4);
		} catch (IndexOutOfBoundsException e) {
			found2 = true;
		}
		assert (found1);
		assert (found2);
	}

	/**
	 * TODO: test the getNth method when index < 0 and index >= elements in list
	 */
	@Test
	public void testGetNth() {
		this.populateLinkedList();
		boolean found1 = false;
		boolean found2 = false;
		try {
			IntegerListBasic.getNth(-1);
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}
		try {
			IntegerListBasic.getNth(4);
		} catch (IndexOutOfBoundsException e) {
			found2 = true;
		}
		assert (found1);
		assert (found2);
	}

	/**
	 * TODO: test the set method when index < 0 and index >= elements in list
	 */
	@Test
	public void testSet() {
		this.populateLinkedList();
		boolean found1 = false;
		boolean found2 = false;
		try {
			IntegerListBasic.set(-1, 224234);
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}
		try {
			IntegerListBasic.set(4, 211233121);
		} catch (IndexOutOfBoundsException e) {
			found2 = true;
		}
		assert (found1);
		assert (found2);
	}

	/**
	 * TODO: test the remove method when index < 0
	 */
	@Test
	public void testRemoveTestOne() {
		this.populateLinkedList();
		boolean found1 = false;

		try {
			IntegerListBasic.remove(-1);
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}

		assert (found1);

	}

	/**
	 * TODO: test the remove method when index >= elements in list
	 */
	@Test
	public void testRemoveTestTwo() {
		this.populateLinkedList();
		boolean found1 = false;

		try {
			IntegerListBasic.remove(5);
		} catch (IndexOutOfBoundsException e) {
			found1 = true;
		}

		assert (found1);
	}

	/**
	 * TODO: test the clear method when list is empty
	 */
	@Test
	public void testClear() {
		MyLinkedList<Integer> test = new MyLinkedList<>();
		test.clear();
		assertEquals(0, test.size());
	}

	/**
	 * TODO: test the size method when there's values
	 */
	@Test
	public void testSize() {
		this.populateLinkedList();
		assertEquals(4, StringListBasic.size());
	}
}