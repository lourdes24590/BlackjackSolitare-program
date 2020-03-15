import java.util.Random;

public class Deck {
	Card[] cardStorer = new Card[52];
	// creates an array to hold the number of cards in a standard deck (52)

	/**
	 * this method creates the standard 52 deck of cards
	 * 
	 * @return cardStorer the filled in array of all 52 cards
	 */
	public Card[] deckCreator() {
		String[] suitList = { "H", "S", "C", "D" };// hearts,spade,club, diamond
		String[] nameList = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };// letter or number of
																									// card
		int[] standardValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };// common value of card for the game
		int y = 0;// initializes the storage location for the cardStorer
		// creates a new card using arrays above
		for (int i = 0; i < nameList.length; i++) {
			for (int j = 0; j < suitList.length; j++) {
				cardStorer[y] = new Card(standardValues[i], nameList[i], suitList[j]);
				y++;
			}
		}

		return cardStorer;
	}

	/**
	 * this method shuffles the array representing the deck of cards
	 * 
	 * @return cardStorer the array of 52 cards shuffled
	 */
	public Card[] shuffle() {
		Random shuffler = new Random();
		for (int i = 0; i < cardStorer.length; i++) {
			int index = shuffler.nextInt(51);// random generator for the next index value
			Card newElement = cardStorer[index];
			// hold card that is currently in the spot that we will place a new card
			cardStorer[index] = cardStorer[i];
			cardStorer[i] = newElement; // switched places

		}
		return cardStorer;

	}

	/**
	 * this method displays the "topmost" card of the deck
	 * 
	 * @return upnext the "topmost" card
	 */
	public Card deal() {
		Card upnext = cardStorer[0];// begins dealing the 1st card
		for (int i = 1; i < cardStorer.length; i++) {
			cardStorer[i - 1] = cardStorer[i];// moves every character up one place in the array
		}
		return upnext;
	}

	public static void main(String[] args) {
	}

}
