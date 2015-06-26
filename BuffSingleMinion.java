import java.util.LinkedList;

public class BuffSingleMinion extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public BuffSingleMinion(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
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

		if (taunt) { minion.setTaunt(taunt); }
		if (charge) { minion.setCharge(charge); }
		if (divineShield) { minion.setDivineShield(divineShield); }
		if (windfury) { minion.setWindfury(windfury); }
	}
}