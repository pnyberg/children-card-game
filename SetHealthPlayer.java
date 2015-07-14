import java.util.LinkedList;

public class SetHealthPlayer extends SpellEffect {
	int healthAmount;

	public SetHealthPlayer(int healthAmount) {
		this.healthAmount = healthAmount;
	}

	public void effect(Player player) {
		player.setHealth(healthAmount);
	}
}