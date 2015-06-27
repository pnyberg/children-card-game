import java.util.LinkedList;

public class BuffSingleMinion extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	private boolean temporarily;

	public BuffSingleMinion(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury, boolean temporarily) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;

		this.temporarily = temporarily;
	}

	public void effect(Minion minion) {
		if (temporarily) {
			minion.addTempAttack(additionalAttack);
			return;
		}

		minion.addAttack(additionalAttack);
		minion.addHealth(additionalHealth);

		if (taunt) { minion.setTaunt(taunt); }
		if (charge) { minion.setCharge(charge); }
		if (divineShield) { minion.setDivineShield(divineShield); }
		if (windfury) { minion.setWindfury(windfury); }
	}
}