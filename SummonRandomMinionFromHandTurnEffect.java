import java.util.LinkedList;

public class SummonRandomMinionFromHandTurnEffect extends TurnEffect {
	private boolean bothPlayers;
	private boolean activeOnBothTurns;
	private boolean returnMinion;

	public SummonRandomMinionFromHandTurnEffect(boolean activeOnBothTurns, boolean bothPlayers, boolean returnMinion) {
		this.activeOnBothTurns = activeOnBothTurns;
		this.bothPlayers = bothPlayers;
		this.returnMinion = returnMinion;
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public boolean forBothPlayer() {
		return bothPlayers;
	}

	public boolean shouldReturnMinion() {
		return returnMinion;
	}

	public int effect(LinkedList<PlayCard> hand) {
		while (true) {
			int index = (int)(Math.random() * 100) % hand.size();
			PlayCard card = hand.get(index);

			if (card instanceof MonsterCard) {
				return index;
			}
		}
	}
}
