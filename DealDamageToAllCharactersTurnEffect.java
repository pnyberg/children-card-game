import java.util.LinkedList;

public class DealDamageToAllCharactersTurnEffect extends TurnEffect {
	private int damageAmount;
	private boolean damageBoard;
	private boolean doNotDamageSelf;
	private boolean damagePlayers;
	private boolean activeOnBothTurns;

	public DealDamageToAllCharactersTurnEffect(int damageAmount, boolean damageBoard, boolean doNotDamageSelf, boolean damagePlayers, boolean activeOnBothTurns) {
		this.damageAmount = damageAmount;
		this.damageBoard = damageBoard;
		this.doNotDamageSelf = doNotDamageSelf;
		this.damagePlayers = damagePlayers;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean damageBoard() {
		return damageBoard;
	}

	public boolean doNotDamageSelf() {
		return doNotDamageSelf;
	}

	public boolean damagePlayers() {
		return damagePlayers;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(DamageHandler damageHandler, int selfIndex, int turnIndex) {
		if (damageBoard) {
			dealDamageToMinions(damageHandler, selfIndex, turnIndex);
			dealDamageToMinions(damageHandler, -1, (turnIndex + 1) % 2);
		}

		if (damagePlayers) {
			damageHandler.dealDamageToPlayer(damageAmount, turnIndex);
			damageHandler.dealDamageToPlayer(damageAmount, (turnIndex + 1) % 2);
		}
	}

	private void dealDamageToMinions(DamageHandler damageHandler, int selfIndex, int turnIndex) {
		LinkedList<Minion> minionList = damageHandler.getBoard(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			if (i == selfIndex && doNotDamageSelf) {
				continue;
			}

			damageHandler.dealDamageToMinion(i, damageAmount, turnIndex);
		}
	}
}