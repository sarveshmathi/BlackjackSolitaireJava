
/**
 * This class stores information of the 20 spots in the current player's board and prints it when prompted.
 * @author sarvesh
 *
 */

public class Board {

	Card[] boardArray = new Card[20]; //a 1-D array of the spots on the board and discard pile


	/**
	 * This method will print the current status of the board (row wise) and the discard pile based on the values in the 
	 * 20 element boardArray. The card in a spot will be printed in the format: rank+suite. 
	 * Ex. King of Hearts will be KH, 10 of Spades will be 10S.
	 */

	public void printBoard() {
		StringBuilder cardRankSuite; 
		for (int i=0; i<5; i++) {
			if (boardArray[i] == null) {
				System.out.format("%10d", i + 1);
			} else {				
				if (Character.isDigit(boardArray[i].rank.charAt(0))) {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank).append(boardArray[i].suite.charAt(0));			
				} else {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank.charAt(0)).append(boardArray[i].suite.charAt(0)); 
				}
				System.out.format("%10s", cardRankSuite.toString()); //prints only first letter of rank if face card or the whole number is number card. ex: King of Hearts is printed as KH
			}
		}
		System.out.println();

		for (int i=5; i<10; i++) {
			if (boardArray[i] == null) {
				System.out.format("%10d", i + 1);
			} else {
				if (Character.isDigit(boardArray[i].rank.charAt(0))) {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank).append(boardArray[i].suite.charAt(0));			
				} else {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank.charAt(0)).append(boardArray[i].suite.charAt(0)); 
				}
				System.out.format("%10s", cardRankSuite.toString()); 
			}
		}
		System.out.println();
		System.out.format("%10s", "");

		for (int i=10; i<13; i++) {
			if (boardArray[i] == null) {
				System.out.format("%10d", i + 1);
			} else {
				if (Character.isDigit(boardArray[i].rank.charAt(0))) {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank).append(boardArray[i].suite.charAt(0));			
				} else {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank.charAt(0)).append(boardArray[i].suite.charAt(0)); 
				}
				System.out.format("%10s", cardRankSuite.toString()); 
			}
		}
		System.out.println();
		System.out.format("%10s", "");

		for (int i=13; i<16; i++) {
			if (boardArray[i] == null) {
				System.out.format("%10d", i + 1);
			} else {
				if (Character.isDigit(boardArray[i].rank.charAt(0))) {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank).append(boardArray[i].suite.charAt(0));			
				} else {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank.charAt(0)).append(boardArray[i].suite.charAt(0)); 
				}
				System.out.format("%10s", cardRankSuite.toString()); 
			}
		}
		System.out.println();
		System.out.print("\nDiscard pile: ");

		for (int i=16; i<20; i++) {
			if (boardArray[i] == null) {
				System.out.print(i + 1 + "  ");
			} else {
				if (Character.isDigit(boardArray[i].rank.charAt(0))) {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank).append(boardArray[i].suite.charAt(0));			
				} else {
					cardRankSuite = new StringBuilder().append(boardArray[i].rank.charAt(0)).append(boardArray[i].suite.charAt(0)); 
				}
				System.out.print(cardRankSuite.toString() + "  "); 
			}
		}
		System.out.println();

	}
}
