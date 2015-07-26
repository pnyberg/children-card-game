//#start
import java.util.LinkedList;
import java.util.Scanner;

public class TheGame {
	public static final int TARGETPLAYER = 10;


	private DamageHandler damageHandler;


	private LinkedList<Minion> minionsOnBoard1;
	private LinkedList<Minion> minionsOnBoard2;

	private LinkedList<PlayCard> cardsInHand1;
	private LinkedList<PlayCard> cardsInHand2;

	private LinkedList<PlayCard> deck1;
	private LinkedList<PlayCard> deck2;

	private int turn;
	private Player player1;
	private Player player2;

	private boolean handlingBattleCry;

	private int discardCardsAmount;
	private boolean emptyHand;

	private int playedMinionType;
	private int minionTriedToPlayCardIndex;

	private Minion minionTriedToPlay;

	private LinkedList<Minion> minionTempList1;
	private LinkedList<Minion> minionTempList2;

	private LinkedList<Minion> minionDeadList1;
	private LinkedList<Minion> minionDeadList2;

	private int randomizer = 0; // temp -> pre-built-order 

	public TheGame() {
		minionsOnBoard1 = new LinkedList<Minion>();
		minionsOnBoard2 = new LinkedList<Minion>();

		cardsInHand1 = new LinkedList<PlayCard>();
		cardsInHand2 = new LinkedList<PlayCard>();

		deck1 = new LinkedList<PlayCard>();
		deck2 = new LinkedList<PlayCard>();

		turn = 0;
		player1 = new Player("Player 1", 30);
		player2 = new Player("Player 2", 30);

		handlingBattleCry = false;
		playedMinionType = -1;
		minionTriedToPlay = null;
		minionTriedToPlayCardIndex = -1;
		discardCardsAmount = 0;

		minionTempList1 = new LinkedList<Minion>();
		minionTempList2 = new LinkedList<Minion>();

		minionDeadList1 = new LinkedList<Minion>();
		minionDeadList2 = new LinkedList<Minion>();

		initDamageHandling();

		initDecks();

		start();
	}

	public void initDamageHandling() {
		damageHandler = new DamageHandler(player1, player2, deck1, deck2, cardsInHand1, cardsInHand2, minionsOnBoard1, minionsOnBoard2);
	}

	public void initDecks() {
		deck2.add(new MonsterCard(MonsterCard.BARON_GEDDON));
		deck2.add(new MonsterCard(MonsterCard.GRIM_PATRON));
		deck2.add(new MonsterCard(MonsterCard.SUCCUBUS));
		deck2.add(new MonsterCard(MonsterCard.DOOMGUARD));
		deck2.add(new MonsterCard(MonsterCard.ACOLYTE_OF_PAIN));
		deck2.add(new MonsterCard(MonsterCard.UNSTABLE_GHOUL));
		deck2.add(new MonsterCard(MonsterCard.RAGNAROS_THE_FIRELORD));
		deck2.add(new MonsterCard(MonsterCard.GRUUL));
		deck2.add(new MonsterCard(MonsterCard.MALORNE));
		deck2.add(new MonsterCard(MonsterCard.DREAD_INFERNAL));
		deck2.add(new MonsterCard(MonsterCard.NOVICE_ENGINEER));
		deck2.add(new MonsterCard(MonsterCard.LEEROY_JENKINS));

		deck1.add(new MonsterCard(MonsterCard.SHADE_OF_NAXXRAMAS));
		deck1.add(new MonsterCard(MonsterCard.YOUNG_PRIESTESS));
		deck1.add(new MonsterCard(MonsterCard.MASTER_SWORDSMITH));
		deck1.add(new MonsterCard(MonsterCard.CLOCKWORK_GNOME));
		deck1.add(new MonsterCard(MonsterCard.ELVEN_ARCHER));
		deck1.add(new MonsterCard(MonsterCard.ARMORSMITH));
		deck1.add(new MonsterCard(MonsterCard.FROTHING_BERSERKER));
		deck1.add(new MonsterCard(MonsterCard.SHATTERED_SUN_CLERIC));
		deck1.add(new MonsterCard(MonsterCard.WARBOT));
		deck1.add(new MonsterCard(MonsterCard.RAGING_WORGEN));
		deck1.add(new MonsterCard(MonsterCard.VODOO_DOCTOR));
		deck1.add(new MonsterCard(MonsterCard.SPELLBREAKER));
		deck1.add(new MonsterCard(MonsterCard.IMP_GANG_BOSS));
		deck1.add(new MonsterCard(MonsterCard.SHIELDMAIDEN));
		deck1.add(new MonsterCard(MonsterCard.KING_MUKKLA));
		deck1.add(new MonsterCard(MonsterCard.GAHZRILLA));
		deck1.add(new MonsterCard(MonsterCard.DR_BOOM));
		deck1.add(new MonsterCard(MonsterCard.YSERA));
		deck1.add(new MonsterCard(MonsterCard.ARGENT_SQUIRE));
		deck1.add(new MonsterCard(MonsterCard.SUNWALKER));
		deck1.add(new MonsterCard(MonsterCard.BLOOD_KNIGHT));
		deck1.add(new MonsterCard(MonsterCard.DEATHLORD));
		deck1.add(new MonsterCard(MonsterCard.MANA_TIDE_TOTEM));
		deck1.add(new MonsterCard(MonsterCard.LOOT_HOARDER));
		deck1.add(new MonsterCard(MonsterCard.SAVANNAH_HIGHMANE));
		deck1.add(new MonsterCard(MonsterCard.TWILIGHT_DRAKE));
		deck1.add(new MonsterCard(MonsterCard.ALDOR_PEACEKEEPER));
		deck1.add(new MonsterCard(MonsterCard.HOGGER));
		deck1.add(new MonsterCard(MonsterCard.CRAZED_ALCHEMIST));
		deck1.add(new MonsterCard(MonsterCard.ALARM_O_BOT));
		deck1.add(new MonsterCard(MonsterCard.DOOMSAYER));
		deck1.add(new MonsterCard(MonsterCard.FROSTWOLF_WARLORD));
		deck1.add(new MonsterCard(MonsterCard.SLUDGE_BELCHER));
		deck1.add(new MonsterCard(MonsterCard.SYLVANAS_WINDRUNNER));
		deck1.add(new MonsterCard(MonsterCard.EMPEROR_THAURISSAN));
		deck1.add(new MonsterCard(MonsterCard.WOLFRIDER));
		deck1.add(new MonsterCard(MonsterCard.ABUSIVE_SERGEANT));

		deck1.add(new MonsterCard(MonsterCard.GURUBASHI_BERSERKER));
		deck1.add(new MonsterCard(MonsterCard.LEPER_GNOME));
		deck1.add(new MonsterCard(MonsterCard.ZOMBIE_CHOW));
		deck1.add(new MonsterCard(MonsterCard.BLOOD_IMP));
		deck1.add(new MonsterCard(MonsterCard.NIGHTBLADE));
		deck1.add(new MonsterCard(MonsterCard.PRIESTESS_OF_ELUNE));
		deck1.add(new MonsterCard(MonsterCard.WORGEN_INFILTRATOR));
		deck1.add(new MonsterCard(MonsterCard.ARGENT_PROTECTOR));
		deck1.add(new MonsterCard(MonsterCard.SCARLET_CRUSADER));
		deck1.add(new MonsterCard(MonsterCard.ARGENT_COMMANDER));
		deck1.add(new MonsterCard(MonsterCard.IMP_MASTER));
		deck1.add(new MonsterCard(MonsterCard.SHRINKMEISTER));
		deck1.add(new MonsterCard(MonsterCard.ALEXSTRASZA));
		deck1.add(new MonsterCard(MonsterCard.MOLTEN_GIANT));
		deck1.add(new MonsterCard(MonsterCard.SEA_GIANT));
		deck1.add(new MonsterCard(MonsterCard.MOUNTAIN_GIANT));
		deck1.add(new MonsterCard(MonsterCard.ONYXIA));
		deck1.add(new MonsterCard(MonsterCard.DEATHWING));
		deck1.add(new MonsterCard(MonsterCard.CLOCKWORK_GIANT));
		deck1.add(new MonsterCard(MonsterCard.YOUTHFUL_BREWMASTER));
		deck1.add(new MonsterCard(MonsterCard.BLOODFEN_RAPTOR));
		deck1.add(new MonsterCard(MonsterCard.MURLOC_TIDEHUNTER));
		deck1.add(new SpellCard(SpellCard.STAFF_OF_THE_EMPEROR));
		deck1.add(new SpellCard(SpellCard.FEATHER_OF_THE_FEATHER));
		deck1.add(new SpellCard(SpellCard.DRAGONS_BLOOD));
		deck1.add(new SpellCard(SpellCard.DRAGON_POWER));
		deck1.add(new MonsterCard(MonsterCard.CHILLWIND_YETI));
		deck1.add(new SpellCard(SpellCard.EMERALD_SCALE));
		deck1.add(new MonsterCard(MonsterCard.EARTHEN_RING_FARSEER));
	}

//#100
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

