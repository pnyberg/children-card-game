//#start
import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	private final int TARGETPLAYER = 10;

	private LinkedList<Minion> minionsOnBoard1;
	private LinkedList<Minion> minionsOnBoard2;

	private LinkedList<PlayCard> cardsInHand1;
	private LinkedList<PlayCard> cardsInHand2;

	private int turn;
	private Player player1;
	private Player player2;

	private boolean handlingBattleCry;
	private boolean emptyHand;

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
		player1 = new Player("Player 1", 30);
		player2 = new Player("Player 2", 30);

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

//#100
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

		SpellEffect battleCryEffect = minionTriedToPlay.getBattleCryEffect();

		handleBattleCryEffectTargeting(str, battleCryEffect);
	}

	public void handleBattleCryEffectTargeting(String[] str, SpellEffect battleCryEffect) {
		String[] array;

		if (battleCryEffect instanceof BuffSingleMinion || battleCryEffect instanceof DealDamage) {
			array = new String[]{"target"};
		} else if (battleCryEffect instanceof PickUpMinion) {
			array = new String[]{"pick", "up"};
		} else if (battleCryEffect instanceof HealMinion) {
			array = new String[]{"heal"};
		} else {
			return;
		}

		int minionIndex = getBattleCryTargetIndex(str, array);

		if (minionIndex == -1) {
			return;
		}

		int arrayLength = array.length;
		int turnIndex = getTurnIndex(str[arrayLength]);

		if (battleCryEffect instanceof HealMinion) {
			Character character;

			if (minionIndex == TARGETPLAYER) {
				character = getPlayer(turnIndex);
			} else {
				character = getMinion(minionIndex, turnIndex);
			}

			HealMinion healMinion = (HealMinion)battleCryEffect;

			healMinion.effect(character);

			System.out.println(character.getName() + " got healed!");
		} else if (battleCryEffect instanceof DealDamage) {
			Character character;

			if (minionIndex == TARGETPLAYER) {
				character = getPlayer(turnIndex);
			} else {
				character = getMinion(minionIndex, turnIndex);
			}

			DealDamage dealDamage = (DealDamage)battleCryEffect;

			dealDamage.effect(character);

			System.out.println(character.getName() + " took damage!");
		} else {
			LinkedList<Minion> minionTargetList = getMinionList(turnIndex);

			Minion targetMinion = minionTargetList.get(minionIndex);

			if (battleCryEffect instanceof BuffSingleMinion) {
				BuffSingleMinion buffSingleMinion = (BuffSingleMinion)battleCryEffect;

				buffSingleMinion.effect(targetMinion);

				System.out.println(targetMinion.getName() + " got buffed!");
			} else if (battleCryEffect instanceof PickUpMinion) {
				PickUpMinion pickUpMinion = (PickUpMinion)battleCryEffect;
				LinkedList<PlayCard> cardHand = getCardList(turnIndex);

				pickUpMinion.effect(targetMinion, cardHand);

				removeMinionFromBoard(minionIndex, turnIndex);

				System.out.println(targetMinion.getName() + " got picked up!");
			}
		}

		LinkedList<Minion> minionList = getMinionList(turn);
		addMinionToBoardRemoveFromHand(minionList);

		handlingBattleCry = false;

		if (minionIndex != TARGETPLAYER && !(battleCryEffect instanceof PickUpMinion)) {
			checkDeath(minionIndex, turnIndex);
		}
	}

