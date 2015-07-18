import java.util.LinkedList;

public class AddDreamCardToHandTurnEffect extends TurnEffect {
	private final static PlayCard[] dreamCards = new PlayCard[] {	new MonsterCard(MonsterCard.MALYGOS), 
																	new MonsterCard(MonsterCard.DEATHWING),
																	new MonsterCard(MonsterCard.ALEXSTRASZA),
																	new SpellCard(SpellCard.DRAGON_POWER),
																};
	private int drawAmount;
	private boolean giveSelf;
	private boolean giveEnemy;
	private boolean activeOnBothTurns;

	public AddDreamCardToHandTurnEffect(int drawAmount, boolean giveSelf, boolean giveEnemy, boolean activeOnBothTurns) {
		this.drawAmount = drawAmount;
		this.giveSelf = giveSelf;
		this.giveEnemy = giveEnemy;
		this.activeOnBothTurns = activeOnBothTurns;
	}

	public boolean giveSelf() {
		return giveSelf;
	}

	public boolean giveEnemy() {
		return giveEnemy;
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