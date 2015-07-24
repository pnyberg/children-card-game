import java.util.LinkedList;

public class SummonRandomMinions extends SpellEffect {
	private int[] friendlyMinionsToBeSummonedTypes;
	private int[] enemyMinionsToBeSummonedTypes;

	private int numberOfFriendly;
	private int numberOfEnemy;

	public SummonRandomMinions(int numberOfFriendly, int[] friendlyMinionsToBeSummonedTypes, int numberOfEnemy, int[] enemyMinionsToBeSummonedTypes) {
		this.numberOfFriendly = numberOfFriendly;
		this.numberOfEnemy = numberOfEnemy;

		this.friendlyMinionsToBeSummonedTypes = friendlyMinionsToBeSummonedTypes;
		this.enemyMinionsToBeSummonedTypes = enemyMinionsToBeSummonedTypes;
	}

	public void effect(LinkedList<Minion> friendlyMinionsToBeSummonedList, LinkedList<Minion> enemyMinionsToBeSummonedList) {
		addRandomMinions(numberOfFriendly, friendlyMinionsToBeSummonedTypes, friendlyMinionsToBeSummonedList);
		addRandomMinions(numberOfEnemy, enemyMinionsToBeSummonedTypes, enemyMinionsToBeSummonedList);
	}

	private void addRandomMinions(int amountOfMinions, int[] types, LinkedList<Minion> board) {
		for (int i = 0 ; i < amountOfMinions ; i++) {
			int index = ((int)(Math.random() * 100)) % types.length;
			int type = types[index];
			Minion minion = new MonsterCard(type).toMinion();
			board.add(minion);
		}
	}
}