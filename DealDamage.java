import java.util.LinkedList;

public class DealDamage extends SpellEffect {
	int damageAmount;

	public DealDamage(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	public void effect(DamageHandler damageHandler, int targetIndex, int turnIndex) {
		if (targetIndex == TheGame.TARGETPLAYER) {
			damageHandler.dealDamageToPlayer(damageAmount, turnIndex);
		} else {
			damageHandler.dealDamageToMinion(targetIndex, damageAmount, turnIndex);
		}
	}
}