import java.util.LinkedList;

public class SwapAttackHealthMinion extends SpellEffect {
	public SwapAttackHealthMinion() {
	}

	public void effect(Minion minion) {
		int attack = minion.getCurrentAttack();
		int health = minion.getCurrentHealth();

		minion.setAttack(health);
		minion.setHealth(attack);
	}
}