import java.util.Random;

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
	 * @param whichBackground: a number 0-2**
	 */
		private int whichIcon;
		private int groupSize;
		private int whichColor;
		private int whichBackground;

	 public Card(int icon, int size, int color, int background)
	 {
		//--------------------
		// TODO: insert your code here.
		//--------------------
		 whichIcon = icon;
		 groupSize = size;
		 whichColor = color;
		 whichBackground = background;
	 }
	
	 // TODO: write accessors for all member variables. In this case,
	 //       you shouldn't write modifiers; a Card never changes.
	 
	 
	/**\
	 * toString - get a visual description of this card.
	 * @return the string describing this card.
	 */
	// TODO: you write the Card's toString
	// hint: see https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
	// so the string "/u001B[31mTest/u001B[0m" Prints Test in red letters.
	// and "/u001B[31m/u001B[42mTest2/u001B[0m" prints Test2 in red letters on a green background.
	//  (the /u001B[0m at the end resets the color to normal for the next thing you print.)
	public String toString() {

		String background = null;
		String color = null;
		String number = null;
		String icon = null;

		//whichColor
		if (whichColor == 0){
			color = "\u001B[31m"; //this is Red
		} else if(whichColor ==1) {
			color = "\u001B[32m"; //this is Green
		} else if(whichColor==2){
			color = "\\u001B[35m"; //this is Purple
		}

		//whichBackground
		if (whichBackground == 0){
			background = "\\u001B[43m"; // this is Yellow
		}else if(whichBackground==1){
			background = "\\u001B[46m"; // this is Aqua/Cyan
		}else if(whichBackground==2){
			background = "\\u001B[44m"; // this is Blue
		}

		//whichIcon
		if (whichIcon == 0){
			icon = "x";
		}else if (whichIcon == 1){
			icon = "•";
		} else if (whichIcon == 2) {
			icon = "o";
		}

		number = icon.repeat(groupSize);

		String Card = (color+background+number);

		return "Cards:\n" + Card;
	}
	
}
