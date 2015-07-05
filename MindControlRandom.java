import java.util.LinkedList;

public class MindControlRandom extends SpellEffect {
	public MindControlRandom() {
	}

	public void effect(Minion minion, LinkedList<Minion> friendlyMinions) {
		friendlyMinions.add(minion);
	}
}