/**
 * TODO: Add your file header
* Name:Dhylan Patel 
 * ID: A16993071
 * Email: ddpatel@ucsd.edu
 * Sources used: PA2 README - 
 * the instructions for the PA where I copied some definitions for variables/methods
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 * This file inclues hidden 
 */

//IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class MyArrayListHiddenTester {

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test
     */
    private MyArrayList testBasicS, testBasicI, listDetestBasicIfaultCap, testBasicLS, testBasicLI, testBasicI2,
            testBasicM, testBasicMI;

    @Before
    public void setUp() throws Exception {
        String[] test = new String[] { "one", "two", "three", "four", "five", "six" };
        Integer[] test1 = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        testBasicS = new MyArrayList<String>();
        testBasicI = new MyArrayList<Integer>();
        testBasicLS = new MyArrayList<String>(0);
        testBasicLI = new MyArrayList<Integer>(20);
        testBasicI2 = new MyArrayList<Integer>(8);
        testBasicM = new MyArrayList<String>(test);
        testBasicMI = new MyArrayList<Integer>(test1);
    }

    @Test
    public void testFailures() {
        // check with a bucnch of different positions and check to see if the array is
        // similiar
        MyArrayList<Integer> test = new MyArrayList<>();
        for (int i = 0; i < 5; i++) {
            test.insert(i, i);
        }
        Integer[] ray = new Integer[] { 0, 1, 2, 3, 4 };
        for (int j = 0; j < 5; j++) {
            assertEquals(ray[j], test.get(j));
        }
        // TODO: check for whole data array when array is capacity for prepend
        test.insert(1, 5);
        test.prepend(12);
        Integer[] ray2 = new Integer[] { 12, 0, 5, 1, 2, 3, 4 };
        for (int j = 0; j < ray2.length; j++) {
            assertEquals(ray2[j], test.get(j));
        }
        assertEquals(ray2.length, test.size());
        assertEquals(10, test.getCapacity());
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg() {
        boolean found = false;
        try {
            MyArrayList<String> exceptional = new MyArrayList<>(-4);
        } catch (Exception e) {
            // TODO: handle exception
            //assertEquals("length strictly less than 0", e.getMessage());

            found = true;
        }
        assertEquals(true, found);
        MyArrayList<String> exceptional2 = new MyArrayList<>(null);
        assertEquals(5, exceptional2.data.length);

    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg() {
        MyArrayList<String> exceptional = new MyArrayList<>(null);
        assertEquals(5, exceptional.data.length);
        MyArrayList<String> exceptional2 = new MyArrayList<>();
        assertEquals(5, exceptional2.data.length);

    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity() {
        testBasicM.append("added");
        assertEquals(12, testBasicM.data.length);
        assertEquals(7, testBasicM.size());
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull() {
        testBasicMI.prepend(null);
        assertEquals(14, testBasicMI.data.length);
        assertEquals(8, testBasicMI.size());
        assertNull(testBasicMI.get(0));
    }

    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound() {
        boolean found = false;
        try {
            testBasicI.insert(8, 2);
        } catch (Exception e) {
            // TODO: handle exception
            //assertEquals("the index input is invalid", e.getMessage());
            found = true;
        }
        assertTrue(found);
        // assertEquals(2, testBasicI.get(0));
    }

    /**
     * Test prepend, append, remove, and prepend at onece
     */
    @Test
    public void testAddingAndRemoving() {
        testBasicLS.append("this");
        assertEquals("this", testBasicLS.get(0));
        assertEquals(1, testBasicLS.size());
        assertEquals(5, testBasicLS.data.length);
        testBasicLS.remove(0);
        testBasicLS.prepend("this again");
        assertEquals("this again", testBasicLS.get(0));
        assertEquals(1, testBasicLS.size());
        assertEquals(5, testBasicLS.data.length);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple() {
        int expecCapacity = testBasicMI.data.length;
        int currCapacity = expecCapacity;
        for (int i = (testBasicMI.size()); i < 100; i++) {
            currCapacity = testBasicMI.data.length;
            if (testBasicMI.size() == testBasicMI.data.length) {
                testBasicMI.insert(i, i);
                expecCapacity = testBasicMI.data.length;
                assert (expecCapacity == currCapacity * 2);
            } else
                testBasicMI.insert(i, i);
        }
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound() {
        boolean errorFound = false;
        try {
            testBasicI2.get(0);
        } catch (Exception e) {
            // TODO: handle exception
            errorFound = true;
            //assertEquals("index input invalid", e.getMessage());
        }
        assert (0 < 0 || 0 >= testBasicI2.size());
        assertEquals(0, testBasicI2.size());
        assert (errorFound);

    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound() {
        boolean errorFound = false;
        try {
            testBasicI2.set(-423, 5);
        } catch (Exception e) {
            // TODO: handle exception\
            errorFound = true;
            //assertEquals("the index input is invalid", e.getMessage());
        }
        assert (errorFound);
    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound() {
        boolean errorFound = false;
        try {
            testBasicI2.remove(-423);
        } catch (Exception e) {
            // TODO: handle exception\
            errorFound = true;
            //assertEquals("the index input is invalid", e.getMessage());
        }
        assert (errorFound);
    }

    /**
     * Aims to test the expandCapacity method when
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller() {
        boolean errorFound = false;
        try {
            testBasicMI.expandCapacity(-1);
        } catch (Exception e) {
            // TODO: handle exception\
            errorFound = true;
            //assertEquals("requiredCapacity not valid", e.getMessage());
        }
        assert (errorFound);
    }

    /**
     * Aims to test the expandCapacity method when
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode() {
        testBasicMI.expandCapacity(18);
        assertEquals(18, testBasicMI.data.length);
    }

}
