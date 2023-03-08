package com.csis3475.assignment2.BGe013;
/*
 * @author 300358013 Bengisu Gelin
 */

public class Assignment2_BGe013_Name {
	private String firstName;
	private String lastName;

	/**
	 * Default Constructor
	 */
	public Assignment2_BGe013_Name() {

	}

	/**
	 * Constructor wit fields
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Assignment2_BGe013_Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public String getName() {
		return firstName + " " + lastName;

	}

	public void setName(String first, String last) {
		firstName = first;
		lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first) {
		firstName = first;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	@Override
	public String toString() {
		return  firstName + " " + lastName;
	}

}
