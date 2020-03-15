
public class Scorer {
	Card card;
	Hand hand;
	int currentscore = 0;
	Hand[][] hands = new Hand[4][5];
	Display display;

	Scorer(Display display) {
		this.display = display;
	}

	/**
	 * this method adds the number value of cards of each row and determines the
	 * value of A to be 1 or 11 relative to the other cards by using the absolute
	 * value of the sum in comparison to 21. Then places the sums into the array
	 * containing all of the hands.
	 * 
	 * @param playingCards the 2d array of the board which contains the cards
	 * 
	 */
	public void rowadder(Space[][] playingCards) {
		// calculate sum of card value of each row
		int[][] numCards = { { 0, 5 }, { 1, 5 }, { 2, 3 }, { 3, 4 } };

		for (int i = 0; i < 4; i++) {
			int rowsum = 0;
			for (int j = 0; j < playingCards[i].length; j++) {
				if (playingCards[i][j] != null) {
					if (playingCards[i][j].holding.name == "A") {
						int a1sum = 0;
						a1sum = a1sum + playingCards[i][j].holding.numValue;
						int a2sum = a1sum - 1 + 11;
						int distance_a1sum = Math.abs(21 - a1sum);
						int distance_a2sum = Math.abs(21 - a2sum);
						if (distance_a2sum <= 21 && distance_a1sum <= 21) {
							if (distance_a2sum < distance_a1sum) {

								hands[0][i] = new Hand(a2sum, numCards[i][1]);
							}
						} else {
							hands[0][i] = new Hand(a1sum, numCards[i][1]);
						}
					}

					else {
						rowsum = rowsum + playingCards[i][j].holding.numValue;
					}
					hands[0][i] = new Hand(rowsum, numCards[i][1]);
				}
			}
		}

	}

	/**
	 * this method for each column on the board adds the values of the cards and
	 * stores the sum as a new hand with the corresponding number of cards in the
	 * array with all the hands called hands
	 * 
	 * @param playingCards the 2d array of the board which contains the cards
	 */
	public void coladder(Space[][] playingCards) {
		// calculate sum of card value of each row
		int[][] numCards = { { 0, 2 }, { 1, 4 }, { 2, 4 }, { 3, 4 }, { 4, 2 } };
		// the 1st column is the column number and the 2nd column is the
		// number of cards that can be held in that column; this is used to assign
		// numCards for each Hand
		// this loop goes through each column and assigns a new hand and adds it to the
		// hands array
		for (int j = 0; j < 5; j++) {
			int colsum = 0;
			for (int i = 0; i < 4; i++) {
				if (playingCards[i][j] != null) {
					if (playingCards[i][j].holding.name == "A") {
						int a1sum = 0;// starting value
						a1sum = a1sum + playingCards[i][j].holding.numValue;
						// A has preset value of 1
						int a2sum = a1sum - 1 + 11;
						// this will make it 11
						int distance_a1sum = Math.abs(21 - a1sum);
						int distance_a2sum = Math.abs(21 - a2sum);
						// will only check for difference if it is less than 21 so it
						// doesn't pass 21
						if (distance_a2sum <= 21 && distance_a1sum <= 21) {
							if (distance_a2sum < distance_a1sum) {
								hands[1][j] = new Hand(a2sum, numCards[j][1]);
							}
						} else {

							hands[1][j] = new Hand(a1sum, numCards[j][1]);
						}
					}

					else {
						colsum = colsum + playingCards[i][j].holding.numValue;
					} // any other cards not A
					hands[1][j] = new Hand(colsum, numCards[j][1]);
				}
			}
		}
	}

	/**
	 * this method adds the points of all the hands to get the score and print it to
	 * the user
	 */

	public void pointer() {
		for (int i = 0; i < hands.length; i++) {
			for (int j = 0; j < hands[i].length; j++) {
				if (hands[i][j] != null) {
					currentscore = currentscore + hands[i][j].points;
				}
			}
		}
		System.out.println("Your score is:" + currentscore);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
