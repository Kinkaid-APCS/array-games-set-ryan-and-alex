import java.util.Random;

/**
 * the Card class represents a card in the Set game - it consists 
 * of 1-3 characters (aka icons), which come in 3 varieties. Each of the
 * groups is in one of 3 colors on one of 3 background colors. A card may not be empty.
 *
 * So each card can be represented by four numbers - which icon, how many, color, and background.
 * Each of these numbers has 3 possible values.
 * Question: how many legal combinations are there??
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

	public int getBackground(){
		return whichBackground;
	}
	public int getColor(){
		return whichColor;
	}
	public int getGroupSize(){
		return groupSize;
	}
	public int getIcon(){
		return whichIcon;
	}
	 // TODO: write accessors for all member variables. In this case,
	 //       you shouldn't write modifiers; a Card never changes.



	public String toString() {

		String background = "";
		String color = "";
		String number = "";
		String icon = "";
		String RESET = "\u001B[0m";

			//whichColor
			if (whichColor == 0){
				color += "\u001B[31m"; //this is Red
			} else if(whichColor ==1) {
				color += "\u001B[37m"; //this is White
			} else if(whichColor==2){
				color += "\u001B[35m"; //this is Purple
			}

			//whichBackground
			if (whichBackground == 0){
				background += "\u001B[43m"; // this is Yellow
			}else if(whichBackground==1){
				background += "\u001B[42m"; // this is Green
			}else if(whichBackground==2){
				background += "\u001B[44m"; // this is Blue
			}

			//whichIcon
			if (whichIcon == 0){
				icon += "x";
			}else if (whichIcon == 1){
				icon += "•";
			} else if (whichIcon == 2) {
				icon += "o";
			}
			number = icon.repeat(groupSize);
			return (color+background+number+RESET);
	}
	
}
