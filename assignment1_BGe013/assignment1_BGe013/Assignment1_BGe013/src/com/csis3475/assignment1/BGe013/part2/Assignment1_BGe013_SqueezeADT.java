package com.csis3475.assignment1.BGe013.part2;

public final class Assignment1_BGe013_SqueezeADT<T> implements Assignment1_BGe013_SqueezeADTInterface<T> {

	private Node firstNode; // References node at front of queue
	private Node lastNode; // References node at back of queue
	private int size; // size of the nodes

	public Assignment1_BGe013_SqueezeADT() {
		firstNode = null;
		lastNode = null;
		int size = 0;
	} // end default constructor

	@Override
	public int getNumOfEntries() {

		return size;
	}// end of getNumOfEntries

	@Override
	public void smash(T newEntry) {
		Node newNode = new Node(newEntry, null);

		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNext(newNode);

		} // end of if
		lastNode = newNode;
		size++;

	}// end of smash

	@Override
	public void squeeze(T newEntry) {
		Node newNode = new Node(newEntry, null);

		if (isEmpty()) {
			firstNode = newNode;

		} else {
			Node temp; // temporary node, will be used traverse through the list
			Node current;// current node, will be used traverse through the list

			int count;
			// find and store the middle of the node
			if (size % 2 == 0) {
				count = size / 2;
			} else {
				count = (size + 1) / 2;
			} // end of if else

			temp = firstNode;
			current = null;

			// traverse through the list until the middle of the list is reached

			for (int i = 0; i < count; i++) {
				current = temp;
				temp = temp.next;
			} // end of for loop

			current.next = newNode;
			newNode.next = temp;

		}
		size++;

	}// end of squeeze

	@Override
	public T getHead() {
		if (isEmpty())
			throw new RuntimeException();
		else
			return firstNode.getData();

	}// end of getHead

	@Override
	public T grab() {
		T front = getHead(); // Might throw RunTimeException
		firstNode.setData(null);
		firstNode = firstNode.getNext();

		if (firstNode == null)
			lastNode = null;

		size--;

		return front;
	}// end of grab

	@Override
	public T getTail() {
		if (isEmpty())
			throw new RuntimeException();
		else
			return lastNode.getData();
	}// end of getTail

//	@Override
//	public T dump() {
//		if (firstNode == null)
//			lastNode = null;
//		
//		Node temp = firstNode;
//		Node previousToLast = null;
//		//lastNode.setData(null);
//		
//		
//		while(temp.next != null) {
//			previousToLast = temp;
//			temp = temp.next;
//		}
//		previousToLast.next=null;
//		T back = getTail();
//		displayEntries();
//		System.out.println(temp.getData());
//		size --;
//		return back;
//	}
	@Override
	public T dump() {
		T back = getTail();

		if (firstNode == lastNode) {
			firstNode = null;
			lastNode = null;
		} else {
			Node previousToLast = firstNode;
			while (previousToLast.next != lastNode) {
				previousToLast = previousToLast.next;
			} // end of the while
			lastNode = previousToLast;
			lastNode.next = null;

		} // end of if
		
		size--;
		return back;

	}// end of dump

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}// end of isEmpty

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;

		size = 0;

	}// end of clear

	@Override
	public void displayEntries() {
		Node current = firstNode;
		if (current == null) {
			System.out.println("List is Empty");
			return;
		}
		while (current != null) {
			System.out.println(current.getData());
			current = current.next;
		}

	}

	private class Node {
		private T data; // Entry in queue
		private Node next; // Link to next node

		private Node(T ddata) {
			data = ddata;
			next = null;
		} // end constructor

		private Node(T ddata, Node link) {
			data = ddata;
			next = link;
		} // end constructor

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	} // end Node class

}
