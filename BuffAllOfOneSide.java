import java.util.LinkedList;

public class BuffAllOfOneSide extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public BuffAllOfOneSide(int additionalAttack, int additionalHealth) {
		this(additionalAttack, additionalHealth, false, false, false, false);
	}

	public BuffAllOfOneSide(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public void effect(LinkedList<Minion> minionList) {
		for (Minion minion : minionList) {
			minion.addAttack(additionalAttack);
			minion.addHealth(additionalHealth);
		}
	}
}