		checkHandCostChange();
	}

	public void checkHandCostChange() {
		checkHandCostChangeForList(turn);
		checkHandCostChangeForList((turn + 1) % 2);
	}

	public void checkHandCostChangeForList(int turnIndex) {
		LinkedList<PlayCard> cardList = getHand(turnIndex);

		for (PlayCard card : cardList) {
			if (card.hasCostEffect()) {
				handleCostEffect(card, turnIndex);
			}
		}
	}

//#200 
	public void handleCostEffect(PlayCard card, int turnIndex) {
		SpellEffect costEffect = card.getCostEffect();

		if (costEffect instanceof CostDeterminedByHealth) {
			CostDeterminedByHealth costDeterminedByHealth = (CostDeterminedByHealth)costEffect;
			Player player;

			if (costDeterminedByHealth.basedOnFriendlyPlayer()) {
				player = getPlayer(turnIndex);
			} else {
				player = getPlayer((turnIndex + 1) % 2);
			}

			int healthLost = 30 - player.getHealth();

			costDeterminedByHealth.effect(card, healthLost);
		} else if (costEffect instanceof CostDeterminedByMinionsOnBoard) {
			CostDeterminedByMinionsOnBoard costDeterminedByMinionsOnBoard = (CostDeterminedByMinionsOnBoard)costEffect;

			int minionsOnBoard = 0;

			if (costDeterminedByMinionsOnBoard.basedOnFriendlyBoard()) {
				LinkedList<Minion> minionList = getMinionList(turnIndex);
				minionsOnBoard += minionList.size();
			}

			if (costDeterminedByMinionsOnBoard.basedOnEnemyBoard()) {
				LinkedList<Minion> minionList = getMinionList((turnIndex + 1) % 2);
				minionsOnBoard += minionList.size();
			}

			costDeterminedByMinionsOnBoard.effect(card, minionsOnBoard);
		} else if (costEffect instanceof CostDeterminedByCardsInHand) {
			CostDeterminedByCardsInHand costDeterminedByCardsInHand = (CostDeterminedByCardsInHand)costEffect;

			int cardsInHand = -1; // card played does not count

			if (costDeterminedByCardsInHand.basedOnFriendlyHand()) {
				LinkedList<PlayCard> cardHand = getHand(turnIndex);
				cardsInHand += cardHand.size();
			}

			if (costDeterminedByCardsInHand.basedOnEnemyHand()) {
				LinkedList<PlayCard> cardHand = getHand((turnIndex + 1) % 2);
				cardsInHand += cardHand.size();
			}

			costDeterminedByCardsInHand.effect(card, cardsInHand);
		}
	}

	public void handleBasicCommands(String[] str) {
		if (str.length == 1 && str[0].equals("draw")) {
			drawCard(turn);
		} else if (str.length == 2 && str[0].equals("draw")) {
			/*EXTRA*/
			int number = Integer.parseInt(str[1]);
			for (int i = 0 ; i < number ; i++)
				drawCard(turn);
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
		} else if (str.length == 3 && str[0].equals("end") && str[1].equals("turn") && str[2].equals("double")) {
			/*EXTRA*/
			endTurn();
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

//#300
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

		PlayCard cardToBePlayed = getCardFromHand(minionTriedToPlayCardIndex);

		if (cardToBePlayed instanceof SpellCard) {
			return;
		}

		Minion minionToBePlayed = ((MonsterCard)cardToBePlayed).toMinion();
		SpellEffect battleCryEffect = minionToBePlayed.getBattleCryEffect();

		handleBattleCryEffectTargeting(str, battleCryEffect);
	}

	public void handleBattleCryEffectTargeting(String[] str, SpellEffect battleCryEffect) {
		String[] array;

		if (battleCryTargetInstanceOf(battleCryEffect)) {
			array = new String[]{"target"};
		} else if (battleCryEffect instanceof BuffSingleMinion) {
			array = new String[]{"buff"};
		} else if (battleCryEffect instanceof PickUpMinion) {
			array = new String[]{"pick", "up"};
		} else if (battleCryEffect instanceof HealCharacter) {
			array = new String[]{"heal"};
		} else if (battleCryEffect instanceof SwapHealthMinion) {
			array = new String[]{"swap", "health"};
		} else if (battleCryEffect instanceof SetHealthPlayer) {
			array = new String[]{"set", "health"};
		} else if (battleCryEffect instanceof Silence) {
			array = new String[]{"silence"};
		} else {
			return;
		}

		int minionIndex = getBattleCryTargetIndex(str, array);

		if (minionIndex == -1) {
			return;
		}

		// the last token in the command is the targetingindex
		// the array is all but one of the tokens (therefore targetindex is on position 'arraylength')
		int arrayLength = array.length;
		int turnIndex = getTurnIndex(str[arrayLength]);

		/* HERE: target only friendly/enemy - check */

		if (!targetAttackable(minionIndex, turnIndex)) {
			System.out.println("You cannot target that, that minion has stealth!");
			return;
		}

		if (battleCryEffect instanceof HealCharacter) {
			HealCharacter healCharacter = (HealCharacter)battleCryEffect;

			healCharacterEffect(healCharacter, minionIndex, turnIndex);
		} else if (battleCryEffect instanceof SetHealthPlayer) {
			Player player = getPlayer(turnIndex);

			SetHealthPlayer setHealthPlayer = (SetHealthPlayer)battleCryEffect;

			setHealthPlayer.effect(player);

			System.out.println(player.getName() + " got changed health!");
		} else if (battleCryEffect instanceof DealDamage) {
			DealDamage dealDamage = (DealDamage)battleCryEffect;

			dealDamage.effect(damageHandler, minionIndex, turnIndex);
		} else {
			// BuffSingelMinion, PickUpMinion and SwapHealthMinion only handle minions, so they can have the same base-code
			LinkedList<Minion> minionTargetList = getMinionList(turnIndex);

			Minion targetMinion = minionTargetList.get(minionIndex);

			if (battleCryEffect instanceof BuffSingleMinion) {
				BuffSingleMinion buffSingleMinion = (BuffSingleMinion)battleCryEffect;

				buffSingleMinion.effect(targetMinion);

				System.out.println(targetMinion.getName() + " got buffed!");
			} else if (battleCryEffect instanceof SetStatsSingleMinion) {
				SetStatsSingleMinion setStatsSingleMinion = (SetStatsSingleMinion)battleCryEffect;

				setStatsSingleMinion.effect(targetMinion);

				System.out.println(targetMinion.getName() + " got buffed!");
			} else if (battleCryEffect instanceof PickUpMinion) {
				PickUpMinion pickUpMinion = (PickUpMinion)battleCryEffect;
				LinkedList<PlayCard> cardHand = getHand(turnIndex);

				pickUpMinion.effect(targetMinion, cardHand);

				removeMinionFromBoard(minionIndex, turnIndex);

				System.out.println(targetMinion.getName() + " got picked up!");
			} else if (battleCryEffect instanceof SwapHealthMinion) {
				SwapHealthMinion swapHealthMinion = (SwapHealthMinion)battleCryEffect;

				PlayCard cardToBePlayed = getCardFromHand(minionTriedToPlayCardIndex);

				if (cardToBePlayed instanceof SpellCard) {
					return;
				}

				Minion minionToBePlayed = ((MonsterCard)cardToBePlayed).toMinion();

				swapHealthMinion.effect(minionToBePlayed, targetMinion);

				System.out.println(targetMinion.getName() + " got swaped health with " + minionToBePlayed.getName() + "!");
			} else if (battleCryEffect instanceof SwapAttackHealthMinion) {
				SwapAttackHealthMinion swapAttackHealthMinion = (SwapAttackHealthMinion)battleCryEffect;

				swapAttackHealthMinion.effect(targetMinion);

				System.out.println(targetMinion.getName() + " got swaped attack and health!");
			} else if (battleCryEffect instanceof Silence) {
				Silence silence = (Silence)battleCryEffect;

				silence.effect(targetMinion);

				System.out.println(targetMinion.getName() + " got silenced!");
			}
		}

		LinkedList<Minion> minionList = getMinionList(turn);
		addMinionToBoardRemoveFromHand(minionList);

		handlingBattleCry = false;

		if (minionIndex != TARGETPLAYER && !(battleCryEffect instanceof PickUpMinion)) {
			checkDeath(minionIndex, turnIndex);
		}
	}

//#400
	public void healCharacterEffect(HealCharacter healCharacter, int minionIndex, int turnIndex) {
		Character character;

		if (minionIndex == TARGETPLAYER) {
			character = getPlayer(turnIndex);
		} else {
			character = getMinion(minionIndex, turnIndex);
		}

		healCharacter.effect(character);

		System.out.println(character.getName() + " got healed!");
	}

	public boolean battleCryTargetInstanceOf(SpellEffect battleCryEffect) {
		return 	battleCryEffect instanceof DealDamage || 
				battleCryEffect instanceof SetStatsSingleMinion || 
				battleCryEffect instanceof SwapAttackHealthMinion;
	}

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
		addMinionToBoardRemoveFromHand(minionList, minionTriedToPlayCardIndex, turn);
	}

	public void addMinionToBoardRemoveFromHand(LinkedList<Minion> minionList, int minionCardIndex, int turnIndex) {
		MonsterCard cardTriedToPlay = (MonsterCard)getCardFromHand(minionCardIndex, turnIndex);
		Minion minionPlayed = cardTriedToPlay.toMinion();

		minionList.add(minionPlayed);

		removeCardFromHand(minionCardIndex, turnIndex);

		System.out.println("Played " + cardTriedToPlay.getName() + ", it costs " + cardTriedToPlay.getCost() + "!");
	}

	public void drawCard(int turnIndex) {
		LinkedList<PlayCard> deck = getDeck(turnIndex);
		LinkedList<PlayCard> hand = getHand(turnIndex);

		PlayCard drawnCard = deck.poll();

		hand.add(drawnCard);
		System.out.println("Draw " + drawnCard.getName() + "!");
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

//#500
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
		if (!targetAttackable(targetIndex, (turn + 1) % 2)) {
			System.out.println("You cannot attack that, that minion has stealth!");
			return;
		}
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

	public boolean targetAttackable(int targetIndex, int turnIndex) {
		int enemyTurnNumber = (turn + 1) % 2;
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		if (targetIndex != TARGETPLAYER && turnIndex == enemyTurnNumber && minionList.get(targetIndex).hasStealth()) {
			return false;
		}

		return true;
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

//#600
	public void minionDuel(int attackerIndex, int targetIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);
		Minion targetMinion = getTarget(targetIndex);

		if (!attackingMinion.canAttack()) {
			System.out.println(attackingMinion.reasonForNotAttacking());
			return;
		}

		int damage1 = attackingMinion.attack();
		int damage2 = targetMinion.getCurrentAttack();

		damageHandler.dealDamageToMinion(targetIndex, damage1, (turn + 1) % 2);

		damageHandler.dealDamageToMinion(attackerIndex, damage2, turn);

		System.out.println("(Player " + (turn + 1) + " #" + attackerIndex + ")" + attackingMinion.getName() + " is attacking (Player " + ((turn + 1) % 2 + 1) + " #" + attackerIndex + ")" + targetMinion.getName());

		checkDeathBoard();

		System.out.println(attackingMinion.getName() + " HP: " + attackingMinion.getCurrentHealth() + " - " + targetMinion.getName() + " HP: " + targetMinion.getCurrentHealth());
	}

	public void checkDeathBoard() {
		checkDeathInList(turn);
		checkDeathInList((turn + 1) % 2);
	}

	public void checkDeathInList(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			if (checkDeath(i, turnIndex)) {
				i--;
			}
		}
	}

	public boolean checkDeath(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);

		if (!minion.isAlive()) {
			removeMinionFromBoard(minionIndex, turnIndex);
			manageDeathRattle(minion, turnIndex);
			System.out.println("(Player " + (turnIndex + 1) + " #" + minionIndex + ")" + minion.getName() + " died!");

			addSummonedMinions(turn);
			addSummonedMinions((turn + 1) % 2);

			addToDeadList(minion, turnIndex);

			return true;
		}
		return false;
	}

	public void attackEnemyPlayer(int attackerIndex) {
		Minion attackingMinion = getAttacker(attackerIndex);

		if (!attackingMinion.canAttack()) {
			System.out.println(attackingMinion.reasonForNotAttacking());
			return;
		}

		int damage = attackingMinion.attack();
		int playerNumber = (turn + 1) % 2 + 1;

		System.out.println(attackingMinion.getName() + " is attacking Player " + playerNumber);

		damageHandler.dealDamageToPlayer(damage, (turn + 1) % 2);
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

//#700
	public void endTurn() {
		handleEndTurnActions(turn);

		turn = (turn + 1) % 2;
		System.out.println("Player " + (turn + 1) + "'s turn!");

		handleStartTurnActions(turn);

		prepareTurn(turn);
	}

	public void prepareTurn(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turn);

		for (Minion minion : minionList) {
			minion.prepareMinion(true);
		}
	}

	public void handleStartTurnActions(int turnIndex) {
		handleStartTurnActionsForList(turnIndex);
		handleStartTurnActionsForList((turnIndex + 1) % 2);
	}

	public void handleStartTurnActionsForList(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			Minion minion = minionList.get(i);
			if (minion.hasStartTurnEffect()) {
				boolean minionRemovedFromBoard = manageStartTurnEffect(i, turnIndex);

				if (minionRemovedFromBoard) { i--; }
			}
		}
	}

	public void handleEndTurnActions(int turnIndex) {
		handleEndTurnActionsForList(turnIndex);
		handleEndTurnActionsForList((turnIndex + 1) % 2);

		addSummonedMinions(turnIndex);
		addSummonedMinions((turnIndex + 1) % 2);

		minionDeadList1.clear();
		minionDeadList2.clear();
	}

	public void handleEndTurnActionsForList(int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			Minion minion = minionList.get(i);
			if (minion.hasEndTurnEffect() && !minion.restoredThisTurn()) {
				manageEndTurnEffect(i, turnIndex);
			}
			minion.endTurnAction();
		}
	}

	public int getTurnIndex(String player) {
		int turnIndex = turn;
		if (player.equals("enemy")) {
			turnIndex = (turnIndex + 1) % 2;
		}

		return turnIndex;
	}

