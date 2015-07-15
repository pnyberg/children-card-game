import java.util.LinkedList;

public class SummonRandomMinionFromHandTurnEffect extends TurnEffect {
	private boolean bothPlayers;
	private boolean activeOnBothTurns;

	public SummonRandomMinionFromHandTurnEffect(boolean activeOnBothTurns, boolean bothPlayers) {
		this.activeOnBothTurns = activeOnBothTurns;
		this.bothPlayers = bothPlayers;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public boolean forBothPlayer() {
		return bothPlayers;
	}

	public MonsterCard effect(LinkedList<PlayCard> hand) {
		PlayCard card;
		MonsterCard returnCard;

		while (true) {
			int index = (int)(Math.random() * 100) % hand.size();
			card = hand.get(index);

			if (card instanceof MonsterCard) {
				returnCard = (MonsterCard)card;
				return returnCard;
			}
		}
	}
}
