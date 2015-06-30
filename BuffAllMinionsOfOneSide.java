import java.util.LinkedList;

public class BuffAllMinionsOfOneSide extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	private boolean temporarily;

	public BuffAllMinionsOfOneSide(int additionalAttack, int additionalHealth) {
		this(additionalAttack, additionalHealth, false, false, false, false, false);
	}

	public BuffAllMinionsOfOneSide(int additionalAttack, int additionalHealth, boolean taunt, boolean charge, boolean divineShield, boolean windfury, boolean temporarily) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;

		this.temporarily = temporarily;
	}

	public void effect(LinkedList<Minion> minionList) {
		for (Minion minion : minionList) {
			if (temporarily) {
				minion.addTempAttack(additionalAttack);
				return;
			}
			minion.addAttack(additionalAttack);
			minion.addHealth(additionalHealth);
		}
	}
}