import java.util.LinkedList;

public class BuffAccordingToDivineShields extends SpellEffect {
	private int additionalAttackPerDivineShield;
	private int additionalHealthPerDivineShield;

	private boolean removeShields;
	private boolean accordingToFriendlyBoard;
	private boolean accordingToEnemyBoard;
	private boolean buffFriendlyMinion;
	private boolean buffEnemyMinion;


	public BuffAccordingToDivineShields(int additionalAttackPerDivineShield, int additionalHealthPerDivineShield, boolean removeShields, boolean accordingToFriendlyBoard, boolean accordingToEnemyBoard, boolean buffFriendlyMinion, boolean buffEnemyMinion) {
		this.additionalAttackPerDivineShield = additionalAttackPerDivineShield;
		this.additionalHealthPerDivineShield = additionalHealthPerDivineShield;

		this.removeShields = removeShields;
		this.accordingToFriendlyBoard = accordingToFriendlyBoard;
		this.accordingToEnemyBoard = accordingToEnemyBoard;
		this.buffFriendlyMinion = buffFriendlyMinion;
		this.buffEnemyMinion = buffEnemyMinion;
	}

	public boolean removeShields() {
		return removeShields;
	}

	public boolean buffAccordingToFriendlyBoard() {
		return accordingToFriendlyBoard;
	}

	public boolean buffAccordingToEnemyBoard() {
		return accordingToEnemyBoard;
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

	public void effect(Minion minion, int numberOfShields) {
		int additionalAttack = numberOfShields * additionalAttackPerDivineShield;
		int additionalHealth = numberOfShields * additionalHealthPerDivineShield;

		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);
	}
}