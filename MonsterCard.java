public class MonsterCard extends PlayCard {
	public static final int	
							TARGET_DUMMY = 1,
							WISP = 2,
							ABUSIVE_SERGEANT = 3,
							ANGRY_CHICKEN = 4,
							ARGENT_SQUIRE = 5,
							BLOOD_IMP = 6, // not completely done [endturn-buff]
							BLOODSAIL_CORSAIR = 7, // not completely done [weapon-effect]
							CLOCKWORK_GNOME = 8, // not completely done [Spare Part]
							COGMASTER = 9, // not completely done [Board Area Effect]
							DRAGON_EGG = 10,
							BLACK_WHELP = 11,
							DUST_DEVIL = 12, // not completely done [Overload]
							ELVEN_ARCHER = 13,
							FLAME_IMP = 14,
							GOLDSHIRE_FOOTMAN = 15,
							GRIMSCALE_ORACLE = 16, // not completely done - area effect
							HUNGRY_CRAB = 17, // not completely done [area-type-effect]
							LEPER_GNOME = 18,
							LIGHTWARDEN = 19, // not completelydone [Heal-effect]
							MANA_WYRM = 20, // not completely done [Spell-effect]
							MURLOC_RAIDER = 21,
							MURLOC_TIDECALLER = 22, // not completely done [Summon-effect]
							NORTHSHIRE_CLERIC = 23, // not completely done [Heal-effect]
							SECRETKEEPER = 24, // not completely done [Secret-effect]
							SHADOWBOMBER = 25,
							SHIELDBEARER = 26,
							SOUTHSEA_DECKHAND = 27, // not completely done [Weapon-effect]
							STONETUSK_BOAR = 28,
							TIMBER_WOLF = 29, // not completely done [Area-effect]
							TWILIGHT_WHELP = 30, // not completely done [In hand-effect]
							UNDERTAKER = 31, // not completely done [Summon-effect]
							VOIDWALKER = 32,
							VODOO_DOCTOR = 33,
							WARBOT = 34,
							WEBSPINNER = 35, // not completely done [Deathrattle]
							WORGEN_INFILTRATOR = 36,
							YOUNG_DRAGONHAWK = 37,
							YOUNG_PRIESTESS = 38, // not completely done [endturn-buff]
							ZOMBIE_CHOW = 39,
							ACIDIC_SWAMP_OOZE = 40, // not completely done - weapon
							AMANI_BERSERKER = 41,
							ANCIENT_WATCHER = 42,
							ANNOY_O_TRON = 43,
							ANODIZED_ROBO_CUB = 44, // not done [Choose one]
							ARGENT_PROTECTOR = 45,
							ARMORSMITH = 46, // not completely done - [Dmg-effect]: damage on board-effect
							BLOODFEN_RAPTOR = 47,
							BLOODMAGE_THALNOS = 48, // not completely one - dubbla effekter + spell dmg
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
							FAERIE_DRAGON = 60,
							FLAMETOUNGE_TOTEM = 61, // not completely done - [NEXT TO + AREA-effect]
							FROSTWOLF_GRUNT = 62,
							GILBIN_STALKER = 63,
							GOBLIN_AUTO_BARBER = 64, // not done
							HAUNTED_CREEPER = 65,
							SPECTRAL_SPIDER = 66,
							IRONBEAK_OWL = 67,
							KNIFE_JUGGLER = 68, // not completely done - board summon-effect
							KOBOLD_GEOMANCER = 69, // not completely done - spell dmg
							LIGHTWELL = 70, // not done
							LOOT_HOARDER = 71,
							LOREWALKER_CHO = 72, // not completely done - spell-copying
							MAD_BOMBER = 73, // not done
							MAD_SCIENTIST = 74, // not done
							MANA_ADDICT = 75, // not done
							MANA_WRAITH = 76, // not done
							MASTER_SWORDSMITH = 77, // not done
							MECHWARPER = 78, // not done
							MICRO_MACHINE = 79, // not done
							MILLHOUSE_MANASTORM = 80, // not completely done - spell-cost-next-turn
							MISTRESS_OF_PAIN = 81, // not done
							MURLOC_TIDEHUNTER = 82,
							MURLOC_SCOUT = 83,
							NAT_PAGLE = 84, // not completely done - draw-chance-effect
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
							EDWIN_VANCLEEF = 129, // not completely done - combo-buff
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
							HARVEST_GOLEM = 140,
							DAMAGED_GOLEM = 141,
							HOBGOBLIN = 142, // not done
							ILLUMINATOR = 143, // not done
							IMP_GANG_BOSS = 144,
							IMP = 145,
							IMP_MASTER = 146, // not completely done - dubbla effekter + take dmg
							INJURED_BLADEMASTER = 147, // not done
							IRON_SENSEI = 148, // not done
							IRONFORGE_RIFLEMAN = 149,
							IRONFUR_GRIZZLY = 150,
							JUNGLE_PANTHER = 151,
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
							RAGING_WORGEN = 162,	
							RAID_LEADER = 163, // not completely done - area effect
							RAZORFEN_HUNTER = 164,
							BOAR = 165,
							SCARLET_CRUSADER = 166,
							SCARLET_PURIFIER = 167, // not done
							SHADE_OF_NAXXRAMAS = 168,
							SHATTERED_SUN_CLERIC = 169,
							SI7_AGENT = 170, // not done
							SILVERBACK_PATRIARCH = 171,
							SOOT_SPEWER = 172, // not done
							SOUTHSEA_CAPTAIN = 173, // not done
							SPIDER_TANK = 174,
							STONESKIN_GARGOYLE = 175, // not done
							TAUREN_WARRIOR = 176,
							THRALLMAR_FARSEER = 177,
							TINKERTOWN_TECHNICIAN = 178, // not done
							TINKMASTER_OVERSPARK = 179, // not completely done - transform-effect
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
							BARON_RIVERDARE = 191, // not completely done - double deathrattle
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
							GNOMISH_INVENTOR = 207,
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
							OLD_MURK_EYE = 223, // not completely done - murloc area buff
							PILOTED_SHREDDER = 224, // not done
							PIT_LORD = 225,
							SCREWJANK_CLUNKER = 226, // not done
							SENJIN_SHIELDMASTA = 227,
							SILTFIN_SPIRITWALKER = 228, // not done
							SILVERMOON_GUARDIAN = 229,
							SPELLBREAKER = 230,
							STORMWIND_KNIGHT = 231,
							SUMMONING_PORTAL = 232, // not done
							TWILIGHT_DRAKE = 233,
							VIOLET_TEACHER = 234, // not done
							VIOLET_APPRENTICE = 235,
							VOIDCALLER = 236, // not done
							WAILING_SOUL = 237, // not done
							WATER_ELEMENTAL = 238, // not completely done - freeze
							WEE_SPELLSTOPPER = 239, // not done
							WINDSPEAKER = 240,
							ABOMINATION = 241,
							ANTIQUE_HEALBOT = 242,
							AZURE_DRAKE = 243, // not done
							BLACKWING_CORRUPTOR = 244, // not done
							BLINGTRON_3000 = 245, // not completely done - weapon-battlecry
							BOLVAR_FORDRAGON = 246, // not completely done - minions died-effect
							BOMB_LOBBER = 247, // not done
							BOOTY_BAY_BODYGUARD = 248,
							CAPTAIN_GREENSKIN = 249, // not completely done - weapon-battlecry
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
							ELITE_TAUREN_CHIEFTAIN = 261, // not completely done - rock-effect
							FACELESS_MANIPULATOR = 262, // not done
							FEL_REAVER = 263, // not done
							FEN_CREEPER = 264,
							FEUGEN = 265, // not completely done - thaddius-effect
							FLOATING_WATCHER = 266, // not done
							FROSTWOLF_WARLORD = 267,
							GRIM_PATRON = 268,
							GURUBASHI_BERSERKER = 269,
							HARRISON_JONES = 270, // not completely done - weapon-battlecry
							HEMET_NESINGWARY = 271, // not completely done - destroy minion type
							JUNKBOT = 272, // not done
							KING_OF_BEASTS = 273, // not done
							LEEROY_JENKINS = 274,
							LOATHEB = 275, // not completely done - spell cost next turn
							MADDER_BOMBER = 276, // not done
							MIMIRONS_HEAD = 277, // not completely done - summon effect
							V_07_TR_0N = 278, // not done
							NIGHTBLADE = 279,
							OGRE_NINJA = 280, // not done
							QUARTERMASTER = 281, // not done
							SALTY_DOG = 282,
							SIEGE_ENGINE = 283, // not done
							SILVER_HAND_KNIGHT = 284,
							SQUIRE = 285,
							SLUDGE_BELCHER = 286,
							SLIME = 287,
							SPECTRAL_KNIGHT = 288,
							SPITEFUL_SMITH = 289, // not done
							STALAGG = 290, // not completely done - thaddius-effect
							THADDIUS = 291,
							STAMPEDING_KODO = 292, // not completely done - destroy based on attack-effect
							STARVING_BUZZARD = 293, // not done
							STORMPIKE_COMMANDO = 294,
							STRANGLETHORN_TIGER = 295,
							TUNDRA_RHINO = 296, // not completely done - charge for type-effect
							UPGRADED_REPAIR_BOT = 297, // not done
							VENTURE_CO_MERCENARY = 298, // not done
							VOLJIN = 299,
							ANIMA_GOLEM = 300, // not completely done - destroy if alone-effect
							ARCHMAGE = 301, // not done
							ARGENT_COMMANDER = 302,
							BOULDERFIST_OGRE = 303,
							CABAL_SHADOW_PRIEST = 304, // not done
							CAIRNE_BLOODHOOF = 305,
							BAINE_BLOODHOOF = 306,
							DRAKONID_CRUSHER = 307, // not done
							DREAD_INFERNAL = 308,
							EMPEROR_THAURISSAN = 309,
							FIRE_ELEMENTAL = 310,
							FROST_ELEMENTAL = 311, // not done
							GADGETZAN_AUCTIONEER = 312, // not done
							GAZLOWE = 313, // not completely done - add mech card
							GELBIN_MEKKATORQUE = 314, // not completely done - awesome invention
							EMBOLDENER_3000 = 315, // not done
							HOMING_CHICKEN = 316, // not done
							POULTRYIZER = 317, // not done
							REPAIR_BOT = 318, // not done
							HOGGER = 319,
							GNOLL = 320,
							ILLIDAN_STORMRAGE = 321, // not completely done - play summon effect
							FLAME_OF_AZZINOTH = 322, // not done
							IRON_JUGGERNAUT = 323, // not completel done - mine battlecry effect
							BURROWING_MINE = 324, // not done
							KIDNAPPER = 325, // not done
							LORD_OF_THE_ARENA = 326,
							MAEXXNA = 327, // not completely done - poision effect
							MECH_BEAR_CAT = 328, // not done
							MOGOR_THE_OGRE = 329, // not completely done - attack chance effect
							PILOTED_SKY_GOLEM = 330, // not done
							PRIESTESS_OF_ELUNE = 331,
							RECKLESS_ROCKETEER = 332,
							SAVANNAH_HIGHMANE = 333,
							HYENA = 334,
							SHIELDMAIDEN = 335,
							SUNWALKER = 336,
							SYLVANAS_WINDRUNNER = 337,
							TEMPLE_ENFORCER = 338, // not done
							THE_BEAST = 339,
							FINKLE_EINHORN = 340,
							THE_BLACK_KNIGHT = 341, // not completely done - destroy taunt
							TOSHLEY = 342, // not completely done - spare part 
							TRADE_PRINCE_GALLYWIX = 343, // not completely done - coin effect
							VOLCANIC_DRAKE = 344, // not done
							WINDFURY_HARPY = 345,
							ANCIENT_OF_LORE = 346, // not done
							ANCIENT_OF_WAR = 347, // not done
							ARCHMAGE_ANTONIDAS = 348, // not completely done - fireball effect
							BARON_GEDDON = 349,
							CORE_HOUND = 350,
							DR_BOOM = 351,
							BOOM_BOT = 352,
							FLAME_LEVIATHAN = 353, // not completely done - draw effect
							GAHZRILLA = 354,
							GUARDIAN_OF_KINGS = 355, // not done
							MALORNE = 356,
							NEPTULON = 357, // not completely done - overload + murloc
							PROPHET_VELEN = 358, // not completely done - double spell + hero -effect
							RAVENHOLDT_ASSASSIN = 359,
							REND_BLACKHAND = 360, // not completely done - hold card-destroy type 
							STORMWIND_CHAMPION = 361, // not done
							TROGGZOR_THE_EARTHINATOR = 362, // not completely done - spell-summon-effect
							WAR_GOLEM = 363,
							ALAKIR_THE_WINDLORD = 364,
							CHROMAGGUS = 365, // not completely done - draw effect
							FOE_REAPER_4000 = 366, // not completely done - close by-effect
							FORCE_TANK_MAX = 367,
							GROMMASH_HELLSCREAM = 368,
							GRUUL = 369,
							IRONBARK_PROTECTOR = 370,
							KELTHUZAD = 371,
							RAGNAROS_THE_FIRELORD = 372,
							SNEEDS_OLD_SHREDDER = 373,
							TIRION_FORDRING = 374, // not completely done - weapon-deathrattle
							ALEXSTRASZA = 375,
							CENARIUS = 376, // not compleyely done - choose one
							TREANT = 377, // not done
							KING_KRUSH = 378,
							LORD_JARAXXUS = 379, // not compleyely done - hero
							MAJORDOMO_EXECUTUS = 380, // not completely done - hero
							MALGANIS = 381, // not completely done - immune & +2/+2 - demon
							MALYGOS = 382, // not completely done - spell dmg
							MEKGINEER_THERMAPLUGG = 383, // not completely done - die-effect
							NEFARIAN = 384, // not completely done - nefarian-effect
							NOZDORMU = 385, // not to be done? - inte göra
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
	private boolean noSpellTarget;

	private SpellEffect costEffect;

	private DamageEffect damageEffect;
	private EnrageEffect enrageEffect;

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
		noSpellTarget = false;
		stealth = false;
		stealthTemporary = false;

		battleCryEffect = null;
		damageEffect = null;
		enrageEffect = null;
		deathRattleEffect = null;
		startTurnEffect = null;
		endTurnEffect = null;

//==============================================================================
		if (type == TARGET_DUMMY) {
			name = "Target Dummy";
			minionType = Minion.MECH;
			initBasicStats(0, 0, 2);
			taunt = true;
		} else if (type == WISP) {
			name = "Wisp";
			initBasicStats(0, 1, 1);
		} else if (type == MURLOC_SCOUT) {
 			// not playable
 			name = "Murloc Scout";
			minionType = Minion.MURLOC;
			initBasicStats(0, 1, 1);
		} else if (type == VIOLET_APPRENTICE) {
			name = "Violet Apprentice";
			initBasicStats(0, 1, 1);
//==============================================================================
		} else if (type == ABUSIVE_SERGEANT) {
			name = "Abusive Sergeant";
			initBasicStats(1, 2, 1);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == ANGRY_CHICKEN) {
			name = "Angry Chicken";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
			enrageEffect = new BuffSingleMinionEnrageEffect(1, 0, false, false, false, false);
		} else if (type == ARGENT_SQUIRE) {
			name = "Argent Squire";
			initBasicStats(1, 1, 1);
			divineShield = true;
		} else if (type == BLOOD_IMP) {
			// add endturn-health-buff
			name = "Blood Imp";
			minionType = Minion.DEMON;
			initBasicStats(1, 0, 1);
			stealth = true;
		} else if (type == BLOODSAIL_CORSAIR) {
			// add weapon-battlecry-effect
			name = "Bloodsail Corsair";
			minionType = Minion.PIRATE;
			initBasicStats(1, 1, 2);
		} else if (type == CLOCKWORK_GNOME) {
			// add spare part-deathrattle
			name = "Clockwork Gnome";
			minionType = Minion.MECH;
			initBasicStats(1, 2, 1);
		} else if (type == COGMASTER) {
			// add type-area-effect
			name = "Cogmaster";
			initBasicStats(1, 1, 2);
		} else if (type == DRAGON_EGG) {
			name = "Dragon Egg";
			initBasicStats(1, 0, 2);
			damageEffect = new SummonMinionsDamageEffect(new int[] {BLACK_WHELP}, null, false, false, false);
		} else if (type == DUST_DEVIL) {
			// add overload-effect
			name = "Dust Devil";
			initBasicStats(1, 3, 1);
			windfury = true;
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
		} else if (type == GRIMSCALE_ORACLE) {
			// add type-area-buff-effect
			name = "Grimscale Oracle";
			minionType = Minion.MURLOC;
			initBasicStats(1, 1, 1);
		} else if (type == HUNGRY_CRAB) {
			// add type-area-battlecry-effect
			name = "Hungry Crab";
			initBasicStats(1, 1, 2);
		} else if (type == LEPER_GNOME) {
			name = "Leper Gnome";
			initBasicStats(1, 2, 1);
			deathRattleEffect = new DealDamageToAllCharacters(2, false, false, false, true);
		} else if (type == LIGHTWARDEN) {
			// add heal-buff-effect
			name = "Lightwarden";
			initBasicStats(1, 1, 2);
		} else if (type == MANA_WYRM) {
			// add spell-buff-effect
			name = "Mana Wyrm";
			initBasicStats(1, 1, 3);
		} else if (type == MURLOC_RAIDER) {
			name = "Murloc Raider";
			minionType = Minion.MURLOC;
			initBasicStats(1, 2, 1);
		} else if (type == MURLOC_TIDECALLER) {
			// add summon-type-effect
			name = "Murloc Tidecaller";
			initBasicStats(1, 1, 2);
		} else if (type == NORTHSHIRE_CLERIC) {
			// add heal-draw-effect
			name = "Northshire Cleric";
			initBasicStats(1, 1, 3);
		} else if (type == SECRETKEEPER) {
			// add secret-turn-effect
			name = "Secretkeeper";
			initBasicStats(1, 1, 2);
		} else if (type == SHADOWBOMBER) {
			name = "Shadowbomber";
			initBasicStats(1, 2, 1);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, true, true);
		} else if (type == SHIELDBEARER) {
			name = "Shieldbearer";
			initBasicStats(1, 0, 4);
			taunt = true;
		} else if (type == SOUTHSEA_DECKHAND) {
			// add weapon-charge-effect
			name = "Southsea Deckhand";
			minionType = Minion.PIRATE;
			initBasicStats(1, 2, 1);
		} else if (type == STONETUSK_BOAR) {
			name = "Stonetusk Boar";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
			charge = true;
		} else if (type == TIMBER_WOLF) {
			// add type-area-buff-effect
			name = "Timber Wolf";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
		} else if (type == TWILIGHT_WHELP) {
			// add type-hand-buff-effect
			name = "Twilight Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 2, 1);
		} else if (type == UNDERTAKER) {
			// add deathrattle-summon-effect
			name = "Undertaker";
			initBasicStats(1, 1, 2);
		} else if (type == VOIDWALKER) {
			name = "Voidwalker";
			minionType = Minion.DEMON;
			initBasicStats(1, 1, 3);
			taunt = true;
		} else if (type == VODOO_DOCTOR) {
			name = "Vodoo Doctor";
			initBasicStats(1, 2, 1);
			battleCryEffect = new HealCharacter(2, false, false);
		} else if (type == WARBOT) {
			name = "Warbot";
			minionType = Minion.MECH;
			initBasicStats(1, 1, 3);
			enrageEffect = new BuffSingleMinionEnrageEffect(1, 0, false, false, false, false);
		} else if (type == WEBSPINNER) {
			// add random-spec-card-draw-deathrattle-effect
			name = "Webspinner";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
		} else if (type == WORGEN_INFILTRATOR) {
			name = "Worgen Infiltrator";
			initBasicStats(1, 2, 1);
			stealth = true;
		} else if (type == YOUNG_DRAGONHAWK) {
			name = "Young Dragonhawk";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
			windfury = true;
		} else if (type == YOUNG_PRIESTESS) {
			// add endturn-health-buff
			name = "Young Priestess";
			initBasicStats(1, 2, 1);
		} else if (type == ZOMBIE_CHOW) {
			name = "Zombie Chow";
			initBasicStats(1, 2, 3);
			deathRattleEffect = new HealCharacter(5, true, false);
		} else if (type == DEFIAS_BANDIT) {
 			// not playable
			name = "Defias Bandit";
			initBasicStats(1, 2, 1);
		} else if (type == SPECTRAL_SPIDER) {
 			// not playable
			name = "Spectral Spider";
			initBasicStats(1, 1, 1);
		} else if (type == IMP) {
 			// not playable
			name = "Imp";
			minionType = Minion.DEMON;
			initBasicStats(1, 1, 1);
		} else if (type == BOAR) {
 			// not playable
			name = "Boar";
			minionType = Minion.BEAST;
			initBasicStats(1, 1, 1);
		} else if (type == MECHANICAL_DRAGONLING) {
 			// not playable
			name = "Mechanical Dragonling";
			minionType = Minion.MECH;
			initBasicStats(1, 2, 1);
		} else if (type == SLIME) {
 			// not playable
			name = "Slime";
			initBasicStats(1, 1, 2);
			taunt = true;
		} else if (type == BOOM_BOT) {
 			// not playable
			name = "Boom Bot";
			minionType = Minion.MECH;
			initBasicStats(1, 1, 1);
			deathRattleEffect = new DealRandomDamageRandomly(1, 3, true);
		} else if (type == WHELP) {
 			// not playable
			name = "Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 1, 1);
		} else if (type == BLACK_WHELP) {
 			// not playable
			name = "Black Whelp";
			minionType = Minion.DRAGON;
			initBasicStats(1, 2, 1);
		} else if (type == DAMAGED_GOLEM) {
			// not playable
			name = "Damaged Golem";
			minionType = Minion.MECH;
			initBasicStats(1, 2, 1);
		} else if (type == SQUIRE) {
			// not playable
			name = "Squire";
			initBasicStats(1, 2, 2);
//==============================================================================
		} else if (type == ANCIENT_WATCHER) {
			name = "Ancient Watcher";
			initBasicStats(2, 4, 5);
			cannotAttack = true;
		} else if (type == EXPLOSIVE_SHEEP) {
			name = "Explosive Sheep";
			minionType = Minion.MECH;
			initBasicStats(2, 1, 1);
			deathRattleEffect = new DealDamageToAllCharacters(2, true, true, false, false);
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
		} else if (type == AMANI_BERSERKER) {
			name = "Amani Berserker";
			initBasicStats(2, 2, 3);
			enrageEffect = new BuffSingleMinionEnrageEffect(3, 0, false, false, false, false);
		} else if (type == BLOODMAGE_THALNOS) {
			// Add spell damage
			name = "Bloodmage Thalnos";
			initBasicStats(2, 1, 1);
			deathRattleEffect = new DrawCards(1);
		} else if (type == LOREWALKER_CHO) {
			// Add spell-copying-effect
			name = "Lorewalker Cho";
			initBasicStats(2, 0, 4);
		} else if (type == MILLHOUSE_MANASTORM) {
			// Add spell-cost-0-next-turn-effect
			name = "Millhouse Manastorm";
			initBasicStats(2, 4, 4);
		} else if (type == NAT_PAGLE) {
			// Add draw-chance-effect
			name = "Nat Pagle";
			initBasicStats(2, 0, 4);
		} else if (type == UNSTABLE_GHOUL) {
			name = "Unstable Ghoul";
			initBasicStats(2, 1, 3);
			taunt = true;
			deathRattleEffect = new DealDamageToAllCharacters(1, true, true, false, false);
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
		} else if (type == HAUNTED_CREEPER) {
			name = "Haunted Creeper";
			minionType = Minion.BEAST;
			initBasicStats(2, 1, 2);
			deathRattleEffect = new SummonMinions(new int[] {SPECTRAL_SPIDER, SPECTRAL_SPIDER}, null);
		} else if (type == SUCCUBUS) {
			name = "Succubus";
			minionType = Minion.DEMON;
			initBasicStats(2, 4, 3);
			battleCryEffect = new DiscardCards(1);
		} else if (type == SHIELDED_MINIBOT) {
			name = "Shielded Minibot";
			minionType = Minion.MECH;
			initBasicStats(2, 2, 2);
			divineShield = true;
		} else if (type == FAERIE_DRAGON) {
			name = "Faerie Dragon";
			minionType = Minion.DRAGON;
			initBasicStats(2, 3, 2);
			noSpellTarget = true;
		} else if (type == FLAMETOUNGE_TOTEM) {
			// [NEXT TO + AREA-effect]
			name = "Flametounge Totem";
			minionType = Minion.TOTEM;
			initBasicStats(2, 0, 3);
		} else if (type == ARMORSMITH) {
			// Add damage on board-effect
			name = "Armorsmith";
			initBasicStats(2, 1, 4);
		} else if (type == KNIFE_JUGGLER) {
			// Add board summon-effect
			name = "Knife Juggler";
			initBasicStats(2, 3, 2);
		} else if (type == HYENA) {
			// not playable
			name = "Hyena";
			minionType = Minion.BEAST;
			initBasicStats(2, 2, 2);
		} else if (type == GNOLL) {
			// not playable
			name = "Gnoll";
			initBasicStats(2, 2, 2);
			taunt = true;
//==============================================================================
		} else if (type == IRONFORGE_RIFLEMAN) {
			name = "Ironforge Rifleman";
			initBasicStats(3, 2, 2);
			battleCryEffect = new DealDamage(1);
		} else if (type == SHADE_OF_NAXXRAMAS) {
			name = "Shade of Naxxramas";
			initBasicStats(3, 2, 2);
			stealth = true;
			startTurnEffect = new BuffMinionTurnEffect(1, 1, true, false);
		} else if (type == JUNGLE_PANTHER) {
			name = "Jungle Panther";
			minionType = Minion.BEAST;
			stealth = true;
			initBasicStats(3, 4, 2);
		} else if (type == TAUREN_WARRIOR) {
			name = "Tauren Warrior";
			initBasicStats(3, 2, 3);
			taunt = true;
			enrageEffect = new BuffSingleMinionEnrageEffect(3, 0, false, false, false, false);
		} else if (type == HARVEST_GOLEM) {
			name = "Harvest Golem";
			minionType = Minion.MECH;
			initBasicStats(3, 2, 3);
			deathRattleEffect = new SummonMinions(new int[] {DAMAGED_GOLEM}, null);
		} else if (type == RAGING_WORGEN) {
			name = "Raging Worgen";
			initBasicStats(3, 3, 3);
			enrageEffect = new BuffSingleMinionEnrageEffect(1, 0, false, false, false, true);
		} else if (type == DALARAN_MAGE) {
			// Add spell damage
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
		} else if (type == MANA_TIDE_TOTEM) {
			name = "Mana Tide Totem";
			minionType = Minion.TOTEM;
			initBasicStats(3, 0, 3);
			endTurnEffect = new DrawCardsTurnEffect(1, false);
		} else if (type == EARTHEN_RING_FARSEER) {
			name = "Earthen Ring Farseer";
			initBasicStats(3, 3, 3);
			battleCryEffect = new HealCharacter(3, false, false);
		} else if (type == ALARM_O_BOT) {
			name = "Alarm-o-Bot";
			minionType = Minion.MECH;
			initBasicStats(3, 0, 3);
			startTurnEffect = new SummonRandomMinionFromHandTurnEffect(false, false, true);
		} else if (type == IMP_MASTER) {
			name = "Imp Master";
			initBasicStats(3, 1, 5);
			endTurnEffect = new SummonMinionTurnEffect(new int[] {IMP}, null, false);
 		} else if (type == ALDOR_PEACEKEEPER) {
			name = "Aldor Peacekeeper";
			initBasicStats(3, 3, 3);
			battleCryEffect = new SetStatsSingleMinion(1, -1);
		} else if (type == DEATHLORD) {
			name = "Deathlord";
			initBasicStats(3, 2, 8);
			taunt = true;
			deathRattleEffect = new SummonRandomMinionsFromDeck(0, false, 1, true);
		} else if (type == RAZORFEN_HUNTER) {
			name = "Razorfen Hunter";
			initBasicStats(3, 2, 3);
			battleCryEffect = new SummonMinions(new int[] {BOAR}, null);
		} else if (type == SCARLET_CRUSADER) {
			name = "Scarlet Crusader";
			initBasicStats(3, 3, 1);
			divineShield = true;
		} else if (type == ACOLYTE_OF_PAIN) {
			name = "Acolyte of Pain";
			initBasicStats(3, 1, 3);
			damageEffect = new DrawCardsDamageEffect(1, false, false);
		} else if (type == SPIDER_TANK) {
			name = "Spider Tank";
			minionType = Minion.MECH;
			initBasicStats(3, 3, 4);
		} else if (type == GNOMEREGAN_INFANTRY) {
			name = "Gnomeregan Infantry";
			initBasicStats(3, 1, 4);
			taunt = true;
			charge = true;
		} else if (type == THRALLMAR_FARSEER) {
			name = "Thrallmar Farseer";
			initBasicStats(3, 2, 3);
			windfury = true;
		} else if (type == IMP_GANG_BOSS) {
			name = "Imp Gang Boss";
			minionType = Minion.DEMON;
			initBasicStats(3, 2, 4);
			damageEffect = new SummonMinionsDamageEffect(new int[] {IMP}, null, false, false, false);
		} else if (type == KING_MUKKLA) {
			name = "King Mukkla";
			minionType = Minion.BEAST;
			initBasicStats(3, 5, 5);
			battleCryEffect = new AddBananaCardToHand(2, false, true, true);
		} else if (type == FINKLE_EINHORN) {
			name = "Finkle Einhorn";
			initBasicStats(3, 3, 3);
		} else if (type == EDWIN_VANCLEEF) {
			// Add Combo-buff-effect
			name = "Edwin VanCleef";
			initBasicStats(3, 2, 2);
		} else if (type == TINKMASTER_OVERSPARK) {
			// Add transform-battlecry-effect
			name = "Tinkmaster Overspark";
			initBasicStats(3, 3, 3);
//==============================================================================
		} else if (type == WINDSPEAKER) {
			name = "Windspeaker";
			initBasicStats(4, 3, 3);
			battleCryEffect = new BuffSingleMinion(0, 0, false, false, false, true, false);
		} else if (type == SILVERMOON_GUARDIAN) {
			name = "Silvermoon Guardian";
			initBasicStats(4, 3, 3);
			divineShield = true;
		} else if (type == STORMWIND_KNIGHT) {
			name = "Stormwind Knight";
			initBasicStats(4, 2, 5);
			charge = true;
		} else if (type == CHILLWIND_YETI) {
			name = "Chillwind Yeti";
			initBasicStats(4, 4, 5);
		} else if (type == GNOMISH_INVENTOR) {
			name = "Gnomish Inventor";
			initBasicStats(4, 2, 4);
			battleCryEffect = new DrawCards(1);
		} else if (type == DRAGONLING_MECHANIC) {
			name = "Dragonling Mechanic";
			initBasicStats(4, 2, 4);
			battleCryEffect = new SummonMinions(new int[] {MECHANICAL_DRAGONLING}, null);
		} else if (type == BAINE_BLOODHOOF) {
			name = "Baine Bloodhoof";
			initBasicStats(4, 4, 5);
		} else if (type == TWILIGHT_DRAKE) {
			name = "Twilight Drake";
			minionType = Minion.DRAGON;
			initBasicStats(4, 4, 1);
			battleCryEffect = new BuffAccordingToHand(0, 1, true, false, false, false);
		} else if (type == WATER_ELEMENTAL) {
			name = "Water Elemental";
			initBasicStats(4, 3, 6);
		} else if (type == BLOOD_KNIGHT) {
			name = "Blood Knight";
			initBasicStats(4, 3, 3);
		} else if (type == STORMPIKE_COMMANDO) {
			name = "Stormpike Commando";
			initBasicStats(4, 4, 2);
			battleCryEffect = new DealDamage(2);
		} else if (type == LOST_TALLSTRIDER) {
			name = "Lost Tallstrider";
			minionType = Minion.BEAST;
			initBasicStats(4, 5, 4);
		} else if (type == SPELLBREAKER) {
			name = "Spellbreaker";
			initBasicStats(4, 4, 3);
			battleCryEffect = new Silence(false, true, true);
		} else if (type == DARK_IRON_DWARF) {
			name = "Dark Iron Dwarf";
			initBasicStats(4, 4, 4);
			battleCryEffect = new BuffSingleMinion(2, 0, false, false, false, false, true);
		} else if (type == OASIS_SNAPJAW) {
			name = "Oasis Snapjaw";
			minionType = Minion.BEAST;
			initBasicStats(4, 2, 7);
		} else if (type == KORKRON_ELITE) {
			name = "Kor'kron Elite";
			initBasicStats(4, 4, 3);
			charge = true;
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
		} else if (type == SENJIN_SHIELDMASTA) {
			name = "Sen'jin Shieldmasta";
			initBasicStats(4, 3, 5);
			taunt = true;
		} else if (type == BARON_RIVERDARE) {
			// Add double deathrattle-effect
			name = "Baron Riverdare";
			initBasicStats(4, 1, 7);
		} else if (type == OLD_MURK_EYE) {
			// Add murloc area buff-effect
			name = "Old Murk-Eye";
			minionType = Minion.MURLOC;
			initBasicStats(4, 2, 4);
			charge = true;
//==============================================================================
		} else if (type == FEN_CREEPER) {
			name = "Fen Creeper";
			initBasicStats(5, 3, 6);
			taunt = true;
		} else if (type == ABOMINATION) {
			name = "Abomination";
			initBasicStats(5, 4, 4);
			taunt = true;
			deathRattleEffect = new DealDamageToAllCharacters(2, true, true, false, false);
		} else if (type == SILVER_HAND_KNIGHT) {
			name = "Silver Hand Knight";
			initBasicStats(5, 4, 4);
			battleCryEffect = new SummonMinions(new int[] {SQUIRE}, null);
		} else if (type == SLUDGE_BELCHER) {
			name = "Sludge Belcher";
			initBasicStats(5, 3, 5);
			taunt = true;
			deathRattleEffect = new SummonMinions(new int[] {SLIME}, null);
		} else if (type == VOLJIN) {
			name = "Vol'Jin";
			initBasicStats(5, 6, 2);
			battleCryEffect = new SwapHealthMinion();
		} else if (type == NIGHTBLADE) {
			name = "Nightblade";
			initBasicStats(5, 4, 4);
			battleCryEffect = new DealDamageToAllCharacters(3, false, false, false, true);
		} else if (type == FROSTWOLF_WARLORD) {
			name = "Frostwolf Warlord";
			initBasicStats(5, 4, 4);
			battleCryEffect = new BuffAccordingToBoard(1, 1, true, false, false, false);
		} else if (type == LEEROY_JENKINS) {
			name = "Leeroy Jenkins";
			initBasicStats(5, 6, 2);
			charge = true;
			battleCryEffect = new SummonMinions(null, new int[] {WHELP, WHELP});
		} else if (type == EARTH_ELEMENTAL) {
			name = "Earth Elemental";
			initBasicStats(5, 7, 8);
			taunt = true;
		} else if (type == PRIESTESS_OF_ELUNE) {
			name = "Priestess of Elune";
			initBasicStats(5, 4, 4);
			battleCryEffect = new HealCharacter(4, true, true);
		} else if (type == GURUBASHI_BERSERKER) {
			name = "Gurubashi Berserker";
			initBasicStats(5, 2, 7);
			damageEffect = new BuffMinionDamageEffect(3, 0, false, false, false);
		} else if (type == SALTY_DOG) {
			name = "Salty Dog";
			minionType = Minion.PIRATE;
			initBasicStats(5, 7, 4);
		} else if (type == ANTIQUE_HEALBOT) {
			name = "Antique Healbot";
			minionType = Minion.MECH;
			initBasicStats(5, 3, 3);
			battleCryEffect = new HealCharacter(8, true, true);
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
		} else if (type == BOOTY_BAY_BODYGUARD) {
			name = "Booty Bay Bodyguard";
			initBasicStats(5, 5, 4);
			taunt = true;
		} else if (type == DOOMGUARD) {
			name = "Doomguard";
			minionType = Minion.DEMON;
			initBasicStats(5, 5, 7);
			charge = true;
			battleCryEffect = new DiscardCards(2);
		} else if (type == GRIM_PATRON) {
			name = "Grim Patron";
			initBasicStats(5, 3, 3);
			damageEffect = new SummonMinionsDamageEffect(new int[] {GRIM_PATRON}, null, false, false, true);
		} else if (type == DRUID_OF_THE_FANG_VIPER_FORM) {
			// not playable
			name = "Druid of the Fang (viper)";
			minionType = Minion.BEAST;
			initBasicStats(5, 7, 7);
		} else if (type == BLINGTRON_3000) {
			// Add weapons-battlecry-effect
			name = "Blingtron 3000";
			minionType = Minion.MECH;
			initBasicStats(5, 3, 4);
		} else if (type == BOLVAR_FORDRAGON) {
			// Add minions died-effect
			name = "Bolvar Fordragon";
			initBasicStats(5, 1, 7);
		} else if (type == CAPTAIN_GREENSKIN) {
			// Add weapon-battlecry-effect
			name = "Captain Greenskin";
			minionType = Minion.PIRATE;
			initBasicStats(5, 5, 4);
		} else if (type == ELITE_TAUREN_CHIEFTAIN) {
			// Add "rock"-effect
			name = "Elite Tauren Chieftain";
			initBasicStats(5, 5, 5);
		} else if (type == FEUGEN) {
			// Add Thaddius-effect
			name = "Feugen";
			initBasicStats(5, 4, 7);
		} else if (type == HARRISON_JONES) {
			// Add weapon-battlecry-effect
			name = "Harrison Jones";
			initBasicStats(5, 5, 4);
		} else if (type == HEMET_NESINGWARY) {
			// Add destroy-type-effect
			name = "Hemet Nesingwary";
			initBasicStats(5, 6, 3);
		} else if (type == LOATHEB) {
			// Add spell-cost-next-turn-effect
			name = "Loatheb";
			initBasicStats(5, 5, 5);
		} else if (type == MIMIRONS_HEAD) {
			// Add summon-effect
			name = "Mimiron's Head";
			minionType = Minion.MECH;
			initBasicStats(5, 4, 5);
		} else if (type == STALAGG) {
			// Add Thaddius-effect
			name = "Stalagg";
			initBasicStats(5, 7, 4);
		} else if (type == SPECTRAL_KNIGHT) {
			name = "Faerie Dragon";
			initBasicStats(5, 4, 6);
			noSpellTarget = true;
		} else if (type == TUNDRA_RHINO) {
			// Add charge for type-effect
			name = "Tundra Rhino";
			minionType = Minion.BEAST;
			initBasicStats(5, 2, 5);
			charge = true;
		} else if (type == STAMPEDING_KODO) {
			// Add destroy based on attack-effect
			name = "Stampeding Kodo";
			minionType = Minion.BEAST;
			initBasicStats(5, 3, 5);
//==============================================================================
		} else if (type == HOGGER) {
			name = "Hogger";
			initBasicStats(6, 4, 4);
			endTurnEffect = new SummonMinionTurnEffect(new int[] {GNOLL}, null, false);
		} else if (type == RECKLESS_ROCKETEER) {
			name = "Reckless Rocketeer";
			initBasicStats(6, 5, 2);
			charge = true;
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
			battleCryEffect = new BuffAccordingToDivineShields(3, 3, true, true, true, false, false);
		} else if (type == CAIRNE_BLOODHOOF) {
			name = "Cairne Bloodhoof";
			initBasicStats(6, 4, 5);
			deathRattleEffect = new SummonMinions(new int[] {BAINE_BLOODHOOF}, null);
		} else if (type == EMPEROR_THAURISSAN) {
			name = "Emperor Thaurissan";
			initBasicStats(6, 5, 5);
			endTurnEffect = new HandCostTurnEffect(-1, false);
		} else if (type == SYLVANAS_WINDRUNNER) {
			name = "Sylvanas Windrunner";
			initBasicStats(6, 5, 5);
			deathRattleEffect = new MindControlRandom();
		} else if (type == FIRE_ELEMENTAL) {
			name = "Fire Elemental";
			initBasicStats(6, 6, 5);
			battleCryEffect = new DealDamage(3);
		} else if (type == SAVANNAH_HIGHMANE) {
			name = "Savannah Highmane";
			minionType = Minion.BEAST;
			initBasicStats(6, 6, 5);
		} else if (type == DREAD_INFERNAL) {
			name = "Dread Infernal";
			minionType = Minion.DEMON;
			initBasicStats(6, 6, 6);
			battleCryEffect = new DealDamageToAllCharacters(1, true, true, true, true);
		} else if (type == WINDFURY_HARPY) {
			name = "Windfury Harpy";
			initBasicStats(6, 4, 5);
			windfury = true;
		} else if (type == RAVENHOLDT_ASSASSIN) {
			name = "Ravenholdt Assasin";
			initBasicStats(6, 7, 5);
			stealth = true;
		} else if (type == LORD_OF_THE_ARENA) {
			name = "Lord of the Arena";
			initBasicStats(6, 6, 5);
			taunt = true;
		} else if (type == SHIELDMAIDEN) {
			name = "Shieldmaiden";
			initBasicStats(6, 5, 5);
			battleCryEffect = new AddArmor(5, true, false);
		} else if (type == BOULDERFIST_OGRE) {
			name = "Boulderfist Ogre";
			initBasicStats(6, 6, 7);
		} else if (type == GAZLOWE) {
			// Add add mech-effect
			name = "Gazlowe";
			initBasicStats(6, 3, 6);
		} else if (type == GELBIN_MEKKATORQUE) {
			// Add awesome invention-effect
			name = "Gelbin Mekkatorque";
			initBasicStats(6, 6, 6);
		} else if (type == ILLIDAN_STORMRAGE) {
			// Add play summon-effect
			name = "Illidan Stormrage";
			initBasicStats(6, 7, 5);
		} else if (type == IRON_JUGGERNAUT) {
			// Add mine-battlecry-effect
			name = "Iron Juggernaut";
			minionType = Minion.MECH;
			initBasicStats(6, 6, 5);
		} else if (type == MAEXXNA) {
			// Add poison-effect
			name = "Maexxna";
			minionType = Minion.BEAST;
			initBasicStats(6, 2, 8);
		} else if (type == MOGOR_THE_OGRE) {
			// Add attack chance-effect
			name = "Mogor the Ogre";
			initBasicStats(6, 7, 6);
		} else if (type == THE_BLACK_KNIGHT) {
			// Add destroy taunt-effect
			name = "The Black Knight";
			initBasicStats(6, 4, 5);
		} else if (type == TOSHLEY) {
			// Add spare part-effect
			name = "Toshley";
			initBasicStats(6, 5, 7);
		} else if (type == TRADE_PRINCE_GALLYWIX) {
			// Add coin-effect
			name = "Trade Prince Gallywix";
			initBasicStats(6, 5, 8);
		} else if (type == ANIMA_GOLEM) {
			// Add destroy-if-alone-effect
			name = "Anima Golem";
			initBasicStats(6, 9, 9);
//==============================================================================
		} else if (type == DR_BOOM) {
			name = "Dr. Boom";
			initBasicStats(7, 7, 7);
			battleCryEffect = new SummonMinions(new int[] {BOOM_BOT, BOOM_BOT}, null);
		} else if (type == GRUUL) {
			name = "Gruul";
			initBasicStats(7, 7, 7);
			startTurnEffect = new BuffMinionTurnEffect(1, 1, true, false);
		} else if (type == BARON_GEDDON) {
			name = "Baron Geddon";
			initBasicStats(7, 7, 5);
			endTurnEffect = new DealDamageToAllCharactersTurnEffect(2, true, true, true, false);
		} else if (type == GAHZRILLA) {
			name = "Gahzrilla";
			minionType = Minion.BEAST;
			initBasicStats(7, 6, 9);
			damageEffect = new BuffMinionDamageEffect(0, 0, true, false, false);
		} else if (type == THE_BEAST) {
			name = "The Beast";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 7);
			deathRattleEffect = new SummonMinions(null, new int[] {FINKLE_EINHORN});
		} else if (type == WAR_GOLEM) {
			name = "War Golem";
			initBasicStats(7, 7, 7);
		} else if (type == PROPHET_VELEN) {
			// add hero power effect
			name = "Prophet Velen";
			initBasicStats(7, 7, 7);
		} else if (type == CORE_HOUND) {
			name = "Core Hound";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 5);
		} else if (type == ARCHMAGE_ANTONIDAS) {
			// Add fireball-effect
			name = "Archmage Antonidas";
			initBasicStats(7, 5, 7);
		} else if (type == FLAME_LEVIATHAN) {
			// Add draw-effect
			name = "Flame Leviathan";
			minionType = Minion.MECH;
			initBasicStats(7, 7, 7);
		} else if (type == MALORNE) {
			name = "Malorne";
			minionType = Minion.BEAST;
			initBasicStats(7, 9, 7);
			deathRattleEffect = new AddCardToDeck(new int[] {MALORNE}, null);
		} else if (type == NEPTULON) {
			// Add draw-effect
			name = "Neptulon";
			initBasicStats(7, 7, 7);
		} else if (type == REND_BLACKHAND) {
			// Add hold card-destroy type-effect
			name = "Rend Blackhand";
			initBasicStats(7, 8, 4);
		} else if (type == TROGGZOR_THE_EARTHINATOR) {
			// Add spell-summon-effect
			name = "Troggzor the Earthinator";
			initBasicStats(7, 6, 6);
//==============================================================================
		} else if (type == RAGNAROS_THE_FIRELORD) {
			name = "Ragnaros the Firelord";
			initBasicStats(8, 8, 8);
			cannotAttack = true;
			endTurnEffect = new DealDamageRandomTurnEffect(8, false, true);
		} else if (type == ALAKIR_THE_WINDLORD) {
			name = "Al'Akir the Windlord";
			initBasicStats(8, 3, 5);
			charge = true;
			taunt = true;
			divineShield = true;
			windfury = true;
		} else if (type == KELTHUZAD) {
			name = "Kel'Thuzad";
			initBasicStats(8, 6, 8);
			endTurnEffect = new ReviveFriendlyMinionsTurnEffect(true);
		} else if (type == FORCE_TANK_MAX) {
			name = "Force-Tank MAX";
			minionType = Minion.MECH;
			initBasicStats(8, 7, 7);
			divineShield = true;
		} else if (type == GROMMASH_HELLSCREAM) {
			name = "Grommash Hellscream";
			initBasicStats(8, 4, 9);
			charge = true;
			enrageEffect = new BuffSingleMinionEnrageEffect(6, 0, false, false, false, false);
		} else if (type == IRONBARK_PROTECTOR) {
			name = "Ironbark Protector";
			initBasicStats(8, 8, 8);
			taunt = true;
		} else if (type == CHROMAGGUS) {
			// Add draw effect
			name = "Chromaggus";
			minionType = Minion.DRAGON;
			initBasicStats(8, 6, 8);
		} else if (type == FOE_REAPER_4000) {
			// Add damage close by effect
			name = "Foe Reaper 4000";
			minionType = Minion.MECH;
			initBasicStats(8, 6, 9);
		} else if (type == TIRION_FORDRING) {
			// Add weapon-deathrattle-effect
			name = "Tirion Fordring";
			minionType = Minion.DRAGON;
			initBasicStats(8, 6, 6);
			taunt = true;
			divineShield = true;
		} else if (type == SNEEDS_OLD_SHREDDER) {
			name = "Sneed's Old Shredder";
			minionType = Minion.MECH;
			initBasicStats(8, 5, 7);
			deathRattleEffect = new SummonRandomMinions(1, new int[] {	BLOODMAGE_THALNOS, LOREWALKER_CHO, MILLHOUSE_MANASTORM, NAT_PAGLE, 
																		EDWIN_VANCLEEF, KING_MUKKLA, TINKMASTER_OVERSPARK, BARON_RIVERDARE,
																		OLD_MURK_EYE, BLINGTRON_3000, BOLVAR_FORDRAGON, CAPTAIN_GREENSKIN,
																		ELITE_TAUREN_CHIEFTAIN, FEUGEN, HARRISON_JONES, HEMET_NESINGWARY,
																		LEEROY_JENKINS, LOATHEB, MIMIRONS_HEAD, STALAGG,
																		VOLJIN, CAIRNE_BLOODHOOF, EMPEROR_THAURISSAN, GAZLOWE,
																		GELBIN_MEKKATORQUE, HOGGER, ILLIDAN_STORMRAGE, IRON_JUGGERNAUT,
																		MAEXXNA, MOGOR_THE_OGRE, SYLVANAS_WINDRUNNER, THE_BEAST,
																		THE_BLACK_KNIGHT, TOSHLEY, TRADE_PRINCE_GALLYWIX, ARCHMAGE_ANTONIDAS,
																		BARON_GEDDON, DR_BOOM, FLAME_LEVIATHAN, GAHZRILLA, 
																		MALORNE, NEPTULON, PROPHET_VELEN, REND_BLACKHAND, 
																		TROGGZOR_THE_EARTHINATOR, ALAKIR_THE_WINDLORD, CHROMAGGUS, FOE_REAPER_4000,
																		GROMMASH_HELLSCREAM, GRUUL, KELTHUZAD, RAGNAROS_THE_FIRELORD,
																		SNEEDS_OLD_SHREDDER, TIRION_FORDRING, ALEXSTRASZA, CENARIUS,
																		KING_KRUSH, LORD_JARAXXUS, MAJORDOMO_EXECUTUS, MALGANIS,
																		MALYGOS, MEKGINEER_THERMAPLUGG, NEFARIAN, NOZDORMU,
																		ONYXIA, YSERA, DEATHWING}, 0, null);
//==============================================================================
		} else if (type == KING_KRUSH) {
			name = "King Krush";
			minionType = Minion.BEAST;
			initBasicStats(9, 8, 8);
			charge = true;
		} else if (type == ALEXSTRASZA) {
			name = "Alexstrasza";
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
			battleCryEffect = new SetHealthPlayer(15);
		} else if (type == ONYXIA) {
			name = "Onyxia";
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
			battleCryEffect = new SummonMinions(new int[] {WHELP, WHELP, WHELP, WHELP, WHELP, WHELP}, null);
		} else if (type == MALYGOS) {
			// Add spell damageEffect
			name = "Malygos";
			minionType = Minion.DRAGON;
			initBasicStats(9, 4, 12);
		} else if (type == MALGANIS) {
			// Add buff + immune-effect
			name = "Mal'Ganis";
			minionType = Minion.DEMON;
			initBasicStats(9, 9, 7);
		} else if (type == YSERA) {
			name = "Ysera";
			minionType = Minion.DRAGON;
			initBasicStats(9, 4, 12);
			endTurnEffect = new AddDreamCardToHandTurnEffect(1, true, false, false);
		} else if (type == CENARIUS) {
			// Add choose one
			name = "Cenarius";
			initBasicStats(9, 5, 8);
		} else if (type == LORD_JARAXXUS) {
			// Add hero-effect
			name = "Lord Jaraxxus";
			minionType = Minion.DEMON;
			initBasicStats(9, 3, 15);
		} else if (type == MAJORDOMO_EXECUTUS) {
			// Add hero-effect
			name = "Majordomo Executus";
			initBasicStats(9, 9, 7);
		} else if (type == MEKGINEER_THERMAPLUGG) {
			// Add die-effect
			name = "Mekgineer Thermaplugg";
			minionType = Minion.MECH;
			initBasicStats(9, 9, 7);
		} else if (type == NEFARIAN) {
			// Add nefarian-effect
			name = "Nefarian";
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
		} else if (type == NOZDORMU) {
			// Add ???-effect???
			name = "Nozdormu";
			minionType = Minion.DRAGON;
			initBasicStats(9, 8, 8);
//==============================================================================
		} else if (type == DEATHWING) {
			name = "Deathwing";
			minionType = Minion.DRAGON;
			initBasicStats(10, 12, 12);
			battleCryEffect = new DestroyAllMinions(true);
		} else if (type == SEA_GIANT) {
			name = "Sea Giant";
			costEffect = new CostDeterminedByMinionsOnBoard(1, true, true);
			initBasicStats(10, 8, 8);
		} else if (type == THADDIUS) {
			// not playable
			name = "Thaddius";
			initBasicStats(10, 11, 11);
//==============================================================================
		} else if (type == MOUNTAIN_GIANT) {
			name = "Mountain Giant";
			costEffect = new CostDeterminedByCardsInHand(1, true, false);
			initBasicStats(12, 8, 8);
		} else if (type == CLOCKWORK_GIANT) {
			name = "Clockwork Giant";
			minionType = Minion.MECH;
			costEffect = new CostDeterminedByCardsInHand(1, false, true);
			initBasicStats(12, 8, 8);
		} else if (type == MOLTEN_GIANT) {
			name = "Molten Giant";
			costEffect = new CostDeterminedByHealth(1, true);
			initBasicStats(20, 8, 8);
			deathRattleEffect = new SummonMinions(new int[] {HYENA, HYENA}, null);
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
		return new Minion(type, name, minionType, attack, health, taunt, charge, divineShield, windfury, cannotAttack, noSpellTarget, stealth, stealthTemporary, damageEffect, enrageEffect, battleCryEffect, deathRattleEffect, startTurnEffect, endTurnEffect);
	}
}