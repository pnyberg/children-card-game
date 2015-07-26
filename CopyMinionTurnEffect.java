import java.util.LinkedList;

public class CopyMinionTurnEffect extends TurnEffect {
	private boolean activeOnBothTurns;
	private boolean activeOnlyOnce;

	public CopyMinionTurnEffect(boolean activeOnlyOnce, boolean activeOnBothTurns) {
		this.activeOnBothTurns = activeOnBothTurns;
		this.activeOnlyOnce = activeOnlyOnce;
	}

	public boolean activeOnlyOnce() {
		return activeOnlyOnce;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(Minion minion, LinkedList<Minion> board) {
		Minion newMinion = minion.clone();

		board.add(newMinion);
	}
}