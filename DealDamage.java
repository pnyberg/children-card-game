import java.util.LinkedList;

public class DealDamage extends SpellEffect {
	int damageAmount;

	public DealDamage(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	public void effect(Character character) {
		character.takeDamage(damageAmount);
	}
}