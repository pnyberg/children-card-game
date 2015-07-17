import java.util.LinkedList;

public class DealDamageToAllCharacters extends SpellEffect {
	private int damageAmount;
	private boolean damageBoard;
	private boolean damagePlayers;
//	private boolean doNotDamageSelf;

	public DealDamageToAllCharacters(int damageAmount, boolean damageBoard, boolean damagePlayers) {
		this.damageAmount = damageAmount;
		this.damageBoard = damageBoard;
		this.damagePlayers = damagePlayers;
	}

	public boolean damageBoard() {
		return damageBoard;
	}

	public boolean damagePlayers() {
		return damagePlayers;
	}

	public void effect(DamageHandler damageHandler, int turnIndex) {
		if (damageBoard) {
			dealDamageToMinions(damageHandler, turnIndex);
			dealDamageToMinions(damageHandler, (turnIndex + 1) % 2);
		}

		if (damagePlayers) {
			damageHandler.dealDamageToPlayer(damageAmount, turnIndex);
			damageHandler.dealDamageToPlayer(damageAmount, (turnIndex + 1) % 2);
		}
	}

	private void dealDamageToMinions(DamageHandler damageHandler, int turnIndex) {
		LinkedList<Minion> minionList = damageHandler.getBoard(turnIndex);

		for (int i = 0 ; i < minionList.size() ; i++) {
			damageHandler.dealDamageToMinion(i, damageAmount, turnIndex);
		}
	}
}