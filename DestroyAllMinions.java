import java.util.LinkedList;

public class DestroyAllMinions extends SpellEffect {
	private boolean emptyHand;

	public DestroyAllMinions(boolean emptyHand) {
		this.emptyHand = emptyHand;
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