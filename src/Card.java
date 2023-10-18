/**
 * the Card class represents a card in the Set game - it consists 
 * of 1-3 characters (aka icons), which come in 3 varieties. Each of the
 * groups is in one of 3 colors on one of 3 background colors. A card may not be empty.
 *
 * So each card can be represented by four numbers - which icon, how many, color, and background.
 * Each of these numbers has 3 possible values.
 * Question: how many legal combinations are there???
 */
public class Card {

	// TODO: decide which private member variables the Card class requires and declare them here.

	/**
	 * constructor - given four values, initialize the card.
	 * @param whichIcon: a number 0-2, where 0 means "*"; 1 means "o"; and 2 means "•" 
	 * @param groupSize: a number 1-3
	 * @param whichColor: a number 0-2
	 * @param whichBackground: a number 0-2
	 */
	 public Card(int whichIcon, int groupSize, int whichColor, int whichBackground)
	 {
		//--------------------
		// TODO: insert your code here.
		//--------------------
	 }
	
	 // TODO: write accessors for all member variables. In this case,
	 //       you shouldn't write modifiers; a Card never changes.
	 
	 
	/**
	 * toString - get a visual description of this card.
	 * @return the string describing this card.
	 */
	// TODO: you write the Card's toString
	// hint: see https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
	// so the string "/u001B[31mTest/u001B[0m" Prints Test in red letters.
	// and "/u001B[31m/u001B[42mTest2/u001B[0m" prints Test2 in red letters on a green background.
	//  (the /u001B[0m at the end resets the color to normal for the next thing you print.)
	
	
}
