import java.util.LinkedList;

public class DestroyAllMinions extends SpellEffect {
	public DestroyAllMinions() {
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