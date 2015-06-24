import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	private LinkedList<String> monstersPlayer1;
	private LinkedList<String> monstersPlayer2;

	private LinkedList<String> cardHand1;
	private LinkedList<String> cardHand2;

	public TheGame() {
		monstersPlayer1 = new LinkedList<String>();
		monstersPlayer2 = new LinkedList<String>();

		cardHand1 = new LinkedList<String>();
		cardHand2 = new LinkedList<String>();

		System.out.print('\n' + "Command: ");

		Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
        	String s = sc.nextLine();
        	command(s);
        	System.out.print('\n' + "Command: ");
        }
	}

	public void command(String s) {
		String[] str = s.split(" ");

		System.out.println();

		if (str.length > 0 && str[0].equals("draw")) {
			cardHand1.add("DragonLord");
			System.out.println("Draw " + cardHand1.getLast() + "!");
		} else if (str.length > 0 && str[0].equals("play")) {
			monstersPlayer1.add(str[1]);
			System.out.println("Played " + str[1] + "!");
		} else if(str.length > 1 && str[0].equals("show") && str[1].equals("hand")) {
			System.out.println("----- Hand -----");
			System.out.print("Cards Player1: ");
			for (String card : cardHand1) {
				System.out.print(card + " ");
			}
			System.out.print('\n' + "Cards Player2: ");
			for (String card : cardHand2) {
				System.out.print(card + " ");
			}
			System.out.println("");
		} else if(str.length > 1 && str[0].equals("show") && str[1].equals("board")) {
			System.out.println("----- BOARD -----");
			System.out.print("Monsters Player1: ");
			for (String monster : monstersPlayer1) {
				System.out.print(monster + " ");
			}
			System.out.print('\n' + "Monsters Player2: ");
			for (String monster : monstersPlayer2) {
				System.out.print(monster + " ");
			}
			System.out.println("");
		} else {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		new TheGame();
	}
}