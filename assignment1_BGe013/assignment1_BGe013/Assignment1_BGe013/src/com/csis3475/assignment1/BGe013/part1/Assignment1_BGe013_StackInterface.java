package com.csis3475.assignment1.BGe013.part1;

/**
 * 
 * @author 300358013
 *
 */
public interface Assignment1_BGe013_StackInterface<T> {

	// removes top entry
	public T pop();

	// to add a new entry to the top
	public void push(T newEntry);

	// determines if the stack is empty or not.
	public boolean isEmpty();

	// retrieves the top entry
	public T peek();
}
