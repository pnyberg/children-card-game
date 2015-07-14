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
							MANA_TIDE_TOTEM = 27,
							EARTHEN_RING_FARSEER = 28,
							SLUDGE_BELCHER = 29,
							SLIME = 30,
							LOOT_HOARDER = 31,
							UNSTABLE_GHOUL = 32,
							SORCERERS_DRAKE = 33,
							NOVICE_ENGINEER = 34,
							DRAGON_GRUNT = 35,
							DISPATCHING_DRAKE = 36,
							RAGNAROS = 37,
							YSERA = 38, // not done
							KELTHUZAD = 39,
							EMPEROR_THAURISSAN = 40,
							ALEXSTRASZA = 41, // not done
							SYLVANAS_WINDRUNNER = 42,
							CAIRNE_BLOODHOOF = 43,
							BAINE_BLOODHOOF = 44,
							ALAKIR = 45,
							KING_KRUSH = 46,
							MALGANIS = 47, // not done
							DEATHWING = 48,
							MALYGOS = 49, // not done
							DR_BOOM = 50,
							BOOM_BOT = 51,
							VOLJIN = 52,
							PROPHET_VELEN = 53, // not done
							GAHZRILLA = 54, // not done
							ARCHMAGE_ANTONIDAS = 55, // not done
							BLOODMAGE_THALNOS = 56; // not done

	private String name;
	private int type;

	private int cost;
	private int attack;
	private int health;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;
	private boolean cannotAttack;

	private SpellEffect battleCryEffect;
	private SpellEffect deathRattleEffect;

	private TurnEffect startTurnEffect;
	private TurnEffect endTurnEffect;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		this.type = type;

		taunt = false;
		charge = false;
		divineShield = false;
		windfury = false;
		cannotAttack = false;

		battleCryEffect = null;
		deathRattleEffect = null;
		startTurnEffect = null;
		endTurnEffect = null;

		if (type == ELVEN_ARCHER) {
			name = "Elven Archer";
			initBasicStats(1, 1, 1);
			battleCryEffect = new DealDamage(1);
		} else if (type == GOLDSHIRE_FOOTMAN) {
			name = "Goldshire Footman";
			initBasicStats(1, 1, 2);
			taunt = true;
		} else if (type == GRIMSCALE_ORACLE) {
			name = "Grimscale Oracle";
			initBasicStats(1, 1, 1);
		} else if (type == MURLOC_RAIDER) {
			name = "Murloc Raider";
			initBasicStats(1, 2, 1);
		} else if (type == STONETUSK_BOAR) {
			name = "Stonetusk Boar";
			initBasicStats(1, 1, 1);
			charge = true;
		} else if (type == VODOO_DOCTOR) {
			name = "Vodoo Doctor";
			initBasicStats(1, 2, 1);
			battleCryEffect = new HealMinion(2);
		} else if (type == ACIDIC_SWAMP_OOZE) {
			name = "Acidic Swamp Ooze";
			initBasicStats(2, 3, 2);
		} else if (type == BLOODFEN_RAPTOR) {
			name = "Bloodfen Raptor";
			initBasicStats(2, 3, 2);
		} else if (type == BLUEGILL_WARRIOR) {
			name = "Bluegill Warrior";
			initBasicStats(2, 2, 1);
			charge = true;
		} else if (type == FROSTWOLF_GRUNT) {
			name = "Frostwolf Grunt";
			initBasicStats(2, 2, 2);
			taunt = true;
		} else if (type == KOBOLD_GEOMANCER) {
			name = "Kobold Geomancer";
			initBasicStats(2, 2, 2);
		} else if (type == RIVER_CROCOLISK) {
			name = "River Crocolisk";
			initBasicStats(2, 2, 3);
		} else if (type == DALARAN_MAGE) {
			name = "Dalaran Mage";
			initBasicStats(3, 1, 4);
		} else if (type == IRONFORGE_RIFLEMAN) {
			name = "Ironforge Rifleman";
			initBasicStats(3, 2, 2);
			battleCryEffect = new DealDamage(1);
		} else if (type == IRONFUR_GRIZZLY) {
			name = "Ironfur Grizzly";
			initBasicStats(3, 3, 3);
			taunt = true;
		} else if (type == MAGMA_RAGER) {
			name = "Magma Rager";
			initBasicStats(3, 5, 1);
		} else if (type == RAID_LEADER) {
			name = "Raid Leader";
			initBasicStats(3, 2, 2);
		} else if (type == SHATTERED_SUN_CLERIC) {
			name = "Shattered Sun Cleric";
			initBasicStats(3, 3, 2);
			battleCryEffect = new BuffSingleMinion(1, 1, false, false, false, false, false);
		} else if (type == SILVERBACK_PATRIARCH) {
			name = "Silverback Patriarch";
			initBasicStats(3, 1, 4);
			taunt = true;
		} else if (type == WOLFRIDER) {
			name = "Wolfrider";
			initBasicStats(3, 3, 1);
			charge = true;
		} else if (type == CHILLWIND_YETI) {
			name = "Chillwind Yeti";
			initBasicStats(4, 4, 5);
		} else if (type == DRAGONLING_MECHANIC) {
			name = "Dragonling Mechanic";
			initBasicStats(4, 2, 4);
			battleCryEffect = new SummonMinions(new int[] {MECHANICAL_DRAGONLING}, null);
		} else if (type == MECHANICAL_DRAGONLING) {
			name = "Mechanical Dragonling";
			initBasicStats(1, 2, 1);
		} else if (type == MANA_TIDE_TOTEM) {
			name = "Mana Tide Totem";
			initBasicStats(3, 0, 3);
			endTurnEffect = new DrawCardsTurnEffect(1, false);
		} else if (type == SORCERERS_DRAKE) {
			name = "Sorcerers Drake";
			initBasicStats(1, 1, 2);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == MURLOC_TIDEHUNTER) {
			name = "Murloc Tidehunter";
			initBasicStats(2, 2, 1);
			battleCryEffect = new SummonMinions(new int[] {MURLOC_SCOUT}, null);
		} else if (type == MURLOC_SCOUT) {
			name = "Murloc Scout";
			initBasicStats(0, 1, 1);
		} else if (type == DISPATCHING_DRAKE) {
			name = "Dispatching Drake";
			initBasicStats(1, 2, 1);
			battleCryEffect = new PickUpMinion(-1);
		} else if (type == EARTHEN_RING_FARSEER) {
			name = "Earthen Ring Farseer";
			initBasicStats(3, 3, 3);
			battleCryEffect = new HealMinion(3);
		} else if (type == SLUDGE_BELCHER) {
			name = "Sludge Belcher";
			initBasicStats(5, 3, 5);
			taunt = true;
			deathRattleEffect = new SummonMinions(new int[] {SLIME}, null);
		} else if (type == SLIME) {
			name = "Slime";
			initBasicStats(1, 1, 2);
			taunt = true;
		} else if (type == NOVICE_ENGINEER) {
			name = "Novice Engineer";
			initBasicStats(2, 1, 1);
			battleCryEffect = new DrawCards(1);
		} else if (type == LOOT_HOARDER) {
			name = "Loot Hoarder";
			initBasicStats(2, 2, 1);
			deathRattleEffect = new DrawCards(1);
		} else if (type == UNSTABLE_GHOUL) {
			name = "Unstable Ghoul";
			initBasicStats(2, 1, 3);
			taunt = true;
			deathRattleEffect = new DealDamageToAllMinions(1);
		} else if (type == RAGNAROS) {
			name = "Ragnaros";
			initBasicStats(8, 8, 8);
			cannotAttack = true;
			endTurnEffect = new DealDamageRandomTurnEffect(8, false, true);
		} else if (type == CAIRNE_BLOODHOOF) {
			name = "Cairne Bloodhoof";
			initBasicStats(6, 4, 5);
			deathRattleEffect = new SummonMinions(new int[] {BAINE_BLOODHOOF}, null);
		} else if (type == BAINE_BLOODHOOF) {
			name = "Baine Bloodhoof";
			initBasicStats(4, 4, 5);
		} else if (type == ALAKIR) {
			name = "Al'Akir";
			initBasicStats(8, 3, 5);
			charge = true;
			taunt = true;
			divineShield = true;
			windfury = true;
		} else if (type == KING_KRUSH) {
			name = "King Krush";
			initBasicStats(8, 8, 8);
			charge = true;
		} else if (type == DR_BOOM) {
			name = "Dr. Boom";
			initBasicStats(7, 7, 7);
			battleCryEffect = new SummonMinions(new int[] {BOOM_BOT, BOOM_BOT}, null);
		} else if (type == BOOM_BOT) {
			name = "Boom Bot";
			initBasicStats(1, 1, 1);
			deathRattleEffect = new DealRandomDamageRandomly(1, 3, true);
		} else if (type == DEATHWING) {
			name = "Deathwing";
			initBasicStats(10, 12, 12);
			battleCryEffect = new DestroyAllMinions();
		} else if (type == EMPEROR_THAURISSAN) {
			name = "Emperor Thaurissan";
			initBasicStats(6, 5, 5);
			endTurnEffect = new HandCostTurnEffect(-1, false);
		} else if (type == SYLVANAS_WINDRUNNER) {
			name = "Sylvanas Windrunner";
			initBasicStats(6, 5, 5);
			deathRattleEffect = new MindControlRandom();
		} else if (type == KELTHUZAD) {
			name = "Kel'Thuzad";
			initBasicStats(8, 6, 8);
			endTurnEffect = new ReviveFriendlyMinionsTurnEffect(true);
		} else if (type == VOLJIN) {
			name = "Vol'Jin";
			initBasicStats(5, 6, 2);
			battleCryEffect = new SwapHealthMinion();
		} else if (type == ALEXSTRASZA) {
			name = "Alexstrasza";
			initBasicStats(9, 8, 8);
			battleCryEffect = new SetHealthPlayer(15);
		}
	}

	private void initBasicStats(int cost, int attack, int health) {
		this.cost = cost;
		this.attack = attack;
		this.health = health;
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
		return new Minion(name, type, attack, health, taunt, charge, divineShield, windfury, cannotAttack, battleCryEffect, deathRattleEffect, startTurnEffect, endTurnEffect);
	}
}