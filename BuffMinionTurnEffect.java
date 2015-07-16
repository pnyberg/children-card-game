import java.util.LinkedList;

public class BuffMinionTurnEffect extends TurnEffect {
	private int additionalAttack;
	private int additionalHealth;
	private boolean activeOnBothTurns;
	private boolean buffOtherMinions;

	public BuffMinionTurnEffect(int additionalAttack, int additionalHealth, boolean activeOnBothTurns, boolean buffOtherMinions) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;
		this.activeOnBothTurns = activeOnBothTurns;
		this.buffOtherMinions = buffOtherMinions;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public boolean buffOtherMinions() {
		return buffOtherMinions;
	}

	public void effect(Minion minion) {
		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);
	}
}