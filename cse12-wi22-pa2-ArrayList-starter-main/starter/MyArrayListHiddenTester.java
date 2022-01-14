/**
 * TODO: Add your file header
* Name:Dhylan Patel 
 * ID: A16993071
 * Email: ddpatel@ucsd.edu
 * Sources used: https://docs.google.com/document/d/1Je-9HpFo4g9-Cxqb07armFIoLRBOAF0WT4sB0fWBnwA/edit - the instructions fo rthe PA where I copied some definitions for variables/methods
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

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg() {
        try {
            MyArrayList<String> exceptional = new MyArrayList<>(-1);
        } catch (Exception e) {
            // TODO: handle exception
            assertEquals("The length is strictly less than 0.", e.getMessage());

        }
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg() {
        MyArrayList<String> exceptional = new MyArrayList<>(null);
        assertEquals(5, exceptional.data.length);
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

        try {
            testBasicI.insert(1, 2);
        } catch (Exception e) {
            // TODO: handle exception
            assertEquals("the index input is invalid because size is less than1", e.getMessage());

        }
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

    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound() {
        try {
            testBasicI2.get(0);
        } catch (Exception e) {
            // TODO: handle exception
            assertEquals("the index input is invalid: 0", e.getMessage());
        }

    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound() {

    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound() {

    }

    /**
     * Aims to test the expandCapacity method when
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller() {

    }

    /**
     * Aims to test the expandCapacity method when
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode() {

    }

}
