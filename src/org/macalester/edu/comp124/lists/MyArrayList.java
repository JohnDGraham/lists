package org.macalester.edu.comp124.lists;


/**
 * An unfinished implementation of an array-based List.
 *
 * @param <E>
 * @author shilad
 */
public class MyArrayList<E> {
    /**
     * The array elements
     */
    private E elements[];

    /**
     * The number of elements currently contained in the list.
     */
    private int currentSize;

    /**
     * Creates a new list.
     */
    public MyArrayList() {
        clear();
    }

    /**
     * Clears the contents of the array.
     */
    public void clear() {
        elements = newArrayOfE(4);
        currentSize = 0;
    }

    /**
     * Returns the current size of the list.
     *
     * @return
     */
    public int size() {
        return currentSize;
    }

    /**
     * Returns the element at position index.
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return elements[index];    // replace this line with the correct code.
    }

    /**
     * Adds a new element to the end of the list:
     * <p/>
     * If the array is full, expand the array.
     * Add the element to the first unused position in the array.
     * Update the size of the array.
     *
     * @param elem
     */
    public void add(E elem) {
        if (elements.length == currentSize) {
            this.expandSize();
        }
        elements[currentSize] = elem;
        currentSize++;
    }

    /**
     * Inserts a new element at the specified index.
     * <p/>
     * If the array is full, expand the array.
     * Slide the elements of the array starting with index over.
     * Place the new element in the correct spot of the array.
     * <p/>
     * Update the size of the array.
     *
     * @param elem
     */
    public void add(int index, E elem) {
        if (elements.length == currentSize) {
            this.expandSize();

        }
        E newArray[] = elements.clone();
        for (int pos = index; pos < currentSize; pos++) {
            newArray[pos+1] = elements[pos];

        }
        newArray[index] = elem;
        elements = newArray;
        currentSize++;
    }

    /**
     * Doubles the size of the array, copies the old elements
     * into the new array, and updates elements to point to the
     * new array.
     * <p/>
     * This will be useful for both versions of add().
     * Hint: use newArrayOfE!
     */
    private void expandSize() {
        E[] newArray = newArrayOfE(elements.length * 2);
        for (int pos = 0; pos < currentSize; pos++) {
            newArray[pos] = elements[pos];

        }
        elements = newArray;
    }

    /**
     * Due to some crazy Java constraints, we can't simply create a
     * new array of elements of class E.  We need to create an array
     * of class Object and then cast the array to E.
     *
     * @param capacity
     * @return
     */
    @SuppressWarnings("unchecked")
    private E[] newArrayOfE(int capacity) {
        return (E[]) (E[]) new Object[capacity];
    }
}
