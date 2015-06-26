public class MonsterCard extends PlayCard {
	public static final int	DRAGON_LORD = 1,
							DRAGON_KING = 2,
							PRINCE_CRUSH = 3;

	private String name;

	private int cost;
	private int attack;
	private int health;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		if (type == DRAGON_LORD) {
			name = "Dragon Lord";
			cost = 1;
			attack = 1;
			health = 1;
			initBasicEffect(false, false, false, false);
		} else if (type == DRAGON_KING) {
			name = "Dragon King";
			cost = 2;
			attack = 2;
			health = 2;
			initBasicEffect(false, false, false, false);
		} else if (type == PRINCE_CRUSH) {
			name = "Prince Crush";
			cost = 3;
			attack = 3;
			health = 3;
			initBasicEffect(false, true, false, false);
		}
	}

	private void initBasicEffect(boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
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
		return new Minion(name, attack, health, taunt, charge, divineShield, windfury);
	}
}