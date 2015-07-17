import java.util.LinkedList;

public class HealCharacter extends SpellEffect {
	private int healAmount;
	private boolean mustTargetPlayer;
	private boolean targetSelf;

	public HealCharacter(int healAmount, boolean mustTargetPlayer, boolean targetSelf) {
		this.healAmount = healAmount;
		this.mustTargetPlayer = mustTargetPlayer;
		this.targetSelf = targetSelf;
	}

	public boolean mustTargetPlayer() {
		return mustTargetPlayer;
	}

	public boolean targetSelf() {
		return targetSelf;
	}

	public void effect(Character character) {
		character.heal(healAmount);
	}
}