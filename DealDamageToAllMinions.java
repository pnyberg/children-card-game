import java.util.LinkedList;

public class DealDamageToAllMinions extends SpellEffect {
	int damageAmount;

	public DealDamageToAllMinions(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	public void effect(LinkedList<Minion> friendlyMinions, LinkedList<Minion> enemyMinions) {
		dealDamageToMinions(friendlyMinions);
		dealDamageToMinions(enemyMinions);
	}

	private void dealDamageToMinions(LinkedList<Minion> minionList) {
		for (Minion minion : minionList) {
			minion.takeDamage(damageAmount);
		}
	}
}