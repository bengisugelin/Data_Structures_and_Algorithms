package com.csis3475.assignment1.BGe013.part1;

import java.util.Random;

public class Assignment1_BGe013_CardStackGame {

	public static void main(String[] args) {

		// creating players

		// Computer as a dealer
		Assignment1_BGe013_StackInterface<String> Computer = new Assignment1_BGe013_ArrayStack();
		for (int i = 0; i < 5; i++) {
			String randCard = generateRandomCard();
			Computer.push(randCard);
		} // end of for loop

		// First Player
		Assignment1_BGe013_StackInterface<String> Player1 = new Assignment1_BGe013_ArrayStack();
		dealCards(Player1, "Player1");

		// Second Player
		Assignment1_BGe013_StackInterface<String> Player2 = new Assignment1_BGe013_ArrayStack();
		dealCards(Player2, "Player2");

		// game begins
		System.out.println("\nThe game has begun");

		int p1CardCounter = 5;
		int p2CardCounter = 5;

		while (!Computer.isEmpty()) {
			String cCard = Computer.peek();
			String p1Card = Player1.peek();
			String p2Card = Player2.peek();

			String compTempCard = Computer.pop();
			String player1TempCard = Player1.pop();
			String player2TempCard = Player2.pop();
			System.out.println("Computer draw card " + cCard);
			if (compTempCard.equals(player1TempCard)) {
				p1CardCounter--;
				System.out.println("\t Player 1 has the same card at the top ");
				System.out.println("\t Cards remained:" + p1CardCounter);
			} else {
				System.out.println("\t Player 1 : no move");
				System.out.println("\t Cards remained:" + p1CardCounter);
				Player1.push(p1Card);

			} // end of if else

			if (compTempCard.equals(player2TempCard)) {
				p2CardCounter--;
				System.out.println("\t Player 2 has the same card at the top ");
				System.out.println("\t Cards remained:" + p2CardCounter);
			} else {
				System.out.println("\t Player 2 : no move");
				System.out.println("\t Cards remained:" + p2CardCounter);
				Player2.push(p2Card);

			} // end of if else

		} // end of while loop

		System.out.println("Player 1 has " + p1CardCounter + " cards left.");
		System.out.println("Player 2 has " + p2CardCounter + " cards left.");
		System.out.println(winner(p1CardCounter, p2CardCounter) + " WON the game!");

	}// end of main

	// method for generating "R" (Red) or "B" (Blue) card for the game.
	private static String generateRandomCard() {
		String[] cardArray = { "R", "B" };
		Random generator = new Random();
		int randomIndex = generator.nextInt(cardArray.length);
		return cardArray[randomIndex];
	}// end of generateRandomCard method

	// method for dealing cards to players
	private static void dealCards(Assignment1_BGe013_StackInterface<String> player, String playerName) {
		String[] cards = new String[5];
		for (int i = 4; i > -1; i--) {
			String randCard = generateRandomCard();
			cards[i] = randCard;

			player.push(randCard);
		} // end of for
		System.out.println(playerName + "'s cards are: " + cards[0] + cards[1] + cards[2] + cards[3] + cards[4]);
	} // end of dealcards method

	
	//method for determining the winner
	private static String winner(int p1RemainCards, int p2RemainCards) {
		String winner = "";
		if (p1RemainCards < p2RemainCards)
			winner = "Player 1";
		else if (p2RemainCards < p1RemainCards)
			winner = "Player 2";
		else if (p2RemainCards == p1RemainCards)
			winner = "Deal! both player 1 and player 2";

		return winner;
	}//end of winner

}
