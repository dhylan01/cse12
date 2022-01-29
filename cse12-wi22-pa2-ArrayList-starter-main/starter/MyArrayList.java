import java.rmi.server.ObjID;

/**
 * TODO: Add your file header
 * Name:Dhylan Patel 
 * ID: A16993071
 * Email: ddpatel@ucsd.edu
 * Sources used: PA2 README 
 * 
 * Sources used: PA2 README - 
 * the instructions for the PA 
 * 
 * 
 * 
 * A file that has the MyArrayList class.
 * The MyArrayList object impliments MyList and is a generic class as well
 * It can be created as an object with the 3 constructors
 * 
 * 
 */

/**
 * class that contains MyArrayList class
 * It implents the myList interface as well
 */

public class MyArrayList<E> implements MyList<E> {

    // Data is initialized here and is the array for the list
    // Theis array length is capacity
    // The index value of it is the index of the ArrayList
    Object[] data;

    // Size is the variable should be equal to the number of valid elements
    // A valid element in data is an element in the ArrayList.
    int size;

    /**
     * a default contructor- initializes the array to have a default length
     * 
     * @params none
     * @return none but creates a new array with default length of 5
     */
    public MyArrayList() {
        // set initial capacity to 5
        this.data = new Object[5];
        // set initial size to 0
        this.size = 0;
    }

    /**
     * a default contructor that initializes the array to have a given length
     * 
     * @params an integer of length
     * @return na -initializes a new array with length of the given integer
     *         and thows exception if not valid length
     */
    public MyArrayList(int initialCapacity) {
        // throw exception if negative initial capacity is input
        if (initialCapacity < 0)
            throw new IllegalArgumentException("length strictly less than 0");
        else {
            // set initial capacity to input
            this.data = new Object[initialCapacity];
            // set initial size to 0
            this.size = 0;
        }
    }

    /**
     * a default contructor- initializes the array to have a default length
     * 
     * @params array with objects of type E
     * @return none but creates a data array depending on param
     */

    public MyArrayList(E[] arr) {
        // initialize array to default if null array input
        if (arr == null) {
            this.data = new Object[5];
            this.size = 0;
        } else {
            // copy over the input array to the arrayList

            this.size = arr.length;
            this.data = new Object[size];
            for (int i = 0; i < size; i++) {
                this.data[i] = (E) arr[i];
            }
        }
    }

    /**
     * Increase the capacity of the underlying array
     */
    @SuppressWarnings("unchecked")
    public void expandCapacity(int requiredCapacity) {
        // create a new temporary array of same type as data
        Object[] tempRay;
        // check if required capacity is greater than current
        if (data.length > requiredCapacity)
            // throw exception if requiredCapacity is invalid
            throw new IllegalArgumentException("requiredCapacity not valid");
        // if capacity 0 make it 5
        if (data.length == 0) {
            data = new Object[5];
        } else {
            // run necesary checks and increase cpacity as needed
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
        // throw exception if index is invalid
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("the index input is invalid");
        // if needed extend capacity
        else if ((size + 1) > getCapacity())
            expandCapacity(size + 1);
        // initialize new temp array to replace data with
        Object[] tempRay = new Object[data.length];
        // seperate counter for new array
        int tempCounter = 0;
        // insert new element

        if(index == 0){
            tempRay[0] = (E) element;
            if(size > 0){
                for(int j = 0; j < size; j++){
                    tempRay[j + 1] = data[j];
                }
            }
        }
        else if (index == size){
            for(int k = 0; k < size; k++){
                tempRay[k] = data[k];
            }
            tempRay[size] = (E) element;
        }
        else {
        for (int i = 0; i < (size); i++) {
            // if at index to insert then insert
            if (i == index) {
                // add inserting element to temp array
                tempRay[tempCounter] = (E) element;
                tempCounter++;
            }
            // copy data value to temp array
            tempRay[tempCounter] = data[i];
            tempCounter++;

        }
    }
        // copy tempRay to data
        data = tempRay;
        size++;
    }

    /**
     * Add an element to the end of the list
     * 
     * @param element - the element to be added
     */
    public void append(E element) {
        // insert element into list
        insert(size, element);
    }

    /**
     * Add an element to the beginning of the list
     * 
     * @param element - the element to be added
     */
    public void prepend(E element) {
        // insert element into list
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
        // throw exception if index invalid
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index input invalid");
        // return the data at index
        return (E) data[index];
    }

    /**
     * Replaces an element at index and return riginal
     * 
     * @param index   - position of the element to be replaced
     * @param element - new element replacing the old element
     * @return original element present in the index before replacement
     */
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        // throw exception if index invalid
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("the index input is invalid");
        // store temp and then replace data at that value/ return previous
        E temp = (E) data[index];
        data[index] = element;
        return temp;
    }

    /**
     * Remove the element at the specified index, return the removed element
     * 
     * @param index - position of the element to be removed
     * @return element in that index
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        // throw exception if index invalid
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("the index input is invalid");
        // store previous data in new E object
        E temp = (E) data[index];
        // create new temporary array to replace list with
        Object[] tempRay = new Object[data.length];
        // have seperate counter for the new array
        int tCount = 0;
        for (int i = 0; i < size; i++) {
            // check if it is not at index to remove
            if (i != index) {
                // add to tCount
                tempRay[tCount] = data[i];
                tCount++;
            }
        }
        size--;
        // replace data with tempRay
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
