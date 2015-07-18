public class MonsterCard extends PlayCard {
	public static final int	ELVEN_ARCHER = 1,
							GOLDSHIRE_FOOTMAN = 2,
							GRIMSCALE_ORACLE = 3, // not done - area effect
							MURLOC_RAIDER = 4,
							STONETUSK_BOAR = 5,
							VODOO_DOCTOR = 6,
							ACIDIC_SWAMP_OOZE = 7, // not done - weapon
							BLOODFEN_RAPTOR = 8,
							BLUEGILL_WARRIOR = 9,
							FROSTWOLF_GRUNT = 10,
							KOBOLD_GEOMANCER = 11, // not done - spell dmg
							MURLOC_TIDEHUNTER = 12,
							MURLOC_SCOUT = 13,
							RIVER_CROCOLISK = 14,
							DALARAN_MAGE = 15, // not done - spell dmg
							IRONFORGE_RIFLEMAN = 16,
							IRONFUR_GRIZZLY = 17,
							MAGMA_RAGER = 18,
							RAID_LEADER = 19, // not done - area effect
							RAZORFEN_HUNTER = 20,
							RAZORFEN_BOAR = 205,
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
							ABUSIVE_SERGEANT = 33,
							NOVICE_ENGINEER = 34,
							DRAGON_GRUNT = 35,
							DISPATCHING_DRAKE = 36,
							RAGNAROS = 37,
							YSERA = 38,
							KELTHUZAD = 39,
							EMPEROR_THAURISSAN = 40,
							ALEXSTRASZA = 41,
							SYLVANAS_WINDRUNNER = 42,
							CAIRNE_BLOODHOOF = 43,
							BAINE_BLOODHOOF = 44,
							ALAKIR = 45,
							KING_KRUSH = 46,
							MALGANIS = 47, // not done - immune & +2/+2 - demon
							DEATHWING = 48,
							MALYGOS = 49, // not done - spell dmg
							DR_BOOM = 50,
							BOOM_BOT = 51,
							VOLJIN = 52,
							PROPHET_VELEN = 53, // not done
							GAHZRILLA = 54,
							ARCHMAGE_ANTONIDAS = 55, // not done
							BLOODMAGE_THALNOS = 56, // not done - dubbla effekter + spell dmg
							TWILIGHT_DRAKE = 57,
							BOLIVAR_FORDRAGON = 58, // not done
							SHRINKMEISTER = 59,
							IMP_MASTER = 60, // not done - dubbla effekter + take dmg
							IMP = 203, 
							GRUUL = 61,
							WATER_ELEMENTAL = 62, // not done - freeze
							EARTH_ELEMENTAL = 63, // not done - overload
							FIRE_ELEMENTAL = 64,
							DOOMSAYER = 65,
							ACOLYTE_OF_PAIN = 66,
							KNIFE_JUGGLER = 67, // not done
							SHIELDMAIDEN = 68, // not done
							IMP_GANG_BOSS = 69, // not done
							BLOOD_IMP = 70,
							ONYXIA = 71,
							DRAGON_WHELP = 201,
							ILLIDAN_STORMRAGE = 72, // not done
							LOATHEB = 73, // not done
							NERUBIAN_WEBLORD = 74, // not done
							VENTURE_CO_MERCENARY = 75, // not done
							SAVANNAH_HIGHMANE = 76,
							SAVANNAH_HYENA = 202,
							SEA_GIANT = 77,
							MOUNTAIN_GIANT = 78,
							MOLTEN_GIANT = 79,
							CLOCKWORK_GIANT = 80,
							ALARMO_BOT = 81,
							PILOTED_SHREDDER = 82, // not done
							MAD_BOMBER = 83, // not done
							SUCCUBUS = 84, // not done
							DEATHLORD = 85,
							FAERIE_DRAGON = 86, // not done
							MANA_ADDICT = 87, // not done
							TINKERTOWN_TECHNICHIAN = 88, // not done
							LEPER_GNOME = 89,
							LEPER_GNOME_BOT = 90, // not done
							NIGHTBLADE = 91,
							NAGA_ORACLE = 92, // not done
							CRUEL_TASKMASTER = 93, // not done
							MIND_CONTROL_TECH = 94, // not done
							CABAL_SHADOWPRIEST = 95, // not done
							STORMWIND_CHAMPION = 96, // not done
							FROSTWOLF_WARLORD = 97,
							VOID_TERROR = 98, // not done
							ENHANCO_MECHANIC = 99, // not done
							LOREWALKER_CHO = 100, // not done
							ELVEN_OF_ELUNE = 101,
							MILLHOUSE_MANASTORM = 102, // not done
							LEEROY_JENKINS = 103,
							LORD_JARAXXUS = 104, // not done
							FOE_REAPER = 105, // not done
							RAGING_WORGEN = 106, // not done
							INJURED_BLADEMASTER = 107, // not done
							SOOTHING_BERSERKER = 108, // not done
							GURUBASHI_BERSERKER = 109,
							ZUL_FARRAK_BERSERKER = 110, // not done
							HARRISON_JONES = 111, // not done
							WILD_PYROMANCER = 112, // not done
							NORTHSHIRE_CLERIC = 113, // not done
							SHADOWBOXER = 114, // not done
							STONESKIN_GARGOYLE = 115, // not done
							TIMBERWOLF = 116, // not done
							BEASTMASTER = 117, // not done
							THUNDRA_RHINO = 118, // not done
							STAMPEDING_KODO = 119, // not done
							DEFIAS_RINGLEADER = 120, // not done
							KIRIN_TOR_MAGE = 121, // not done
							TRAP_MYSTIC = 122, // not done
							ARCANE_NEXXUS = 123, // not done
							ARGENT_PROTECTOR = 124,
							BLOOD_KNIGHT = 125,
							BIG_GAME_HUNTER = 126, // not done
							NEFARIAN = 127, // not done
							POISON_COBRA = 128, // not done
							STEALTH_WORGEN = 129,
							BARON_GEDDON = 130,
							MALORNE = 131,
							ALDOR_PEACEKEEPER = 132,
							CRAZED_ALCHEMIST = 133,
							HOGGER = 134,
							GNOLL = 204,
							FACELESS_MANIPULATOR = 135, // not done
							SPELLBREAKER = 136, // not done
							FELGUARD = 137, // not done
							GADGETZAN_AUCTIONEER = 138, // not done
							AUCHENAI_SOULPRIEST = 139, // not done
							TYRION_FORDRING = 140, // not done
							FOREST_PROTECTOR_CENTAUR = 141, // not done
							CENARIUS = 142, // not done
							GROMMASH_HELLSCREAM = 143, // not done
							ARMORSMITH = 144, // not done
							WEAPONSMITH = 145, // not done
							ARATHI_WEAPONSMITH = 146, // not done
							HEALING_SUCCUBUS = 147, // not done
							ENRAGED_WEAPON_HELPER = 148, // not done
							MOONLIGHT_PRIEST = 149, // not done
							ZOMBIE_CHOW = 150,
							OLD_MURK_EYE = 151, // not done
							COLDLIGHT_ORACLE = 152, // not done
							MURLOC_RAID_LEADER = 153, // not done
							EDWIN_VAN_CLEEF = 154, // not done
							REND_BLACKHAND = 155, // not done
							BLACK_KNIGHT = 156, // not done
							MANA_WYRM = 157, // not done
							SORCERERS_APPRENTICE = 158, // not done
							MANA_WRAITH = 159, // not done
							WAILING_SOUL = 160, // not done
							DRAGONKIN_CRUSHER = 161, // not done
							TROLL_CARDHAND_ATTACKER = 162, // not done
							SIEGE_ENGINE = 163, // not done
							FLOATING_WATCHER = 164, // not done
							KING_OF_BEASTS = 165, // not done
							DEFENDER_OF_ARGUS = 166, // not done
							SUNFURY_PROTECTOR = 167, // not done
							ANGRY_CHICKEN = 168, // not done
							PILOTED_SKY_GOLEM = 169, // not done
							THE_BEAST = 170,
							TAUREN_WARRIOR = 171, // not done
							NAT_PAGLE = 172, // not done
							OGRE_BRUTE = 173, // not done
							MOGOR_THE_OGRE = 174, // not done
							CLOCKWORK_GNOME = 175, // not done
							CULT_MASTER = 176, // not done
							MAGNA_GOLEM = 177, // not done
							NEPTULON = 178, // not done
							MINE_MACHINE = 179, // not done
							LEVIATHON_MACHINE = 180, // not done
							ARGENT_SQUIRE = 181,
							SCARLET_CRUSADER = 182,
							SHIELDED_MINIBOT = 183,
							ARGENT_COMMANDER = 184,
							SUNWALKER = 185,
							STORMPIKE_COMMANDO = 186,
							CHROMAGGUS = 187, // not done
							DOOMGUARD = 188, // not done
							SILENCE_OWL = 189, // not done
							TALLSTRIDER = 190,
							LIGHTWELL = 191, // not done
							SALTY_DOG = 192,
							WEAPON_PIRATE_CHARGER = 193, // not done
							BLOODSAIL_BUCCANEER = 194, // not done
							CAPTAIN_GREENSKIN = 195, // not done
							CAPTAINS_PARROT = 196, // not done
							PIRATE_TAUNTER = 197, // not done
							PIRATE_RARE_DRANEI = 198, // not done
							PIRATE_CANNON = 199, // not done
							TEST_DUMMY = 200,
							MECHWARPER = 201, // not done
							ANNOY_O_TRON = 202,
							MECHANICAL_YETI = 203, // not done
							SPIDER_TANK = 204,
							SHADOWBOMBER = 205,
							DRAENAI_GUARD = 206,
							OGRE_NINJA = 207, // not done
							MINI_MAGE = 208, // not done
							STEALTHED_ASSASSIN = 209, // not done
							GAZLOW = 210, // not done
							GNOME_DIVER = 211,
							OGRE_MAGI = 212, // not done
							ANTIQUE_HEALBOT = 213,
							GNOME_INFANTRY = 214,
							FLAMEWALKER = 215, // not done
							ONE_EYED_GOBLIN = 216, // not done
							PALADIN_MECH_SHIELDER = 217, // not done
							QUARTERMASTER = 218, // not done
							STEAMWHEELER_SNIPER = 219, // not done
							DREAD_INFERNAL = 220;

	private int type;

	private String name;
	private int minionType;

	private int cost;
	private int originalCost;
	private int attack;
	private int health;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;
	private boolean cannotAttack;
	private boolean stealth;
	private boolean stealthTemporary;
	//private boolean noSpellTarget;

	private SpellEffect costEffect;

	private DamageEffect damageEffect;

	private SpellEffect battleCryEffect;
	private SpellEffect deathRattleEffect;

	private TurnEffect startTurnEffect;
	private TurnEffect endTurnEffect;

	public MonsterCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		this.type = type;

		costEffect = null;

		taunt = false;
		charge = false;
		divineShield = false;
		windfury = false;
		cannotAttack = false;
		stealth = false;
		stealthTemporary = false;

		battleCryEffect = null;
		damageEffect = null;
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
			minionType = Minion.MURLOC;
			initBasicStats(1, 1, 1);
		} else if (type == MURLOC_RAIDER) {
			name = "Murloc Raider";
			minionType = Minion.MURLOC;
			initBasicStats(1, 2, 1);
		} else if (type == STONETUSK_BOAR) {
			name = "Stonetusk Boar";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
			charge = true;
		} else if (type == VODOO_DOCTOR) {
			name = "Vodoo Doctor";
			initBasicStats(1, 2, 1);
			battleCryEffect = new HealCharacter(2, false, false);
		} else if (type == ACIDIC_SWAMP_OOZE) {
			name = "Acidic Swamp Ooze";
			initBasicStats(2, 3, 2);
		} else if (type == BLOODFEN_RAPTOR) {
			name = "Bloodfen Raptor";
			minionType = Minion.BEAST;
			initBasicStats(2, 3, 2);
		} else if (type == BLUEGILL_WARRIOR) {
			name = "Bluegill Warrior";
			minionType = Minion.MURLOC;
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
			minionType = Minion.BEAST;
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
			minionType = Minion.BEAST;
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
			minionType = Minion.BEAST;
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
			minionType = Minion.MECH;
			initBasicStats(1, 2, 1);
		} else if (type == MANA_TIDE_TOTEM) {
			name = "Mana Tide Totem";
			minionType = Minion.TOTEM;
			initBasicStats(3, 0, 3);
			endTurnEffect = new DrawCardsTurnEffect(1, false);
		} else if (type == ABUSIVE_SERGEANT) {
			name = "Abusive Sergeant";
			initBasicStats(1, 2, 1);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == MURLOC_TIDEHUNTER) {
			name = "Murloc Tidehunter";
			minionType = Minion.MURLOC;
			initBasicStats(2, 2, 1);
			battleCryEffect = new SummonMinions(new int[] {MURLOC_SCOUT}, null);
		} else if (type == MURLOC_SCOUT) {
			name = "Murloc Scout";
			minionType = Minion.MURLOC;
			initBasicStats(0, 1, 1);
		} else if (type == DISPATCHING_DRAKE) {
			name = "Dispatching Drake";
			initBasicStats(1, 2, 1);
			battleCryEffect = new PickUpMinion(-1);
		} else if (type == EARTHEN_RING_FARSEER) {
			name = "Earthen Ring Farseer";
			initBasicStats(3, 3, 3);
			battleCryEffect = new HealCharacter(3, false, false);
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
			deathRattleEffect = new DealDamageToAllCharacters(1, true, true, false, false);
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
			minionType = Minion.BEAST;
			initBasicStats(8, 8, 8);
			charge = true;
		} else if (type == DR_BOOM) {
			name = "Dr. Boom";
			initBasicStats(7, 7, 7);
			battleCryEffect = new SummonMinions(new int[] {BOOM_BOT, BOOM_BOT}, null);
		} else if (type == BOOM_BOT) {
			name = "Boom Bot";
			minionType = Minion.MECH;
			initBasicStats(1, 1, 1);
			deathRattleEffect = new DealRandomDamageRandomly(1, 3, true);
		} else if (type == DEATHWING) {
			name = "Deathwing";
			minionType = Minion.DRAGON;
			initBasicStats(10, 12, 12);
			battleCryEffect = new DestroyAllMinions(true);
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
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
			battleCryEffect = new SetHealthPlayer(15);
		} else if (type == DOOMSAYER) {
			name = "Doomsayer";
			initBasicStats(2, 0, 7);
			startTurnEffect = new DestroyAllMinionsTurnEffect(false, false);
		} else if (type == FIRE_ELEMENTAL) {
			name = "Fire Elemental";
			initBasicStats(6, 6, 5);
			battleCryEffect = new DealDamage(3);
		} else if (type == BLOOD_IMP) {
			name = "Blood Imp";
			minionType = Minion.DEMON;
			initBasicStats(1, 3, 2);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, true, false);
		} else if (type == NIGHTBLADE) {
			name = "Nightblade";
			initBasicStats(5, 4, 4);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, false, true);
		} else if (type == LEPER_GNOME) {
			name = "Leper Gnome";
			initBasicStats(1, 2, 1);
			deathRattleEffect = new DealDamageToAllCharacters(2, false, false, false, true);
		} else if (type == ALARMO_BOT) {
			name = "Alarm'O Bot";
			minionType = Minion.MECH;
			initBasicStats(3, 0, 3);
			startTurnEffect = new SummonRandomMinionFromHandTurnEffect(false, false, true);
		} else if (type == FROSTWOLF_WARLORD) {
			name = "Frostwolf Warlord";
			initBasicStats(5, 4, 4);
			battleCryEffect = new BuffAccordingToBoard(1, 1, true, false, false, false);
		} else if (type == MOLTEN_GIANT) {
			name = "Molten Giant";
			costEffect = new CostDeterminedByHealth(1, true);
			initBasicStats(20, 8, 8);
		} else if (type == SEA_GIANT) {
			name = "Sea Giant";
			costEffect = new CostDeterminedByMinionsOnBoard(1, true, true);
			initBasicStats(10, 8, 8);
		} else if (type == MOUNTAIN_GIANT) {
			name = "Mountain Giant";
			costEffect = new CostDeterminedByCardsInHand(1, true, false);
			initBasicStats(12, 8, 8);
		} else if (type == CLOCKWORK_GIANT) {
			name = "Clockwork Giant";
			minionType = Minion.MECH;
			costEffect = new CostDeterminedByCardsInHand(1, false, true);
			initBasicStats(12, 8, 8);
		} else if (type == GRUUL) {
			name = "Gruul";
			initBasicStats(7, 7, 7);
			startTurnEffect = new BuffMinionTurnEffect(1, 1, true, false);
		} else if (type == ONYXIA) {
			name = "Onyxia";
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
			battleCryEffect = new SummonMinions(new int[] {DRAGON_WHELP, DRAGON_WHELP, DRAGON_WHELP, DRAGON_WHELP, DRAGON_WHELP, DRAGON_WHELP}, null);
		} else if (type == DRAGON_WHELP) {
			name = "Dragon Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 1, 1);
		} else if (type == SHRINKMEISTER) {
			name = "Shrinkmeister";
			initBasicStats(2, 3, 2);
			battleCryEffect = new BuffSingleMinion(-2, 0, false, false, false, false, true);
		} else if (type == SAVANNAH_HIGHMANE) {
			name = "Savannah Highmane";
			minionType = Minion.BEAST;
			initBasicStats(6, 6, 5);
			deathRattleEffect = new SummonMinions(new int[] {SAVANNAH_HYENA, SAVANNAH_HYENA}, null);
		} else if (type == SAVANNAH_HYENA) {
			name = "Savannah Hyena";
			minionType = Minion.BEAST;
			initBasicStats(2, 2, 2);
		} else if (type == TWILIGHT_DRAKE) {
			name = "Twilight Drake";
			minionType = Minion.DRAGON;
			initBasicStats(4, 4, 1);
			battleCryEffect = new BuffAccordingToHand(0, 1, true, false, false, false);
		} else if (type == IMP_MASTER) {
			name = "Imp Master";
			initBasicStats(3, 1, 5);
			endTurnEffect = new SummonMinionTurnEffect(new int[] {IMP}, null, false);
		} else if (type == IMP) {
			name = "Imp";
			minionType = Minion.DEMON;
			initBasicStats(1, 1, 1);
		} else if (type == HOGGER) {
			name = "Hogger";
			initBasicStats(5, 4, 4);
			endTurnEffect = new SummonMinionTurnEffect(new int[] {GNOLL}, null, false);
		} else if (type == GNOLL) {
			name = "Gnoll";
			initBasicStats(2, 2, 2);
			taunt = true;
		} else if (type == SHRINKMEISTER) {
			name = "Shrinkmeister";
			initBasicStats(2, 3, 2);
			battleCryEffect = new BuffSingleMinion(-2, 0, false, false, false, false, true);
		} else if (type == ALDOR_PEACEKEEPER) {
			name = "Aldor Peacekeeper";
			initBasicStats(3, 3, 3);
			battleCryEffect = new SetStatsSingleMinion(1, -1);
		} else if (type == CRAZED_ALCHEMIST) {
			name = "Crazed Alchemist";
			initBasicStats(2, 2, 2);
			battleCryEffect = new SwapAttackHealthMinion();
		} else if (type == BARON_GEDDON) {
			name = "Baron Geddon";
			initBasicStats(7, 7, 5);
			endTurnEffect = new DealDamageToAllCharactersTurnEffect(2, true, true, true, false);
		} else if (type == MALORNE) {
			name = "Malorne";
			minionType = Minion.BEAST;
			initBasicStats(9, 9, 7);
			deathRattleEffect = new AddCardToDeck(new int[] {MALORNE}, null);
		} else if (type == DEATHLORD) {
			name = "Deathlord";
			initBasicStats(3, 2, 8);
			taunt = true;
			deathRattleEffect = new SummonRandomMinionsFromDeck(0, false, 1, true);
		} else if (type == LEEROY_JENKINS) {
			name = "Leeroy Jenkins";
			initBasicStats(5, 6, 2);
			charge = true;
			battleCryEffect = new SummonMinions(null, new int[] {DRAGON_WHELP, DRAGON_WHELP});
		} else if (type == RAZORFEN_HUNTER) {
			name = "Razorfen Hunter";
			initBasicStats(3, 2, 3);
			battleCryEffect = new SummonMinions(new int[] {RAZORFEN_BOAR}, null);
		} else if (type == RAZORFEN_BOAR) {
			name = "Razorfen Boar";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
		} else if (type == MALYGOS) {
			name = "Malygos";
			minionType = Minion.DRAGON;
			initBasicStats(9, 4, 12);
		} else if (type == WATER_ELEMENTAL) {
			name = "Water Elemental";
			initBasicStats(4, 3, 6);
		} else if (type == EARTH_ELEMENTAL) {
			name = "Earth Elemental";
			initBasicStats(5, 7, 8);
			taunt = true;
		} else if (type == MALGANIS) {
			name = "Mal'Ganis";
			minionType = Minion.BEAST;
			initBasicStats(9, 9, 7);
		} else if (type == BLOODMAGE_THALNOS) {
			name = "Bloodmage Thalnos";
			initBasicStats(2, 1, 1);
			deathRattleEffect = new DrawCards(1);
		} else if (type == ZOMBIE_CHOW) {
			name = "Zombie Chow";
			initBasicStats(1, 2, 3);
			deathRattleEffect = new HealCharacter(5, true, false);
		} else if (type == ELVEN_OF_ELUNE) {
			name = "Elven of Elune";
			initBasicStats(5, 4, 4);
			battleCryEffect = new HealCharacter(4, true, true);
		} else if (type == ARGENT_PROTECTOR) {
			name = "Argent Protector";
			initBasicStats(2, 2, 2);
			battleCryEffect = new BuffSingleMinion(0, 0, false, false, true, false, false);
		} else if (type == ARGENT_SQUIRE) {
			name = "Argent Squire";
			initBasicStats(1, 1, 1);
			divineShield = true;
		} else if (type == SCARLET_CRUSADER) {
			name = "Scarlet Crusader";
			initBasicStats(3, 3, 1);
			divineShield = true;
		} else if (type == SHIELDED_MINIBOT) {
			name = "Shielded Minibot";
			initBasicStats(2, 2, 2);
			divineShield = true;
		} else if (type == ARGENT_COMMANDER) {
			name = "Argent Commander";
			initBasicStats(6, 4, 2);
			charge = true;
			divineShield = true;
		} else if (type == SUNWALKER) {
			name = "Sunwalker";
			initBasicStats(6, 4, 5);
			taunt = true;
			divineShield = true;
		} else if (type == BLOOD_KNIGHT) {
			name = "Blood Knight";
			initBasicStats(4, 3, 3);
			battleCryEffect = new BuffAccordingToDivineShields(3, 3, true, true, true, false, false);
		} else if (type == YSERA) {
			name = "Ysera";
			minionType = Minion.DRAGON;
			initBasicStats(9, 4, 12);
			endTurnEffect = new AddDreamCardToHandTurnEffect(1, false);
		} else if (type == ACOLYTE_OF_PAIN) {
			name = "Acolyte of Pain";
			initBasicStats(3, 1, 3);
			damageEffect = new DrawCardsDamageEffect(1, false, false);
		} else if (type == GAHZRILLA) {
			name = "Gahzrilla";
			minionType = Minion.BEAST;
			initBasicStats(7, 6, 9);
			damageEffect = new BuffMinionDamageEffect(0, 0, true, false, false);
		} else if (type == GURUBASHI_BERSERKER) {
			name = "Gurubashi Berserker";
			initBasicStats(5, 2, 7);
			damageEffect = new BuffMinionDamageEffect(3, 0, false, false, false);
		} else if (type == STORMPIKE_COMMANDO) {
			name = "Stormpike Commando";
			initBasicStats(4, 4, 2);
			battleCryEffect = new DealDamage(2);
		} else if (type == TALLSTRIDER) {
			name = "Tallstrider";
			minionType = Minion.BEAST;
			initBasicStats(4, 5, 4);
		} else if (type == SALTY_DOG) {
			name = "Salty Dog";
			minionType = Minion.PIRATE;
			initBasicStats(5, 7, 4);
		} else if (type == TEST_DUMMY) {
			name = "Test Dummy";
			minionType = Minion.MECH;
			initBasicStats(0, 0, 2);
			taunt = true;
		} else if (type == ANNOY_O_TRON) {
			name = "Annoy-O-tron";
			minionType = Minion.MECH;
			initBasicStats(2, 1, 2);
			taunt = true;
			divineShield = true;
		} else if (type == SPIDER_TANK) {
			name = "Spider Tank";
			minionType = Minion.MECH;
			initBasicStats(3, 3, 4);
		} else if (type == SHADOWBOMBER) {
			name = "Shadowbomber";
			initBasicStats(1, 2, 1);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, true, true);
		} else if (type == THE_BEAST) {
			name = "The Beast";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 7);
			deathRattleEffect = new SummonMinions(null, new int[] {GNOME_DIVER});
		} else if (type == GNOME_DIVER) {
			name = "Gnome Diver";
			initBasicStats(3, 3, 3);
		} else if (type == GNOME_INFANTRY) {
			name = "Gnome Infantry";
			initBasicStats(3, 1, 4);
			taunt = true;
			charge = true;
		} else if (type == ANTIQUE_HEALBOT) {
			name = "Antique Healbot";
			minionType = Minion.MECH;
			initBasicStats(5, 3, 3);
			battleCryEffect = new HealCharacter(8, true, true);
		} else if (type == STEALTH_WORGEN) {
			name = "Stealth Worgen";
			initBasicStats(1, 2, 1);
			stealth = true;
		} else if (type == DRAENAI_GUARD) {
			name = "Draenai Guard";
			initBasicStats(1, 0, 4);
			taunt = true;
		} else if (type == DREAD_INFERNAL) {
			name = "Dread Infernal";
			initBasicStats(6, 6, 6);
			battleCryEffect = new DealDamageToAllCharacters(1, true, true, true, true);
		} else if (type == SPELLBREAKER) {
			name = "Spellbreaker";
			initBasicStats(4, 4, 3);
			battleCryEffect = new Silence(false, true, true);
		}
	}

	private void initBasicStats(int cost, int attack, int health) {
		originalCost = cost;
		this.cost = cost;
		this.attack = attack;
		this.health = health;
	}

	public void changeCost(int costChange) {
		cost = (cost + costChange) < 0 ? 0 : cost + costChange;
	}

	public void setCost(int newCost) {
		cost = newCost < 0 ? 0 : newCost;
	}

	public boolean hasCostEffect() {
		return costEffect != null;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getOriginalCost() {
		return originalCost;
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

	public int getMinionType() {
		return minionType;
	}

	public SpellEffect getCostEffect() {
		return costEffect;
	}

	public Minion toMinion() {
		return new Minion(type, name, minionType, attack, health, taunt, charge, divineShield, windfury, cannotAttack, stealth, stealthTemporary, damageEffect, battleCryEffect, deathRattleEffect, startTurnEffect, endTurnEffect);
	}
}