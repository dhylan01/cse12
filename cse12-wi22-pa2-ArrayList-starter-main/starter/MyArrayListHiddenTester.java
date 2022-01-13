/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
       
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
       
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        
    }

}
