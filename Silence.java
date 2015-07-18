import java.util.LinkedList;

public class Silence extends SpellEffect {
	private boolean wholeBoardSide; 
	private boolean friendly;
	private boolean enemy;

	public Silence(boolean wholeBoardSide, boolean friendly, boolean enemy) {
		this.wholeBoardSide = wholeBoardSide;
		this.friendly = friendly;
		this.enemy = enemy;
	}

	public boolean affectWholeBoardSide() {
		return wholeBoardSide;
	}

	public boolean affectFriendly() {
		return friendly;
	}

	public boolean affectEnemy() {
		return enemy;
	}

	public void effect(Minion minion) {
		minion.silence();
	}
}