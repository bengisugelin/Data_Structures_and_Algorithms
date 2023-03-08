package com.csis3475.assignment1.BGe013.part1;

import java.util.EmptyStackException;

/**
 * 
 * @author 300358013
 *
 */
public final class Assignment1_BGe013_ArrayStack<T> implements Assignment1_BGe013_StackInterface<T> {
	private T[] stackArray; // array for entries will be stacked
	private int topIndex; // index of top entry in the stack
	private boolean integrity = false;
	private static final int STACK_CAPACITY = 5; // every player gets 5 cards, so default and max number of stack
													// determined as 5.

	// default constructor
	public Assignment1_BGe013_ArrayStack() {
		this(STACK_CAPACITY);
	}// end of default constructor

	// constructor
	public Assignment1_BGe013_ArrayStack(int initialStackCapacity) {
		integrity = false;
		checkStackCapacity(initialStackCapacity); // check the capacity ( max 5 for every user)

		@SuppressWarnings("unchecked")
		T[] temporaryStack = (T[]) new Object[initialStackCapacity];
		stackArray = temporaryStack;
		topIndex = -1;
		integrity = true;
	}// end of constructor

	@Override
	public T pop() {
		checkStackIntegrity();
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			T top = stackArray[topIndex];
			stackArray[topIndex] = null;
			topIndex--;
			return top;
		} // end of if statement

	}// end of pop method

	@Override
	public void push(T newEntry) {
		checkStackIntegrity();
		stackArray[topIndex + 1] = newEntry;
		topIndex++;
	}// end of push method

	@Override
	public boolean isEmpty() {

		return topIndex < 0;
	}// end of isEmpty

	@Override
	public T peek() {
		checkStackIntegrity();
		if (isEmpty()) {
			throw new EmptyStackException();
		} else
			return stackArray[topIndex];
	}// end of peek

	private void checkStackCapacity(int capacity) {

		if (capacity > STACK_CAPACITY) {
			throw new IllegalStateException("Dealer dealed more card than it should be. Card number must be 5. ");
		}
	} // end of the checkStackCapacity method.

	private void checkStackIntegrity() {
		if (!integrity) {
			throw new SecurityException("Corruption in Arraystack Object");
		}//end of if

	}//end of checkStacksIntegrity

}//end of ArrayStack
