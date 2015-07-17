import java.util.LinkedList;

public class DealDamageToPlayer extends SpellEffect {
	private int damageAmount;
	private boolean self;
	private boolean enemy;

	public DealDamageToPlayer(int damageAmount, boolean self, boolean enemy) {
		this.damageAmount = damageAmount;
		this.self = self;
		this.enemy = enemy;
	}

	public void effect(DamageHandler damageHandler, int turnIndex) {
		if (self) {
			damageHandler.dealDamageToPlayer(damageAmount, turnIndex);
		}

		if (enemy) {
			damageHandler.dealDamageToPlayer(damageAmount, (turnIndex + 1) % 2);
		}
	}
}