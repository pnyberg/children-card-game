import java.util.LinkedList;

public class CostDeterminedByHealth extends SpellEffect {
	private int diffPerHealth;
	private boolean basedOnFriendlyPlayer;

	public CostDeterminedByHealth(int diffPerHealth, boolean basedOnFriendlyPlayer) {
		this.diffPerHealth = diffPerHealth;
		this.basedOnFriendlyPlayer = basedOnFriendlyPlayer;
	}

	public boolean basedOnFriendlyPlayer() {
		return basedOnFriendlyPlayer;
	}

	public void effect(PlayCard card, int healthLost) {
		int subtractedCost = healthLost * diffPerHealth;
		int newCost = card.getOriginalCost() - subtractedCost;

		card.setCost(newCost);
	}
}