//#800
	public Player getPlayer(int turnIndex) {
		Player player;
		if (turnIndex == 0) {
			player = player1;
		} else {
			player = player2;
		}
		return player;
	}

	public LinkedList<PlayCard> getDeck(int turnIndex) {
		LinkedList<PlayCard> deckList;
		if (turnIndex == 0) {
			deckList = deck1;
		} else {
			deckList = deck2;
		}
		return deckList;
	}

	public LinkedList<PlayCard> getHand(int turnIndex) {
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

	public LinkedList<Minion> getDeadMinionList(int turnIndex) {
		LinkedList<Minion> deadMinionList;
		if (turnIndex == 0) {
			deadMinionList = minionDeadList1;
		} else {
			deadMinionList = minionDeadList2;
		}
		return deadMinionList;
	}

	public PlayCard getCardFromHand(int index) {
		return getCardFromHand(index, turn);
	}

	public PlayCard getCardFromHand(int index, int turnIndex) {
		LinkedList<PlayCard> cardList = getHand(turnIndex);

		if (index >= 0 && index < cardList.size()) {
			return cardList.get(index);
		}

		System.out.println(index + " is not a valid cardIndex for Player " + (turnIndex + 1));

		return null;
	}

	public void removeCardFromHand(int index) {
		removeCardFromHand(index, turn);
		discardCardsFromHand(turn);
	}

	public void removeCardFromHand(int index, int turnIndex) {
		LinkedList<PlayCard> cardList = getHand(turnIndex);

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

	public void discardCardsFromHand(int turnIndex) {
		LinkedList<PlayCard> hand = getHand(turnIndex);
		LinkedList<PlayCard> discardedCards = new LinkedList<PlayCard>();

		for (int i = 0 ; i < discardCardsAmount ; i++) {
			if (hand.size() == 0) {
				break;
			}

			int index = ((int)(Math.random() * 100)) % hand.size();
			PlayCard discardCard = hand.remove(index);
			discardedCards.add(discardCard);
		}

		if (discardedCards.size() == 0) {
			return;
		}

		System.out.print("Discarded following cards: ");

		for (int i = 0 ; i < discardedCards.size() ; i++) {
			PlayCard card = discardedCards.get(i);
			System.out.print(card.getName());

			if (i < (discardedCards.size() - 1)) {
				System.out.print(", ");
			}
		}

		System.out.println("");
	}

//#900
	public void manageBattleCry(Minion minion, int turnIndex) {
		playedMinionType = minion.getType();

		SpellEffect battleCryEffect = minion.getBattleCryEffect();

		if (battleCryEffect instanceof BuffSingleMinion) {
			if (minionExists()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to buff?");
			}
		} else if (battleCryEffect instanceof SetStatsSingleMinion) {
			if (minionExists()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to target?");
			}
		} else if (battleCryEffect instanceof BuffAccordingToBoard) {
			BuffAccordingToBoard buffAccordingToBoard = (BuffAccordingToBoard)battleCryEffect;

			if (!buffAccordingToBoard.buffSelf() && minionExists()) {
				// not implemented yet
				/*handlingBattleCry = true;

				System.out.println("Which minion do you want to target?");*/
			} else {
				int numberOfMinions = 0;
				if (buffAccordingToBoard.buffAccordingToFriendlyBoard()) {
					LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
					numberOfMinions += friendlyMinionList.size();
				}

				if (buffAccordingToBoard.buffAccordingToEnemyBoard()) {
					LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);
					numberOfMinions += enemyMinionList.size();
				}

				buffAccordingToBoard.effect(minion, numberOfMinions);
			}
		} else if (battleCryEffect instanceof BuffAccordingToHand) {
			BuffAccordingToHand buffAccordingToHand = (BuffAccordingToHand)battleCryEffect;

			if (!buffAccordingToHand.buffSelf() && minionExists()) {
				// not implemented yet
				/*handlingBattleCry = true;

				System.out.println("Which minion do you want to target?");*/
			} else {
				int numberOfCards = -1; // card played does not count
				if (buffAccordingToHand.buffAccordingToFriendlyHand()) {
					LinkedList<PlayCard> friendlyHand = getHand(turnIndex);
					numberOfCards += friendlyHand.size();
				}

				if (buffAccordingToHand.buffAccordingToEnemyHand()) {
					LinkedList<PlayCard> enemyHand = getHand((turnIndex + 1) % 2);
					numberOfCards += enemyHand.size();
				}

				buffAccordingToHand.effect(minion, numberOfCards);
			}
		} else if (battleCryEffect instanceof BuffAccordingToDivineShields) {
			BuffAccordingToDivineShields buffAccordingToDivineShields = (BuffAccordingToDivineShields)battleCryEffect;

			if (!buffAccordingToDivineShields.buffSelf() && minionExists()) {
				// not implemented yet
				/*handlingBattleCry = true;

				System.out.println("Which minion do you want to target?");*/
			} else {
				int numberOfShields = 0;
				boolean removeShields = buffAccordingToDivineShields.removeShields();

				if (buffAccordingToDivineShields.buffAccordingToFriendlyBoard()) {
					LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);

					numberOfShields += getNumberOfShields(friendlyMinionList, removeShields);
				}

				if (buffAccordingToDivineShields.buffAccordingToEnemyBoard()) {
					LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

					numberOfShields += getNumberOfShields(enemyMinionList, removeShields);
				}

				buffAccordingToDivineShields.effect(minion, numberOfShields);
			}
		} else if (battleCryEffect instanceof PickUpMinion) {
			if (minionExists()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to pick up?");
			}
		} else if (battleCryEffect instanceof HealCharacter) {
			HealCharacter healCharacter = (HealCharacter)battleCryEffect;

			if (healCharacter.mustTargetPlayer()) {
				int minionIndex = TARGETPLAYER;
				int turnNumber = turnIndex;

				if (!healCharacter.targetSelf()) {
					turnNumber = (turnNumber + 1) % 2;
				}

				healCharacterEffect(healCharacter, minionIndex, turnNumber);
			} else {
				handlingBattleCry = true;

				System.out.println("Which character do you want to heal?");
			}
		} else if (battleCryEffect instanceof AddArmor) {
			AddArmor addArmor = (AddArmor)battleCryEffect;

			Player player = getPlayer(turnIndex);

			addArmor.effect(player);
		} else if (battleCryEffect instanceof DealDamage) {
			handlingBattleCry = true;

			System.out.println("Which character do you want to deal damage to?");
		} else if (battleCryEffect instanceof SwapHealthMinion) {
			handlingBattleCry = true;

			System.out.println("Which minion do you want to swap health with?");
		} else if (battleCryEffect instanceof SwapAttackHealthMinion) {
			handlingBattleCry = true;

			System.out.println("Which minion do you want to swap attack and health with?");
		} else if (battleCryEffect instanceof SetHealthPlayer) {
			handlingBattleCry = true;

			System.out.println("Which player do you want to set health = 15?");
		} else if (battleCryEffect instanceof Silence) {
			Silence silence = (Silence)battleCryEffect;

			if (!silence.affectWholeBoardSide()) {
				handlingBattleCry = true;

				System.out.println("Which minion do you want to silence?");
			} else {
				// silence board + friendly/enemy/both?*/
			}
		} else if (battleCryEffect instanceof SummonMinions) {
			SummonMinions summonMinions = (SummonMinions)battleCryEffect;
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonMinions.effect(friendlyPlayerMinionTempList, enemyPlayerMinionTempList);
		} else if (battleCryEffect instanceof DrawCards) {
			DrawCards drawCards = (DrawCards)battleCryEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);
			LinkedList<PlayCard> deck = getDeck(turnIndex);

			drawCards.effect(cardHand, deck);
		} else if (battleCryEffect instanceof DiscardCards) {
			DiscardCards discardCards = (DiscardCards)battleCryEffect;

			discardCardsAmount = discardCards.getDiscardAmount();
		} else if (battleCryEffect instanceof AddRandomSpellCardToHand) {
			AddRandomSpellCardToHand addRandomSpellCardToHand = (AddRandomSpellCardToHand)battleCryEffect;

			if (addRandomSpellCardToHand.giveSelf()) {
				LinkedList<PlayCard> cardHand = getHand(turnIndex);
				addRandomSpellCardToHand.effect(cardHand, true);
			}

			if (addRandomSpellCardToHand.giveEnemy()) {
				LinkedList<PlayCard> cardHand = getHand((turnIndex + 1) % 2);
				addRandomSpellCardToHand.effect(cardHand, false);
			}
		} else if (battleCryEffect instanceof DealDamageToAllCharacters) {
			DealDamageToAllCharacters dealDamageToAllCharacters = (DealDamageToAllCharacters)battleCryEffect;

			dealDamageToAllCharacters.effect(damageHandler, turnIndex);

			checkDeathBoard();
		} else if (battleCryEffect instanceof DestroyAllMinions) {
			DestroyAllMinions destroyAllMinions = (DestroyAllMinions)battleCryEffect;

			LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
			LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

			emptyHand = destroyAllMinions.shouldEmptyHand();

			destroyAllMinions.effect(friendlyMinionList, enemyMinionList);

			checkDeathBoard();
		}
	}

	public int getNumberOfShields(LinkedList<Minion> minionList, boolean removeShields) {
		int numberOfShields = 0;
		for (Minion minion : minionList) {
			if (minion.hasDivineShield()) {
				numberOfShields++;

				if (removeShields) {
					minion.setDivineShield(false);
				}
			}
		}

		return numberOfShields;
	}

