import java.util.LinkedList;

public class DealRandomDamageRandomly extends SpellEffect {
	private int startDamage;
	private int maximalAddDamage;
	private boolean enemiesOnly;

	public DealRandomDamageRandomly(int startDamage, int maximalAddDamage, boolean enemiesOnly) {
		this.enemiesOnly = enemiesOnly;
		this.startDamage = startDamage;
		this.maximalAddDamage = maximalAddDamage;
	}

	public boolean attackingEnemiesOnly() {
		return enemiesOnly;
	}

	public void effect(Character character) {
		int damageAmount = startDamage + ((int)(Math.random() * 100)) % maximalAddDamage;
		character.takeDamage(damageAmount);
	}
}