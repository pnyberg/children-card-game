import java.util.LinkedList;

public class SpellEffect_BuffSingleMinionOfOneSide extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public SpellEffect_BuffSingleMinionOfOneSide(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public void effect(Minion minion) {
		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);
	}
}