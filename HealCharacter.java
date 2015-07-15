import java.util.LinkedList;

public class HealCharacter extends SpellEffect {
	int healAmount;

	public HealCharacter(int healAmount) {
		this.healAmount = healAmount;
	}

	public void effect(Character character) {
		character.heal(healAmount);
	}
}