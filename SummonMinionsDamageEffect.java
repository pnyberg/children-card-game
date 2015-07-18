import java.util.LinkedList;

public class SummonMinionsDamageEffect extends DamageEffect {
	private int[] friendlyMinionsToBeSummonedTypes;
	private int[] enemyMinionsToBeSummonedTypes;

	private boolean friendlyMinionTakesDamage;
	private boolean enemyMinionTakesDamage;
	private boolean onlyIfSurvived;

	public SummonMinionsDamageEffect(int[] friendlyMinionsToBeSummonedTypes, int[] enemyMinionsToBeSummonedTypes, boolean friendlyMinionTakesDamage, boolean enemyMinionTakesDamage, boolean onlyIfSurvived) {
		this.friendlyMinionsToBeSummonedTypes = friendlyMinionsToBeSummonedTypes;
		this.enemyMinionsToBeSummonedTypes = enemyMinionsToBeSummonedTypes;

		this.friendlyMinionTakesDamage = friendlyMinionTakesDamage;
		this.enemyMinionTakesDamage = enemyMinionTakesDamage;
		this.onlyIfSurvived = onlyIfSurvived;
	}

	public boolean friendlyBoardAreaEffect() {
		return friendlyMinionTakesDamage;
	}

	public boolean enemyBoardAreaEffect() {
		return enemyMinionTakesDamage;
	}

	public boolean onlyIfSurvived() {
		return onlyIfSurvived;
	}

	public void effect(LinkedList<Minion> friendlyBoard, LinkedList<Minion> enemyBoard) {
		addToBoard(friendlyBoard, friendlyMinionsToBeSummonedTypes);

		addToBoard(enemyBoard, enemyMinionsToBeSummonedTypes);
	}

	private void addToBoard(LinkedList<Minion> board, int[] minionTypes) {
		LinkedList<Minion> minionList = new LinkedList<Minion>();

		arrayToList(minionTypes, minionList);

		for (Minion minion : minionList) {
			board.add(minion);
		}
	}

	private void arrayToList(int[] array, LinkedList<Minion> list) {
		if (array != null) {
			for (int minionType : array) {
				Minion minion = new MonsterCard(minionType).toMinion();
				list.add(minion);
			}
		}
	}
}