import java.util.LinkedList;

public class SwapHealthMinion extends SpellEffect {
	public SwapHealthMinion() {
	}

	public void effect(Minion minion, Minion other) {
		int healthDiff = other.getCurrentHealth() - minion.getCurrentHealth();
		minion.addHealth(healthDiff);
		other.addHealth(-healthDiff);
	}
}