//#1000
	/*HERE*/ // does it matter if there is an enemy minion or a friendly one?
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
		} else if (deathRattleEffect instanceof SummonRandomMinionsFromDeck) {
			SummonRandomMinionsFromDeck summonRandomMinionsFromDeck = (SummonRandomMinionsFromDeck)deathRattleEffect;

			LinkedList<PlayCard> friendlyDeck = getDeck(turnIndex);
			LinkedList<PlayCard> enemyDeck = getDeck((turnIndex + 1) % 2);
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonRandomMinionsFromDeck.effect(friendlyDeck, friendlyPlayerMinionTempList, enemyDeck, enemyPlayerMinionTempList);
		} else if (deathRattleEffect instanceof DrawCards) {
			DrawCards drawCards = (DrawCards)deathRattleEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);
			LinkedList<PlayCard> deck = getDeck(turnIndex);

			drawCards.effect(cardHand, deck);
		} else if (deathRattleEffect instanceof AddRandomSpellCardToHand) {
			/*HERE*/
			AddRandomSpellCardToHand addRandomSpellCardToHand = (AddRandomSpellCardToHand)deathRattleEffect;

			if (addRandomSpellCardToHand.giveSelf()) {
				LinkedList<PlayCard> cardHand = getHand(turnIndex);
				addRandomSpellCardToHand.effect(cardHand, true);
			}

			if (addRandomSpellCardToHand.giveEnemy()) {
				LinkedList<PlayCard> cardHand = getHand((turnIndex + 1) % 2);
				addRandomSpellCardToHand.effect(cardHand, false);
			}
		} else if (deathRattleEffect instanceof AddCardToDeck) {
			AddCardToDeck addCardToDeck = (AddCardToDeck)deathRattleEffect;
			LinkedList<PlayCard> friendlyDeck = getDeck(turnIndex);
			LinkedList<PlayCard> enemyDeck = getDeck((turnIndex + 1) % 2);

			addCardToDeck.effect(friendlyDeck, enemyDeck);
		} else if (deathRattleEffect instanceof DealDamageToAllCharacters) {
			DealDamageToAllCharacters dealDamageToAllCharacters = (DealDamageToAllCharacters)deathRattleEffect;

			dealDamageToAllCharacters.effect(damageHandler, turnIndex);

			checkDeathBoard();
		} else if (deathRattleEffect instanceof MindControlRandom) {
			MindControlRandom mindControlRandom = (MindControlRandom)deathRattleEffect;
			LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
			LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

			int enemyMinionListSize = enemyMinionList.size();
			if (enemyMinionListSize == 0) {
				return;
			}

			int randomIndex = ((int)(Math.random() * 100)) % enemyMinionListSize;
			Minion stolenMinion = enemyMinionList.remove(randomIndex);

			mindControlRandom.effect(stolenMinion, friendlyMinionList);
		} else if (deathRattleEffect instanceof DealRandomDamageRandomly) {
			DealRandomDamageRandomly dealRandomDamageRandomly = (DealRandomDamageRandomly)deathRattleEffect;

			int targetChoice;
			int turnNumber = turnIndex;

			if (dealRandomDamageRandomly.attackingEnemiesOnly()) {
				turnNumber = (turnNumber + 1) % 2;
				LinkedList<Minion> enemyMinionList = getMinionList(turnNumber);
				targetChoice = ((int)(Math.random() * 100)) % (enemyMinionList.size() + 1) - 1;

				if (targetChoice == -1) {
					targetChoice = TARGETPLAYER;
				}
			} else {
				return;
			}

			dealRandomDamageRandomly.effect(damageHandler, targetChoice, turnNumber);

			if (targetChoice != TARGETPLAYER) {
				checkDeath(targetChoice, turnNumber);
			}
		} else if (deathRattleEffect instanceof HealCharacter) {
			HealCharacter healCharacter = (HealCharacter)deathRattleEffect;
			int minionIndex = -1;
			int turnNumber = turnIndex;

			if (healCharacter.mustTargetPlayer()) {
				minionIndex = TARGETPLAYER;

				if (!healCharacter.targetSelf()) {
					turnNumber = (turnNumber + 1) % 2;
				}
			} else {
				return;
			}

			healCharacterEffect(healCharacter, minionIndex, turnNumber);
		}
	}

