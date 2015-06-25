import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	private LinkedList<Minion> monstersPlayer1;
	private LinkedList<Minion> monstersPlayer2;

	private LinkedList<PlayCard> cardHand1;
	private LinkedList<PlayCard> cardHand2;

	private int turn;
	private int playerHealth1;
	private int playerHealth2;

	public TheGame() {
		monstersPlayer1 = new LinkedList<Minion>();
		monstersPlayer2 = new LinkedList<Minion>();

		cardHand1 = new LinkedList<PlayCard>();
		cardHand2 = new LinkedList<PlayCard>();

		turn = 0;
		playerHealth1 = 30;
		playerHealth2 = 30;

		start();
	}

	public void start() {
		System.out.println("");
		System.out.println("Welcome to A-Childrens-Card-Game");
		System.out.println("If help is needed, please type \"help\"");
		System.out.println("");
		System.out.println("Player " + (turn+1) + " starts!");
		System.out.print("Command: ");

		Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
        	String command = sc.nextLine();
        	handleCommand(command);
        	System.out.print('\n' + "Command: ");
        }
	}

	public void handleCommand(String command) {
		String[] str = command.split(" ");

		System.out.println();

		if (str.length == 1 && str[0].equals("draw")) {
			drawCard();
		} else if (str.length == 2 && str[0].equals("play")) {
			playCard(str[1]);
		} else if (str.length == 4 && str[0].equals("let") && str[2].equals("attack")) {
			makeAttack(str[1], str[3]);
		} else if (str.length == 2 && str[0].equals("show") && str[1].equals("hand")) {
			showHand();
		} else if (str.length == 2 && str[0].equals("show") && str[1].equals("board")) {
			showBoard();
		} else if (str.length == 2 && str[0].equals("end") && str[1].equals("turn")) {
			endTurn();
		} else if (str.length == 1 && str[0].equals("help")) {
			printHelp();
		} else if (str.length == 1 && str[0].equals("exit")) {
			System.out.println("Thanks for playing! Good bye!");
			System.out.println("");
			System.exit(0);
		} else {
			System.out.println("Not a command: " + command);
		}
	}

	public void drawCard() {
		int randomizer = (int)(Math.random()*10);
		if (randomizer < 3) {
			addCardToHand(new MonsterCard("DragonLord", 1, 1, 1));
		} else if (randomizer < 7) {
			addCardToHand(new SpellCard("DragonPower", 2));
		} else {
			addCardToHand(new MonsterCard("DragonKing", 2, 2, 2));
		}
	}

	public void playCard(String cardName) {
		PlayCard cardToPlay = removeCardFromHand(cardName);

		if (cardToPlay == null) {
			System.out.println("You do not have " + cardName + " in your hand!");
			return;
		}

		if (cardToPlay instanceof MonsterCard) {
			addMinionToBoard(((MonsterCard)cardToPlay).toMinion());
			System.out.println("Played " + cardToPlay.getName() + "!");
		} else {
			System.out.println("Cast " + cardToPlay.getName() + "!");
		}
	}

	public void makeAttack(String attacker, String target) {
		Minion attackingMinion = getAttacker(attacker);
		if (attackingMinion == null) {
			System.out.println("The 'attacker' doesn't exist!");
			return;
		}

		if (target.equals("player")) {
			attackEnemyPlayer(attackingMinion);
			return;
		}

		Minion targetMinion = getTarget(target);

		if (targetMinion == null) {
			System.out.println("The 'target' doesn't exist!");
			return;
		}

		minionDuel(attackingMinion, targetMinion);
	}

	public void minionDuel(Minion attackingMinion, Minion targetMinion) {
		int damage1 = attackingMinion.getCurrentAttack();
		int damage2 = targetMinion.getCurrentAttack();

		if (!targetMinion.hasDivineShield()) {
			targetMinion.takeDamage(damage1);
		}

		if (!attackingMinion.hasDivineShield()) {
			attackingMinion.takeDamage(damage2);
		}

		System.out.println(attackingMinion.getName() + " is attacking " + targetMinion.getName());

		if (!targetMinion.isAlive()) {
			removeMinionFromBoard(targetMinion, (turn + 1) % 2);
			System.out.println(targetMinion.getName() + " died!");
		}

		if (!attackingMinion.isAlive()) {
			removeMinionFromBoard(attackingMinion, turn);
			System.out.println(attackingMinion.getName() + " died!");
		}

		System.out.println(attackingMinion.getName() + " HP: " + attackingMinion.getCurrentHealth() + " - " + targetMinion.getName() + " HP: " + targetMinion.getCurrentHealth());
	}

	public void attackEnemyPlayer(Minion attackingMinion) {
		int damage = attackingMinion.getCurrentAttack();
		int health;

		if (turn == 0) {
			playerHealth2 -= damage;
			health = playerHealth2;
		} else {
			playerHealth1 -= damage;
			health = playerHealth1;
		}
		System.out.println(attackingMinion.getName() + " is attacking Player " + (((turn+1) % 2) + 1));
		System.out.println("Player " + (((turn+1) % 2) + 1) + " takes " + damage + " damage, has " + health + " left!");
	}

	public Minion getAttacker(String name) {
		return getMinion(name, turn);
	}

	public Minion getTarget(String name) {
		return getMinion(name, (turn + 1) % 2);
	}

	public Minion getMinion(String name, int turn) {
		if (turn == 0) {
			for (Minion monster : monstersPlayer1) {
				if (monster.getName().equals(name)) {
					return monster;
				}
			}
		} else {
			for (Minion monster : monstersPlayer2) {
				if (monster.getName().equals(name)) {
					return monster;
				}
			}
		}

		return null;
	}

	public void showHand() {
		System.out.println("----- Hand -----");
		System.out.print("Cards Player1: ");
		for (PlayCard card : cardHand1) {
			int amount = 15 - card.getName().length() + (card.getName().length() > 12 ? card.getName().length()-12 : 0);
			System.out.print(card.getName() + addSpaces(amount));
		}
		System.out.print('\n' + addSpaces(14));
		for (PlayCard card : cardHand1) {
			if (card instanceof MonsterCard) {
				System.out.print("(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ") ");
			} else {
				System.out.print(addSpaces(4) + "(C:" + card.getCost() + ")" + addSpaces(5));				
			}
		}
		System.out.print('\n' + "Cards Player2: ");
		for (PlayCard card : cardHand2) {
			int amount = 15 - card.getName().length() + (card.getName().length() > 12 ? card.getName().length()-12 : 0);
			System.out.print(card.getName() + addSpaces(amount));
		}
		System.out.print('\n' + addSpaces(14));
		for (PlayCard card : cardHand2) {
			if (card instanceof MonsterCard) {
				System.out.print("(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ") ");
			} else {
				System.out.print(addSpaces(4) + "(C:" + card.getCost() + ")" + addSpaces(5));				
			}
		}
		System.out.println("");
	}

	public void showBoard() {
		System.out.println("Player1 Health: " + playerHealth1);
		System.out.println("----- BOARD -----");
		System.out.print("Monsters Player1: ");
		for (Minion monster : monstersPlayer1) {
			System.out.print(monster.getName() + " ");
		}
		System.out.print('\n' + addSpaces(18));
		for (Minion monster : monstersPlayer1) {
			System.out.print("(A:" + monster.getCurrentAttack() + " H:" + monster.getCurrentHealth() + ") ");
		}
		System.out.print('\n' + "Monsters Player2: ");
		for (Minion monster : monstersPlayer2) {
			System.out.print(monster.getName() + " ");
		}
		System.out.print('\n' + addSpaces(18));
		for (Minion monster : monstersPlayer2) {
			System.out.print("(A:" + monster.getCurrentAttack() + " H:" + monster.getCurrentHealth() + ") ");
		}
		System.out.println("");
		System.out.println("----- BOARD -----");
		System.out.println("Player2 Health: " + playerHealth2);
	}

	public void endTurn() {
		turn = (turn + 1) % 2;
		System.out.println("Player " + (turn+1) + "'s turn!");
	}

	public void printHelp() {
		System.out.println("Following commands currently exists:");
		System.out.println(" - draw = you draw a new card");
		System.out.println(" - play [name] = you play a card from hand, [name] is the name of the card");
		System.out.println(" - let [attacker] attack [target] = your minion, [attacker], attacks a target, which is either 'player' or an enemy minion");
		System.out.println(" - show hand = print the players hands");
		System.out.println(" - show board = print the board");
		System.out.println(" - end turn = end players turn");
		System.out.println(" - exit = exit game");
		System.out.println(" - help = will make you see these rows");
//		System.out.println(" - ");

	}

	public void addCardToHand(PlayCard cardToAdd) {
		if (turn == 0) {
			cardHand1.add(cardToAdd);
			System.out.println("Draw " + cardHand1.getLast().getName() + "!");
		} else {
			cardHand2.add(cardToAdd);
			System.out.println("Draw " + cardHand2.getLast().getName() + "!");
		}
	}

	public PlayCard removeCardFromHand(String name) {
		if (turn == 0) {
			for (int i = 0 ; i < cardHand1.size() ; i++) {
				if (cardHand1.get(i).getName().equals(name)) {
					return cardHand1.remove(i);
				}
			}
		} else {
			for (int i = 0 ; i < cardHand2.size() ; i++) {
				if (cardHand2.get(i).getName().equals(name)) {
					return cardHand2.remove(i);
				}
			}
		}
		return null;
	}

	public void addMinionToBoard(Minion minion) {
		if (turn == 0) {
			monstersPlayer1.add(minion);
		} else {
			monstersPlayer2.add(minion);
		}
	}

	public void removeMinionFromBoard(Minion minion, int turnIndex) {
		if (turnIndex == 0) {
			monstersPlayer1.remove(minion);
		} else {
			monstersPlayer2.remove(minion);
		}
	}

	public String addSpaces(int number) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0 ; i < number ; i++) {
			builder.append(" ");
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		new TheGame();
	}
}