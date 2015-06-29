public class MonsterCard extends PlayCard {
	public static final int	DRAGON_LORD = 1,
							DRAGON_KING = 2,
							PRINCE_CRUSH = 3,
							SORCERERS_DRAKE = 4,
							DRAGON_LIEUTENANT = 5,
							DRAGON_GRUNT = 6,
							DISPATCHING_DRAKE = 7,
							EARTHEN_RING_FARSEER = 8,
							SLUDGE_BELCHER = 9,
							SLIME = 10,
							NOVICE_ENGINEER = 11,
							LOOT_HOARDER = 12;

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
	private SpellEffect deathRattleEffect;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		this.type = type;

		if (type == DRAGON_LORD) {
			name = "Dragon Lord";
			initBasicStats(1, 1, 1);
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == DRAGON_KING) {
			name = "Dragon King";
			initBasicStats(6, 5, 5);
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == PRINCE_CRUSH) {
			name = "Prince Crush";
			initBasicStats(3, 3, 3);
			initBasicEffect(false, true, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == SORCERERS_DRAKE) {
			name = "Sorcerers Drake";
			initBasicStats(1, 1, 2);
			initBasicEffect(false, false, false, false);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
			deathRattleEffect = null;
		} else if (type == DRAGON_LIEUTENANT) {
			name = "Dragon Lieutenant";
			initBasicStats(3, 3, 2);
			initBasicEffect(false, false, false, false);
			battleCryEffect = new SummonMinions(new int[] {DRAGON_GRUNT}, null);
			deathRattleEffect = null;
		} else if (type == DRAGON_GRUNT) {
			name = "Dragon Grunt";
			initBasicStats(1, 2, 2);
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == DISPATCHING_DRAKE) {
			name = "Dispatching Drake";
			initBasicStats(1, 2, 1);
			initBasicEffect(false, false, false, false);
			battleCryEffect = new PickUpMinion(-1);
			deathRattleEffect = null;
		} else if (type == EARTHEN_RING_FARSEER) {
			name = "Earthen Ring Farseer";
			initBasicStats(3, 3, 3);
			initBasicEffect(false, false, false, false);
			battleCryEffect = new HealMinion(3);
			deathRattleEffect = null;
		} else if (type == SLUDGE_BELCHER) {
			name = "Sludge Belcher";
			initBasicStats(5, 3, 5);
			initBasicEffect(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = new SummonMinions(new int[] {SLIME}, null);
		} else if (type == SLIME) {
			name = "Slime";
			initBasicStats(1, 1, 2);
			initBasicEffect(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == NOVICE_ENGINEER) {
			name = "Novice Engineer";
			initBasicStats(2, 1, 1);
			initBasicEffect(false, false, false, false);
			battleCryEffect = new DrawCards(1);
			deathRattleEffect = null;
		} else if (type == LOOT_HOARDER) {
			name = "Loot Hoarder";
			initBasicStats(2, 2, 1);
			initBasicEffect(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = new DrawCards(1);
		}
	}

	private void initBasicStats(int cost, int attack, int health) {
		this.cost = cost;
		this.attack = attack;
		this.health = health;
	}

	private void initBasicEffect(boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public void changeCost(int costChange) {
		cost = (cost + costChange) < 0 ? 0 : cost + costChange;
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
		return new Minion(name, type, attack, health, taunt, charge, divineShield, windfury, battleCryEffect, deathRattleEffect);
	}
}