package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BlackJackAssignment {

	public static void main(String[] args) {

		int noOfPlayers = 0;
		int noOfDealers = 1;
		int totalNoOfCardInPlay = 0;
		Set<Integer> valuesOfTheCards = null;
		int cardsPerHead = 2;
		int min = 1;
		int maxPlayers = 7;
		int noOfDecksOfCard = 2;
		boolean isDealerEmpty = true;
		int dealerTotal = 0;
		int tempcard01 = 0;
		int tempcard02 = 0;
		int playerTotal = 0;

		// Obtain no. of players & validate player count.
		while (true) {
			System.out.println("Please enter the numbers of player!... \n");
			// Scan the command-Line input
			Scanner scan = new Scanner(System.in);
			try {
				noOfPlayers = scan.nextInt();
			} catch (Exception e) {
				// Handle exception when STRING is provided
				System.out.println("Please provide integer values only. Try again");
				continue;
			}

			// Player validation: Min players = 1; Max players = 7
			if (noOfPlayers <= 1 || noOfPlayers > maxPlayers) {
				System.out.println("Players can't be ONE or more than 7, it's house rules. Please try again");
				continue;
			}
			break;
		}

		// Total Number Of Cards on the table
		totalNoOfCardInPlay = (noOfPlayers + noOfDealers) * cardsPerHead;

		// Values of each card stored in Set collection to avoid repeated card
		// number
		valuesOfTheCards = new HashSet<Integer>();
		for (; valuesOfTheCards.size() < totalNoOfCardInPlay;) {
			Random randomValue = new Random();
			// Obtain 2 cards to each players.
			// Card no. can't start with ZERO, hence min = 1.
			valuesOfTheCards.add(randomValue.nextInt(totalNoOfCardInPlay * noOfDecksOfCard) + min);
		}
		// Fetch the cards from the Set to List for easy access.
		List<Integer> listOfCards = new ArrayList<Integer>(valuesOfTheCards);
		System.out.println("\nCards drawn are :" + listOfCards.toString());

		// Deal the cards.
		HashMap<String, Integer> playesrAtTheTable = new HashMap<String, Integer>();
		int playerNo = 1;
		// Label the for() loop.
		handlecards: for (int i = 0; i < listOfCards.size(); i++) {
			// Handling Dealer's cards.
			if (isDealerEmpty) {
				tempcard01 = listOfCards.get(i);
				tempcard02 = listOfCards.get(++i);
				dealerTotal = tempcard01 + tempcard02;
				System.out.println("\n\nDealer's Cards are:- \nCard01: " + tempcard01);
				System.out.print("Card02: " + tempcard02);
				System.out.print(" >> Dealer's Total: " + dealerTotal + "\n\n\n");
				isDealerEmpty = false;
				continue handlecards;
			}
			// handle player's cards.
			tempcard01 = listOfCards.get(i);
			tempcard02 = listOfCards.get(++i);
			playerTotal = tempcard01 + tempcard02;
			System.out.println("Player" + playerNo + " Cards are:- \nCard01: " + tempcard01);
			System.out.print("Card02: " + tempcard02);
			System.out.print(" >> Player" + playerNo + " Total: " + playerTotal + "\n\n");
			playesrAtTheTable.put("player" + playerNo, playerTotal);
			playerNo++;
		}
		// Find the player with the highest total (Used Java8 to reduce code).
		String playerWithMaxValue = Collections.max(playesrAtTheTable.entrySet(), Map.Entry.comparingByValue()).getKey();
		// Display the winning player & his details.
		System.out.println("Winning player is: " + playerWithMaxValue + ", whose total is: " + (playesrAtTheTable.get(playerWithMaxValue)+dealerTotal));
	}
}