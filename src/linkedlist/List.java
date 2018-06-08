package linkedlist;


public interface List<T>
{
    /**
     * Return the size of the list.
     * 
     * @return 
     */
    int size();

    /**
     * Get the element at the given index.
     * 
     * If no such element exists, throw an exception.
     * 
     * @param index
     * @return
     */
    T get(int index);
    
    /**
     * Sets the given item at the given index, overwriting whatever was previously there.
     * THrows an exception if index is out of bounds.
     * 
     * @param index
     * @param item
     */
    void set(int index, T item);

    /**
     * Add the given item at the end of the list.
     * 
     * @param item
     */
    void add(T item);

    /**
     * Insert the given item at the given index, shifting everything to the right to make room, if necesasry.
     * 
     * @param index
     * @param item
     */
    void insert(int index, T item);

    /**
     * Inserts the given item at the first position (i.e. at index 0).
     * 
     * @param item
     */
    void insertFirst(T item);
    
    /**
     * Removes the item at the given index and returns it.
     * 
     * @param index
     * @return
     */
    T remove(int index);
    
    /**
     * Removes the item at the head of the list (i.e. at index 0) and returns it.
     * 
     * @return
     */
    T removeFirst();

    /**
     * Returns a new List start at the given start index and continuing up to, <b>but not including</b>, the
     * given end index.
     * 
     * The simplest way to do this is to use the {@link #get(int)} and {@link #add(T t))} methods
     * in a loop.
     * 
     * 
     * @param start
     * @param end
     * @return
     */
    List<T> subList(int start, int end);
    
    /**
     * Returns a new List starting at the given index and continuing to the end of the list.
     * 
     * The simplest way to do this is to use the {@link #get(int)} and {@link #add(T t))} methods
     * in a loop.
     * 
     * You may want to implement this method by calling {@link #subList(int, int)}.
     * 
     * @param index
     * @return
     */
    List<T> subList(int index);
    
    
    /**
     * Add all of the elements of the given other list to the end of the list.
     * 
     * Again, calling {@link #get(int)} and {@link #add(Object)} in a loop
     * is a pretty easy way to implement this method.
     * 
     * @param other
     */
    void add(List<T> other);
    
    /**
     * Does the list contain the given element?
     * 
     * @param item
     * @return
     */
    boolean contains(T item);
}