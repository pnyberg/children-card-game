import java.util.LinkedList;

public class BuffSingleMinionEnrageEffect extends EnrageEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public BuffSingleMinionEnrageEffect(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public void effect(Minion minion) {
		minion.setEnrage(true);
		minion.addEnrageAttack(additionalAttack);

		if (taunt) { minion.setEnrageTaunt(true); }
		if (charge) { minion.setEnrageCharge(true); }
		if (divineShield) { minion.setEnrageDivineShield(true); }
		if (windfury) { minion.setEnrageWindfury(true); }
	}
}