import java.util.Scanner;

public class Display {
	Space[] discardCard;// array of 4 cards that user wants to discard
	Space[][] playingCards;// array of cards that are actually part of the game
	Deck playingdeck;// deck that will be used in the game

	/**
	 * this method will return the actual board of playing cards with the space
	 * numbers by creating a new card for each available space
	 * 
	 * @return playingCards a 2D array of the board of the playing cards with space
	 *         numbers
	 */
	public Space[][] playingcardAssignments() {
		playingCards = new Space[4][5];
		int counter = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (!(i >= 2 && (j < 1 || j > 3))) {
					playingCards[i][j] = new Space(counter);
					counter++;
				}
			}
		}

		return playingCards;
	}

	/**
	 * this method will return the actual board of discard cards with the space
	 * numbers by creating a new card for each available discard space
	 * 
	 * @return discardCard an array representing the board of the discard cards with
	 *         space numbers
	 */
	public Space[] discardCard() {
		discardCard = new Space[4];
		int counter = 17;
		for (int i = 0; i < 4; i++) {
			discardCard[i] = new Space(counter);
			counter++;
		}
		return discardCard;
	}

	/**
	 * this method actually will print out in the format of the game with the space
	 * number the 2d array that contains the playing cards and the array that
	 * contains the discarded cards
	 */
	public void displayPlaying() {
		System.out.println("  ");
		System.out.println("   ");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (playingCards[i][j] != null) {
					System.out.format("%10d", playingCards[i][j].spaceNum);
				} else {
					System.out.format("%10s", "   ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Discard Cards");
		for (int i = 0; i < 4; i++) {
			System.out.format("%10d", discardCard[i].spaceNum);
		}

	}

	/**
	 * this method places the dealt card in the place that the user indicates it
	 * checks to see if there is a card there already in the space before.
	 * 
	 * @param currentCard dealt card
	 */
	public void placer(Card currentCard) {
		Scanner newLocationGrabber = new Scanner(System.in);
		boolean successfulPlacement = false;// used to know when to stop asking the user for a place
		System.out.println();
		while (successfulPlacement == false) {
			System.out.println("Please input place number of where you would like to place current card");
			int toPlace = newLocationGrabber.nextInt();
			// grabs location as indicated by user
			// if else indicates if it will go into the playing cards or discard places
			if (toPlace < 17) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 5; j++) {
						if (playingCards[i][j] != null) {
							if (playingCards[i][j].spaceNum == toPlace && playingCards[i][j].holding == null) {
								playingCards[i][j].holding = currentCard;
								successfulPlacement = true;
							} else if (playingCards[i][j].spaceNum == toPlace && playingCards[i][j].holding != null) {
								System.out.println("There is already a card in that spot");
								// this checks if the space is occupied; if it is it is not a
								// successfulPlacement=true
								// and so it will continue asking the user for a place
							}
						}
					}
				}
			} else if (toPlace >= 17) {
				for (int i = 0; i < 4; i++) {
					if (discardCard[i].spaceNum == toPlace && discardCard[i].holding == null) {
						discardCard[i].holding = currentCard;
						successfulPlacement = true;
					} else if (discardCard[i].spaceNum == toPlace && discardCard[i].holding != null) {
						System.out.println("There is already a card in that spot");

					}
				}
			}
		}
	}

	/**
	 * this method will display the board replacing the space number with the card
	 * display name if there is a card in that space
	 */
	public void update() {
		System.out.println("  ");
		System.out.println("   ");
		// loops through the playing card display board to check if for each space it
		// contains a card
		// if so, it will display the name of the card instead of the space number
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (playingCards[i][j] != null) {
					if (playingCards[i][j].holding != null) {
						System.out.format("%10s", playingCards[i][j].holding.displayname);
					} else {
						System.out.format("%10d", playingCards[i][j].spaceNum);
					}
				} else {
					System.out.format("%10s", "   ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Discard Cards");
		// loops through the discarded cards display board to check if for each space it
		// contains a card
		// if so, it will display the name of the card instead of the space number
		for (int i = 0; i < 4; i++) {
			if (discardCard[i].holding != null) {
				System.out.format("%10s", discardCard[i].holding.displayname);
			} else {
				System.out.format("%10d", discardCard[i].spaceNum);
			}
		}
	}

	public static void main(String[] args) {

	}

}