//#200 
	public int getBattleCryTargetIndex(String[] commandArray, String[] keyWordArray) {
		int lengthOfDefiningCommand = keyWordArray.length;

		if (!checkLengthAndKeyWords(commandArray, keyWordArray)) {
			System.out.println("Target-choosing command not valid for battlecry! (should be '" + arrayToText(keyWordArray) + " [player] [index]')");
			return -1;
		}

		if (!commandArray[lengthOfDefiningCommand].equals("self") && !commandArray[lengthOfDefiningCommand].equals("enemy")) {
			System.out.println("Must say if target is 'self' or 'enemy'");
			return-1;
		}

		int minionIndex = getAdressingIndex(commandArray[lengthOfDefiningCommand + 1]);

		if (minionIndex == -1) {
			System.out.println("Target-choice not valid!");
			return -1;
		}

		return minionIndex;
	}

	public boolean checkLengthAndKeyWords(String[] commandArray, String[] keyWordArray) {
		if (commandArray.length != (keyWordArray.length + 2)) {
			return false;
		}

		for (int i = 0 ; i < keyWordArray.length ; i++) {
			if (!commandArray[i].equals(keyWordArray[i])) {
				return false;
			}
		}

		return true;
	}

	public void addMinionToBoardRemoveFromHand(LinkedList<Minion> minionList) {
		minionList.add(minionTriedToPlay);

		MonsterCard cardTriedToPlay = (MonsterCard)getCardFromHand(minionTriedToPlayCardIndex);

		removeCardFromHand(minionTriedToPlayCardIndex);

		System.out.println("Played " + cardTriedToPlay.getName() + ", it costs " + cardTriedToPlay.getCost() + "!");
	}

//#300
	public void drawCard() {
//		int randomizer = (int)(Math.random()*10);
		if (randomizer == 0) {
			addCardToHand(new MonsterCard(MonsterCard.DR_BOOM));
		} else if (randomizer == 1) {
			addCardToHand(new MonsterCard(MonsterCard.RAGNAROS));
		} else if (randomizer == 2) {
			addCardToHand(new MonsterCard(MonsterCard.DEATHWING));
		} else if (randomizer == 3) {
			addCardToHand(new MonsterCard(MonsterCard.MANA_TIDE_TOTEM));
		} else if (randomizer == 4) {
			addCardToHand(new MonsterCard(MonsterCard.NOVICE_ENGINEER));
		} else if (randomizer == 5) {
			addCardToHand(new MonsterCard(MonsterCard.UNSTABLE_GHOUL));
		} else if (randomizer == 6) {
			addCardToHand(new MonsterCard(MonsterCard.WOLFRIDER));
		} else if (randomizer == 7) {
			addCardToHand(new MonsterCard(MonsterCard.SORCERERS_DRAKE));
		} else if (randomizer == 8) {
			addCardToHand(new MonsterCard(MonsterCard.ELVEN_ARCHER));
		} else if (randomizer == 9) {
			addCardToHand(new MonsterCard(MonsterCard.LOOT_HOARDER));
		} else if (randomizer == 10) {
			addCardToHand(new MonsterCard(MonsterCard.SLUDGE_BELCHER));
		} else if (randomizer == 11) {
			addCardToHand(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
		} else if (randomizer == 12) {
			addCardToHand(new MonsterCard(MonsterCard.BLOODFEN_RAPTOR));
		} else if (randomizer == 13) {
			addCardToHand(new SpellCard(SpellCard.STAFF_OF_THE_EMPEROR));
		} else if (randomizer == 14) {
			addCardToHand(new SpellCard(SpellCard.FEATHER_OF_THE_FEATHER));
		} else if (randomizer == 15) {
			addCardToHand(new SpellCard(SpellCard.DRAGONS_BLOOD));
		} else if (randomizer == 16) {
			addCardToHand(new SpellCard(SpellCard.DRAGON_POWER));
		} else if (randomizer == 17) {
			addCardToHand(new MonsterCard(MonsterCard.DISPATCHING_DRAKE));
		} else if (randomizer == 18) {
			addCardToHand(new SpellCard(SpellCard.EMERALD_SCALE));
		} else {
			addCardToHand(new MonsterCard(MonsterCard.MURLOC_TIDEHUNTER));
		}

		randomizer++; // pre-build-order
	}

	public int getAdressingIndex(String raw) {
		int length = raw.length();

		if (raw.equals("player")) {
			return TARGETPLAYER;
		} else if (length != 2 || raw.charAt(0) != '#') {
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

//#400
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

	public void checkDeathBoard() {
		checkDeathInList(turn);
		checkDeathInList((turn + 1) % 2);
	}

	public void checkDeathInList(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			checkDeath(i, turnIndex);
		}
	}

	public void checkDeath(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);

		if (!minion.isAlive()) {
			removeMinionFromBoard(minionIndex, turnIndex);
			manageDeathRattle(minion, turnIndex);
			System.out.println("(Player " + (turnIndex + 1) + " #" + minionIndex + ")" + minion.getName() + " died!");

			addSummonedMinions(turn);
			addSummonedMinions((turn + 1) % 2);
		}
	}

//#500
	public void attackEnemyPlayer(int attackerIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);

		if (!attackingMinion.canAttack()) {
			System.out.println(attackingMinion.reasonForNotAttacking());
			return;
		}

		int damage = attackingMinion.attack();
		int playerNumber = (turn+1) % 2 + 1;

		System.out.println(attackingMinion.getName() + " is attacking Player " + playerNumber);

		Player player = getPlayer(turn);
		player.takeDamage(damage);
		System.out.println("Player " + playerNumber + " takes " + damage + " damage, has " + player.getHealth() + " left!");
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
		System.out.println("Player1 Health: " + player1.getHealth());
		System.out.println("----- BOARD -----");

		printBoardInfo(0);

		printBoardInfo(1);

		System.out.println("----- BOARD -----");
		System.out.println("Player2 Health: " + player2.getHealth());
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
		LinkedList<Minion> minionsOtherPlayer = getMinionList((turnIndex + 1) % 2);

		handleEndTurnActionsForList(turnIndex);
		handleEndTurnActionsForList((turnIndex + 1) % 2);
	}

	public void handleEndTurnActionsForList(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			Minion minion = minionList.get(i);
			minion.endTurnAction();
			if (minion.hasEndTurnEffect()) {
				manageEndTurnEffect(i, turnIndex);
			}
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

//#600
	public int getTurnIndex(String player) {
		int turnIndex = turn;
		if (player.equals("enemy")) {
			turnIndex = (turnIndex + 1) % 2;
		}

		return turnIndex;
	}

	public Player getPlayer(int turnIndex) {
		Player player;
		if (turnIndex == 0) {
			player = player1;
		} else {
			player = player2;
		}
		return player;
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
			if (emptyHand) {
				cardList.clear();
			} else {
				cardList.remove(index);
			}
			return;
		}

		System.out.println(index + " is not a valid cardIndex for Player " + ((turn + 1) % 2));
	}

