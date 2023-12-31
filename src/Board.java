/**
 * the Board class holds and displays 12 - 15 cards. (Typically,
 * it holds 12, but if the player is stumped, they can deal 3 more - this
 * is an advanced feature, so don't worry about it at first.)
 * Cards are selected in groups of three - if they form a "SET," they are
 * removed from the board and another three cards are automatically 
 * dealt into the vacated spots.
 */
public class Board {
	
	private Card[] displayedCards;
	Deck deck = new Deck();
	/**
	 * constructor - set up the board's variables, including dealing 12 cards.
	 */
	public Board() {

		displayedCards = new Card[15];
		//--------------------
		// fill the first 12 slots with cards from the deck.
		// leave the last 3 as null for now.
		// TODO: Insert your code here.
		for (int i = 0; i < 15; i++) {
			displayedCards[i] = deck.dealCard();
			if (i > 11) {
				displayedCards[i] = null;
			}
		}
	}

	
	/**
	 * getCardAtLoc - accesses the card at a given location
	 * @param loc
	 * @return a copy of the card that is stored at location loc,
	 * 			or null, if there is none there.
	 * precondition: loc is a valid location from 0-14, inclusive.
	 */
	public Card getCardAtLoc(int loc)
	{

		return displayedCards[loc];
	}
	
	/**
	 * isLegal - determines whether the three cards at the given locations
	 * are a "SET."
	 *  // alternately, use a small array.
	 * @return whether (true/false) these cards are a "SET."
	 * A SET is formed when for each of the four categories, all the cards 
	 * are the same, or all are different. For example, here is a "SET":
	 * 0: {**} {**} {**}
	 * 1: [**] [**]
	 * 2: <**>
	 * this is a "SET" because: a) the brackets are different on all three 
	 * cards; b) the number of groups is different on all three cards; 
	 * c) the size of the groups are the same on all three cards; and d)
	 * the icon is the same on all three cards.
	 * Here's another example of a "SET":
	 * 0: {•} {•}
	 * 1: {ooo} {ooo}
	 * 2: {**} {**}
	 * In this case the brackets and number of groups are constant, but
	 * the icon and the size of the groups are all different.
	 * Here's an example of a non-"SET."
	 * 0: {o} {o}
	 * 1: <•> <•> <•>
	 * 2: [o]
	 * In this case, the group sizes are all the same, the number of groups
	 * are all different, the brackets are all different, BUT two of the
	 * cards have the icon "o" and one has the icon "•." So this is NOT a "SET."
	 * Another example of a non-"SET.":
	 * 0: {**} {**} {**}
	 * 1: {•}
	 * 2: <ooo> <ooo>
	 * In this case, it is the bracket types that fail; there are two cards with
	 * curly brackets and one with angle brackets.
	 * Note: If you are given the same card twice (or three times), it is illegal.
	 * Note: If any of the cards are null, it is illegal.
	 */
	public boolean isLegal(Card a, Card b, Card c)
	{
		boolean legal = false;
		//--------------------
		// Hint: there is a fancy math trick for making this work, involving
		//       factors of 3. You should not need a ton of "if" statements!!!!
		//       See me if you have questions.
		// TODO: insert your code here.

		int allColors = a.getColor() + b.getColor() + c.getColor();
		int allBackgrounds = a.getBackground() + b.getBackground() + c.getBackground();
		int allIcons = a.getIcon() + b.getIcon() + c.getIcon();
		int allGroupSizes = a.getGroupSize() + b.getGroupSize() + c.getGroupSize();

		if (allColors%3 == 0 || allColors == 2){
			if (allBackgrounds%3 == 0 || allBackgrounds == 2){
				if (allIcons%3 ==0 || allIcons == 2){
					if (allGroupSizes%3 == 0){
						legal = true;
						System.out.println("SET FOUND!\n");

					}
				}
			}
		}else{
			System.out.println("NOT A SET. TRY AGAIN!\n");
		}
		//--------------------
		return legal;
	}
	
	/**
	 * dealThreeCards - if there are fewer than 15 cards on the board,
	 * and if there are still cards in the deck, deal three cards from
	 * the deck and put them into the first three locations that contain
	 * null.
	 */
	public void dealThreeCards() {
		if (!(displayedCards[12] == null)){
			System.out.println("You've already drawn three cards!");
		}else{
			for (int i = 11; i<15; i++){
				displayedCards[i] = deck.dealCard();
			}
		}
	}
	//
	/**
	 * remove3Cards - removes three cards from the board by replacing them with null.
	 * Optional: if there are remaining cards in locations 12, 13, or 14, move
	 * them into empty locations.
	 * If there are fewer than 12 cards remaining and there are cards in the deck,
	 * fill in empty places with three cards dealt from the deck.
	 *  // alternate version: an array of locations
	 * note: no return value; only private member variables changed.
	 * prerequisite: all three locations are within 0-14, all point to non-null cards,
	 * and there are no duplicates.
	 */
	public void removeThreeCards(int aCard, int bCard, int cCard){
		for (int i = 0; i<15; i++){
			if (aCard==i){
				displayedCards[aCard] = null;
			}else if (bCard==i){
				displayedCards[bCard] = null;
			}else if (cCard==i){
				displayedCards[cCard] = null;
			}
		}
		for (int i = 0; i<15; i++){
			if (displayedCards[i] == null){
				displayedCards[i] = deck.dealCard();
			}
		}
	}
	 // TODO: 
	 // 1: write the remove3Cards() method signature. (i.e., return type, method name, parameter list)
	 //    MAKE SURE THAT YOU COMMUNICATE THIS WITH THE REST OF YOUR TEAM.
	 // 2: go to BoardTest.java and write a test to make sure that this is
	 //    working - Look at the test for "testGetNumCardsOnBoardAndDeal3" as an
	 //    example of what to write here.
	 // 3: write the method and make sure that it passes the test.
	
	/**
	 * getNumCardsOnBoard
	 * @return the number of non-null cards on the board
	 */
	public int getNumCardsOnBoard()
	{
		int numCards = 15;
		//--------------------
		// TODO: insert your code here
		if (displayedCards[12] == null){
			numCards = 12;
		}
		
		//--------------------
		return numCards;
	}
	
	/**
	 * toString - displays the contents of the board, along with numbers (or letters)
	 * to identify the cards for the user's input.
	 * @return - a string describing the board.
	 */
	public String toString()
	{
		String result = "";
		//--------------------
		int counter = 0;
		// TODO: insert your code here.
		//i is rows, j is columns
		for (int i = 0; i<5; i++){
			for (int j = 0;j<3;j++){
				if (displayedCards[counter] == null){
					counter++;
				}
				else {
					System.out.print(counter + "." + "[" + displayedCards[counter] + "] ");
					counter++;
				}
			}
			System.out.println("");
		}
		
		//--------------------
		return result;
	}
}
