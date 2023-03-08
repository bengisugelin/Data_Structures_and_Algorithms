package com.csis3475.assignment2.BGe013;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.vdurmont.emoji.EmojiManager;

public class Assignment2_BGe013 {

	public static void main(String[] args) {

		Assignment2_BGe013_UserAdministration admin = new Assignment2_BGe013_UserAdministration();

		admin.isEmpty();
		System.out.println("-------------------------------");
		System.out.println();

		System.out.println("Reading profile data.");
		readUserListCSV(admin.userlist);
		System.out.println("\n-----------------------------");
		System.out.println();

		System.out.println("Creating friendships.");
		readUserFriendsCSV(admin.userlist, admin);
		System.out.println("\n-----------------------------\n");

		System.out.println("Displaying all profiles and friends.");
		System.out.println();
		admin.displayUser();

		System.out.println("\n-----------------------------\n");
		changeStatus("kelvin", "Its about what you do...don't", admin);

		System.out.println("\n-----------------------------\n");
		befriend("bratt", "kelvin", admin);

	}

	/**
	 * method for reading user_list.csv file line by line, create user by the info,
	 * and add the user to the userlist.
	 * 
	 * @param userlist - Alist for adding the user.
	 */
	public static void readUserListCSV(AList<Assignment2_BGe013_User> userlist) {
		int countIdNumber = 1;

		String path = "data\\user_list.csv";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";

			while ((line = br.readLine()) != null) {
				Assignment2_BGe013_User tempUser = new Assignment2_BGe013_User();

				String[] tokens = line.split(",");

				tempUser.setUserID(countIdNumber);
				tempUser.setUserName(tokens[0], tokens[1]);
				tempUser.setUserEmoji(tokens[2]);
				tempUser.setUserStatus(tokens[3]);

				userlist.add(countIdNumber, tempUser);
				countIdNumber++;

			} // end of while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not found the data");
		} catch (IOException e) {
			e.printStackTrace();
		} // end of try/catch

	}// end of readUserCSV

	/**
	 * method for reading friends_list.csv file line by line, get user info and
	 * create friendship accordingly
	 * 
	 * @param userlist - to get the user info using getUser method from
	 *                 userAdministration
	 * @param admin    - userAdministration to reach the userlist and getUser method
	 */
	public static void readUserFriendsCSV(AList<Assignment2_BGe013_User> userlist,
			Assignment2_BGe013_UserAdministration admin) {
		Assignment2_BGe013_User user1 = new Assignment2_BGe013_User();
		Assignment2_BGe013_User user2 = new Assignment2_BGe013_User();
		AList<Assignment2_BGe013_User> friendList = new AList<>();
		AList<Assignment2_BGe013_User> friendList2 = new AList<>();
		String path = "data\\friends_list.csv";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";

			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");

				user1 = admin.getUser(tokens[0]);
				user2 = admin.getUser(tokens[1]);

				admin.createFriendship(user1, user2);
			}

		} // end of while

		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not found the data");
		} catch (IOException e) {
			e.printStackTrace();
		} // end of try/catch

	}

	/**
	 * method for changing the status of the user
	 * 
	 * @param userName - user that will change their status
	 * @param status   - String status value
	 * @param admin    - stores user in userlist
	 */
	public static void changeStatus(String userName, String status, Assignment2_BGe013_UserAdministration admin) {
		Assignment2_BGe013_User user = new Assignment2_BGe013_User();

		user = admin.getUser(userName);

		user.setUserStatus(status);

		System.out.println("Changing user " + userName + "'s status");
		System.out.println();
		System.out.println(user);
		user.displayFriendsList();

	}// end of changeStatus method

	/**
	 * make friend two user
	 * 
	 * @param userFirstName   - first user's first name to find the user by their
	 *                        name
	 * @param friendFirstName - second user's first name to find them by their name
	 * @param admin           --stores user in userlist
	 */
	public static void befriend(String userFirstName, String friendFirstName,
			Assignment2_BGe013_UserAdministration admin) {

		Assignment2_BGe013_User user = new Assignment2_BGe013_User();
		Assignment2_BGe013_User friend = new Assignment2_BGe013_User();

		user = admin.getUser(userFirstName);
		friend = admin.getUser(friendFirstName);

		admin.createFriendship(user, friend);

		System.out.println("User " + userFirstName + " has befriended " + friendFirstName + "!");

		System.out.println(friend);
		friend.displayFriendsList();

		System.out.println(user);
		user.displayFriendsList();

	} //end of befriend method

}//end of main class