//#700
	public void manageBattleCry(Minion minion, int turnIndex) {
		playedMinionType = minion.getType();
		minionTriedToPlay = minion;

		SpellEffect battleCryEffect = minion.getBattleCryEffect();

		if (battleCryEffect instanceof BuffSingleMinion) {
			if (minionExists()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to target?");
			}
		} else if (battleCryEffect instanceof SummonMinions) {
			SummonMinions summonMinions = (SummonMinions)battleCryEffect;
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonMinions.effect(friendlyPlayerMinionTempList, enemyPlayerMinionTempList);
		} else if (battleCryEffect instanceof PickUpMinion) {
			if (minionExists()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to pick up?");
			}
		} else if (battleCryEffect instanceof HealMinion) {
			handlingBattleCry = true;

			System.out.println("Which character do you want to heal?");
		} else if (battleCryEffect instanceof DealDamage) {
			handlingBattleCry = true;

			System.out.println("Which character do you want to deal damage to?");
		} else if (battleCryEffect instanceof DrawCards) {
			DrawCards drawCards = (DrawCards)battleCryEffect;
			LinkedList<PlayCard> cardHand = getCardList(turnIndex);
			LinkedList<PlayCard> deck = new LinkedList<PlayCard>();
			deck.add(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
			deck.add(new MonsterCard(MonsterCard.MURLOC_TIDEHUNTER));
			deck.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));

			drawCards.effect(cardHand, deck);
		} else if (battleCryEffect instanceof DestroyAllMinions) {
			DestroyAllMinions destroyAllMinions = (DestroyAllMinions)battleCryEffect;

			LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
			LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

			emptyHand = true;

			destroyAllMinions.effect(friendlyMinionList, enemyMinionList);
		}
	}

	public boolean minionExists() {
		return !minionsOnBoard1.isEmpty() || !minionsOnBoard2.isEmpty();
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
			deck.add(new MonsterCard(MonsterCard.MURLOC_TIDEHUNTER));
			deck.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));

			drawCards.effect(cardHand, deck);
		} else if (deathRattleEffect instanceof DealDamageToAllMinions) {
			DealDamageToAllMinions dealDamageToAllMinions = (DealDamageToAllMinions)deathRattleEffect;
			LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
			LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

			dealDamageToAllMinions.effect(friendlyMinionList, enemyMinionList);

			checkDeathBoard();
		} else if (deathRattleEffect instanceof DealRandomDamageRandomly) {
			DealRandomDamageRandomly dealRandomDamageRandomly = (DealRandomDamageRandomly)deathRattleEffect;

			int targetChoice;
			Character character;

			int enemyTurn = (turnIndex + 1) % 2;

			if (dealRandomDamageRandomly.attackingEnemiesOnly()) {
				LinkedList<Minion> enemyMinionList = getMinionList(enemyTurn);
				targetChoice = ((int)(Math.random() * 100)) % (enemyMinionList.size() + 1) - 1;

				if (targetChoice == -1) {
					targetChoice = TARGETPLAYER;
					character = getPlayer(enemyTurn);
				} else {
					character = getMinion(targetChoice, enemyTurn);
				}
			} else {
				return;
			}

			dealRandomDamageRandomly.effect(character);

			if (targetChoice != TARGETPLAYER) {
				checkDeath(targetChoice, enemyTurn);
			}
		}
	}

	/*HERE*/
	public void manageStartTurnEffect() {
	}

	public void manageEndTurnEffect(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);
		TurnEffect endTurnEffect = minion.getEndTurnEffect();

		if (turn != turnIndex && !endTurnEffect.activeOnBothTurns()) {
			return;
		}

		if (endTurnEffect instanceof DrawCardsTurnEffect) {
			DrawCardsTurnEffect drawCardsTurnEffect = (DrawCardsTurnEffect)endTurnEffect;
			LinkedList<PlayCard> cardHand = getCardList(turnIndex);
			LinkedList<PlayCard> deck = new LinkedList<PlayCard>();
			deck.add(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
			deck.add(new MonsterCard(MonsterCard.MURLOC_TIDEHUNTER));
			deck.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));

			drawCardsTurnEffect.effect(cardHand, deck);
		} else if (endTurnEffect instanceof DealDamageRandomTurnEffect) {
			int targetChoice;
			Character character;

			int enemyTurn = (turnIndex + 1) % 2;
			DealDamageRandomTurnEffect dealDamageRandomTurnEffect = (DealDamageRandomTurnEffect)endTurnEffect;

			if (dealDamageRandomTurnEffect.attackingEnemiesOnly()) {
				LinkedList<Minion> enemyMinionList = getMinionList(enemyTurn);
				targetChoice = ((int)(Math.random() * 100)) % (enemyMinionList.size() + 1) - 1;

				if (targetChoice == -1) {
					targetChoice = TARGETPLAYER;
					character = getPlayer(enemyTurn);
				} else {
					character = getMinion(targetChoice, enemyTurn);
				}
			} else {
				return;
			}

			dealDamageRandomTurnEffect.effect(character);

			if (targetChoice != TARGETPLAYER) {
				checkDeath(targetChoice, enemyTurn);
			}
		}
	}

