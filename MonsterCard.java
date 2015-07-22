public class MonsterCard extends PlayCard {
	public static final int	
							TARGET_DUMMY = 1,
							WISP = 2,
							ABUSIVE_SERGEANT = 3,
							ANGRY_CHICKEN = 4, // not done [enrage]
							ARGENT_SQUIRE = 5,
							BLOOD_IMP = 6, // not done [endturn-buff]
							BLOODSAIL_CORSAIR = 7, // not done
							CLOCKWORK_GNOME = 8, // not done [Spare Part]
							COGMASTER = 9, // not done [Board Area Effect]
							DRAGON_EGG = 10, // not done [Dmg-effect]
							BLACK_WHELP = 11,
							DUST_DEVIL = 12, // not done [Overload]
							ELVEN_ARCHER = 13,
							FLAME_IMP = 14,
							GOLDSHIRE_FOOTMAN = 15,
							GRIMSCALE_ORACLE = 16, // not completely done - area effect
							HUNGRY_CRAB = 17, // not done []
							LEPER_GNOME = 18,
							LIGHTWARDEN = 19, // not done [Heal-effect]
							MANA_WYRM = 20, // not done [Spell-effect]
							MURLOC_RAIDER = 21,
							MURLOC_TIDECALLER = 22, // not done [Summon-effect]
							NORTHSHIRE_CLERIC = 23, // not done [Heal-effect]
							SECRETKEEPER = 24, // not done [Secret-effect]
							SHADOWBOMBER = 25,
							SHIELDBEARER = 26,
							SOUTHSEA_DECKHAND = 27, // not done [Weapon-effect]
							STONETUSK_BOAR = 28,
							TIMBER_WOLF = 29, // not done [Area-effect]
							TWILIGHT_WHELP = 30, // not done [In hand-effect]
							UNDERTAKER = 31, // not done [Summon-effect]
							VOIDWALKER = 32,
							VODOO_DOCTOR = 33,
							WARBOT = 34, // not done [Enrage-effect]
							WEBSPINNER = 35, // not done [Deathrattle]
							WORGEN_INFILTRATOR = 36,
							YOUNG_DRAGONHAWK = 37,
							YOUNG_PRIESTESS = 38, // not done [endturn-buff]
							ZOMBIE_CHOW = 39,
							ACIDIC_SWAMP_OOZE = 40, // not completely done - weapon
							AMANI_BERSERKER = 41, // not done [Enrage]
							ANCIENT_WATCHER = 42,
							ANNOY_O_TRON = 43,
							ANODIZED_ROBO_CUB = 44, // not done [Choose one]
							ARGENT_PROTECTOR = 45,
							ARMORSMITH = 46, // not done [Dmg-effect]
							BLOODFEN_RAPTOR = 47,
							BLOODMAGE_THALNOS = 48, // not dcompletely one - dubbla effekter + spell dmg
							BLOODSAIL_RAIDER = 49, // not done [Weapon-effect]
							BLUEGILL_WARRIOR = 50,
							CAPTAINS_PARROT = 51, // not done [Deathrattle]
							CRAZED_ALCHEMIST = 52,
							CRUEL_TASKMASTER = 53, // not done [Buff-effect, double]
							DEFIAS_RINGLEADER = 54, // not done [COMBO]
							DEFIAS_BANDIT = 55,
							DIRE_WOLF_ALPHA = 56, // not done [NEXT TO + AREA-effect]
							DOOMSAYER = 57,
							ECHOING_OOZE = 58, // not done [COPY-end turn effect]
							EXPLOSIVE_SHEEP = 59,
							FAERIE_DRAGON = 60, // not done [NO TARGET-effect]
							FLAMETOUNGE_TOTEM = 61, // not done [NEXT TO + AREA-effect]
							FROSTWOLF_GRUNT = 62,
							GILBIN_STALKER = 63,
							GOBLIN_AUTO_BARBER = 64, // not done
							HAUNTED_CREEPER = 65,
							SPECTRAL_SPIDER = 66,
							IRONBEAK_OWL = 67,
							KNIFE_JUGGLER = 68, // not done
							KOBOLD_GEOMANCER = 69, // not completely done - spell dmg
							LIGHTWELL = 70, // not done
							LOOT_HOARDER = 71,
							LOREWALKER_CHO = 72, // not done
							MAD_BOMBER = 73, // not done
							MAD_SCIENTIST = 74, // not done
							MANA_ADDICT = 75, // not done
							MANA_WRAITH = 76, // not done
							MASTER_SWORDSMITH = 77, // not done
							MECHWARPER = 78, // not done
							MICRO_MACHINE = 79, // not done
							MILLHOUSE_MANASTORM = 80, // not done
							MISTRESS_OF_PAIN = 81, // not done
							MURLOC_TIDEHUNTER = 82,
							MURLOC_SCOUT = 83,
							NAT_PAGLE = 84, // not done
							NERUBAR_WEBLORD = 85, // not done
							NERUBIAN_EGG = 86, // not done
							NERUBIAN = 87, // not done
							NOVICE_ENGINEER = 88,
							ONE_EYED_CHEAT = 89, // not done
							STEALTHED_ASSASSIN = 90, // not done
							PINT_SIZED_SUMMONER = 91, // not done
							PUDDLESTOMPER = 92, // not done
							RECOMBOBULATOR = 93, // not done
							RIVER_CROCOLISK = 94,
							SCAVENGING_HYENA = 95, // not done
							SHADOWBOXER = 96, // not done
							SHIELDED_MINIBOT = 97,
							SHIPS_CANNON = 98, // not done
							SHRINKMEISTER = 99,
							SNOWCHUGGER = 100,
							SORCERERS_APPRENTICE = 101, // not done
							STEAMWHEEDLE_SNIPER = 102, // not done
							STONESPLINTER_TROGG = 103, // not done
							SUCCUBUS = 104,
							SUNFURY_PROTECTOR = 105, // not done
							UNSTABLE_GHOUL = 106,
							VITALITY_TOTEM = 107, // not done
							WHIRLING_ZAP_O_MATIC = 108, // not done
							WILD_PYROMANCER = 109, // not done
							YOUTHFUL_BREWMASTER = 110,
							ACOLYTE_OF_PAIN = 111,
							ALARM_O_BOT = 112,
							ALDOR_PEACEKEEPER = 113,
							ARCANE_GOLEM = 114, // not done
							BIG_GAME_HUNTER = 115, // not done
							BLACKWING_TECHNICIAN = 116, // not done
							BLOOD_KNIGHT = 117,
							COLDLIGHT_ORACLE = 118, // not done
							COLDLIGHT_SEER = 119, // not done
							DALARAN_MAGE = 120, // not completely done - spell dmg
							DANCING_SWORDS = 121, // not done
							DARK_CULTIST = 122, // not done
							DEATHLORD = 123,
							DEMOLISHER = 124, // not done
							DRUID_OF_THE_FLAME = 125, // not done
							DRUID_OF_THE_FLAME_FIRECAT_FORM = 126, // not done
							DRUID_OF_THE_FLAME_FIRE_HAWK_FORM = 127, // not done
							EARTHEN_RING_FARSEER = 128,
							EDWIN_VANCLEEF = 129, // not done
							EMPEROR_COBRA = 130, // not done
							FELGUARD = 131, // not done
							FLAMEWALKER = 132, // not done
							FLESHEATING_GHOUL = 133, // not done
							FLYING_MACHINE = 134, // not done
							FROTHING_BERSERKER = 135, // not done
							GNOMEREGAN_INFANTRY = 136,
							GNOMISH_EXPERIMENTER = 137, // not done
							GOBLIN_SAPPER = 138, // not done
							GROVE_TENDER = 139, // not done
							HARVEST_GOLEM = 140, // not done
							DAMAGED_GOLEM = 141, // not done
							HOBGOBLIN = 142, // not done
							ILLUMINATOR = 143, // not done
							IMP_GANG_BOSS = 144,
							IMP = 145,
							IMP_MASTER = 146, // not completely done - dubbla effekter + take dmg
							INJURED_BLADEMASTER = 147, // not done
							IRON_SENSEI = 148, // not done
							IRONFORGE_RIFLEMAN = 149,
							IRONFUR_GRIZZLY = 150,
							JUNGLE_PANTHER = 151, // not done
							KING_MUKKLA = 152,
							KIRIN_TOR_MAGE = 153, // not done
							LILEXORCIST = 154, // not done
							MAGMA_RAGER = 155,
							MANA_TIDE_TOTEM = 156,
							METALTOOTH_LEAPER = 157, // not done
							MIND_CONTROL_TECH = 158, // not done
							MURLOC_WARLEADER = 159, // not done
							OGRE_BRUTE = 160, // not done
							QUESTING_ADVENTURER = 161, // not done
							RAGING_WORGEN = 162, // not done
							RAID_LEADER = 163, // not completely done - area effect
							RAZORFEN_HUNTER = 164,
							BOAR = 165,
							SCARLET_CRUSADER = 166,
							SCARLET_PURIFIER = 167, // not done
							SHADE_OF_NAXXRAMAS = 168, // not done
							SHATTERED_SUN_CLERIC = 169,
							SI7_AGENT = 170, // not done
							SILVERBACK_PATRIARCH = 171,
							SOOT_SPEWER = 172, // not done
							SOUTHSEA_CAPTAIN = 173, // not done
							SPIDER_TANK = 174,
							STONESKIN_GARGOYLE = 175, // not done
							TAUREN_WARRIOR = 176, // not done
							THRALLMAR_FARSEER = 177,
							TINKERTOWN_TECHNICIAN = 178, // not done
							TINKMASTER_OVERSPARK = 179, // not done
							UNBOUND_ELEMENTAL = 180, // not done
							VOID_TERROR = 181, // not done
							WARSONG_COMMANDER = 182, // not done
							WOLFRIDER = 183,
							ANCIENT_BREWMASTER = 184,
							ANCIENT_MAGE = 185, // not done
							ANUBAR_AMBUSHER = 186, // not done
							ARATHI_WEAPONSMITH = 187, // not done
							ARCANE_NULLIFIER_X21 = 188, // not done
							AUCHENAI_SOULPRIEST = 189, // not done
							AXE_FLINGER = 190, // not done
							BARON_RIVERDARE = 191, // not done
							BURLY_ROCKJAW_TROGG = 192, // not done
							CHILLWIND_YETI = 193,
							CORE_RAGER = 194, // not done
							CULT_MASTER = 195, // not done
							DARK_IRON_DWARF = 196,
							DEFENDER_OF_ARGUS = 197, // not done
							DRAGONKIN_SORCERER = 198, // not done
							DRAGONLING_MECHANIC = 199,
							MECHANICAL_DRAGONLING = 200,
							DREAD_CORSAIR = 201, // not done
							DUNEMAUL_SHAMAN = 202, // not done
							ENHANCE_O_MECHANO = 203, // not done
							ETHEREAL_ARCANIST = 204, // not done
							FEL_CANNON = 205, // not done
							FIREGUARD_DESTROYER = 206, // not done
							GNOMISH_INVENTOR = 207, // not done
							GOBLIN_BLASTMAGE = 208, // not done
							HOUNDMASTER = 209, // not done
							HUNGRY_DRAGON = 210, // not done
							JEEVES = 211, // not done
							KEEPER_OF_THE_GROVE = 212, // not done
							KEZAN_MYSTIC = 213, // not done
							KORKRON_ELITE = 214,
							LIGHTSPAWN = 215, // not done
							LOST_TALLSTRIDER = 216,
							MASTER_OF_DISGUISE = 217, // not done
							MECHANICAL_YETI = 218, // not done
							MINI_MAGE = 219, // not done
							MOGUSHAN_WARDEN = 220, // not done
							OASIS_SNAPJAW = 221, // not done
							OGRE_MAGI = 222, // not done
							OLD_MURK_EYE = 223, // not done
							PILOTED_SHREDDER = 224, // not done
							PIT_LORD = 225,
							SCREWJANK_CLUNKER = 226, // not done
							SENJIN_SHIELDMASTA = 227, // not done
							SILTFIN_SPIRITWALKER = 228, // not done
							SILVERMOON_GUARDIAN = 229, // not done
							SPELLBREAKER = 230,
							STORMWIND_KNIGHT = 231, // not done
							SUMMONING_PORTAL = 232, // not done
							TWILIGHT_DRAKE = 233,
							VIOLET_TEACHER = 234, // not done
							VIOLET_APPRENTICE = 235, // not done
							VOIDCALLER = 236, // not done
							WAILING_SOUL = 237, // not done
							WATER_ELEMENTAL = 238, // not completely done - freeze
							WEE_SPELLSTOPPER = 239, // not done
							WINDSPEAKER = 240, // not done
							ABOMINATION = 241, // not done
							ANTIQUE_HEALBOT = 242,
							AZURE_DRAKE = 243, // not done
							BLACKWING_CORRUPTOR = 244, // not done
							BLINGTRON_3000 = 245, // not done
							BOLVAR_FORDRAGON = 246, // not done
							BOMB_LOBBER = 247, // not done
							BOOTY_BAY_BODYGUARD = 248,
							CAPTAIN_GREENSKIN = 249, // not done
							COBALT_GUARDIAN = 250, // not done
							DARK_IRON_SKULKER = 251, // not done
							DARKSCALE_HEALER = 252, // not done
							DOOMGUARD = 253,
							DRAGON_CONSORT = 254, // not done
							DRUID_OF_THE_CLAW = 255, // not done
							DRUID_OF_THE_CLAW_CAT_FORM = 256,
							DRUID_OF_THE_CLAW_BEAR_FORM = 257,
							DRUID_OF_THE_FANG = 258, // not done
							DRUID_OF_THE_FANG_VIPER_FORM = 259, // not done
							EARTH_ELEMENTAL = 260, // not completely done - overload
							ELITE_TAUREN_CHIEFTAIN = 261, // not done
							FACELESS_MANIPULATOR = 262, // not done
							FEL_REAVER = 263, // not done
							FEN_CREEPER = 264, // not done
							FEUGEN = 265, // not done
							FLOATING_WATCHER = 266, // not done
							FROSTWOLF_WARLORD = 267,
							GRIM_PATRON = 268,
							GURUBASHI_BERSERKER = 269,
							HARRISON_JONES = 270, // not done
							HEMET_NESINGWARY = 271, // not done
							JUNKBOT = 272, // not done
							KING_OF_BEASTS = 273, // not done
							LEEROY_JENKINS = 274,
							LOATHEB = 275, // not done
							MADDER_BOMBER = 276, // not done
							MIMIRONS_HEAD = 277, // not done
							V_07_TR_0N = 278, // not done
							NIGHTBLADE = 279,
							OGRE_NINJA = 280, // not done
							QUARTERMASTER = 281, // not done
							SALTY_DOG = 282,
							SIEGE_ENGINE = 283, // not done
							SILVER_HAND_KNIGHT = 284, // not done
							SQUIRE = 285, // not done
							SLUDGE_BELCHER = 286,
							SLIME = 287,
							SPECTRAL_KNIGHT = 288, // not done
							SPITEFUL_SMITH = 289, // not done
							STALAGG = 290, // not done
							THADDIUS = 291, // not done
							STAMPEDING_KODO = 292, // not done
							STARVING_BUZZARD = 293, // not done
							STORMPIKE_COMMANDO = 294,
							STRANGLETHORN_TIGER = 295,
							TUNDRA_RHINO = 296, // not done
							UPGRADED_REPAIR_BOT = 297, // not done
							VENTURE_CO_MERCENARY = 298, // not done
							VOLJIN = 299,
							ANIMA_GOLEM = 300, // not done
							ARCHMAGE = 301, // not done
							ARGENT_COMMANDER = 302,
							BOULDERFIST_OGRE = 303, // not done
							CABAL_SHADOW_PRIEST = 304, // not done
							CAIRNE_BLOODHOOF = 305,
							BAINE_BLOODHOOF = 306,
							DRAKONID_CRUSHER = 307, // not done
							DREAD_INFERNAL = 308,
							EMPEROR_THAURISSAN = 309,
							FIRE_ELEMENTAL = 310,
							FROST_ELEMENTAL = 311, // not done
							GADGETZAN_AUCTIONEER = 312, // not done
							GAZLOWE = 313, // not done
							GELBIN_MEKKATORQUE = 314, // not done
							EMBOLDENER_3000 = 315, // not done
							HOMING_CHICKEN = 316, // not done
							POULTRYIZER = 317, // not done
							REPAIR_BOT = 318, // not done
							HOGGER = 319,
							GNOLL = 320,
							ILLIDAN_STORMRAGE = 321, // not done
							FLAME_OF_AZZINOTH = 322, // not done
							IRON_JUGGERNAUT = 323, // not done
							BURROWING_MINE = 324, // not done
							KIDNAPPER = 325, // not done
							LORD_OF_THE_ARENA = 326,
							MAEXXNA = 327, // not done
							MECH_BEAR_CAT = 328, // not done
							MOGOR_THE_OGRE = 329, // not done
							PILOTED_SKY_GOLEM = 330, // not done
							PRIESTESS_OF_ELUNE = 331,
							RECKLESS_ROCKETEER = 332, // not done
							SAVANNAH_HIGHMANE = 333,
							HYENA = 334,
							SHIELDMAIDEN = 335,
							SUNWALKER = 336,
							SYLVANAS_WINDRUNNER = 337,
							TEMPLE_ENFORCER = 338, // not done
							THE_BEAST = 339,
							FINKLE_EINHORN = 340,
							THE_BLACK_KNIGHT = 341, // not done
							TOSHLEY = 342, // not done
							TRADE_PRINCE_GALLYWIX = 343, // not done
							VOLCANIC_DRAKE = 344, // not done
							WINDFURY_HARPY = 345,
							ANCIENT_OF_LORE = 346, // not done
							ANCIENT_OF_WAR = 347, // not done
							ARCHMAGE_ANTONIDAS = 348, // not done
							BARON_GEDDON = 349,
							CORE_HOUND = 350,
							DR_BOOM = 351,
							BOOM_BOT = 352,
							FLAME_LEVIATHAN = 353, // not done
							GAHZRILLA = 354,
							GUARDIAN_OF_KINGS = 355, // not done
							MALORNE = 356,
							NEPTULON = 357, // not done
							PROPHET_VELEN = 358, // not completely done - double spell + hero -effect
							RAVENHOLDT_ASSASSIN = 359,
							REND_BLACKHAND = 360, // not done
							STORMWIND_CHAMPION = 361, // not done
							TROGGZOR_THE_EARTHINATOR = 362, // not done
							WAR_GOLEM = 363,
							ALAKIR_THE_WINDLORD = 364,
							CHROMAGGUS = 365, // not done
							FOE_REAPER_4000 = 366, // not done
							FORCE_TANK_MAX = 367,
							GROMMASH_HELLSCREAM = 368, // not done
							GRUUL = 369,
							IRONBARK_PROTECTOR = 370, // not done
							KELTHUZAD = 371,
							RAGNAROS_THE_FIRELORD = 372,
							SNEEDS_OLD_SHREDDER = 373, // not done
							TIRION_FORDRING = 374, // not done
							ALEXSTRASZA = 375,
							CENARIUS = 376, // not done
							TREANT = 377, // not done
							KING_KRUSH = 378,
							LORD_JARAXXUS = 379, // not done
							MAJORDOMO_EXECUTUS = 380, // not done
							MALGANIS = 381, // not completely done - immune & +2/+2 - demon
							MALYGOS = 382, // not completely done - spell dmg
							MEGGINEER_THERMAPLUGG = 383, // not done
							NEFARIAN = 384, // not done
							NOZDORMU = 385, // not done - inte göra
							ONYXIA = 386,
							WHELP = 387,
							VOLCANIC_LUMBERER = 388, // not done
							YSERA = 389,
							DEATHWING = 390,
							SEA_GIANT = 391,
							CLOCKWORK_GIANT = 392,
							MOUNTAIN_GIANT = 393,
							MOLTEN_GIANT = 394;

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

		if (type == TARGET_DUMMY) {
			name = "Target Dummy";
			minionType = Minion.MECH;
			initBasicStats(0, 0, 2);
			taunt = true;
		} else if (type == WISP) {
			name = "Wisp";
			initBasicStats(0, 1, 1);
		} else if (type == ABUSIVE_SERGEANT) {
			name = "Abusive Sergeant";
			initBasicStats(1, 2, 1);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == ARGENT_SQUIRE) {
			name = "Argent Squire";
			initBasicStats(1, 1, 1);
			divineShield = true;
		} else if (type == BLACK_WHELP) {
			name = "Black Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 2, 1);
		} else if (type == ELVEN_ARCHER) {
			name = "Elven Archer";
			initBasicStats(1, 1, 1);
			battleCryEffect = new DealDamage(1);
		} else if (type == FLAME_IMP) {
			name = "Flame Imp";
			minionType = Minion.DEMON;
			initBasicStats(1, 3, 2);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, true, false);
		} else if (type == GOLDSHIRE_FOOTMAN) {
			name = "Goldshire Footman";
			initBasicStats(1, 1, 2);
			taunt = true;
		} else if (type == LEPER_GNOME) {
			name = "Leper Gnome";
			initBasicStats(1, 2, 1);
			deathRattleEffect = new DealDamageToAllCharacters(2, false, false, false, true);
		} else if (type == MURLOC_RAIDER) {
			name = "Murloc Raider";
			minionType = Minion.MURLOC;
			initBasicStats(1, 2, 1);
		} else if (type == SHADOWBOMBER) {
			name = "Shadowbomber";
			initBasicStats(1, 2, 1);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, true, true);
		} else if (type == SHIELDBEARER) {
			name = "Shieldbearer";
			initBasicStats(1, 0, 4);
			taunt = true;
		} else if (type == STONETUSK_BOAR) {
			name = "Stonetusk Boar";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
			charge = true;
		} else if (type == VOIDWALKER) {
			name = "Voidwalker";
			minionType = Minion.DEMON;
			initBasicStats(1, 1, 3);
			taunt = true;
		} else if (type == VODOO_DOCTOR) {
			name = "Vodoo Doctor";
			initBasicStats(1, 2, 1);
			battleCryEffect = new HealCharacter(2, false, false);
		} else if (type == ANCIENT_WATCHER) {
			name = "Ancient Watcher";
			initBasicStats(2, 4, 5);
			cannotAttack = true;
		} else if (type == DEFIAS_BANDIT) {
			name = "Defias Bandit";
			initBasicStats(1, 2, 1);
		} else if (type == EXPLOSIVE_SHEEP) {
			name = "Explosive Sheep";
			minionType = Minion.MECH;
			initBasicStats(2, 1, 1);
			deathRattleEffect = new DealDamageToAllCharacters(2, true, true, false, false);
		} else if (type == WORGEN_INFILTRATOR) {
			name = "Worgen Infiltrator";
			initBasicStats(1, 2, 1);
			stealth = true;
		} else if (type == GILBIN_STALKER) {
			name = "Gilbin Stalker";
			initBasicStats(2, 2, 3);
			stealth = true;
		} else if (type == DOOMSAYER) {
			name = "Doomsayer";
			initBasicStats(2, 0, 7);
			startTurnEffect = new DestroyAllMinionsTurnEffect(false, false);
		} else if (type == FROSTWOLF_GRUNT) {
			name = "Frostwolf Grunt";
			initBasicStats(2, 2, 2);
			taunt = true;
		} else if (type == BLUEGILL_WARRIOR) {
			name = "Bluegill Warrior";
			minionType = Minion.MURLOC;
			initBasicStats(2, 2, 1);
			charge = true;
		} else if (type == MURLOC_TIDEHUNTER) {
			name = "Murloc Tidehunter";
			minionType = Minion.MURLOC;
			initBasicStats(2, 2, 1);
			battleCryEffect = new SummonMinions(new int[] {MURLOC_SCOUT}, null);
		} else if (type == MURLOC_SCOUT) {
			name = "Murloc Scout";
			minionType = Minion.MURLOC;
			initBasicStats(0, 1, 1);
		} else if (type == CRAZED_ALCHEMIST) {
			name = "Crazed Alchemist";
			initBasicStats(2, 2, 2);
			battleCryEffect = new SwapAttackHealthMinion();
		} else if (type == SHRINKMEISTER) {
			name = "Shrinkmeister";
			initBasicStats(2, 3, 2);
			battleCryEffect = new BuffSingleMinion(-2, 0, false, false, false, false, true);
		} else if (type == NOVICE_ENGINEER) {
			name = "Novice Engineer";
			initBasicStats(2, 1, 1);
			battleCryEffect = new DrawCards(1);
		} else if (type == LOOT_HOARDER) {
			name = "Loot Hoarder";
			initBasicStats(2, 2, 1);
			deathRattleEffect = new DrawCards(1);
		} else if (type == YOUTHFUL_BREWMASTER) {
			name = "Youthful Brewmaster";
			initBasicStats(2, 3, 2);
			battleCryEffect = new PickUpMinion(0);
		} else if (type == ACIDIC_SWAMP_OOZE) {
			name = "Acidic Swamp Ooze";
			initBasicStats(2, 3, 2);
		} else if (type == BLOODFEN_RAPTOR) {
			name = "Bloodfen Raptor";
			minionType = Minion.BEAST;
			initBasicStats(2, 3, 2);
		} else if (type == KOBOLD_GEOMANCER) {
			name = "Kobold Geomancer";
			initBasicStats(2, 2, 2);
		} else if (type == RIVER_CROCOLISK) {
			name = "River Crocolisk";
			minionType = Minion.BEAST;
			initBasicStats(2, 2, 3);
		} else if (type == IRONFORGE_RIFLEMAN) {
			name = "Ironforge Rifleman";
			initBasicStats(3, 2, 2);
			battleCryEffect = new DealDamage(1);
		} else if (type == BLOODMAGE_THALNOS) {
			name = "Bloodmage Thalnos";
			initBasicStats(2, 1, 1);
			deathRattleEffect = new DrawCards(1);
		} else if (type == UNSTABLE_GHOUL) {
			name = "Unstable Ghoul";
			initBasicStats(2, 1, 3);
			taunt = true;
			deathRattleEffect = new DealDamageToAllCharacters(1, true, true, false, false);
		} else if (type == ZOMBIE_CHOW) {
			name = "Zombie Chow";
			initBasicStats(1, 2, 3);
			deathRattleEffect = new HealCharacter(5, true, false);
		} else if (type == ARGENT_PROTECTOR) {
			name = "Argent Protector";
			initBasicStats(2, 2, 2);
			battleCryEffect = new BuffSingleMinion(0, 0, false, false, true, false, false);
		} else if (type == ANNOY_O_TRON) {
			name = "Annoy-o-Tron";
			minionType = Minion.MECH;
			initBasicStats(2, 1, 2);
			taunt = true;
			divineShield = true;
		} else if (type == IRONBEAK_OWL) {
			name = "Ironbeak Owl";
			minionType = Minion.BEAST;
			initBasicStats(2, 2, 1);
			battleCryEffect = new Silence(false, true, true);
		} else if (type == YOUNG_DRAGONHAWK) {
			name = "Young Dragonhawk";
			minionType = Minion.DRAGON;
			initBasicStats(1, 1, 1);
			windfury = true;
//==============================================================================
		} else if (type == GRIMSCALE_ORACLE) {
			name = "Grimscale Oracle";
			minionType = Minion.MURLOC;
			initBasicStats(1, 1, 1);
		} else if (type == DALARAN_MAGE) {
			name = "Dalaran Mage";
			initBasicStats(3, 1, 4);
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
		} else if (type == RAGNAROS_THE_FIRELORD) {
			name = "Ragnaros the Firelord";
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
		} else if (type == ALAKIR_THE_WINDLORD) {
			name = "Al'Akir the Windlord";
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
		} else if (type == FIRE_ELEMENTAL) {
			name = "Fire Elemental";
			initBasicStats(6, 6, 5);
			battleCryEffect = new DealDamage(3);
		} else if (type == NIGHTBLADE) {
			name = "Nightblade";
			initBasicStats(5, 4, 4);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, false, true);
		} else if (type == ALARM_O_BOT) {
			name = "Alarm-o-Bot";
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
			battleCryEffect = new SummonMinions(new int[] {WHELP, WHELP, WHELP, WHELP, WHELP, WHELP}, null);
		} else if (type == WHELP) {
			name = "Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 1, 1);
		} else if (type == SAVANNAH_HIGHMANE) {
			name = "Savannah Highmane";
			minionType = Minion.BEAST;
			initBasicStats(6, 6, 5);
			deathRattleEffect = new SummonMinions(new int[] {HYENA, HYENA}, null);
		} else if (type == HYENA) {
			name = "Hyena";
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
 		} else if (type == ALDOR_PEACEKEEPER) {
			name = "Aldor Peacekeeper";
			initBasicStats(3, 3, 3);
			battleCryEffect = new SetStatsSingleMinion(1, -1);
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
			battleCryEffect = new SummonMinions(null, new int[] {WHELP, WHELP});
		} else if (type == RAZORFEN_HUNTER) {
			name = "Razorfen Hunter";
			initBasicStats(3, 2, 3);
			battleCryEffect = new SummonMinions(new int[] {BOAR}, null);
		} else if (type == BOAR) {
			name = "Boar";
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
			minionType = Minion.DEMON;
			initBasicStats(9, 9, 7);
		} else if (type == PRIESTESS_OF_ELUNE) {
			name = "Priestess of Elune";
			initBasicStats(5, 4, 4);
			battleCryEffect = new HealCharacter(4, true, true);
		} else if (type == SCARLET_CRUSADER) {
			name = "Scarlet Crusader";
			initBasicStats(3, 3, 1);
			divineShield = true;
		} else if (type == SHIELDED_MINIBOT) {
			name = "Shielded Minibot";
			minionType = Minion.MECH;
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
			endTurnEffect = new AddDreamCardToHandTurnEffect(1, true, false, false);
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
		} else if (type == LOST_TALLSTRIDER) {
			name = "Lost Tallstrider";
			minionType = Minion.BEAST;
			initBasicStats(4, 5, 4);
		} else if (type == SALTY_DOG) {
			name = "Salty Dog";
			minionType = Minion.PIRATE;
			initBasicStats(5, 7, 4);
		} else if (type == SPIDER_TANK) {
			name = "Spider Tank";
			minionType = Minion.MECH;
			initBasicStats(3, 3, 4);
		} else if (type == THE_BEAST) {
			name = "The Beast";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 7);
			deathRattleEffect = new SummonMinions(null, new int[] {FINKLE_EINHORN});
		} else if (type == FINKLE_EINHORN) {
			name = "Finkle Einhorn";
			initBasicStats(3, 3, 3);
		} else if (type == GNOMEREGAN_INFANTRY) {
			name = "Gnomeregan Infantry";
			initBasicStats(3, 1, 4);
			taunt = true;
			charge = true;
		} else if (type == ANTIQUE_HEALBOT) {
			name = "Antique Healbot";
			minionType = Minion.MECH;
			initBasicStats(5, 3, 3);
			battleCryEffect = new HealCharacter(8, true, true);
		} else if (type == DREAD_INFERNAL) {
			name = "Dread Infernal";
			minionType = Minion.DEMON;
			initBasicStats(6, 6, 6);
			battleCryEffect = new DealDamageToAllCharacters(1, true, true, true, true);
		} else if (type == SPELLBREAKER) {
			name = "Spellbreaker";
			initBasicStats(4, 4, 3);
			battleCryEffect = new Silence(false, true, true);
		} else if (type == WINDFURY_HARPY) {
			name = "Windfury Harpy";
			initBasicStats(6, 4, 5);
			windfury = true;
		} else if (type == THRALLMAR_FARSEER) {
			name = "Thrallmar Farseer";
			initBasicStats(3, 2, 3);
			windfury = true;
		} else if (type == FORCE_TANK_MAX) {
			name = "Force-Tank MAX";
			minionType = Minion.MECH;
			initBasicStats(8, 7, 7);
			divineShield = true;
		} else if (type == DARK_IRON_DWARF) {
			name = "Dark Iron Dwarf";
			initBasicStats(4, 4, 4);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == OASIS_SNAPJAW) {
			name = "Oasis Snapjaw";
			minionType = Minion.BEAST;
			initBasicStats(4, 2, 7);
		} else if (type == WAR_GOLEM) {
			name = "War Golem";
			initBasicStats(7, 7, 7);
		} else if (type == HAUNTED_CREEPER) {
			name = "Haunted Creeper";
			minionType = Minion.BEAST;
			initBasicStats(2, 1, 2);
			deathRattleEffect = new SummonMinions(new int[] {SPECTRAL_SPIDER, SPECTRAL_SPIDER}, null);
		} else if (type == SPECTRAL_SPIDER) {
			name = "Spectral Spider";
			initBasicStats(1, 1, 1);
		} else if (type == ANCIENT_BREWMASTER) {
			name = "Ancient Brewmaster";
			initBasicStats(5, 5, 4);
			battleCryEffect = new PickUpMinion(0);
		} else if (type == PIT_LORD) {
			name = "Pit Lord";
			minionType = Minion.DEMON;
			initBasicStats(5, 7, 5);
			battleCryEffect = new DealDamageToAllCharacters(5, false, false, true, false);
		} else if (type == STRANGLETHORN_TIGER) {
			name = "Stranglethorn Tiger";
			minionType = Minion.BEAST;
			initBasicStats(5, 5, 5);
			stealth = true;
		} else if (type == RAVENHOLDT_ASSASSIN) {
			name = "Ravenholdt Assasin";
			initBasicStats(6, 7, 5);
			stealth = true;
		} else if (type == PROPHET_VELEN) {
			name = "Prophet Velen";
			initBasicStats(7, 7, 7);
		} else if (type == IMP_GANG_BOSS) {
			name = "Imp Gang Boss";
			minionType = Minion.DEMON;
			initBasicStats(3, 2, 4);
			damageEffect = new SummonMinionsDamageEffect(new int[] {IMP}, null, false, false, false);
		} else if (type == LORD_OF_THE_ARENA) {
			name = "Lord of the Arena";
			initBasicStats(6, 6, 5);
			taunt = true;
		} else if (type == CORE_HOUND) {
			name = "Core Hound";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 5);
		} else if (type == SUCCUBUS) {
			name = "Succubus";
			minionType = Minion.DEMON;
			initBasicStats(2, 4, 3);
			battleCryEffect = new DiscardCards(1);
		} else if (type == KORKRON_ELITE) {
			name = "Kor'kron Elite";
			initBasicStats(4, 4, 3);
			charge = true;
		} else if (type == BOOTY_BAY_BODYGUARD) {
			name = "Booty Bay Bodyguard";
			initBasicStats(5, 5, 4);
			taunt = true;
		} else if (type == DRUID_OF_THE_CLAW_CAT_FORM) {
			name = "Druid of the Claw (cat)";
			minionType = Minion.BEAST;
			initBasicStats(4, 4, 4);
			charge = true;
		} else if (type == DRUID_OF_THE_CLAW_BEAR_FORM) {
			name = "Druid of the Claw (bear)";
			minionType = Minion.BEAST;
			initBasicStats(4, 4, 6);
			taunt = true;
		} else if (type == DRUID_OF_THE_FANG_VIPER_FORM) {
			name = "Druid of the Fang (viper)";
			minionType = Minion.BEAST;
			initBasicStats(7, 7, 7);
		} else if (type == KING_MUKKLA) {
			name = "King Mukkla";
			minionType = Minion.BEAST;
			initBasicStats(3, 5, 5);
			battleCryEffect = new AddBananaCardToHand(2, false, true, true);
		} else if (type == DOOMGUARD) {
			name = "Doomguard";
			minionType = Minion.DEMON;
			initBasicStats(5, 5, 7);
			charge = true;
			battleCryEffect = new DiscardCards(2);
		} else if (type == SHIELDMAIDEN) {
			name = "Shieldmaiden";
			initBasicStats(6, 5, 5);
			battleCryEffect = new AddArmor(5, true, false);
		} else if (type == GRIM_PATRON) {
			name = "Grim Patron";
			initBasicStats(5, 3, 3);
			damageEffect = new SummonMinionsDamageEffect(new int[] {GRIM_PATRON}, null, false, false, true);
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