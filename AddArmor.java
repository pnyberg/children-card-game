import java.util.LinkedList;

public class AddArmor extends SpellEffect {
	private int armorAmount;
	private boolean self;
	private boolean enemy;

	public AddArmor(int armorAmount, boolean self, boolean enemy) {
		this.armorAmount = armorAmount;
		this.self = self;
		this.enemy = enemy;
	}

	public boolean giveArmorToSelf() {
		return self;
	}

	public boolean giveArmorToEnemy() {
		return enemy;
	}

	public void effect(Player player) {
		player.addArmor(armorAmount);
	}
}