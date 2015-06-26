public class MonsterCard extends PlayCard {
	public static final int	DRAGON_LORD = 1,
							DRAGON_KING = 2,
							PRINCE_CRUSH = 3,
							SORCERERS_DRAKE = 4;

	private String name;
	private int type;

	private int cost;
	private int attack;
	private int health;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	private SpellEffect battleCryEffect;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		this.type = type;

		if (type == DRAGON_LORD) {
			name = "Dragon Lord";
			cost = 1;
			attack = 1;
			health = 1;
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
		} else if (type == DRAGON_KING) {
			name = "Dragon King";
			cost = 2;
			attack = 2;
			health = 2;
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
		} else if (type == PRINCE_CRUSH) {
			name = "Prince Crush";
			cost = 3;
			attack = 3;
			health = 3;
			initBasicEffect(false, true, false, false);
			battleCryEffect = null;
		} else if (type == SORCERERS_DRAKE) {
			name = "Sorcerers Drake";
			cost = 1;
			attack = 1;
			health = 2;
			initBasicEffect(false, false, false, false);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
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

	public int getType() {
		return type;
	}

	public Minion toMinion() {
		return new Minion(name, type, attack, health, taunt, charge, divineShield, windfury, battleCryEffect);
	}
}