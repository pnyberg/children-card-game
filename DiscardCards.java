import java.util.LinkedList;

public class DiscardCards extends SpellEffect {
	private int discardAmount;

	public DiscardCards(int discardAmount) {
		this.discardAmount = discardAmount;
	}

	public int getDiscardAmount() {
		return discardAmount;
	}

/*	public void effect(LinkedList<PlayCard> hand, LinkedList<PlayCard> discarded) {
		for (int i = 0 ; i < discardAmount ; i++) {
			int index = ((int)(Math.random() * 100)) % hand.size();
			PlayCard discardedCard = hand.remove(index);
			discarded.add(discardedCard);
		}
	}*/
}