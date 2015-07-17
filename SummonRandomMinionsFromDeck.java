import java.util.LinkedList;

public class SummonRandomMinionsFromDeck extends SpellEffect {
	private int numberOfFriendlyMinions;
	private int numberOfEnemyMinions;
	private boolean removeFriendlyCardFromDeck;
	private boolean removeEnemyCardFromDeck;

	public SummonRandomMinionsFromDeck(int numberOfFriendlyMinions, boolean removeFriendlyCardFromDeck, int numberOfEnemyMinions, boolean removeEnemyCardFromDeck) {
		this.numberOfFriendlyMinions = numberOfFriendlyMinions;
		this.numberOfEnemyMinions = numberOfEnemyMinions;

		this.removeFriendlyCardFromDeck = removeFriendlyCardFromDeck;
		this.removeEnemyCardFromDeck = removeEnemyCardFromDeck;
	}

	public void effect(LinkedList<PlayCard> friendlyDeck, LinkedList<Minion> friendlyMinionList, LinkedList<PlayCard> enemyDeck, LinkedList<Minion> enemyMinionList) {
		pickOutCardsFromDeck(friendlyDeck, friendlyMinionList, numberOfFriendlyMinions, removeFriendlyCardFromDeck);

		pickOutCardsFromDeck(enemyDeck, enemyMinionList, numberOfEnemyMinions, removeEnemyCardFromDeck);
	}

	private void pickOutCardsFromDeck(LinkedList<PlayCard> deck, LinkedList<Minion> minionList, int numberOfMinions, boolean removeFromDeck) {
		int number = 0;

		while (number < numberOfMinions) {
			if (deck.size() == 0) {
				break;
			}

			int index = ((int)(Math.random() * 100)) % deck.size();
			PlayCard card = deck.get(index);

			System.out.println(index + " " + number);

			if (card instanceof MonsterCard) {
				MonsterCard monsterCard = (MonsterCard)card;
				Minion minion = monsterCard.toMinion();
				minionList.add(minion);

				if (removeFromDeck) {
					deck.remove(index);
				}

				number++;
			}
		}
	}
}