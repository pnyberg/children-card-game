public class MonsterCard extends PlayCard {
	public static final int	DRAGON_LORD = 1,
							DRAGON_KING = 2;

	private String name;

	private int cost;
	private int attack;
	private int health;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		if (type == DRAGON_LORD) {
			name = "Dragon Lord";
			cost = 1;
			attack = 1;
			health = 1;
		} else if (type == DRAGON_KING) {
			name = "Dragon King";
			cost = 2;
			attack = 2;
			health = 2;
		}
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

	public Minion toMinion() {
		return new Minion(name, attack, health, false, false, false, false);
	}
}