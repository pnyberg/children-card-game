import java.util.LinkedList;

public class DestroyAllMinionsTurnEffect extends TurnEffect {
	private boolean activeOnBothTurns;
	private boolean emptyHand;

	public DestroyAllMinionsTurnEffect(boolean activeOnBothTurns, boolean emptyHand) {
		this.emptyHand = emptyHand;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public boolean shouldEmptyHand() {
		return emptyHand;
	}

	public void effect(LinkedList<Minion> friendlyMinions, LinkedList<Minion> enemyMinions) {
		for(Minion minion : friendlyMinions) {
			minion.kill();
		}

		for(Minion minion : enemyMinions) {
			minion.kill();
		}
	}
}