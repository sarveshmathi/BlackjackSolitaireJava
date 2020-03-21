import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck of cards and deals a card from a shuffled deck when prompted
 * @author sarvesh
 *
 */

public class Deck {

	Card[] deckOfCards = new Card[52];
	Card[] shuffledDeck = new Card[52];
	int cardDealCounter = 0; //keeps track of dealt cards in the shuffledDeck


	/**
	 * Fills the deckOfCards with 52 cards by calling the loadSuite helper method
	 * and shuffles the deck with the shuffleDeck helper method
	 */

	public void initializeAndShuffleDeck() {
		loadSuite("Hearts",0);
		loadSuite("Diamonds",13);
		loadSuite("Clubs",26);
		loadSuite("Spades",39);	
		shuffleDeck();
	}


	/**
	 * Generates 13 cards of the input suite and loads into the deckOfCards array starting from the index provided
	 * @param suite
	 * @param index
	 */

	public void loadSuite(String suite, int index) {
		Card[] suiteArray = new Card[13];
		Card ace = new Card("Ace",suite,1); //we give A value 1 but depending on the hand, A can be 11 as well, this will be accordingly by the Player class
		suiteArray[0] = ace;
		for (int i=2; i<=10; i++) {
			Card n = new Card(Integer.toString(i), suite,i); //creates cards from number 2 to 10 for the specified suite
			suiteArray[i-1] = n;
		}
		Card jack = new Card("Jack",suite,10);
		suiteArray[10] = jack; 
		Card queen = new Card("Queen",suite,10);
		suiteArray[11] = queen; 
		Card king= new Card("King",suite,10);
		suiteArray[12] = king; 

		for (int i=0; i<13; i++) {
			deckOfCards[index] = suiteArray[i]; //adds the card to the deck array
			index++;
		}
	}

	//Shuffles the deck of 52 cards

	public void shuffleDeck() {
		Random random = new Random();
		ArrayList<Integer> dealtCardsIndices = new ArrayList<Integer>();
		for (int i = 0; i < shuffledDeck.length; i++) {
			int index = random.nextInt(52);
			while (dealtCardsIndices.contains(index)) {
				index = random.nextInt(52);
			}
			shuffledDeck[i] = deckOfCards[index];
			dealtCardsIndices.add(index);
		}
	}


	/**
	 * Returns a card from the shuffled deck
	 * Keeps track of the dealt cards with the card deal counter variable to avoid repeating the same card 
	 * @return
	 */

	public Card getCard() {
		Card deal = shuffledDeck[cardDealCounter];
		cardDealCounter++;
		return deal;
	} 

}
