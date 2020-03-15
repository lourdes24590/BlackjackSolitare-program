
public class Space {
	Card holding;
	int spaceNum;

	/**
	 * this method creates a space and identifies the number on the board where the
	 * space is and what Card it is holding (null at first).
	 * 
	 * @param spaceNum number of the space on the board
	 */
	public Space(int spaceNum) {
		this.spaceNum = spaceNum;
		this.holding = null;// initially there is no card in a space

	}

}
