import java.util.LinkedList;

public class AddCardToDeck extends SpellEffect {
	private int[] friendlyMinionsToBeSummonedTypes;
	private int[] enemyMinionsToBeSummonedTypes;

	public AddCardToDeck(int[] friendlyMinionsToBeSummonedTypes, int[] enemyMinionsToBeSummonedTypes) {
		this.friendlyMinionsToBeSummonedTypes = friendlyMinionsToBeSummonedTypes;
		this.enemyMinionsToBeSummonedTypes = enemyMinionsToBeSummonedTypes;
	}

	public void effect(LinkedList<PlayCard> friendlyDeck, LinkedList<PlayCard> enemyDeck) {
		addToRandomPlaceInDeck(friendlyDeck, friendlyMinionsToBeSummonedTypes);

		addToRandomPlaceInDeck(enemyDeck, enemyMinionsToBeSummonedTypes);
	}

	private void addToRandomPlaceInDeck(LinkedList<PlayCard> deck, int[] minionTypes) {
		LinkedList<PlayCard> cards = new LinkedList<PlayCard>();

		arrayToList(minionTypes, cards);

		for (PlayCard card : cards) {
			int index = ((int)Math.random() * 100) % (deck.size() + 1);
			deck.add(index, card);
		}
	}

	private void arrayToList(int[] array, LinkedList<PlayCard> list) {
		if (array != null) {
			for (int minionType : array) {
				MonsterCard minion = new MonsterCard(minionType);
				list.add(minion);
			}
		}
	}
}