//#1100
	public boolean manageStartTurnEffect(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);
		TurnEffect startTurnEffect = minion.getStartTurnEffect();

		if (turn != turnIndex && !startTurnEffect.activeOnBothTurns()) {
			return false;
		}

		if (startTurnEffect instanceof DestroyAllMinionsTurnEffect) {
			DestroyAllMinionsTurnEffect destroyAllMinionsTurnEffect = (DestroyAllMinionsTurnEffect)startTurnEffect;

			LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
			LinkedList<Minion> enemyMinionList = getMinionList((turnIndex + 1) % 2);

			emptyHand = destroyAllMinionsTurnEffect.shouldEmptyHand();

			destroyAllMinionsTurnEffect.effect(friendlyMinionList, enemyMinionList);

			checkDeathBoard();
		} else if (startTurnEffect instanceof SummonRandomMinionFromHandTurnEffect) {
			SummonRandomMinionFromHandTurnEffect summonRandomMinionFromHandTurnEffect = (SummonRandomMinionFromHandTurnEffect)startTurnEffect;

			summonMinionFromHand(summonRandomMinionFromHandTurnEffect, turnIndex);

			if (summonRandomMinionFromHandTurnEffect.forBothPlayer()) {
				summonMinionFromHand(summonRandomMinionFromHandTurnEffect, (turnIndex + 1) % 2);
			}

			if (summonRandomMinionFromHandTurnEffect.shouldReturnMinion()) {
				MonsterCard monsterCard = new MonsterCard(minion.getType());
				LinkedList<PlayCard> handList = getHand(turnIndex);

				handList.add(monsterCard);
				removeMinionFromBoard(minionIndex, turnIndex);

				return true;
			}
		} else if (startTurnEffect instanceof BuffMinionTurnEffect) {
			BuffMinionTurnEffect buffMinionTurnEffect = (BuffMinionTurnEffect)startTurnEffect;
			Minion minionToBeBuffed;

			if (buffMinionTurnEffect.buffOtherMinions()) {
				LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
				int index = minionIndex;
				while (index == minionIndex) {
					index = (int)(Math.random() * 100) % friendlyMinionList.size();					
				}
				minion = friendlyMinionList.get(index);
			} else {
				minionToBeBuffed = minion;
			}

			buffMinionTurnEffect.effect(minion);
		}

		return false;
	}

	public void summonMinionFromHand(SummonRandomMinionFromHandTurnEffect summonRandomMinionFromHandTurnEffect, int turnIndex) {
		LinkedList<PlayCard> handList = getHand(turnIndex);
		LinkedList<Minion> minionList = getMinionList(turnIndex);
		int cardToPlayIndex = summonRandomMinionFromHandTurnEffect.effect(handList);
		PlayCard cardToPlay = handList.get(cardToPlayIndex);

		addMinionToBoardRemoveFromHand(minionList, cardToPlayIndex, turnIndex);

		System.out.println(cardToPlay.getName() + " got summoned!");
	}

