import java.util.LinkedList;

public class SetStatsSingleMinion extends SpellEffect {
	private int newAttack;
	private int newHealth;

	public SetStatsSingleMinion(int newAttack, int newHealth) {
		this.newAttack = newAttack;
		this.newHealth = newHealth;
	}

	public void effect(Minion minion) {
		if (newAttack > -1) {
			minion.setAttack(newAttack);
		}
		if (newHealth > -1) {
			minion.setHealth(newHealth);
		}
	}
}