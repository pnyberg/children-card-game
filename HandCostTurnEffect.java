import java.util.LinkedList;

public class HandCostTurnEffect extends TurnEffect {
	private int costChange;
	private boolean activeOnBothTurns;

	public HandCostTurnEffect(int costChange, boolean activeOnBothTurns) {
		this.costChange = costChange;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(LinkedList<PlayCard> hand) {
		for (PlayCard monsterCard : hand) {
			monsterCard.changeCost(costChange);
		}
	}
}