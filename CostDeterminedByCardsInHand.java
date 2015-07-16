import java.util.LinkedList;

public class CostDeterminedByCardsInHand extends SpellEffect {
	private int diffPerCard;
	private boolean basedOnFriendlyHand;
	private boolean basedOnEnemyHand;

	public CostDeterminedByCardsInHand(int diffPerCard, boolean basedOnFriendlyHand, boolean basedOnEnemyHand) {
		this.diffPerCard = diffPerCard;
		this.basedOnFriendlyHand = basedOnFriendlyHand;
		this.basedOnEnemyHand = basedOnEnemyHand;
	}

	public boolean basedOnFriendlyHand() {
		return basedOnFriendlyHand;
	}

	public boolean basedOnEnemyHand() {
		return basedOnEnemyHand;
	}

	public void effect(PlayCard card, int cardsInHand) {
		int subtractedCost = cardsInHand * diffPerCard;
		int newCost = card.getOriginalCost() - subtractedCost;

		card.setCost(newCost);
	}
}