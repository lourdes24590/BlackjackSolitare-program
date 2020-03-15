public class Card {
	int numValue; // numerical value of the card e.g. J=11
	String displayname; // name that will be displayed to user on board e.g. "AH"
	String suit;// club, heart, spade, or diamond
	String name;// Letter or number of the card e.g. 7,8,J,K

	// Constructor for Card
	Card(int numValue, String name, String suit) {
		this.numValue = numValue;
		this.suit = suit;
		this.displayname = name + suit;
	}

	public static void main(String[] args) {

	}

}
