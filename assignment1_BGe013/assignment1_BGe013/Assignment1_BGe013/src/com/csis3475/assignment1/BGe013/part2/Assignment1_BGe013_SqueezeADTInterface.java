package com.csis3475.assignment1.BGe013.part2;

public interface Assignment1_BGe013_SqueezeADTInterface<T> {

	/** Returns the number of entries in the queue */
	public int getNumOfEntries();

	/**
	 * Adds a new entry to the back of the queue.
	 * 
	 * @param newEntry An object to be added.
	 */
	public void smash(T newEntry);

	/**
	 * Adds a new entry to the middle of the queue.
	 * 
	 * @param newEntry An object to be added.
	 */
	public void squeeze(T newEntry);

	/**
	 * Retrieves the entry at the front of the queue.
	 * 
	 * @return The object at the front of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public T getHead();

	/**
	 * Removes and returns the entry at the head of the queue.
	 * 
	 * @return The object at the front of the queue.
	 * @throws EmptyQueueException if the queue is empty before the operation.
	 */
	public T grab();

	/**
	 * Retrieves the entry at the end of the queue.
	 * 
	 * @return The object at the end of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public T getTail();

	/**
	 * Removes and returns the entry at the tail of this queue.
	 * 
	 * @return The object at the end of the queue.
	 * @throws EmptyQueueException if the queue is empty before the operation.
	 */
	public T dump();

	/**
	 * Detects whether this queue is empty.
	 * 
	 * @return True if the queue is empty, or false otherwise.
	 */
	public boolean isEmpty();

	/** Removes all entries from this queue. */
	public void clear();

	/** Prints out all entries of the queue */
	public void displayEntries();
}
