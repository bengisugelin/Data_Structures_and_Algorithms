package com.csis3475.assignment2.BGe013;

public class Assignment2_BGe013_UserAdministration {

	public AList<Assignment2_BGe013_User> userlist = new AList<>();

	/**
	 * default constructor
	 */
	public Assignment2_BGe013_UserAdministration() {

	}

	/**
	 * getUser method - helper method that required to match the string read from
	 * user_friends.csv with its corresponding User object
	 * 
	 * @param firstname of the user which is aimed to be reached.
	 * @return user needs to be found
	 */
	public Assignment2_BGe013_User getUser(String firstname) {
		Assignment2_BGe013_User user = new Assignment2_BGe013_User();
		for (int i = 1; i <= userlist.getLength(); i++) {
			user = userlist.getEntry(i);
			if (user.getUserName().getFirstName().equals(firstname)) {
				return user;
			}
		}
		return userlist.getEntry(1);
	}// end of getUser method

	/*
	 * method for adding new user to the userlist.
	 * 
	 * @param u - user that will be added
	 */
	public void addUser(Assignment2_BGe013_User u) {
		userlist.add(u);
	}// end of addUser method

	/**
	 * method for removing user from the userlist
	 * 
	 * @param u - user that will be removed
	 */
	public void removeUser(Assignment2_BGe013_User u) {
		userlist.remove(u.getUserID());
	}// end of removeUser method

	/**
	 * creating friendship between two user, user a and user b
	 * 
	 * @param a first user
	 * @param b second user
	 */
	public void createFriendship(Assignment2_BGe013_User a, Assignment2_BGe013_User b) {

		if (a != null && b != null) {
			a.addFriend(b);
			b.addFriend(a);
		}
	}// end of createFriendship method

	/**
	 * ending the friendship between two user, user a and user b
	 * 
	 * @param a -- user a
	 * @param b -- user b
	 */
	public void endFriendship(Assignment2_BGe013_User a, Assignment2_BGe013_User b) {

		if (a != null && b != null) {
			a.removeFriend(b);
			b.removeFriend(a);
		}
	}// end of endFriendship method

	/**
	 * displaying user information, userID, userName, userStatus, userEmoji, # of
	 * friends, friend info
	 */
	public void displayUser() {

		Assignment2_BGe013_User user = new Assignment2_BGe013_User();
		for (int i = 1; i < userlist.getLength() + 1; i++) {
			user = userlist.getEntry(i);
			System.out.println(user);
			user.displayFriendsList();
		}
	}// end of displayUser method

	/**
	 * Check whether userlist is empty or not
	 */
	public void isEmpty() {
		if (userlist.isEmpty())
			System.out.println("Profile is empty.");
		else
			System.out.println("Profile is not empty.");
	}

}
