import java.util.LinkedList;

public class DrawCardsDamageEffect extends DamageEffect {
	private int drawAmount;
	private boolean friendlyMinionTakesDamage;
	private boolean enemyMinionTakesDamage;

	public DrawCardsDamageEffect(int drawAmount, boolean friendlyMinionTakesDamage, boolean enemyMinionTakesDamage) {
		this.drawAmount = drawAmount;
		this.friendlyMinionTakesDamage = friendlyMinionTakesDamage;
		this.enemyMinionTakesDamage = enemyMinionTakesDamage;
	}

	public boolean friendlyBoardAreaEffect() {
		return friendlyMinionTakesDamage;
	}

	public boolean enemyBoardAreaEffect() {
		return enemyMinionTakesDamage;
	}

	public void effect(LinkedList<PlayCard> hand, LinkedList<PlayCard> deck) {
		for (int i = 0 ; i < drawAmount ; i++) {
			hand.add(deck.poll());
		}
	}
}