//#1200
	public void manageEndTurnEffect(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);
		TurnEffect endTurnEffect = minion.getEndTurnEffect();

		if (turn != turnIndex && !endTurnEffect.activeOnBothTurns()) {
			return;
		}

		if (endTurnEffect instanceof DrawCardsTurnEffect) {
			DrawCardsTurnEffect drawCardsTurnEffect = (DrawCardsTurnEffect)endTurnEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);
			LinkedList<PlayCard> deck = getDeck(turnIndex);

			drawCardsTurnEffect.effect(cardHand, deck);
		} else if (endTurnEffect instanceof AddDreamCardToHandTurnEffect) {
			AddDreamCardToHandTurnEffect addDreamCardToHandTurnEffect = (AddDreamCardToHandTurnEffect)endTurnEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);

			addDreamCardToHandTurnEffect.effect(cardHand);
		} else if (endTurnEffect instanceof HandCostTurnEffect) {
			HandCostTurnEffect handCostTurnEffect = (HandCostTurnEffect)endTurnEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);

			handCostTurnEffect.effect(cardHand);
		} else if (endTurnEffect instanceof BuffMinionTurnEffect) {
			BuffMinionTurnEffect buffMinionTurnEffect = (BuffMinionTurnEffect)endTurnEffect;
			Minion minionToBeBuffed;

			if (buffMinionTurnEffect.buffOtherMinions()) {
				LinkedList<Minion> friendlyMinionList = getMinionList(turnIndex);
				int index = 0;
				while (true) {
					index = (int)(Math.random() * 100) % friendlyMinionList.size();

					if (index != minionIndex) {
						break;
					}
				}
				minion = friendlyMinionList.get(index);
			} else {
				minionToBeBuffed = minion;
			}

			buffMinionTurnEffect.effect(minion);
		} else if (endTurnEffect instanceof DealDamageToAllCharactersTurnEffect) {
			DealDamageToAllCharactersTurnEffect dealDamageToAllCharactersTurnEffect = (DealDamageToAllCharactersTurnEffect)endTurnEffect;

			dealDamageToAllCharactersTurnEffect.effect(damageHandler, minionIndex, turnIndex);

			if (dealDamageToAllCharactersTurnEffect.damageBoard()) {
				checkDeathBoard();
			}
		} else if (endTurnEffect instanceof DealDamageRandomTurnEffect) {
			int targetChoice;
			int turnNumber = turnIndex;

			DealDamageRandomTurnEffect dealDamageRandomTurnEffect = (DealDamageRandomTurnEffect)endTurnEffect;

			if (dealDamageRandomTurnEffect.attackingEnemiesOnly()) {
				turnNumber = (turnNumber + 1) % 2;
				LinkedList<Minion> enemyMinionList = getMinionList(turnNumber);
				targetChoice = ((int)(Math.random() * 100)) % (enemyMinionList.size() + 1) - 1;

				if (targetChoice == -1) {
					targetChoice = TARGETPLAYER;
				}
			} else {
				return;
			}

			dealDamageRandomTurnEffect.effect(damageHandler, targetChoice, turnNumber);

			if (targetChoice != TARGETPLAYER) {
				checkDeath(targetChoice, turnNumber);
			}
		} else if (endTurnEffect instanceof ReviveFriendlyMinionsTurnEffect) {
			ReviveFriendlyMinionsTurnEffect reviveFriendlyMinionsTurnEffect = (ReviveFriendlyMinionsTurnEffect)endTurnEffect;
			LinkedList<Minion> minionList = getMinionList(turnIndex);
			LinkedList<Minion> deadMinions = getDeadMinionList(turnIndex);

			reviveFriendlyMinionsTurnEffect.effect(deadMinions, minionList);
		} else if (endTurnEffect instanceof SummonMinionTurnEffect) {
			SummonMinionTurnEffect summonMinionTurnEffect = (SummonMinionTurnEffect)endTurnEffect;
			LinkedList<Minion> friendlyPlayerMinionTempList = getTempMinionList(turnIndex);
			LinkedList<Minion> enemyPlayerMinionTempList = getTempMinionList((turnIndex + 1) % 2);

			summonMinionTurnEffect.effect(friendlyPlayerMinionTempList, enemyPlayerMinionTempList);
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

//#1300
	public void addToDeadList(Minion minion, int turnIndex) {
		LinkedList<Minion> deadMinionList = getDeadMinionList(turnIndex);

		deadMinionList.add(minion);
	}

	public void removeMinionFromBoard(int minionIndex, int turnIndex) {
		LinkedList<Minion> minionList = getMinionList(turnIndex);

		minionList.remove(minionIndex);
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

	public void showHand() {
		System.out.println("----- Hand -----");

		printHandInfo(0);

		printHandInfo(1);
	}

	public void showBoard() {
		printPlayerInfo(0);

		System.out.println("----- BOARD -----");

		printBoardInfo(0);

		printBoardInfo(1);

		System.out.println("----- BOARD -----");

		printPlayerInfo(1);
	}

	public void printHandInfo(int turnIndex) {
		LinkedList<PlayCard> cardList = getHand(turnIndex);

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

	public void printPlayerInfo(int turnIndex) {
		Player player = getPlayer(turnIndex);

		System.out.println("Player" + (turnIndex + 1) + " Health: " + player.getHealth());
		System.out.println("Player" + (turnIndex + 1) + " Armor: " + player.getArmor());
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

//#1400
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
		char stealthChar = (minion.hasStealth() ? 'H' : '*');
		char deathrattleChar = (minion.hasDeathRattle() ? 'D' : '*');

		return "[" + tauntChar + chargeChar + divineShieldChar + windfuryChar + stealthChar + deathrattleChar + "]";
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