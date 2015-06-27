import java.util.LinkedList;

public class PickUpMinion extends SpellEffect {
	int costChange;

	public PickUpMinion(int costChange) {
		this.costChange = costChange;
	}

	public void effect(Minion minion, LinkedList<PlayCard> hand) {
		MonsterCard monsterCard = new MonsterCard(minion.getType());
		monsterCard.changeCost(costChange);
		hand.add(monsterCard);
	}
}