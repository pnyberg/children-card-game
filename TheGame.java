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

	private boolean handlingBattleCry;

	private int playedMinionType;
	private int minionTriedToPlayCardIndex;

	private Minion minionTriedToPlay;

	private LinkedList<Minion> minionTempList1;
	private LinkedList<Minion> minionTempList2;


	private int randomizer = 0; // temp -> pre-built-order 

	public TheGame() {
		minionsOnBoard1 = new LinkedList<Minion>();
		minionsOnBoard2 = new LinkedList<Minion>();

		cardsInHand1 = new LinkedList<PlayCard>();
		cardsInHand2 = new LinkedList<PlayCard>();

		turn = 0;
		playerHealth1 = 30;
		playerHealth2 = 30;

		handlingBattleCry = false;
		playedMinionType = -1;
		minionTriedToPlay = null;
		minionTriedToPlayCardIndex = -1;

		minionTempList1 = new LinkedList<Minion>();
		minionTempList2 = new LinkedList<Minion>();

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

		if (handlingBattleCry) {
			handleBattleCryCommands(str);
		} else {
			handleBasicCommands(str);
		}
	}

	public void handleBasicCommands(String[] str) {
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
			String command = arrayToText(str);
			System.out.println("Not a command: " + command);
		}
	}

	public String arrayToText(String[] str) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0 ; i < str.length ; i++) {
			builder.append(str[i]);
			if (i < (str.length)) {
				builder.append(" ");
			}
		}

		return builder.toString();
	}

	public void handleBattleCryCommands(String[] str) {
		if (str.length == 2 && str[0].equals("show") && str[1].equals("board")) {
			showBoard();
			return;
		} else if (str.length == 2 && str[0].equals("show") && str[1].equals("hand")) {
			showHand();
			return;
		} else if (str.length == 1 && str[0].equals("cancel")) {
			handlingBattleCry = false;

			System.out.println("Cancelling, minion will return to hand!");
			return;
		}

		// necessary?
		SpellEffect battleCryEffect = minionTriedToPlay.getBattleCryEffect();
		if (battleCryEffect == null) {
			return;
		}

		if (battleCryEffect instanceof BuffSingleMinion) {
			if (str.length != 2 || !str[0].equals("target")) {
				System.out.println("Target-choosing command not valid for battlecry!");
				return;
			}

			int minionIndex = getAdressingIndex(str[1]);

			if (minionIndex == -1) {
				System.out.println("Target-choice not valid!");
				return;
			}

			BuffSingleMinion buffSingleMinion = (BuffSingleMinion)battleCryEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			Minion minion = minionList.get(minionIndex);
			buffSingleMinion.effect(minion);

			System.out.println(minion.getName() + " got buffed!");
			handlingBattleCry = false;

			minionList.add(minionTriedToPlay);

			MonsterCard cardTriedToPlay = (MonsterCard)getCardFromHand(minionTriedToPlayCardIndex);

			removeCardFromHand(minionTriedToPlayCardIndex);

			System.out.println("Played " + cardTriedToPlay.getName() + ", it costs " + cardTriedToPlay.getCost() + "!");
		} else if (battleCryEffect instanceof PickUpMinion) {
			if (str.length != 3 || !str[0].equals("pick") || !str[1].equals("up")) {
				System.out.println("Target-choosing command not valid for battlecry! (should be 'pick up [index]')");
				return;
			}

			int minionIndex = getAdressingIndex(str[2]);

			if (minionIndex == -1) {
				System.out.println("Target-choice not valid!");
				return;
			}

			PickUpMinion pickUpMinion = (PickUpMinion)battleCryEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			Minion minion = minionList.get(minionIndex);
			LinkedList<PlayCard> cardHand = getCardList(turn);

			pickUpMinion.effect(minion, cardHand);
			removeMinionFromBoard(minionIndex, turn);

			System.out.println(minion.getName() + " got picked up!");
			handlingBattleCry = false;

			minionList.add(minionTriedToPlay);

			MonsterCard cardTriedToPlay = (MonsterCard)getCardFromHand(minionTriedToPlayCardIndex);

			removeCardFromHand(minionTriedToPlayCardIndex);

			System.out.println("Played " + cardTriedToPlay.getName() + ", it costs " + cardTriedToPlay.getCost() + "!");
		} else if (battleCryEffect instanceof HealMinion) {
			if (str.length != 2 || !str[0].equals("heal")) {
				System.out.println("Target-choosing command not valid for battlecry! (should be 'heal [index]')");
				return;
			}

			int minionIndex = getAdressingIndex(str[1]);

			if (minionIndex == -1) {
				System.out.println("Target-choice not valid!");
				return;
			}

			HealMinion healMinion = (HealMinion)battleCryEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			Minion minion = minionList.get(minionIndex);
			healMinion.effect(minion);

			System.out.println(minion.getName() + " got healed!");
			handlingBattleCry = false;

			minionList.add(minionTriedToPlay);

			MonsterCard cardTriedToPlay = (MonsterCard)getCardFromHand(minionTriedToPlayCardIndex);

			removeCardFromHand(minionTriedToPlayCardIndex);

			System.out.println("Played " + cardTriedToPlay.getName() + ", it costs " + cardTriedToPlay.getCost() + "!");
		}
	}

	public void drawCard() {
//		int randomizer = (int)(Math.random()*10);
		if (randomizer == 0) {
			addCardToHand(new MonsterCard(MonsterCard.NOVICE_ENGINEER));
		} else if (randomizer == 1) {
			addCardToHand(new MonsterCard(MonsterCard.LOOT_HOARDER));
		} else if (randomizer == 2) {
			addCardToHand(new MonsterCard(MonsterCard.SLUDGE_BELCHER));
		} else if (randomizer == 3) {
			addCardToHand(new SpellCard(SpellCard.STAFF_OF_THE_EMPEROR));
		} else if (randomizer == 4) {
			addCardToHand(new SpellCard(SpellCard.FEATHER_OF_THE_FEATHER));
		} else if (randomizer == 5) {
			addCardToHand(new SpellCard(SpellCard.DRAGONS_BLOOD));
		} else if (randomizer == 6) {
			addCardToHand(new MonsterCard(MonsterCard.PRINCE_CRUSH));
		} else if (randomizer == 7) {
			addCardToHand(new SpellCard(SpellCard.DRAGON_POWER));
		} else if (randomizer == 8) {
			addCardToHand(new SpellCard(SpellCard.EMERALD_SCALE));
		} else if (randomizer == 9) {
			addCardToHand(new MonsterCard(MonsterCard.SORCERERS_DRAKE));
		} else if (randomizer == 10) {
			addCardToHand(new MonsterCard(MonsterCard.DISPATCHING_DRAKE));
		} else if (randomizer == 11) {
			addCardToHand(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
		} else if (randomizer == 12) {
			addCardToHand(new MonsterCard(MonsterCard.DRAGON_KING));
		} else if (randomizer == 13) {
			addCardToHand(new MonsterCard(MonsterCard.DRAGON_LORD));
		} else {
			addCardToHand(new MonsterCard(MonsterCard.DRAGON_LIEUTENANT));
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
			if (!handlingBattleCry) {
				removeCardFromHand(cardIndex);
			} else {
				minionTriedToPlayCardIndex = cardIndex;
			}
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
		if (!validTarget(targetIndex)) {
			System.out.println("You cannot attack that, you have a taunt in the way!");
			return;
		}

		if (targetIndex == TARGETPLAYER) {
			attackEnemyPlayer(attackerIndex);
			return;
		}

		minionDuel(attackerIndex, targetIndex);
	}

	public boolean validTarget(int targetIndex) {
		LinkedList<Minion> minionList = getMinionList((turn + 1) % 2);

		if (targetIndex != TARGETPLAYER && minionList.get(targetIndex).hasTaunt()) {
			return true;
		}

		for (Minion minion : minionList) {
			if (minion.hasTaunt())
				return false;
		}

		return true;
	}

	public void minionDuel(int attackerIndex, int targetIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);
		Minion targetMinion = getTarget(targetIndex);

		if (!attackingMinion.canAttack()) {
			System.out.println(attackingMinion.reasonForNotAttacking());
			return;
		}

		int damage1 = attackingMinion.attack();
		int damage2 = targetMinion.getCurrentAttack();

		handleDamage(targetMinion, damage1);

		handleDamage(attackingMinion, damage2);

		System.out.println("(Player " + (turn + 1) + " #" + attackerIndex + ")" + attackingMinion.getName() + " is attacking (Player " + ((turn + 1) % 2 + 1) + " #" + attackerIndex + ")" + targetMinion.getName());

		checkDeath(targetIndex, (turn + 1) % 2);

		checkDeath(attackerIndex, turn);

		System.out.println(attackingMinion.getName() + " HP: " + attackingMinion.getCurrentHealth() + " - " + targetMinion.getName() + " HP: " + targetMinion.getCurrentHealth());
	}

	public void handleDamage(Minion minion, int damage) {
		minion.handleDamage(damage);
	}

	public void checkDeath(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);

		if (!minion.isAlive()) {
			manageDeathRattle(minion, turnIndex);
			removeMinionFromBoard(minionIndex, turnIndex);
			System.out.println("(Player " + (turnIndex + 1) + " #" + minionIndex + ")" + minion.getName() + " died!");

			addSummonedMinions(turn);
			addSummonedMinions((turn + 1) % 2);
		}
	}

	public void attackEnemyPlayer(int attackerIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);

		if (!attackingMinion.canAttack()) {
			System.out.println(attackingMinion.reasonForNotAttacking());
			return;
		}

		int damage = attackingMinion.attack();
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
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		if (index >= 0 && index < minionList.size()) {
			return minionList.get(index);
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
		handleEndTurnActions(turn);

		turn = (turn + 1) % 2;
		System.out.println("Player " + (turn + 1) + "'s turn!");

		prepareTurn(turn);
	}

	public void prepareTurn(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turn);

		for (Minion minion : minionList) {
			minion.prepareMinion();
		}
	}

	public void handleEndTurnActions(int turnIndex) {
		for (Minion minion : minionsOnBoard1) {
			minion.endTurnAction();
		}
		for (Minion minion : minionsOnBoard2) {
			minion.endTurnAction();
		}
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

	public LinkedList<Minion> getTempMinionList(int turnIndex) {
		LinkedList<Minion> tempMinionList;
		if (turnIndex == 0) {
			tempMinionList = minionTempList1;
		} else {
			tempMinionList = minionTempList2;
		}
		return tempMinionList;
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

	public void manageBattleCry(Minion minion, int turnIndex) {
		playedMinionType = minion.getType();
		minionTriedToPlay = minion;

		SpellEffect battleCryEffect = minion.getBattleCryEffect();

		if (battleCryEffect instanceof BuffSingleMinion) {
			handlingBattleCry = true;

			System.out.println("Which minion do you want to target?");
		} else if (battleCryEffect instanceof SummonMinions) {
			SummonMinions summonMinions = (SummonMinions)battleCryEffect;
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonMinions.effect(friendlyPlayerMinionTempList, enemyPlayerMinionTempList);
		} else if (battleCryEffect instanceof PickUpMinion) {
			handlingBattleCry = true;

			System.out.println("Which minion do you want to pick up?");
		} else if (battleCryEffect instanceof HealMinion) {
			handlingBattleCry = true;

			System.out.println("Which minion do you want to heal?");
		} else if (battleCryEffect instanceof DrawCards) {
			DrawCards drawCards = (DrawCards)battleCryEffect;
			LinkedList<PlayCard> cardHand = getCardList(turnIndex);
			LinkedList<PlayCard> deck = new LinkedList<PlayCard>();
			deck.add(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
			deck.add(new MonsterCard(MonsterCard.DRAGON_LIEUTENANT));
			deck.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));

			drawCards.effect(cardHand, deck);
		}
	}

	public void manageDeathRattle(Minion minion, int turnIndex) {
		SpellEffect deathRattleEffect = minion.getDeathRattleEffect();

		if (deathRattleEffect instanceof BuffSingleMinion) {
			// nothing yet
		} else if (deathRattleEffect instanceof SummonMinions) {
			SummonMinions summonMinions = (SummonMinions)deathRattleEffect;
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonMinions.effect(friendlyPlayerMinionTempList, enemyPlayerMinionTempList);
		} else if (deathRattleEffect instanceof DrawCards) {
			DrawCards drawCards = (DrawCards)deathRattleEffect;
			LinkedList<PlayCard> cardHand = getCardList(turnIndex);
			LinkedList<PlayCard> deck = new LinkedList<PlayCard>();
			deck.add(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
			deck.add(new MonsterCard(MonsterCard.DRAGON_LIEUTENANT));
			deck.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));

			drawCards.effect(cardHand, deck);
		}
	}

	public void addMinionToBoard(MonsterCard monsterCard) {
		LinkedList<Minion> minionsOnBoardList = getMinionList(turn);

		if (minionsOnBoardList.size() < 7) {
			Minion minion = monsterCard.toMinion();

			manageBattleCry(minion, turn);

			if (handlingBattleCry) {
				return;
			}

			minionsOnBoardList.add(minion);

			addSummonedMinions(turn);
			addSummonedMinions((turn + 1) % 2);

			System.out.println("Played " + monsterCard.getName() + ", it costs " + monsterCard.getCost() + "!");
		} else {
			System.out.println("Can't play that minion, your side of the board is full!");
		}
	}

	public void addSummonedMinions(int turnIndex) {
		LinkedList<Minion> minionsOnBoard = getMinionList(turnIndex);
		LinkedList<Minion> minionTempList = getTempMinionList(turnIndex);

		if (!minionTempList.isEmpty()) {
			while(!minionTempList.isEmpty() && minionsOnBoard.size() < 7) {
				Minion tempMinion = minionTempList.poll();
				minionsOnBoard.add(tempMinion);
				System.out.println(tempMinion.getName() + " got summoned!");
			}

			minionTempList.clear();
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
		System.out.print(addSpaces(15));

		int size = cardList.size();

		for (int i = 0 ; i < size ; i++) {
			int lengthDiff = cardList.get(i).getName().length() - 2;
			System.out.print(addSpaces(lengthDiff / 2 + lengthDiff % 2) + "#" + i + addSpaces(lengthDiff / 2 + 2));
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
		System.out.print(addSpaces(15));
		for (PlayCard card : cardList) {
			if (card instanceof MonsterCard) {
				System.out.print("(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ") ");
			} else {
				int lengthDiff = card.getName().length() - 5;
				System.out.print(addSpaces(lengthDiff / 2) + "(C:" + card.getCost() + ")" + addSpaces(lengthDiff / 2 + lengthDiff % 2 + 2));
			}
		}

		System.out.println("");
	}

	public void printBoardInfo(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		printBoardIndexBar(minionList);

		printBoardMinionNames(turnIndex, minionList);

		printBoardMinionStats(minionList);

		if (!minionList.isEmpty()) {
			printBoardMinionEffects(minionList);
		}
	}

	public void printBoardIndexBar(LinkedList<Minion> minionList) {
		System.out.print(addSpaces(19));

		int size = minionList.size();

		for (int i = 0 ; i < size ; i++) {
			int nameLength = minionList.get(i).getName().length();
			int preAmount = 4 + (nameLength > 10 ? (nameLength - 9) / 2 : 0);
			int postAmount = 6 + (nameLength > 9 ? (nameLength - 9) / 2 + (nameLength - 9) % 2 : 0);
			System.out.print(addSpaces(preAmount) + "#" + i + addSpaces(postAmount));
		}
		System.out.println("");
	}

	public void printBoardMinionNames(int turnIndex, LinkedList<Minion> minionList) {
		System.out.print("Monsters Player " + (turnIndex + 1) + ": ");

		for (Minion minion : minionList) {
			int nameLength = minion.getName().length();
			int preAmount = nameLength < 9 ? (7 - nameLength) / 2 : 0;
			int postAmount = 3 + (nameLength < 9 ? (7 - nameLength) / 2 + (7 - nameLength) % 2 : 0);
			System.out.print(addSpaces(preAmount) + minion.getName() + addSpaces(postAmount));
		}

		System.out.println("");
	}

	public void printBoardMinionStats(LinkedList<Minion> minionList) {
		System.out.print(addSpaces(19));

		for (Minion minion : minionList) {
			int nameLength = minion.getName().length();
			int preAmount = (nameLength > 10 ? (nameLength - 9) / 2 : 0);
			int postAmount = 2 + (nameLength > 9 ? (nameLength - 9) / 2 + (nameLength - 9) % 2 : 0);
			boolean buffed = minion.isBuffed();
			System.out.print(addSpaces(preAmount) + "(A:" + minion.getCurrentAttack() + " H:" + minion.getCurrentHealth() + ")" + (buffed ? "*" : " ") + addSpaces(postAmount));
		}
		System.out.println("");
	}

	public void printBoardMinionEffects(LinkedList<Minion> minionList) {
		System.out.print(addSpaces(19));

		for (Minion minion : minionList) {
			int nameLength = minion.getName().length();
			int preAmount = 1 + (nameLength > 10 ? (nameLength - 9) / 2 : 0);
			int postAmount = 4 + (nameLength > 9 ? (nameLength - 9) / 2 + (nameLength - 9) % 2 : 0);
			System.out.print(addSpaces(preAmount) + getMinionEffects(minion) + addSpaces(postAmount));
		}
		System.out.println("");
	}

	public String getMinionEffects(Minion minion) {
		char tauntChar = (minion.hasTaunt() ? 'T' : '*');
		char chargeChar = (minion.hasCharge() ? 'C' : '*');
		char divineShieldChar = (minion.hasDivineShield() ? 'S' : '*');
		char windfuryChar = (minion.hasWindfury() ? 'W' : '*');
		char deathrattleChar = (minion.hasDeathRattle() ? 'D' : '*');

		return "[" + tauntChar + chargeChar + divineShieldChar + windfuryChar + deathrattleChar + "]";
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

		if (spellEffect instanceof BuffAllOfOneSide) {
			if (str.length != 2) {
				System.out.println("Card-choosing command not valid for spell!");
				return false;
			}

			BuffAllOfOneSide buffAllMinionsEffect = (BuffAllOfOneSide)spellEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			buffAllMinionsEffect.effect(minionList);
		} else if (spellEffect instanceof BuffSingleMinion) {
			if (str.length != 4 || !str[2].equals("on")) {
				System.out.println("Card-choosing command not valid for spell!");
				return false;
			}

			int minionIndex = getAdressingIndex(str[3]);

			if (minionIndex == -1) {
				System.out.println("Card-choosing command not valid!");
				return false;
			}

			BuffSingleMinion buffSingleMinion = (BuffSingleMinion)spellEffect;
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