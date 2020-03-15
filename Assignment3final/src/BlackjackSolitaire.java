public class BlackjackSolitaire {
	Deck deck;
	Display display;
	Card card;
	Hand hand;
	Scorer scorer;

	/**
	 * this method will actually orchestrates the order of the game and executes the
	 * game
	 */
	public void play() {
		display = new Display();
		scorer = new Scorer(display);
		deck = new Deck();
		display.playingcardAssignments();// create the board
		display.discardCard();// create discard part of board
		deck.deckCreator();// make a deck with cards
		deck.shuffle();// shuffle the deck
		display.displayPlaying();// initial board
		// checks if the board is full yet or not
		while (emptyChecker() == true) {
			card = deck.deal();// deal the next card
			System.out.println();
			System.out.println("Your current card is:" + card.displayname);
			// lets user know what card they are dealt
			display.placer(card);
			display.update();// updated board after placement
		}

		System.out.println("Your score is being calculated");
		// let user know we will calculate the score now
		scorer.coladder(display.playingCards);// add the columns
		scorer.rowadder(display.playingCards);// add the rows
		scorer.pointer();// give appropriate points and display score
		System.out.println("Game over! Thanks for playing");// done
	}

	/**
	 * This method checks if in the spaces of the board the space contains a card.
	 * 
	 * @return answer true if there is no card in the space, false if there is
	 */
	public boolean emptyChecker() {
		boolean answer = false;// assume its full
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (display.playingCards[i][j] != null) {
					if (display.playingCards[i][j].holding == null) {
						answer = true;// it is empty
					}
				}
			}
		}
		return answer;

	}

	public static void main(String[] args) {

	}

}
