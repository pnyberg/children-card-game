import java.util.LinkedList;

public class BuffMinionDamageEffect extends DamageEffect {
	private int addAttack;
	private int addHealth;
	private boolean doubleAttack;
	private boolean friendlyMinionTakesDamage;
	private boolean enemyMinionTakesDamage;

	public BuffMinionDamageEffect(int addAttack, int addHealth, boolean doubleAttack, boolean friendlyMinionTakesDamage, boolean enemyMinionTakesDamage) {
		this.addAttack = addAttack;
		this.addHealth = addHealth;
		this.doubleAttack = doubleAttack;
		this.friendlyMinionTakesDamage = friendlyMinionTakesDamage;
		this.enemyMinionTakesDamage = enemyMinionTakesDamage;
	}

	public boolean friendlyBoardAreaEffect() {
		return friendlyMinionTakesDamage;
	}

	public boolean enemyBoardAreaEffect() {
		return enemyMinionTakesDamage;
	}

	public void effect(Minion minion) {
		if (doubleAttack) {
			int attack = minion.getCurrentAttack() * 2;
			minion.setAttack(attack);
		} else {
			minion.addAttack(addAttack);
			minion.addHealth(addHealth);
		}
	}
}