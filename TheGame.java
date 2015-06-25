import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	private final int TARGETPLAYER = -1;

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
			playCardFromHand(str[1]);
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

	public void playCardFromHand(String raw) {
		int length = raw.length();

		if (length != 2 || raw.charAt(0) != '#') {
			System.out.println("Card-choosing command not valid!");
			return;
		}

		int cardIndex = Integer.parseInt(raw.substring(1, length));
		playCardFromHand(cardIndex);
	}

	public void playCardFromHand(int cardIndex) {
		PlayCard cardToPlay = removeCardFromHand(cardIndex);

		if (cardToPlay == null) {
			// if the cardIndex isn't valid
			return;
		}

		if (cardToPlay instanceof MonsterCard) {
			addMinionToBoard(((MonsterCard)cardToPlay).toMinion());
			System.out.println("Played " + cardToPlay.getName() + ", it costs " + cardToPlay.getCost() + "!");
		} else {
			System.out.println("Cast " + cardToPlay.getName() + ", it costs " + cardToPlay.getCost() + "!");
		}
	}

	public void makeAttack(String attackRaw, String targetRaw) {
		int attackLength = attackRaw.length();
		int targetLength = targetRaw.length();

		if (attackLength != 2 || attackRaw.charAt(0) != '#') {
			System.out.println("Card-choosing command not valid for Attacker!");
			return;
		}

		int cardIndex1 = Integer.parseInt(attackRaw.substring(1, attackLength));

		if (targetRaw.equals("player")) {
			makeAttack(cardIndex1, TARGETPLAYER);
			return;
		}

		if (targetLength != 2 || targetRaw.charAt(0) != '#') {
			System.out.println("Card-choosing command not valid for Target!");
			return;
		}

		int cardIndex2 = Integer.parseInt(targetRaw.substring(1, targetLength));
		makeAttack(cardIndex1, cardIndex2);
	}

	public void makeAttack(int attackerIndex, int targetIndex) {
		if (targetIndex == TARGETPLAYER) {
			attackEnemyPlayer(attackerIndex);
			return;
		}

		minionDuel(attackerIndex, targetIndex);
	}

	public void minionDuel(int attackerIndex, int targetIndex) {
		/* HERE */
		Minion attackingMinion = getAttacker(attackerIndex);
		Minion targetMinion = getTarget(targetIndex);

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
			removeMinionFromBoard(targetIndex, (turn + 1) % 2);
			System.out.println(targetMinion.getName() + " died!");
		}

		if (!attackingMinion.isAlive()) {
			removeMinionFromBoard(attackerIndex, turn);
			System.out.println(attackingMinion.getName() + " died!");
		}

		System.out.println(attackingMinion.getName() + " HP: " + attackingMinion.getCurrentHealth() + " - " + targetMinion.getName() + " HP: " + targetMinion.getCurrentHealth());
	}

	public void attackEnemyPlayer(int attackerIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);

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

	public Minion getAttacker(int index) {
		return getMinion(index, turn);
	}

	public Minion getTarget(int index) {
		return getMinion(index, (turn + 1) % 2);
	}

	public Minion getMinion(int index, int turnIndex) {
		if (turnIndex == 0) {
			if (index >= 0 && index < monstersPlayer1.size()) {
				return monstersPlayer1.get(index);
			}
		} else {
			if (index >= 0 && index < monstersPlayer1.size()) {
				return monstersPlayer1.get(index);
			}
		}

		System.out.println(index + " is not a valid boardIndex for Player " + ((turnIndex + 1 ) % 2));

		return null;
	}

	public void showHand() {
		System.out.println("----- Hand -----");

		printHandInfo(0);

		printHandInfo(1);
	}

	public void showBoard() {
		System.out.println("Player1 Health: " + playerHealth1);
		System.out.println("----- BOARD -----");

		printBoardInfo(0);

		printBoardInfo(1);

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
		System.out.println(" - play [cardIndex] = you play a card from hand, [cardIndex] is the index of the card (check 'show hand' for indices)");
		System.out.println(" - let [attackerIndex] attack [targetIndex] = your minion, [attackerIndex], attacks a target, which is either 'player' or an enemy minion");
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

	public PlayCard removeCardFromHand(int index) {
		if (turn == 0) {
			if (index >= 0 && index < cardHand1.size()) {
				return cardHand1.remove(index);
			}
		} else {
			if (index >= 0 && index < cardHand2.size()) {
				return cardHand2.remove(index);
			}
		}

		System.out.println(index + " is not a valid cardIndex for Player " + ((turn + 1 ) % 2));

		return null;
	}

	public void addMinionToBoard(Minion minion) {
		if (turn == 0) {
			monstersPlayer1.add(minion);
		} else {
			monstersPlayer2.add(minion);
		}
	}

	public void removeMinionFromBoard(int minionIndex, int turnIndex) {
		if (turnIndex == 0) {
			monstersPlayer1.remove(minionIndex);
		} else {
			monstersPlayer2.remove(minionIndex);
		}
	}

	public void printHandInfo(int playerIndex) {
		printHandIndexBar(playerIndex);

		printHand(playerIndex);
	}

	public void printHandIndexBar(int playerIndex) {
		System.out.print(addSpaces(19));

		int size;

		if (playerIndex == 0) {
			size = cardHand1.size();
		} else {
			size = cardHand2.size();			
		}

		for (int i = 0 ; i < size ; i++) {
			System.out.print("#" + i + addSpaces(12));
		}
		System.out.println("");
	}

	public void printHand(int playerIndex) {
		System.out.print("Cards Player" + (playerIndex + 1) + ": ");
		LinkedList<PlayCard> playCardList;

		if (playerIndex == 0) {
			playCardList = cardHand1;
		} else {
			playCardList = cardHand2;
		}

		for (PlayCard card : playCardList) {
			int amount = 14 - card.getName().length() + (card.getName().length() > 12 ? card.getName().length()-12 : 0);
			System.out.print(card.getName() + addSpaces(amount));
		}

		System.out.print('\n' + addSpaces(14));
		for (PlayCard card : playCardList) {
			if (card instanceof MonsterCard) {
				System.out.print("(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ") ");
			} else {
				System.out.print(addSpaces(4) + "(C:" + card.getCost() + ")" + addSpaces(5));				
			}
		}

		System.out.println("");
	}

	public void printBoardInfo(int playerIndex) {
		printBoardIndexBar(playerIndex);

		printBoard(playerIndex);
	}

	public void printBoardIndexBar(int playerIndex) {
		System.out.print(addSpaces(21));

		int size;

		if (playerIndex == 0) {
			size = monstersPlayer1.size();
		} else {
			size = monstersPlayer2.size();			
		}

		for (int i = 0 ; i < size ; i++) {
			System.out.print("#" + i + addSpaces(9));
		}
		System.out.println("");
	}

	public void printBoard(int playerIndex) {
		System.out.print("Monsters Player" + (playerIndex + 1) + ": ");
		LinkedList<Minion> monsterList;

		if (playerIndex == 0) {
			monsterList = monstersPlayer1;
		} else {
			monsterList = monstersPlayer2;
		}

		for (Minion monster : monsterList) {
			System.out.print(monster.getName() + " ");
		}

		System.out.print('\n' + addSpaces(18));

		for (Minion monster : monsterList) {
			System.out.print("(A:" + monster.getCurrentAttack() + " H:" + monster.getCurrentHealth() + ")" + addSpaces(2));
		}
		System.out.println("");
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