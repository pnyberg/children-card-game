import java.util.LinkedList;

public class ArmorDamageEffect extends DamageEffect {
	private int addArmor;
	private boolean friendlyMinionTakesDamage;
	private boolean enemyMinionTakesDamage;

	public ArmorDamageEffect(int addArmor, boolean friendlyMinionTakesDamage, boolean enemyMinionTakesDamage) {
		this.addArmor = addArmor;
		this.friendlyMinionTakesDamage = friendlyMinionTakesDamage;
		this.enemyMinionTakesDamage = enemyMinionTakesDamage;
	}

	public boolean friendlyBoardAreaEffect() {
		return friendlyMinionTakesDamage;
	}

	public boolean enemyBoardAreaEffect() {
		return enemyMinionTakesDamage;
	}

	public void effect(Player player) {
		player.addArmor(addArmor);
	}
}