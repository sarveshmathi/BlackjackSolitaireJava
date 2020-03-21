import java.util.Scanner;

/**
 * Represents a player, initiates a board for the player, allows player input for spot on board, 
 * keeps track of the noOfCards on board, and returns the value of the nine hands
 * when prompted at the end of the game. 
 * @author sarvesh
 *
 */

public class Player {

	Board playerBoard = new Board(); 
	int noOfCardsOnBoard; //keeps track to end game at 16 cards on board
	int noOfCardsInDiscard ; //keeps track to disallow more than 4 cards on discard pile
	Card[] handOne, handTwo, handThree, handFour, handFive, handSix, handSeven, handEight, handNine; //nine possible hands based on the 16 spots
	Scanner in; //for user-input of spot on board

	/** 
	 * Initializes the player with 0 cards on board and discard pile and an empty array of cardsAlreadyShown
	 */
	public Player() {
		noOfCardsOnBoard = 0;
		noOfCardsInDiscard = 0;	
		in = new Scanner(System.in);	
	}

	/**
	 * Let's the player input a spot on the board to place the dealt card and returns that number
	 * @return
	 */

	public int chooseSpot() {	
		int position = in.nextInt();
		return position;	
	}

	/**
	 * Returns the final score of the player by adding the points for each hand 
	 * given by the helper method pointsForHand.
	 * The 9 hands are formed from the boards 4 rows and 5 columns
	 * @return
	 */

	public int playerTotalScore() {
		handOne = new Card[] {playerBoard.boardArray[0], playerBoard.boardArray[1], playerBoard.boardArray[2], playerBoard.boardArray[3], playerBoard.boardArray[4]}; // row 1 on the board
		handTwo = new Card[] {playerBoard.boardArray[5], playerBoard.boardArray[6], playerBoard.boardArray[7], playerBoard.boardArray[8], playerBoard.boardArray[9]}; //row 2 on the board
		handThree = new Card[] {playerBoard.boardArray[10], playerBoard.boardArray[11], playerBoard.boardArray[12]}; //row 3 on the board
		handFour = new Card[] {playerBoard.boardArray[13], playerBoard.boardArray[14], playerBoard.boardArray[15]}; // row 4 on the board
		handFive = new Card[] {playerBoard.boardArray[0], playerBoard.boardArray[5]}; //column 1 on board
		handSix = new Card[] {playerBoard.boardArray[1], playerBoard.boardArray[6], playerBoard.boardArray[10], playerBoard.boardArray[13]}; //column 2 on board
		handSeven = new Card[] {playerBoard.boardArray[2], playerBoard.boardArray[7], playerBoard.boardArray[11], playerBoard.boardArray[14]}; //column 3 on board
		handEight = new Card[] {playerBoard.boardArray[3], playerBoard.boardArray[8], playerBoard.boardArray[12], playerBoard.boardArray[15]}; //column 4 on board
		handNine = new Card[] {playerBoard.boardArray[4], playerBoard.boardArray[9]}; //column 5 on board
		int total = pointsForHand(handOne) + pointsForHand(handTwo) + pointsForHand(handThree) + pointsForHand(handFour) 
		+ pointsForHand(handFive) + pointsForHand(handSix) + pointsForHand(handSeven) + pointsForHand(handEight) 
		+ pointsForHand(handNine);
		return total;
	}

	/**
	 * Returns the points for a hand according to the scoring sheet and value provided by helper function handTotalValue
	 * @param hand
	 * @return
	 */
	public int pointsForHand(Card[] hand) {
		int handTotalValue = handTotalValue(hand);
		int points = 0;

		if (handTotalValue > 21) {
			System.out.println("Points for hand: " + points);

			return points; //BUST (Hand totals 22 or more)
		}

		if (hand.length == 2 && handTotalValue == 21) {
			points = 10; // Blackjack! (two cards that total 21)
		} else if (handTotalValue == 21) {
			points = 7; // 3, 4, or 5 cards totaling 21
		} else if (handTotalValue == 20) {
			points = 5; //Hand totals 20
		} else if (handTotalValue == 19) {
			points = 4; //Hand totals 19
		} else if (handTotalValue == 18) {
			points = 3; //Hand totals 18
		} else if (handTotalValue == 17) {
			points = 2; //Hand totals 17
		} else {
			points = 1; //Hand totals 16 or less
		}
		
		System.out.println("Points for hand: " + points);

		return points;
	}

	/**
	 * Returns the total value of all the cards in the hand accounting for Ace, 
	 * which counts as 11 or 1, depending upon which gives you a higher total without going over 21.
	 * @param hand 
	 * @return
	 */

	public int handTotalValue(Card[] hand) {
		boolean isAPresent = false;
		int total = 0;
		for (int i = 0; i < hand.length; i++) {
			int value = hand[i].value;
			total += value;
			if (hand[i].rank.equals("Ace")) {
				isAPresent = true;
			}
		}

		if (isAPresent) {
			int totalWithAValueOne = total; //value of A as one is already included in the total because it the preprogrammed value of the card 
			int totalWithAValueEleven = total + 10; //we add ten to the total to make A value 11
			if (totalWithAValueEleven <= 21) {
				return totalWithAValueEleven;
			} else {
				return totalWithAValueOne;
			}
		}		
		return total;
	}

}
