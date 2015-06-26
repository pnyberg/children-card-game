import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	private final int TARGETPLAYER = 10;

	private LinkedList<Minion> minionsOnBoard1;
	private LinkedList<Minion> minionsOnBoard2;

	private LinkedList<PlayCard> cardsInHand1;
	private LinkedList<PlayCard> cardsInHand2;

	private int turn;
	private int playerHealth1;
	private int playerHealth2;

	private int randomizer = 0; // temp -> pre-built-order 

	public TheGame() {
		minionsOnBoard1 = new LinkedList<Minion>();
		minionsOnBoard2 = new LinkedList<Minion>();

		cardsInHand1 = new LinkedList<PlayCard>();
		cardsInHand2 = new LinkedList<PlayCard>();

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
			playMinionFromHand(str[1]);
		} else if (str.length > 1 && str[0].equals("cast")) {
			castSpellFromHand(str);
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
//		int randomizer = (int)(Math.random()*10);
		if (randomizer == 0) {
			addCardToHand(new MonsterCard(MonsterCard.DRAGON_LORD));
		} else if (randomizer == 1) {
			addCardToHand(new SpellCard(SpellCard.DRAGON_POWER));
		} else if (randomizer == 2) {
			addCardToHand(new SpellCard(SpellCard.EMERALD_SCALE));
		} else if (randomizer == 3) {
			addCardToHand(new SpellCard(SpellCard.STAFF_OF_THE_EMPEROR));
		} else {
			addCardToHand(new MonsterCard(MonsterCard.DRAGON_KING));
		}

		randomizer++; // pre-build-order
	}

	public int getAdressingIndex(String raw) {
		int length = raw.length();

		if (length != 2 || raw.charAt(0) != '#') {
			return -1;
		}

		int adressingIndex = Integer.parseInt(raw.substring(1, length));

		return adressingIndex;
	}

	public void playMinionFromHand(String raw) {
		int cardIndex = getAdressingIndex(raw);

		if (cardIndex == -1) {
			System.out.println("Card-choosing command not valid!");
			return;
		}

		PlayCard cardToPlay = getCardFromHand(cardIndex);

		if (cardToPlay == null) {
			// if the cardIndex isn't valid
			return;
		}

		if (cardToPlay instanceof MonsterCard) {
			addMinionToBoard((MonsterCard)cardToPlay);
			removeCardFromHand(cardIndex);
		} else {
			System.out.println("You cannot 'play' " + cardToPlay.getName() + ", this card is a spell!");
		}
	}

	public void castSpellFromHand(String[] str) {
		int cardIndex = getAdressingIndex(str[1]);

		if (cardIndex == -1) {
			System.out.println("Card-choosing command not valid!");
			return;
		}

		PlayCard cardToPlay = getCardFromHand(cardIndex);

		if (cardToPlay == null) {
			// if the cardIndex isn't valid
			return;
		}

		if (cardToPlay instanceof SpellCard) {
			if (!manageSpellEffect((SpellCard)cardToPlay, str)) {
				return;
			}

			System.out.println("Cast " + cardToPlay.getName() + ", it costs " + cardToPlay.getCost() + "!");

			removeCardFromHand(cardIndex);
		} else {
			System.out.println("You cannot 'cast' " + cardToPlay.getName() + ", this card is a minion!");
		}
	}

	public void makeAttack(String attackRaw, String targetRaw) {
		int minionIndex1 = getAdressingIndex(attackRaw);

		if (minionIndex1 == -1) {
			System.out.println("Card-choosing command not valid for Attacker!");
			return;
		}

		if (targetRaw.equals("player")) {
			makeAttack(minionIndex1, TARGETPLAYER);
			return;
		}

		int minionIndex2 = getAdressingIndex(targetRaw);

		if (minionIndex2 == -1) {
			System.out.println("Card-choosing command not valid for Target!");
			return;
		}

		makeAttack(minionIndex1, minionIndex2);
	}

	public void makeAttack(int attackerIndex, int targetIndex) {
		if (targetIndex == TARGETPLAYER) {
			attackEnemyPlayer(attackerIndex);
			return;
		}

		minionDuel(attackerIndex, targetIndex);
	}

	public void minionDuel(int attackerIndex, int targetIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);
		Minion targetMinion = getTarget(targetIndex);

		int damage1 = attackingMinion.getCurrentAttack();
		int damage2 = targetMinion.getCurrentAttack();

		handleDamage(targetMinion, damage1);

		handleDamage(attackingMinion, damage2);

		System.out.println("(Player " + (turn + 1) + " #" + attackerIndex + ")" + attackingMinion.getName() + " is attacking (Player " + ((turn + 1) % 2 + 1) + " #" + attackerIndex + ")" + targetMinion.getName());

		checkDeath(targetIndex, (turn + 1) % 2);

		checkDeath(attackerIndex, turn);

		System.out.println(attackingMinion.getName() + " HP: " + attackingMinion.getCurrentHealth() + " - " + targetMinion.getName() + " HP: " + targetMinion.getCurrentHealth());
	}

	public void handleDamage(Minion minion, int damage) {
		if (!minion.hasDivineShield()) {
			minion.takeDamage(damage);
		}
	}

	public void checkDeath(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);

		if (!minion.isAlive()) {
			removeMinionFromBoard(minionIndex, turnIndex);
			System.out.println("(Player " + (turnIndex + 1) + " #" + minionIndex + ")" + minion.getName() + " died!");
		}
	}

	public void attackEnemyPlayer(int attackerIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);

		int damage = attackingMinion.getCurrentAttack();
		int playerNumber = (turn+1) % 2 + 1;

		System.out.println(attackingMinion.getName() + " is attacking Player " + playerNumber);

		if (turn == 0) {
			playerHealth2 -= damage;
			System.out.println("Player " + playerNumber + " takes " + damage + " damage, has " + playerHealth2 + " left!");
		} else {
			playerHealth1 -= damage;
			System.out.println("Player " + playerNumber + " takes " + damage + " damage, has " + playerHealth1 + " left!");
		}
	}

	public Minion getAttacker(int index) {
		return getMinion(index, turn);
	}

	public Minion getTarget(int index) {
		return getMinion(index, (turn + 1) % 2);
	}

	public Minion getMinion(int index, int turnIndex) {
		LinkedList<Minion> monsterList = getMinionList(turnIndex);

		if (index >= 0 && index < monsterList.size()) {
			return monsterList.get(index);
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
		System.out.println("Player " + (turn + 1) + "'s turn!");
	}

	public void printHelp() {
		System.out.println("Following commands currently exists:");
		System.out.println(" - draw = you draw a new card");
		System.out.println(" - play [adressingIndex] = you play a card from hand, [adressingIndex] is the index of the card (check 'show hand' for indices)");
		System.out.println(" - let [attackerIndex] attack [targetIndex] = your minion, [attackerIndex], attacks a target, which is either 'player' or an enemy minion");
		System.out.println(" - show hand = print the players hands");
		System.out.println(" - show board = print the board");
		System.out.println(" - end turn = end players turn");
		System.out.println(" - exit = exit game");
		System.out.println(" - help = will make you see these rows");
//		System.out.println(" - ");

	}

	public LinkedList<PlayCard> getCardList(int turnIndex) {
		LinkedList<PlayCard> cardList;
		if (turnIndex == 0) {
			cardList = cardsInHand1;
		} else {
			cardList = cardsInHand2;
		}
		return cardList;
	}

	public LinkedList<Minion> getMinionList(int turnIndex) {
		LinkedList<Minion> minionList;
		if (turnIndex == 0) {
			minionList = minionsOnBoard1;
		} else {
			minionList = minionsOnBoard2;
		}
		return minionList;
	}

	public void addCardToHand(PlayCard cardToAdd) {
		LinkedList<PlayCard> cardList = getCardList(turn);

		cardList.add(cardToAdd);
		System.out.println("Draw " + cardList.getLast().getName() + "!");
	}

	public PlayCard getCardFromHand(int index) {
		LinkedList<PlayCard> cardList = getCardList(turn);

		if (index >= 0 && index < cardList.size()) {
			return cardList.get(index);
		}

		System.out.println(index + " is not a valid cardIndex for Player " + ((turn + 1) % 2));

		return null;
	}

	public void removeCardFromHand(int index) {
		LinkedList<PlayCard> cardList = getCardList(turn);

		if (index >= 0 && index < cardList.size()) {
			cardList.remove(index);
			return;
		}

		System.out.println(index + " is not a valid cardIndex for Player " + ((turn + 1) % 2));
	}

	public void addMinionToBoard(MonsterCard monsterCard) {
		Minion minion = monsterCard.toMinion();

		LinkedList<Minion> minionList = getMinionList(turn);

		if (minionList.size() < 7) {
			minionList.add(minion);

			System.out.println("Played " + monsterCard.getName() + ", it costs " + monsterCard.getCost() + "!");
		} else {
			System.out.println("Can't play that minion, your side of the board is full!");
		}
	}

	public void removeMinionFromBoard(int minionIndex, int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		minionList.remove(minionIndex);
	}

	public void printHandInfo(int turnIndex) {
		LinkedList<PlayCard> cardList = getCardList(turnIndex);

		printHandIndexBar(cardList);

		printHandCardNames(turnIndex, cardList);

		printHandCardStats(cardList);
	}

	public void printHandIndexBar(LinkedList<PlayCard> cardList) {
		System.out.print(addSpaces(19));

		int size = cardList.size();

		for (int i = 0 ; i < size ; i++) {
			System.out.print("#" + i + addSpaces(12));
		}
		System.out.println("");
	}

	public void printHandCardNames(int turnIndex, LinkedList<PlayCard> cardList) {
		System.out.print("Cards Player" + (turnIndex + 1) + ": ");

		for (PlayCard card : cardList) {
			int amount = 14 - card.getName().length() + (card.getName().length() > 12 ? card.getName().length()-12 : 0);
			System.out.print(card.getName() + addSpaces(amount));
		}
		System.out.println("");
	}

	public void printHandCardStats(LinkedList<PlayCard> cardList) {
		System.out.print(addSpaces(14));
		for (PlayCard card : cardList) {
			if (card instanceof MonsterCard) {
				System.out.print("(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ") ");
			} else {
				System.out.print(addSpaces(4) + "(C:" + card.getCost() + ")" + addSpaces(5));				
			}
		}

		System.out.println("");
	}

	public void printBoardInfo(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		printBoardIndexBar(minionList);

		printBoardMinionNames(turnIndex, minionList);

		printBoardMinionStats(minionList);
	}

	public void printBoardIndexBar(LinkedList<Minion> minionList) {
		System.out.print(addSpaces(22));

		int size = minionList.size();

		for (int i = 0 ; i < size ; i++) {
			String name = minionList.get(i).getName();
			int amount = 9 + (name.length() > 8 ? name.length()-8 : 0);
			System.out.print("#" + i + addSpaces(amount));
		}
		System.out.println("");
	}

	public void printBoardMinionNames(int turnIndex, LinkedList<Minion> minionList) {
		System.out.print("Monsters Player" + (turnIndex + 1) + ": ");

		for (Minion monster : minionList) {
			int nameLength = monster.getName().length();
			int amount = 14 - nameLength + (nameLength > 12 ? nameLength-12 : 0);
			System.out.print(monster.getName() + addSpaces(amount));
		}

		System.out.println("");
	}

	public void printBoardMinionStats(LinkedList<Minion> minionList) {
		System.out.print(addSpaces(18));

		for (Minion monster : minionList) {
			int nameLength = monster.getName().length();
			int amount = 1 + (nameLength > 8 ? nameLength-8 : 0);
			boolean buffed = monster.isBuffed();
			System.out.print("(A:" + monster.getCurrentAttack() + " H:" + monster.getCurrentHealth() + ")" + (buffed ? "*" : " ") + addSpaces(amount));
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

	public boolean manageSpellEffect(SpellCard card, String[] str) {
		SpellEffect spellEffect = card.getSpellEffect();

		if (spellEffect instanceof SpellEffect_BuffAllOfOneSide) {
			SpellEffect_BuffAllOfOneSide buffAllMinionsEffect = (SpellEffect_BuffAllOfOneSide)spellEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			buffAllMinionsEffect.effect(minionList);
		} else if (spellEffect instanceof SpellEffect_BuffSingleMinionOfOneSide) {
			if (str.length != 4 || !str[2].equals("on")) {
				System.out.println("Card-choosing command not valid for spell!");
				return false;
			}

			int minionIndex = getAdressingIndex(str[3]);

			if (minionIndex == -1) {
				System.out.println("Card-choosing command not valid!");
				return false;
			}

			SpellEffect_BuffSingleMinionOfOneSide buffSingleMinion = (SpellEffect_BuffSingleMinionOfOneSide)spellEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			Minion minion = minionList.get(minionIndex);
			buffSingleMinion.effect(minion);
		} else {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		new TheGame();
	}
}