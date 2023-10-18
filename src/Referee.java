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
		Deck cards = new Deck();

	}
	
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{
		isPlaying = true;
		System.out.println("Welcome to the game of SET, I am your dealer.");
		while (isPlaying){
			System.out.println("You are now playing!");
			System.out.println("I am going to deal 12 cards on to the board...");
			System.out.println("Would you like to keep playing? y/n");
			String playAgain = scan.nextLine();
			if (playAgain.equals("n")){
				isPlaying = false;
			}

		}
		// TODO: write the Referee's playGame method.
	}
}
