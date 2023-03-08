package com.csis3475.assignment1.BGe013.part2;

public class Assignment1_BGe013_CheckTheCode {

	public static void main(String[] args) {
		
		System.out.println("//-------------------CHECK 1----------------\\ \n");
		Assignment1_BGe013_SqueezeADT<String> sampleOutput = new Assignment1_BGe013_SqueezeADT<>();
		
		//check isEmpty operation
		if(sampleOutput.isEmpty())
		{
			System.out.println("Our ADT is Empty");
		}//end of if
		
		sampleOutput.smash("H");
		sampleOutput.smash("E");
		sampleOutput.smash("L");
		sampleOutput.smash("P");
		sampleOutput.smash("!");

		System.out.println("The front is " + sampleOutput.getHead());
		System.out.println("The last is " + sampleOutput.getTail());
		System.out.println("Displaying Content: "); 
		sampleOutput.displayEntries();
		
		System.out.println("Grab the first entry " + sampleOutput.getHead());
		sampleOutput.grab();
		System.out.println("The number of entries now " + sampleOutput.getNumOfEntries());
		System.out.println("The front is now " + sampleOutput.getHead() + " and the back is " + sampleOutput.getTail());
		System.out.println("Displaying content before squeeze:");
		sampleOutput.displayEntries();
		
		System.out.println("\nSqueezing a new string O");
		sampleOutput.squeeze("O");
		System.out.println("Displaying Content: "); 
		sampleOutput.displayEntries();
		
		System.out.println("\nDump the last entry " + sampleOutput.getTail());
		sampleOutput.dump();
		System.out.println("The number of entries now " + sampleOutput.getNumOfEntries());
		System.out.println("The front is now " + sampleOutput.getHead() + " and the back is " + sampleOutput.getTail());
		System.out.println("Displaying content before squeeze:");
		sampleOutput.displayEntries();
		
		System.out.println("\nSqueezing a new string M");
		sampleOutput.squeeze("M");
		System.out.println("Displaying Content: "); 
		sampleOutput.displayEntries();
		
		System.out.println("\nDump the last entry " + sampleOutput.getTail());
		sampleOutput.dump();
		System.out.println("The number of entries now " + sampleOutput.getNumOfEntries());
		System.out.println("The front is now " + sampleOutput.getHead() + " and the back is " + sampleOutput.getTail());
		System.out.println("Displaying content:");
		sampleOutput.displayEntries();
		
		
		
		
		
		System.out.println("\n //-------------------CHECK 2----------------\\ \n");
		Assignment1_BGe013_SqueezeADT<String> Courses = new Assignment1_BGe013_SqueezeADT<>();

		System.out.println("Adding New courses (Database I and Data Sturucture) using smash operation:");
		Courses.smash("Database I");
		Courses.smash("Data Structure and Algorithm");
		Courses.displayEntries();

		System.out.println("---------------");
		System.out.println("Adding a new course (Mobile App Development) to the middle using squeeze operation:");
		Courses.squeeze("Mobile App Development");
		Courses.displayEntries();

		System.out.println("---------------");
		System.out.println("Adding another course (Backend Web Dev.) to the middle using squeeze operation:");
		Courses.squeeze("Backend Web Development");
		Courses.displayEntries();

		System.out.println("---------------");
		System.out.println("Returns the number of entries in the queue  using getNumOfEntries operation:");
		System.out.println(Courses.getNumOfEntries());

		System.out.println("---------------");
		System.out.println("Retrieving the entry at the front of the queue using getHead operation:");
		System.out.println(Courses.getHead());

		System.out.println("---------------");
		System.out.println("Retrieving the entry at the end of the queue using getTail operation:");
		System.out.println(Courses.getTail());

		System.out.println("---------------");
		System.out.println("Removing and returning the entry at the head of the queue using grab operation:");
		System.out.println(Courses.grab());

		System.out.println("---------------");
		System.out.println("Removing and returning the entry at the tail of this queue using dump operation:");
		System.out.println(Courses.dump());
		

		System.out.println("---------------");
		System.out.println("Detects whether this queue is empty (true) or not(false)  using isEmpty operation:");
		System.out.println(Courses.isEmpty());

		System.out.println("---------------");
		System.out.println("Returns the number of entries in the queue  using getNumOfEntries operation:");
		System.out.println(Courses.getNumOfEntries());

		System.out.println("---------------");
		System.out.println("Removes all entries from this queue using clear operation:");
		Courses.clear();
		Courses.displayEntries();

		System.out.println("---------------");
		System.out.println("Returns the number of entries in the queue  using getNumOfEntries operation:");
		System.out.println(Courses.getNumOfEntries());

	}

}
