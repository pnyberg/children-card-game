import java.util.LinkedList;

public class DealDamageToAllCharacters extends SpellEffect {
	private int damageAmount;
	private boolean damageFriendlyBoard;
	private boolean damageEnemyBoard;
	private boolean damageFriendlyPlayer;
	private boolean damageEnemyPlayer;
//	private boolean doNotDamageSelf;

	public DealDamageToAllCharacters(int damageAmount, boolean damageFriendlyBoard, boolean damageEnemyBoard, boolean damageFriendlyPlayer, boolean damageEnemyPlayer) {
		this.damageAmount = damageAmount;

		this.damageFriendlyBoard = damageFriendlyBoard;
		this.damageEnemyBoard = damageEnemyBoard;
		this.damageFriendlyPlayer = damageFriendlyPlayer;
		this.damageEnemyPlayer = damageEnemyPlayer;
	}

	public boolean damageFriendlyBoard() {
		return damageFriendlyBoard;
	}

	public boolean damageEnemyBoard() {
		return damageEnemyBoard;
	}

	public boolean damageFriendlyPlayer() {
		return damageFriendlyPlayer;
	}

	public boolean damageEnemyPlayer() {
		return damageEnemyPlayer;
	}

	public void effect(DamageHandler damageHandler, int turnIndex) {
		if (damageFriendlyBoard) {
			dealDamageToMinions(damageHandler, turnIndex);
		}

		if (damageEnemyBoard) {
			dealDamageToMinions(damageHandler, (turnIndex + 1) % 2);
		}

		if (damageFriendlyPlayer) {
			damageHandler.dealDamageToPlayer(damageAmount, turnIndex);
		}

		if (damageEnemyPlayer) {
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