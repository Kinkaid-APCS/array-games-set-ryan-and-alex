/**
 * The Deck class represents a pile of cards.
 */
public class Deck {
    //--------------------
// TODO: insert your code here.
    private Card[] Deck = new Card[81];

//	private int topOfDeck; decided to do it similar to blackjack
	private int lastCard;
	private int number = 0;

	
	/**
	 * constructor - makes a deck containing one card for every 
	 * combination of features and sets the topOfDeck to the index
	 * of the last card.
	 */
	public Deck()
	{
		int counter = 0;
			for (int i = 0; i<=2;i++){ //icon
				for (int j = 1; j<=3;j++){ //size
					for(int k =0; k<=2;k++){ //color
						for (int l = 0; l<=2;l++){ //background
							Deck[counter] = new Card(i,j,k,l);
//							System.out.println(counter+"\t"+Deck[counter]);
							counter++;

						}
					}
				}
			}

		lastCard = Deck.length - 1;
		this.shuffle();

		
		//--------------------
		
	}
	
	/**
	 * dealCard - returns the card at the "top" of the deck, moving the
	 * "top" down one. 
	 * If the "top" is low enough to be past the end of the deck,
	 * then return null.
	 * @return the next card.
	 */

	public Card dealCard()
	{
		if (!outOfCards()){
			Card toReturn = Deck[0];
			for (int i = 0; i < lastCard; i++)
			{
				Deck[i] = Deck[i + 1];
			}
			Deck[lastCard] = null;
			lastCard--;

			return toReturn;
		}

		else{
			throw new ArrayIndexOutOfBoundsException("Attempted to return a card from an empty CardPile.");
		}




		//--------------------
	}
	
	/**
	 * shuffle - shuffles the cards in the deck by swapping many times.
	 * resets "top of deck" to the beginning.
	 * Note: no return value; just updates private variables.
	 */
	public void shuffle()
	{
		//--------------------
		// TODO: insert your code here.
		for (int i = 0; i < numCards() * 3; i++)
		{
			int a = (int)(Math.random()*(numCards()));
			int b = (int)(Math.random()*(numCards()));

			if (a != b)
			{
				Card temp = Deck[a];
				Deck[a] = Deck[b];
				Deck[b] = temp;
			}

		}

		// Hint #1: Remember, (int)(Math.random()*52) will give you an integer from 0..51, inclusive.
		// Hint #2: 52 is not the number you want for this deck.
		
		//--------------------
		
	}

	public int numCards(){
		return lastCard + 1;
	}
	
	/**
	 * outOfCards - determines whether the "top of deck" has extended beyond the end of the Deck.
	 * @return - boolean; whether the top of deck is past the end of the deck
	 */
	public boolean outOfCards()
	{
		boolean pastEndOfDeck;
		//--------------------
		//TODO: insert your code here
		if (lastCard > -1){
			pastEndOfDeck = false;
		}
		else {
			 pastEndOfDeck= true;
		}
		
		//--------------------
		return pastEndOfDeck;
	}
	
	
	/**
	 * toString - lists all the cards in the deck.
	 * @return a String with all the cards in it, in the current order, 
	 * with a marker (e.g., "-->" vs. "   ") where the top of the Deck is.
	 */
	public String toString()
	{
		String result = "";
		//--------------------
		// TODO: insert your code here. (optional, but suggested)
		// this is not something you'll use in the game, but might be handy
		//    for debugging.
		
		//--------------------
		return result;
	}
	
}
