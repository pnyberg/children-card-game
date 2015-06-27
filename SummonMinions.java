import java.util.LinkedList;

public class SummonMinions extends SpellEffect {
	LinkedList<Minion> minionList;

	public SummonMinions(int[] minionsToBeSummonedTypes) {
		minionList = new LinkedList<Minion>();
		for (int minionType : minionsToBeSummonedTypes) {
			Minion minion = new MonsterCard(minionType).toMinion();
			minionList.add(minion);
		}
	}

	public void effect(LinkedList<Minion> minionsToBeSummonedList) {
		for (Minion minion : minionList) {
			minionsToBeSummonedList.add(minion);
		}
	}
}