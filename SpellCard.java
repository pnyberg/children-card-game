public class SpellCard extends PlayCard {
	public static final int	DRAGON_POWER = 1;

	private String name;

	private int cost;
	private int type;

	public SpellCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		if (type == DRAGON_POWER) {
			name = "Dragon Power";
			cost = 2;
			this.type = type;
		}
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getType() {
		return type;
	}
}