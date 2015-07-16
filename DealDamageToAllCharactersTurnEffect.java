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

	public void effect(LinkedList<Minion> friendlyMinions, int selfIndex, LinkedList<Minion> enemyMinions, Player self, Player enemy) {
		if (damageBoard) {
			dealDamageToMinions(friendlyMinions, selfIndex);
			dealDamageToMinions(enemyMinions, -1);
		}

		if (damagePlayers) {
			self.takeDamage(damageAmount);
			enemy.takeDamage(damageAmount);
		}
	}

	private void dealDamageToMinions(LinkedList<Minion> minionList, int selfIndex) {
		for (int i = 0 ; i < minionList.size() ; i++) {
			if (i == selfIndex && doNotDamageSelf) {
				continue;
			}
			Minion minion = minionList.get(i);
			minion.takeDamage(damageAmount);
		}
	}
}