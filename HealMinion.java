import java.util.LinkedList;

public class HealMinion extends SpellEffect {
	int healAmount;

	public HealMinion(int healAmount) {
		this.healAmount = healAmount;
	}

	public void effect(Character character) {
		character.heal(healAmount);
	}
}