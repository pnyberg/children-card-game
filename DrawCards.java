import java.util.LinkedList;

public class DrawCards extends SpellEffect {
	private int drawAmount;

	public DrawCards(int drawAmount) {
		this.drawAmount = drawAmount;
	}

	public void effect(LinkedList<PlayCard> hand, LinkedList<PlayCard> deck) {
		for (int i = 0 ; i < drawAmount ; i++) {
			hand.add(deck.poll());
		}
	}
}