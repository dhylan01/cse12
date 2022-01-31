
/**
 * TODO: Add your file header
 * Name: Dhylan Patel, Yashwin
 * ID: A16993071 A16748638
 * Email: ddpatel@ucsd.edu ymadakamutil@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here

 
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;

/**
 * TODO: Add your class header
 * Class that contains all custom tests
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
    private MyLinkedList listLen1, listLen2;
    private MyLinkedList.MyListIterator listLen1Iter, listLen2Iter;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        listLen1 = new MyLinkedList();
        listLen1.add(5);
        listLen1Iter = listLen1.new MyListIterator();

        listLen2 = new MyLinkedList();
        listLen2.add(10);
        listLen2.add(15);
        listLen2Iter = listLen2.new MyListIterator();
    }

    /**
     * TODO: test the hasNext method with empty list
     * With an element added
     * With a value just before the tail
     */
    @Test
    public void testHasNext() {
        // create new empty list for testing
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        // checking empty list
        assertFalse(listTestIter.hasNext());
        listTestIter.add(10);
        
        assertTrue(listTestIter.hasNext());
        // moves to the tail where there will be no next node
        /*
         * for (int i = 0; i < listLen2.size(); i++) {
         * listTestIter.next();
         * }
         */
        assertFalse(listTestIter.hasNext());

    }

    /**
     * TODO: test the next method with emptyList
     * Try also with a multiple adds
     */
    @Test
    public void testNext() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        MyLinkedList.MyListIterator listTestIter2;
        MyLinkedList<Integer> listTest2;
        /*
         * int[] ray = new int[20];
         * for (int i = 0; i < 20; i++) {
         * ray[i] = i * 2;
         * listTest.add(i * 2);
         * }
         * for (int i = 0; i < 20; i++) {
         * assertEquals(ray[i], listTestIter.next());
         * }
         */
        boolean noElementFound = false;
        try {
            listTest2 = new MyLinkedList();
            listTestIter2 = listTest2.new MyListIterator();
            listTestIter2.next();
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            noElementFound = true;
        }
        assertTrue(noElementFound);
    }

    /**
     * TODO: test the hasPrevious method when [fill in another one here]
     */
    @Test
    public void testHasPrevious() {
        // create new empty list for testing
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        // checking empty list
        assertFalse(listTestIter.hasPrevious());
        listTest.add(10);
        listTestIter.next();
        assertTrue(listTestIter.hasPrevious());
        // moves to the tail where there will be no next node
        for (int i = listLen2.size() - 1; i > -1; i--) {
            listTestIter.previous();
        }
        assertFalse(listTestIter.hasNext());
    }

    /**
     * TODO: test the previous method when [...]
     */
    @Test
    public void testPrevious() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        /*
         * int[] ray = new int[20];
         * for (int i = 0; i < 20; i++) {
         * ray[i] = i * 2;
         * listTest.add(i * 2);
         * }
         * for (int i = 19; i > -1; i--) {
         * assertEquals(ray[i], listTestIter.previous());
         * }
         */
        MyLinkedList<Integer> listTest2 = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter2 = listTest.new MyListIterator();
        boolean noElementFound = false;
        try {
            listTestIter2.previous();
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            noElementFound = true;
        }
        assertTrue(noElementFound);
    }

    /**
     * TODO: test the nextIndex method when [...]
     */
    @Test
    public void testNextIndex() {

        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        assertEquals(0, listTestIter.nextIndex());
        
        for (int i = 0; i < 20; i++) {
        
            listTestIter.add(i * 2);
            assertEquals(listTestIter.idx , listTestIter.nextIndex());
            assertEquals(i , listTestIter.nextIndex());
        }
        for (int i = 0; i < 20; i++) {
            //assertEquals(i + 1, listTestIter.nextIndex());
        }

    }

    /**
     * TODO: test the previousIndex method when [...]
     */
    @Test
    public void testPreviousIndex() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        assertEquals(-1, listTestIter.previousIndex());
        int[] ray = new int[20];
        for (int i = 0; i < 20; i++) {
            ray[i] = i;
            listTest.add(i * 2);
        }
        for (int i = 19; i > -1; i--) {
            assertEquals(ray[i], listTestIter.nextIndex());
        }
    }

    /**
     * TODO: test the set method when [...]
     */
    @Test
    public void testSet() {
        // testing null
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();

        boolean found = false;
        try {
            listTestIter.set(null);
        } catch (NullPointerException e) {
            found = true;
        }
        assertTrue(found);
        // testing illegalstate
        listLen2Iter.next();
        listLen2Iter.remove();
        found = false;
        try {
            listTestIter.set(20);
        } catch (IllegalStateException e) {
            // TODO: handle exception
            found = true;
        }
        assertTrue(found);

        int[] ray = new int[20];
        for (int i = 0; i < 20; i++) {
            ray[i] = i * 3;
            listTestIter.add(i * 2);
        }
        for (int i = 0; i < 20; i++) {
            ray[i] = i * 3;
            listTestIter.set(i * 3);
            assertEquals(ray[i], listTestIter.next());
        }

    }

    /**
     * TODO: test the remove method when [...]
     */
    @Test
    public void testRemoveTestOne() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        listLen1Iter.next();
        listLen1Iter.remove();
        boolean found = false;
        try {
            listTestIter.set(20);
        } catch (IllegalStateException e) {
            // TODO: handle exception
            found = true;
        }
        assertTrue(found);

    }

    /**
     * TODO: test the remove method when [fill in another one here]
     */
    @Test
    public void testRemoveTestTwo() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();

        for (int i = 0; i < 20; i++) {

            listTest.add(i);
        }
        for (int i = 0; i < 20; i++) {
            listTestIter.remove();
            assertEquals(20 - i, listTest.size());
        }
    }

    /**
     * TODO: test the add method when [...]
     */
    @Test
    public void testAdd() {
        MyLinkedList<Integer> listTest = new MyLinkedList<>();
        MyLinkedList.MyListIterator listTestIter = listTest.new MyListIterator();
        boolean found = false;
        try {
            listTestIter.set(null);
        } catch (NullPointerException e) {
            found = true;
        }
        assertTrue(found);
        assertEquals(0, listTestIter.nextIndex());
        
        for (int i = 0; i < 20; i++) {
           
            listTestIter.add(i * 2);
            assertEquals(i* 2, (int) listTest.get(i));
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(i, listTestIter.nextIndex());
        }
    }

}