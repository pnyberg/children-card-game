public class MonsterCard extends PlayCard {
	public static final int	ELVEN_ARCHER = 1,
							GOLDSHIRE_FOOTMAN = 2,
							GRIMSCALE_ORACLE = 3, // not done
							MURLOC_RAIDER = 4,
							STONETUSK_BOAR = 5,
							VODOO_DOCTOR = 6,
							ACIDIC_SWAMP_OOZE = 7, // not done
							BLOODFEN_RAPTOR = 8,
							BLUEGILL_WARRIOR = 9,
							FROSTWOLF_GRUNT = 10,
							KOBOLD_GEOMANCER = 11, // not done
							MURLOC_TIDEHUNTER = 12,
							MURLOC_SCOUT = 13,
							RIVER_CROCOLISK = 14,
							DALARAN_MAGE = 15, // not done
							IRONFORGE_RIFLEMAN = 16,
							IRONFUR_GRIZZLY = 17,
							MAGMA_RAGER = 18,
							RAID_LEADER = 19, // not done
							RAZORFEN_HUNTER = 20,
							SHATTERED_SUN_CLERIC = 21,
							SILVERBACK_PATRIARCH = 22,
							WOLFRIDER = 23,
							CHILLWIND_YETI = 24,
							DRAGONLING_MECHANIC = 25,
							MECHANICAL_DRAGONLING = 26,
							DISPATCHING_DRAKE = 27,
							EARTHEN_RING_FARSEER = 28,
							SLUDGE_BELCHER = 29,
							SLIME = 30,
							LOOT_HOARDER = 31,
							UNSTABLE_GHOUL = 32,
							SORCERERS_DRAKE = 33,
							NOVICE_ENGINEER = 34,
							DRAGON_GRUNT = 35;

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

		if (type == ELVEN_ARCHER) {
			name = "Elven Archer";
			initBasicStats(1, 1, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new DealDamage(1);
			deathRattleEffect = null;
		} else if (type == GOLDSHIRE_FOOTMAN) {
			name = "Goldshire Footman";
			initBasicStats(1, 1, 2);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == GRIMSCALE_ORACLE) {
			name = "Grimscale Oracle";
			initBasicStats(1, 1, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == MURLOC_RAIDER) {
			name = "Murloc Raider";
			initBasicStats(1, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == STONETUSK_BOAR) {
			name = "Stonetusk Boar";
			initBasicStats(1, 1, 1);
			initBasicEffectTCSW(false, true, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == VODOO_DOCTOR) {
			name = "Vodoo Doctor";
			initBasicStats(1, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new HealMinion(2);
			deathRattleEffect = null;
		} else if (type == ACIDIC_SWAMP_OOZE) {
			name = "Acidic Swamp Ooze";
			initBasicStats(2, 3, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == BLOODFEN_RAPTOR) {
			name = "Bloodfen Raptor";
			initBasicStats(2, 3, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == BLUEGILL_WARRIOR) {
			name = "Bluegill Warrior";
			initBasicStats(2, 2, 1);
			initBasicEffectTCSW(false, true, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == FROSTWOLF_GRUNT) {
			name = "Frostwolf Grunt";
			initBasicStats(2, 2, 2);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == KOBOLD_GEOMANCER) {
			name = "Kobold Geomancer";
			initBasicStats(2, 2, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == RIVER_CROCOLISK) {
			name = "River Crocolisk";
			initBasicStats(2, 2, 3);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == DALARAN_MAGE) {
			name = "Dalaran Mage";
			initBasicStats(3, 1, 4);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == IRONFORGE_RIFLEMAN) {
			name = "Ironforge Rifleman";
			initBasicStats(3, 2, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new DealDamage(1);
			deathRattleEffect = null;
		} else if (type == IRONFUR_GRIZZLY) {
			name = "Ironfur Grizzly";
			initBasicStats(3, 3, 3);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == MAGMA_RAGER) {
			name = "Magma Rager";
			initBasicStats(3, 5, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == RAID_LEADER) {
			name = "Raid Leader";
			initBasicStats(3, 2, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == SHATTERED_SUN_CLERIC) {
			name = "Shattered Sun Cleric";
			initBasicStats(3, 3, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new BuffSingleMinion(1, 1, false, false, false, false, false);
			deathRattleEffect = null;
		} else if (type == SILVERBACK_PATRIARCH) {
			name = "Silverback Patriarch";
			initBasicStats(3, 1, 4);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == WOLFRIDER) {
			name = "Wolfrider";
			initBasicStats(3, 3, 1);
			initBasicEffectTCSW(false, true, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == CHILLWIND_YETI) {
			name = "Chillwind Yeti";
			initBasicStats(4, 4, 5);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == DRAGONLING_MECHANIC) {
			name = "Dragonling Mechanic";
			initBasicStats(4, 2, 4);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new SummonMinions(new int[] {MECHANICAL_DRAGONLING}, null);
			deathRattleEffect = null;
		} else if (type == MECHANICAL_DRAGONLING) {
			name = "Mechanical Dragonling";
			initBasicStats(1, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == SORCERERS_DRAKE) {
			name = "Sorcerers Drake";
			initBasicStats(1, 1, 2);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
			deathRattleEffect = null;
		} else if (type == MURLOC_TIDEHUNTER) {
			name = "Murloc Tidehunter";
			initBasicStats(2, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new SummonMinions(new int[] {MURLOC_SCOUT}, null);
			deathRattleEffect = null;
		} else if (type == MURLOC_SCOUT) {
			name = "Murloc Scout";
			initBasicStats(0, 1, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == DISPATCHING_DRAKE) {
			name = "Dispatching Drake";
			initBasicStats(1, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new PickUpMinion(-1);
			deathRattleEffect = null;
		} else if (type == EARTHEN_RING_FARSEER) {
			name = "Earthen Ring Farseer";
			initBasicStats(3, 3, 3);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new HealMinion(3);
			deathRattleEffect = null;
		} else if (type == SLUDGE_BELCHER) {
			name = "Sludge Belcher";
			initBasicStats(5, 3, 5);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = new SummonMinions(new int[] {SLIME}, null);
		} else if (type == SLIME) {
			name = "Slime";
			initBasicStats(1, 1, 2);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = null;
		} else if (type == NOVICE_ENGINEER) {
			name = "Novice Engineer";
			initBasicStats(2, 1, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = new DrawCards(1);
			deathRattleEffect = null;
		} else if (type == LOOT_HOARDER) {
			name = "Loot Hoarder";
			initBasicStats(2, 2, 1);
			initBasicEffectTCSW(false, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = new DrawCards(1);
		} else if (type == UNSTABLE_GHOUL) {
			name = "Unstable Ghoul";
			initBasicStats(2, 1, 3);
			initBasicEffectTCSW(true, false, false, false);
			battleCryEffect = null;
			deathRattleEffect = new DealDamageToAllMinions(1);
		}
	}

	private void initBasicStats(int cost, int attack, int health) {
		this.cost = cost;
		this.attack = attack;
		this.health = health;
	}

	private void initBasicEffectTCSW(boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
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