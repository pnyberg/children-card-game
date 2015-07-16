import java.util.LinkedList;

public class BuffAccordingToBoard extends SpellEffect {
	private int additionalAttackPerMinion;
	private int additionalHealthPerMinion;

	private boolean accordingToFriendlyBoard;
	private boolean accordingToEnemyBoard;
	private boolean buffFriendlyMinion;
	private boolean buffEnemyMinion;


	public BuffAccordingToBoard(int additionalAttackPerMinion, int additionalHealthPerMinion, boolean accordingToFriendlyBoard, boolean accordingToEnemyBoard, boolean buffFriendlyMinion, boolean buffEnemyMinion) {
		this.additionalAttackPerMinion = additionalAttackPerMinion;
		this.additionalHealthPerMinion = additionalHealthPerMinion;

		this.accordingToFriendlyBoard = accordingToFriendlyBoard;
		this.accordingToEnemyBoard = accordingToEnemyBoard;
		this.buffFriendlyMinion = buffFriendlyMinion;
		this.buffEnemyMinion = buffEnemyMinion;
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

	public void effect(Minion minion, int numberOfMinions) {
		int additionalAttack = numberOfMinions * additionalAttackPerMinion;
		int additionalHealth = numberOfMinions * additionalHealthPerMinion;

		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);
	}
}