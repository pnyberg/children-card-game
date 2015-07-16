import java.util.LinkedList;

public class BuffAccordingToHand extends SpellEffect {
	private int additionalAttackPerMinion;
	private int additionalHealthPerMinion;

	private boolean accordingToFriendlyHand;
	private boolean accordingToEnemyHand;
	private boolean buffFriendlyMinion;
	private boolean buffEnemyMinion;


	public BuffAccordingToHand(int additionalAttackPerMinion, int additionalHealthPerMinion, boolean accordingToFriendlyHand, boolean accordingToEnemyHand, boolean buffFriendlyMinion, boolean buffEnemyMinion) {
		this.additionalAttackPerMinion = additionalAttackPerMinion;
		this.additionalHealthPerMinion = additionalHealthPerMinion;

		this.accordingToFriendlyHand = accordingToFriendlyHand;
		this.accordingToEnemyHand = accordingToEnemyHand;
		this.buffFriendlyMinion = buffFriendlyMinion;
		this.buffEnemyMinion = buffEnemyMinion;
	}

	public boolean buffAccordingToFriendlyHand() {
		return accordingToFriendlyHand;
	}

	public boolean buffAccordingToEnemyHand() {
		return accordingToEnemyHand;
	}

	public boolean buffFriendlyMinion() {
		return buffFriendlyMinion;
	}

	public boolean buffEnemyMinion() {
		return buffEnemyMinion;
	}

	public boolean buffSelf() {
		return !buffFriendlyMinion && !buffEnemyMinion;
	}

	public void effect(Minion minion, int numberOfCards) {
		int additionalAttack = numberOfCards * additionalAttackPerMinion;
		int additionalHealth = numberOfCards * additionalHealthPerMinion;

		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);
	}
}