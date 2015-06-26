import java.util.LinkedList;

public class SpellEffect_BuffAllOfOneSide extends SpellEffect {
	private int additionalAttack;
	private int additionalHealth;

	public SpellEffect_BuffAllOfOneSide(int additionalAttack, int additionalHealth) {
		this.additionalAttack = additionalAttack;
		this.additionalHealth = additionalHealth;
	}

	public void effect(LinkedList<Minion> minionList) {
		for (Minion minion : minionList) {
			minion.addAttack(additionalAttack);
			minion.addHealth(additionalHealth);
		}
	}
}