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

	public boolean damageSelf() {
		return self;
	}

	public boolean damageEnemy() {
		return enemy;
	}

	public void effect(Player player) {
		player.takeDamage(damageAmount);
	}
}