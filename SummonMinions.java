import java.util.LinkedList;

public class SummonMinions extends SpellEffect {
	private LinkedList<Minion> friendlyMinionList;
	private LinkedList<Minion> enemyMinionList;

	public SummonMinions(int[] friendlyMinionsToBeSummonedTypes, int[] enemyMinionsToBeSummonedTypes) {
		friendlyMinionList = new LinkedList<Minion>();
		enemyMinionList = new LinkedList<Minion>();

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