//#800
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
			PlayCard card = cardList.get(i);
			int nameLength = card.getName().length();

			if (card instanceof MonsterCard) {
				int preAmount = (nameLength > 12 ? (nameLength - 1) / 2 : 6);
				int postAmount = 3 + (nameLength > 12 ? (nameLength - 3) / 2 + (nameLength - 3) % 2 : 5);
				System.out.print(addSpaces(preAmount) + "#" + i + addSpaces(postAmount));
			} else {
				int preAmount = (nameLength - 1) / 2;
				int postAmount = 3 + (nameLength - 3) / 2 + (nameLength - 3) % 2;
				System.out.print(addSpaces(preAmount) + "#" + i + addSpaces(postAmount));
			}
		}
		System.out.println("");
	}

	public void printHandCardNames(int turnIndex, LinkedList<PlayCard> cardList) {
		System.out.print("Cards Player" + (turnIndex + 1) + ": ");

		for (PlayCard card : cardList) {
			int nameLength = card.getName().length();

			if (card instanceof MonsterCard) {
				int preAmount = nameLength < 13 ? (13 - nameLength) / 2 : 0;
				int postAmount = 3 + (nameLength < 13 ? (13 - nameLength) / 2 + (13 - nameLength) % 2 : 0);
				System.out.print(addSpaces(preAmount) + card.getName() + addSpaces(postAmount));
			} else {
				int preAmount = 0;
				int postAmount = 3;
				System.out.print(addSpaces(preAmount) + card.getName() + addSpaces(postAmount));
			}
		}
		System.out.println("");
	}

