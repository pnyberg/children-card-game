import java.util.LinkedList;

public class AddBananaCardToHand extends SpellEffect {
	private final static SpellCard[] bananaCards = new SpellCard[] {	new SpellCard(SpellCard.DRAGON_POWER),
																	};
	private int drawAmount;
	private boolean giveSelf;
	private boolean giveEnemy;
	private boolean onlyStandardBanana;

	public AddBananaCardToHand(int drawAmount, boolean giveSelf, boolean giveEnemy, boolean onlyStandardBanana) {
		this.drawAmount = drawAmount;
		this.onlyStandardBanana = onlyStandardBanana;
		this.giveSelf = giveSelf;
		this.giveEnemy = giveEnemy;
	}

	public boolean giveSelf() {
		return giveSelf;
	}

	public boolean giveEnemy() {
		return giveEnemy;
	}

	public void effect(LinkedList<PlayCard> hand) {
		for (int i = 0 ; i < drawAmount ; i++) {
			SpellCard card = makeBananaCard();
			hand.add(card);
		}
	}

	private SpellCard makeBananaCard() {
		if (onlyStandardBanana) {
			return bananaCards[0];
		} else {
			return randomBananaCard();
		}
	}

	private SpellCard randomBananaCard() {
		int index = ((int)(Math.random() * 100)) % bananaCards.length;
		SpellCard card = bananaCards[index];
		return card;
	}
}