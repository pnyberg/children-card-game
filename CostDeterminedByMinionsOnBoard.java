import java.util.LinkedList;

public class CostDeterminedByMinionsOnBoard extends SpellEffect {
	private int diffPerMinion;
	private boolean basedOnFriendlyBoard;
	private boolean basedOnEnemyBoard;

	public CostDeterminedByMinionsOnBoard(int diffPerMinion, boolean basedOnFriendlyBoard, boolean basedOnEnemyBoard) {
		this.diffPerMinion = diffPerMinion;
		this.basedOnFriendlyBoard = basedOnFriendlyBoard;
		this.basedOnEnemyBoard = basedOnEnemyBoard;
	}

	public boolean basedOnFriendlyBoard() {
		return basedOnFriendlyBoard;
	}

	public boolean basedOnEnemyBoard() {
		return basedOnEnemyBoard;
	}

	public void effect(PlayCard card, int minionsOnBoard) {
		int subtractedCost = minionsOnBoard * diffPerMinion;
		int newCost = card.getOriginalCost() - subtractedCost;

		card.setCost(newCost);
	}
}