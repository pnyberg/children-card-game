import java.util.LinkedList;

public class AddRandomMonsterCardToHand extends SpellEffect {
	private int drawAmountSelf;
	private int drawAmountEnemy;
	private boolean giveSelf;
	private boolean giveEnemy;
	private int[] possibleCardTypes;

	public AddRandomMonsterCardToHand(int drawAmountSelf, int drawAmountEnemy, int[] possibleCardTypes) {
		this.drawAmountSelf = drawAmountSelf;
		this.drawAmountEnemy = drawAmountEnemy;
		this.possibleCardTypes = possibleCardTypes;
	}

	public boolean giveSelf() {
		return drawAmountSelf > 0;
	}

	public boolean giveEnemy() {
		return drawAmountEnemy > 0;
	}

	public void effect(LinkedList<PlayCard> hand, boolean self) {
		if (possibleCardTypes == null || possibleCardTypes.length == 0) {
			return;
		}

		int drawAmount = self ? drawAmountSelf : drawAmountEnemy;

		for (int i = 0 ; i < drawAmount ; i++) {
			MonsterCard card = pickRandomCard();
			hand.add(card);
		}
	}

	private MonsterCard pickRandomCard() {
		int index = ((int)(Math.random() * 100)) % possibleCardTypes.length;
		int type = possibleCardTypes[index];
		MonsterCard card = new MonsterCard(type);
		return card;
	}
}