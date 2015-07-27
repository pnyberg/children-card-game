import java.util.LinkedList;

public class TransformIntoMinion extends SpellEffect {
	public TransformIntoMinion() {
	}

	public void effect(Minion minion, LinkedList<Minion> list) {
		Minion newMinion = minion.clone();

		list.add(newMinion);
	}
}