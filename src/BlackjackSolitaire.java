
/**
 * Represents a game of BlackjackSolitaire by putting together the deck, player, and player's board.
 * @author sarvesh
 *
 */

public class BlackjackSolitaire {

	Deck deck;
	Player player;
	Board board; 

	/**
	 * Lets the user play a game of Blackjack Solitaire by dealing a card and asking where to place the card
	 * on the board and printing the board after each turn. 
	 * When there are 16 cards on the main board, the players total score is printed and the game ends.
	 */

	public void play() {
		deck = new Deck();
		deck.initializeAndShuffleDeck();
		player = new Player();
		board = player.playerBoard;

		while (player.noOfCardsOnBoard < 16) {
			System.out.println("\nThis is your current board:");
			board.printBoard();
			Card deal = deck.getCard();
			System.out.println("\nNew card dealt: " + deal.rank + " of " + deal.suite);
			boolean playerInputError = true; //since player hasn't input yet, we assume error as true to begin the loop
			while (playerInputError) {
				System.out.println("\nEnter a position from 1 to 20 to place the dealt card: ");		  
				int position = player.chooseSpot();
				playerInputError = checkForError(position);
				if(!playerInputError) {
					board.boardArray[position-1] = deal;
					if (position <= 16) {
						player.noOfCardsOnBoard++; //keeps count so we don't go over 16
					} else {
						player.noOfCardsInDiscard++;
					}
				}
			}

		}

		if (player.noOfCardsOnBoard == 16) {
			System.out.println("\nThis is your final board. All sixteen spots are filled, your hands will now be scored.");
			board.printBoard();
			System.out.println("\nYOUR FINAL SCORE IS " + player.playerTotalScore());  
			System.out.println("\nEnd of game");
			player.in.close();
		} else {
			System.out.println("Some unknown error occured"); 
		}

	}

	/**
	 * Returns true if the position input by the user is within the specified range [0..20] and 
	 * if the position is not occupied by another card on the board. Returns false otherwise.
	 * @param position
	 * @return
	 */

	public boolean checkForError(int position) {
		if (position < 1 || position > 20) {
			System.out.println(position + " is an invalid spot");
			return true;
		} else if (board.boardArray[position-1] != null) {
			if (player.noOfCardsInDiscard == 4) {
				System.out.println(position + " is already filled and discard pile is full, please choose a spot on the main board");
			} else {
				System.out.println(position + " is already filled, please try again");
			}
			return true;
		}
		return false;
	}
}
