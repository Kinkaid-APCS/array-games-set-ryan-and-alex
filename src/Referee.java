import java.util.Scanner;
/**
 * The Referee class keeps track of a Board, which in turn 
 * holds a Deck of Cards. The Referee is responsible for communicating 
 * the player and the board to make sure that the board is displayed 
 * regularly, the user is asked for "SET"s of cards, and the board is
 * consulted on whether the user is correct before removing them.
 * If the board is empty, or the player gives up, the player can play again.
 * Advanced: if the player is stumped with 12 cards, give him/her the
 * chance to add three more cards.
 */
public class Referee {
	// TODO: decide which private member variables the Referee class needs and declare them here.
	private boolean isPlaying;

	private Scanner scan = new Scanner(System.in);
	/**
	 * constructor
	 */
	// TODO: write the Referee's constructor method.
	public Referee(){

	}
	
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{
		Board brd = new Board();
		isPlaying = true;
		System.out.println("Welcome to the game of SET, I am your dealer.");
		while (isPlaying){
			System.out.println("You are now playing!");
//			brd.getCardAtLoc(11);

			System.out.println("I am going to deal 12 cards on to the board...");
			brd.toString();

			System.out.println("If you think there are no matches, type -1. Otherwise, give me the number of the first card\n[] [] []");
			int cardA = scan.nextInt();
			if (cardA == -1) {
				brd.dealThreeCards();
				brd.toString();
				System.out.println("Give me the number of the first card");
                cardA = scan.nextInt();
			}
			while (cardA < 0) {
				System.out.println("You can not add any more cards!");
				System.out.println("Give me the number of the first card");
				cardA = scan.nextInt();
			}

			System.out.println("["+brd.getCardAtLoc(cardA)+"] [] []");
			System.out.println("If you think there are no matches, type -1. Give me the second card:");
			if (cardA == -1) {
				brd.dealThreeCards();
				brd.toString();
				System.out.println("Give me the number of the first card");
				cardA = scan.nextInt();
			}
			while (cardA < 0) {
				System.out.println("You can not add any more cards!");
				System.out.println("Give me the number of the first card");
				cardA = scan.nextInt();
			}
			int cardB = scan.nextInt();
			while (cardA == cardB){
				System.out.println("You must pick a different card!");
				cardB = scan.nextInt();
			}


			System.out.println("["+brd.getCardAtLoc(cardA)+"] ["+brd.getCardAtLoc(cardB)+"] []");

			System.out.println("Give me the third card:");
			int cardC = scan.nextInt();
			while (cardC == cardB || cardC == cardA){
				System.out.println("You must pick a different card!");
				cardB = scan.nextInt();
			}

			brd.isLegal(brd.getCardAtLoc(cardA), brd.getCardAtLoc(cardB),brd.getCardAtLoc(cardC));


			System.out.println("Would you like to keep playing? y/n");
			String playAgain = scan.nextLine();
			if (playAgain.equals("n")){
				isPlaying = false;
			}
		}
	}
}