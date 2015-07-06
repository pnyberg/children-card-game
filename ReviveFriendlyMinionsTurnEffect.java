import java.util.LinkedList;

public class ReviveFriendlyMinionsTurnEffect extends TurnEffect {
	private boolean activeOnBothTurns;

	public ReviveFriendlyMinionsTurnEffect(boolean activeOnBothTurns) {
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(LinkedList<Minion> deadMinions, LinkedList<Minion> friendlyMinions) {
		for (Minion minion : deadMinions) {
			if (friendlyMinions.size() == 7) {
				break;
			}
			minion.restore();
			friendlyMinions.add(minion);
		}
	}
}