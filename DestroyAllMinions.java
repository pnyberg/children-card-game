import java.util.LinkedList;

public class DestroyAllMinions extends SpellEffect {
	public DestroyAllMinions() {
	}

	public void effect(LinkedList<Minion> friendlyMinions, LinkedList<Minion> enemyMinions) {
		friendlyMinions.clear();
		enemyMinions.clear();
	}
}