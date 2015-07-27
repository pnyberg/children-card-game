import java.util.LinkedList;

public class HealRandomCharacterTurnEffect extends TurnEffect {
	private int healAmount;
	private boolean onlyHealFriendly;
	private boolean activeOnBothTurns;

	public HealRandomCharacterTurnEffect(int healAmount, boolean onlyHealFriendly, boolean activeOnBothTurns) {
		this.healAmount = healAmount;
		this.onlyHealFriendly = onlyHealFriendly;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean onlyHealFriendly() {
		return onlyHealFriendly;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(Character character) {
		character.heal(healAmount);
	}
}