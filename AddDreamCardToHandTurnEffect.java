import java.util.LinkedList;

public class AddDreamCardToHandTurnEffect extends TurnEffect {
	private final static PlayCard[] dreamCards = new PlayCard[] {	new MonsterCard(MonsterCard.MALYGOS), 
																	new MonsterCard(MonsterCard.DEATHWING),
																	new MonsterCard(MonsterCard.ALEXSTRASZA),
																	new SpellCard(SpellCard.DRAGON_POWER),
																};
	private int drawAmount;
	private boolean activeOnBothTurns;

	public AddDreamCardToHandTurnEffect(int drawAmount, boolean activeOnBothTurns) {
		this.drawAmount = drawAmount;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(LinkedList<PlayCard> hand) {
		for (int i = 0 ; i < drawAmount ; i++) {
			PlayCard card = randomDreamCard();
			hand.add(card);
		}
	}

	private PlayCard randomDreamCard() {
		int index = ((int)(Math.random() * 100)) % dreamCards.length;
		PlayCard card = dreamCards[index];
		return card;
	}
}