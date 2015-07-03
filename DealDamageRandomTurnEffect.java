import java.util.LinkedList;

public class DealDamageRandomTurnEffect extends TurnEffect {
	private int damageAmount;
	private boolean activeOnBothTurns;
	private boolean enemiesOnly;

	public DealDamageRandomTurnEffect(int damageAmount, boolean activeOnBothTurns, boolean enemiesOnly) {
		this.damageAmount = damageAmount;
		this.activeOnBothTurns = activeOnBothTurns;
		this.enemiesOnly = enemiesOnly;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public boolean attackingEnemiesOnly() {
		return enemiesOnly;
	}

	public void effect(Character character) {
		character.takeDamage(damageAmount);
	}
}