//#900
	public void printHandCardStats(LinkedList<PlayCard> cardList) {
		System.out.print(addSpaces(15));
		for (PlayCard card : cardList) {
			int nameLength = card.getName().length();
			if (card instanceof MonsterCard) {
				int preAmount = nameLength > 13 ? (nameLength - 13) / 2 : 0;
				int postAmount = 3 + (nameLength > 13 ? (nameLength - 13) / 2 + (nameLength - 13) % 2 : 0);
				System.out.print(addSpaces(preAmount) + "(C:" + card.getCost() + " A:" + ((MonsterCard)card).getAttack() + " H:" + ((MonsterCard)card).getHealth() + ")" + addSpaces(postAmount));
			} else {
				int preAmount = (nameLength - 5) / 2;
				int postAmount = 3 + (nameLength - 5) / 2 + (nameLength - 5) % 2;
				System.out.print(addSpaces(preAmount) + "(C:" + card.getCost() + ")" + addSpaces(postAmount));
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

//#1000
	public String addSpaces(int number) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0 ; i < number ; i++) {
			builder.append(" ");
		}

		return builder.toString();
	}

	public boolean manageSpellEffect(SpellCard card, String[] str) {
		SpellEffect spellEffect = card.getSpellEffect();

		if (spellEffect instanceof BuffAllMinionsOfOneSide) {
			if (str.length != 2) {
				System.out.println("Card-choosing command not valid for spell!");
				return false;
			}

			BuffAllMinionsOfOneSide buffAllMinionsOneSideEffect = (BuffAllMinionsOfOneSide)spellEffect;
			LinkedList<Minion> minionList = getMinionList(turn);
			buffAllMinionsOneSideEffect.effect(minionList);
		} else if (spellEffect instanceof BuffSingleMinion) {
			if (str.length != 5 || !str[2].equals("on")) {
				System.out.println("Card-choosing command not valid for spell!");
				return false;
			}

			if (!str[3].equals("self") && !str[3].equals("enemy")) {
				System.out.println("Must say if target is 'self' or 'enemy'");
				return false;
			}

			int minionIndex = getAdressingIndex(str[4]);

			if (minionIndex == -1) {
				System.out.println("Card-choosing command not valid!");
				return false;
			}

			BuffSingleMinion buffSingleMinion = (BuffSingleMinion)spellEffect;
			int turnIndex = getTurnIndex(str[1]);

			Minion minion = getMinion(minionIndex, turnIndex);
			buffSingleMinion.effect(minion);
		} else {
			return false;
		}

		return true;
	}

//#end
	public static void main(String[] args) {
		new TheGame();
	}
}