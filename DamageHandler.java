import java.util.LinkedList;

public class DamageHandler {
	private Player player1;
	private Player player2;

	private LinkedList<PlayCard> deck1;
	private LinkedList<PlayCard> deck2;

	private LinkedList<PlayCard> cardsInHand1;
	private LinkedList<PlayCard> cardsInHand2;

	private LinkedList<Minion> minionsOnBoard1;
	private LinkedList<Minion> minionsOnBoard2;

	public DamageHandler(Player player1, Player player2, LinkedList<PlayCard> deck1, LinkedList<PlayCard> deck2, LinkedList<PlayCard> cardsInHand1, LinkedList<PlayCard> cardsInHand2, LinkedList<Minion> minionsOnBoard1, LinkedList<Minion> minionsOnBoard2) {
		this.player1 = player1;
		this.player2 = player2;

		this.deck1 = deck1;
		this.deck2 = deck2;

		this.cardsInHand1 = cardsInHand1;
		this.cardsInHand2 = cardsInHand2;

		this.minionsOnBoard1 = minionsOnBoard1;
		this.minionsOnBoard2 = minionsOnBoard2;
	}

	public void dealDamageToPlayer(int damageAmount, int turnIndex) {
		Player player = getPlayer(turnIndex);

		player.takeDamage(damageAmount);

		System.out.println("Player " + (turnIndex + 1) + " takes " + damageAmount + " damage, has " + player.getHealth() + " left!");
	}

	public void dealDamageToMinion(int minionIndex, int damageAmount, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);
		boolean tookDamage = minion.takeDamage(damageAmount);

		if (tookDamage) {
			manageAllDamageEffects(minionIndex, turnIndex);
			manageEnrageEffect(minionIndex, turnIndex);
		}

		System.out.println(minion.getName() + " took " + damageAmount + " damage!");
	}

	private void manageAllDamageEffects(int minionIndex, int turnIndex) {
		LinkedList<Minion> friendlyMinionList = getBoard(turnIndex);
		LinkedList<Minion> enemyMinionList = getBoard((turnIndex + 1) % 2);

		manageDamageEffectsForList(friendlyMinionList, minionIndex, turnIndex);

		manageDamageEffectsForList(enemyMinionList, -1, (turnIndex + 1) % 2);
	}

	private void manageDamageEffectsForList(LinkedList<Minion> minionList, int minionIndex, int turnIndex) {
		for (int i = 0 ; i < minionList.size() ; i++) {
			Minion minion = minionList.get(i);

			if (activeDamageEffect(minion, i, minionIndex)) {
				manageDamageEffect(minion, turnIndex);
			}
		}
	}

	private boolean activeDamageEffect(Minion minion, int currentIndex, int minionIndex) {
		if (minionIndex == -1) {
			return minion.enemyBoardAreaEffect();
		} else {
			return (currentIndex == minionIndex || minion.friendlyBoardAreaEffect());
		}
	}

	public void manageDamageEffect(Minion minion, int turnIndex) {
		DamageEffect damageEffect = minion.getDamageEffect();

		if (damageEffect instanceof DrawCardsDamageEffect) {
			DrawCardsDamageEffect drawCardsDamageEffect = (DrawCardsDamageEffect)damageEffect;
			LinkedList<PlayCard> cardHand = getHand(turnIndex);
			LinkedList<PlayCard> deck = getDeck(turnIndex);

			drawCardsDamageEffect.effect(cardHand, deck);
		} else if (damageEffect instanceof BuffMinionDamageEffect) {
			BuffMinionDamageEffect buffMinionDamageEffect = (BuffMinionDamageEffect)damageEffect;

			buffMinionDamageEffect.effect(minion);
		} else if (damageEffect instanceof ArmorDamageEffect) {
			ArmorDamageEffect armorDamageEffect = (ArmorDamageEffect)damageEffect;
			Player player = getPlayer(turnIndex);

			armorDamageEffect.effect(player);
		} else if (damageEffect instanceof SummonMinionsDamageEffect) {
			SummonMinionsDamageEffect summonMinionsDamageEffect = (SummonMinionsDamageEffect)damageEffect;

			LinkedList<Minion> friendlyBoard = getBoard(turnIndex);
			LinkedList<Minion> enemyBoard = getBoard((turnIndex + 1) % 2);

			boolean minionSurvived = minion.getCurrentHealth() > 0;

			if (minionSurvived || !summonMinionsDamageEffect.onlyIfSurvived()) {
				summonMinionsDamageEffect.effect(friendlyBoard, enemyBoard);
			}
		}
	}

	public void manageEnrageEffect(int minionIndex, int turnIndex) {
		Minion minion = getMinion(minionIndex, turnIndex);

		if (minion.isEnraged()) {
			return;
		}

		EnrageEffect enrageEffect = minion.getEnrageEffect();

		System.out.println("Checking enrage for " + minion.getName());

		if (enrageEffect instanceof BuffSingleMinionEnrageEffect) {
			BuffSingleMinionEnrageEffect buffSingleMinionEnrageEffect = (BuffSingleMinionEnrageEffect)enrageEffect;

			buffSingleMinionEnrageEffect.effect(minion);

			System.out.println(minion.getName() + " got enraged!");
		}
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

	public LinkedList<Minion> getBoard(int turnIndex) {
		LinkedList<Minion> minionList;
		if (turnIndex == 0) {
			minionList = minionsOnBoard1;
		} else {
			minionList = minionsOnBoard2;
		}
		return minionList;
	}

	public Minion getMinion(int index, int turnIndex) {
		LinkedList<Minion> minionList = getBoard(turnIndex);

		if (index >= 0 && index < minionList.size()) {
			return minionList.get(index);
		}

		System.out.println(index + " is not a valid boardIndex for Player " + ((turnIndex + 1 ) % 2));

		return null;
	}
}