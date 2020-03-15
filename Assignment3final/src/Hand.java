public class Hand {
	int sum;// the sum of the values of all the cards that make up a hand
	int points;// points for each hand
	String handName;// name of the hand used to determine points in table
	int numberOfCards;// amount of card in each hand (row/column)
	String[][] reftable = { { "Blackjack", "10" }, { "21", "7" }, { "20", "5" }, { "19", "4" }, { "18", "3" },
			{ "17", "2" }, { "Bust", "0" }, { "16", "1" } };
	// used to get the points (2nd column) associated with
	// each hand name classification(1st column)

	/**
	 * constructor creates new hand and finds corresponding points and hand name
	 * 
	 * @param sum           the sum of the values of all cards in a row or column
	 * @param numberOfCards the number of cards that a row or column contains
	 * 
	 */
	Hand(int sum, int numberOfCards) {
		this.sum = sum;
		this.numberOfCards = numberOfCards;
		// assign hand name according to sum and number of cards
		if (sum <= 16) {
			this.handName = "16";
		} else if (sum >= 22) {
			this.handName = "Bust";
		} else if (sum == 21 && numberOfCards == 2) {
			this.handName = "Blackjack";
		} else {
			this.handName = String.valueOf(sum);
		}
		for (int i = 0; i < reftable.length; i++) {
			if (reftable[i][0].equals(handName)) {
				this.points = Integer.parseInt(reftable[i][1]);
			} // get points using table

		}
	}

	public static void main(String[] args) {

	}

}
