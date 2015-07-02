import java.util.LinkedList;

public class DrawCardsTurnEffect extends TurnEffect {
	private int drawAmount;
	private boolean activeOnBothTurns;

	public DrawCardsTurnEffect(int drawAmount, boolean activeOnBothTurns) {
		this.drawAmount = drawAmount;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(LinkedList<PlayCard> hand, LinkedList<PlayCard> deck) {
		for (int i = 0 ; i < drawAmount ; i++) {
			hand.add(deck.poll());
		}
	}
}