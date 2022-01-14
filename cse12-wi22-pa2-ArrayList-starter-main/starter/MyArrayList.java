import java.rmi.server.ObjID;

/**
 * TODO: Add your file header
 * Name:Dhylan Patel 
 * ID: A16993071
 * Email: ddpatel@ucsd.edu
 * Sources used: https://docs.google.com/document/d/1Je-9HpFo4g9-Cxqb07armFIoLRBOAF0WT4sB0fWBnwA/edit - the instructions fo rthe PA where I copied some definitions for variables/methods
 * Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 * A file that has the MyArrayList class and is is used by others as new My ArrayList objects are created.
 * The MyArrayList object impliments MyList and is a generic class as well
 * This, along with the hidden tester are also the only two files that we should be editing
 */

/**
 * TODO: Add your implementation of MyArrayList here
 */

public class MyArrayList<E> implements MyList<E> {
    // The underlying data structure of the ArrayList. The index of an element in
    // this array should correspond to the index of the element in the ArrayList.
    Object[] data;
    // This variable should be equal to the number of valid elements in your data
    // array. A valid element in data is an element in your ArrayList.
    int size;

    /**
     * a default contructor that initializes the array to have a default length
     * 
     * @params none
     * @return none but creates a new array with default length of 5
     */
    public MyArrayList() {
        data = new Object[5];
        size = 0;
    }

    /**
     * a default contructor that initializes the array to have a given length
     * 
     * @params an integer of length
     * @return none but creates a new array with default length of the given integer
     *         and thows exception if not valid length
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("The length is strictly less than 0.");

        data = new Object[initialCapacity];
        size = 0;
    }

    /**
     * a default contructor that initializes the array to have a default length
     * 
     * @params array with objects of type E
     * @return none but creates a default array if @param is null and if not then it
     *         will copy that array in and adjust size variable accordingly
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            data = new Object[5];
            size = 0;
        } else {
            size = arr.length;
            data = new Object[size];
            for (int i = 0; i < size; i++) {
                data[i] = (E) arr[i];
            }
        }
    }

    /**
     * Increase the capacity of the underlying array
     */
    @SuppressWarnings("unchecked")
    public void expandCapacity(int requiredCapacity) {
        Object[] tempRay;
        if (data.length > requiredCapacity)
            throw new IllegalArgumentException("requiredCapacity is strictly less than the initial capacity");
        if (data.length == 0) {
            data = new Object[5];
        } else {
            if (data.length * 2 > requiredCapacity) {
                tempRay = new Object[data.length * 2];
            } else {
                tempRay = new Object[requiredCapacity];
            }

            for (int i = 0; i < size; i++) {
                tempRay[i] = (E) data[i];
            }
            data = tempRay;
        }

    }

    /**
     * Get the amount of elements arraylist can hold
     * 
     * @return Number of elements an arraylist can hold - length of the array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Add an element at the specified index
     * 
     * @param index   - position in the array to insert the element
     * @param element - the element to be inserted
     */
    public void insert(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("the index input is invalid because size is less than" + index);
        else if ((size + 1) > data.length)
            expandCapacity(size + 1);
        Object[] tempRay = new Object[data.length];
        int tempCounter = 0;
        for (int i = 0; i < (size + 1); i++) {
            if (i == index) {
                tempRay[tempCounter] = element;
                tempCounter++;
            } else {
                tempRay[tempCounter] = data[i];
                tempCounter++;
            }
        }
        data = tempRay;
        size++;
    }

    /**
     * Add an element to the end of the list
     * 
     * @param element - the element to be added
     */
    public void append(E element) {
        insert(size, element);

    }

    /**
     * Add an element to the beginning of the list
     * 
     * @param element - the element to be added
     */
    public void prepend(E element) {
        insert(0, element);

    }

    /**
     * Get the element at the given index
     * 
     * @param index - position in the arraylist
     * @return element present in the given index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("the index input is invalid: " + index);
        return (E) data[index];
    }

    /**
     * Replaces an element at the specified index with a new element and return the
     * original elements
     * 
     * @param index   - position of the element to be replaced
     * @param element - new element replacing the old element
     * @return original element present in the index before replacement
     */
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("the index input is invalid");
        E temp = (E) data[index];
        data[index] = element;
        return temp;
    }

    /**
     * Remove the element at the specified index and return the removed element
     * 
     * @param index - position of the element to be removed
     * @return element in that index
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("the index input is invalid");
        E temp = (E) data[index];
        Object[] tempRay = new Object[data.length];
        int tCount = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                tempRay[tCount] = data[i];
                tCount++;
            }
        }
        size--;
        data = tempRay;
        return temp;
    }

    /**
     * Get the number of elements in the list
     * 
     * @return number of elements present in the list
     */
    public int size() {

        return size;
    }

}

// Hint: the 'capacity' (length of data array) is not the same as the 'size'
// Size is the number of elements in the ArrayList, i.e., the number of valid
// elements in the array
