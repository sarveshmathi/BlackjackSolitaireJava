/**
 * Represents a single card's rank, suite and value
 * @author sarvesh
 *
 */

public class Card {

	String rank;
	String suite;
	int value;

	/**
	 * Initializes a card with the given rank, suite and value. For example: Rank = King, Suite = Hearts, Value = 10.
	 * @param cardRank
	 * @param cardSuite
	 * @param cardValue
	 */

	public Card(String cardRank, String cardSuite, int cardValue) {
		rank = cardRank;
		suite = cardSuite;
		value = cardValue;
	} 

}
