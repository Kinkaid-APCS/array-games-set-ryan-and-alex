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

	private boolean isExpanded = false;

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
	public void playGame() {
		int cardA = 15;
		int cardB = 15;
		int cardC = 15;
		Board brd = new Board();
		isPlaying = true;
		System.out.println("Welcome to the game of SET, I am your dealer.");
		while (isPlaying) {
			System.out.println("If you think there are not any matches at any point, input -1");
			System.out.println("I am going to deal 12 cards on to the board...");
			brd.toString();
//---------------------------------------------------------------------------------------------------------------------------------
			System.out.println("Give me the number of the first card!");
			System.out.println("[] [] []");
			cardA = scan.nextInt();


			while (cardA < 0 || cardA > 11) {
				if (cardA == -1) {
					brd.dealThreeCards();
					brd.toString();
					isExpanded = true; //can now pick between 12 and 14
					System.out.println("Give me the number of the first card");
					cardA = scan.nextInt();
					break;
				} else {
					System.out.println("The number must be on the board! Give me the number of the first card!");
					cardA = scan.nextInt();
				}
			}
			if (isExpanded) {
				while (cardA < 0 || cardA > 14) {
					if (cardA == -1) {
						brd.dealThreeCards();
						cardA = scan.nextInt();
					}
					System.out.println("The number must be on the board! Give me the number of the first card!");
					cardA = scan.nextInt();
				}
			}


				System.out.println("[" + brd.getCardAtLoc(cardA) + "] [] []");
				System.out.println("Give me the second card:");
				if (cardA == -1) {
					brd.dealThreeCards();
					brd.toString();
					System.out.println("Give me the number of the second card");
					cardA = scan.nextInt();
				}
				while (cardA < 0) {
					System.out.println("You can not add any more cards!");
					System.out.println("Give me the number of the second card");
					cardA = scan.nextInt();
				}
				cardB = scan.nextInt();
				while (cardA == cardB) {
					System.out.println("You must pick a different card!");
					cardB = scan.nextInt();
				}


				System.out.println("[" + brd.getCardAtLoc(cardA) + "] [" + brd.getCardAtLoc(cardB) + "] []");

				System.out.println("Give me the third card:");
				cardC = scan.nextInt();
				while (cardC == cardB || cardC == cardA) {
					System.out.println("You must pick a different card!");
					cardB = scan.nextInt();
				}
				System.out.println("[" + brd.getCardAtLoc(cardA) + "] [" + brd.getCardAtLoc(cardB) + "] [" + brd.getCardAtLoc(cardC) + "]");
				if (brd.isLegal(brd.getCardAtLoc(cardA), brd.getCardAtLoc(cardB), brd.getCardAtLoc(cardC))) {
					System.out.println("Match!");
					System.out.println("Would you like to keep playing? y/n");
					String playAgain = scan.nextLine();
					if (playAgain.equals("n")) {
						isPlaying = false;
//				brd.removeThreeCards(cardA, cardB, cardC);
					} else {
						System.out.println("Sorry that is not a match! Try again!");
					}


				}
			}
		}
	}