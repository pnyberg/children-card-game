import java.util.LinkedList;

public class SummonMinionTurnEffect extends TurnEffect {
	private boolean activeOnBothTurns;

	private LinkedList<Minion> friendlyMinionList;
	private LinkedList<Minion> enemyMinionList;

	public SummonMinionTurnEffect(int[] friendlyMinionsToBeSummonedTypes, int[] enemyMinionsToBeSummonedTypes, boolean activeOnBothTurns) {
		friendlyMinionList = new LinkedList<Minion>();
		enemyMinionList = new LinkedList<Minion>();

		this.activeOnBothTurns = activeOnBothTurns;

		arrayToList(friendlyMinionsToBeSummonedTypes, friendlyMinionList);
		arrayToList(enemyMinionsToBeSummonedTypes, enemyMinionList);
	}

	private void arrayToList(int[] array, LinkedList<Minion> list) {
		if (array != null) {
			for (int minionType : array) {
				Minion minion = new MonsterCard(minionType).toMinion();
				list.add(minion);
			}
		}
	}

	public boolean activeOnBothTurns() {
		return activeOnBothTurns;
	}

	public void effect(LinkedList<Minion> friendlyMinionsToBeSummonedList, LinkedList<Minion> enemyMinionsToBeSummonedList) {
		listTransfer(friendlyMinionList, friendlyMinionsToBeSummonedList);

		listTransfer(enemyMinionList, enemyMinionsToBeSummonedList);
	}

	private void listTransfer(LinkedList<Minion> from, LinkedList<Minion> to) {
		for (Minion minion : from) {
			to.add(minion);
		}
	}
}