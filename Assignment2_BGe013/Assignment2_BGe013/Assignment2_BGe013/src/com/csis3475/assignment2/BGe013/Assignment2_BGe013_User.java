package com.csis3475.assignment2.BGe013;
/**
 * @author 300358013 Bengisu Gelin
 */

import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;

public class Assignment2_BGe013_User {

	private String userEmoji;
	private Assignment2_BGe013_Name userName;
	private String userStatus;
	private int userID;
	private AList<Assignment2_BGe013_User> friends;

	public Assignment2_BGe013_User() {

		this.friends = new AList<>();
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserEmoji(String emojiAlias) {
		String result = EmojiParser.parseToUnicode(emojiAlias);
		this.userEmoji = result;
	}

	public String getUserEmoji() {
		return userEmoji;
	}

	public void setUserName(String first, String last) {
		userName = new Assignment2_BGe013_Name();

		this.userName.setFirstName(first);
		this.userName.setLastName(last);

	}

	public Assignment2_BGe013_Name getUserName() {
		return userName;
	}

	public void setUserStatus(String status) {
		this.userStatus = status;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public AList<Assignment2_BGe013_User> getFriends() {

		return friends;
	}

	
	/**
	 * method for adding a new friend to a selected user
	 * @param friend - user that will be added as a friend of selected user.
	 */
	public void addFriend(Assignment2_BGe013_User friend) {
		if (!friends.contains(friend)) {
			friends.add(friend);
		}
	}//end of addFriend method

	/**
	 * method for removing friend from a selected user
	 * @param friend -  user that will be removed from the user list of selected user.
	 */
	public void removeFriend(Assignment2_BGe013_User friend) {
		if (friends.contains(friend)) {
			friends.remove(friend.userID);
			// friend.removeFriend(this); // remove this user as a friend of the friend
		}
	}//end of removeFriend method

	/**
	 * displaying the friendlist of selected user.
	 */
	public void displayFriendsList() {

		System.out.println("\tFriends:");
		for (int i = 1; i <= friends.getLength(); i++) {
			System.out.println("\t\t" + friends.getEntry(i).getUserName());
		}

	}//end of displayFriendsList method

	@Override
	public String toString() {
		return "User Id: " + userID + "\n\tName: " + userName 
				+ "\n\tStatus: " + userStatus + "\n\tEmoji: " 
				+ EmojiManager.getForAlias(userEmoji).getUnicode()
				+ "\n\t# of friends: " + friends.getLength();
	}

}
