public class Minion extends Character {
	public static final int	NONE = 0,
							BEAST = 1,
							MURLOC = 2,
							DEMON = 3,
							MECH = 4,
							DRAGON = 5,
							TOTEM = 6,
							PIRATE = 7;

	private int type;

	private String name;
	private int minionType;

	private int normalAttack;
	private int currentAttack;
	private int tempAttack;
	private int enrageAttack;

	private int normalMaxHealth;
	private int currentMaxHealth;
	private int currentHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;
	private boolean cannotAttack;
	private boolean noSpellTarget;
	private boolean stealth;
	private boolean stealthTemporary;

	private boolean originallyTaunt;
	private boolean originallyCharge;
	private boolean originallyDivineShield;
	private boolean originallyWindfury;
	private boolean originallyCannotAttack;
	private boolean originallyNoSpellTarget;
	private boolean originallyStealth;
	private boolean originallyStealthTemporary;

	private boolean enraged;
	private boolean enrageTaunt;
	private boolean enrageCharge;
	private boolean enrageDivineShield;
	private boolean enrageWindfury;

	private DamageEffect damageEffect;
	private DamageEffect originallyDamageEffect;

	private EnrageEffect enrageEffect;
	private EnrageEffect originallyEnrageEffect;

	private SpellEffect battleCryEffect;
	private SpellEffect deathRattleEffect;

	private SpellEffect originallyBattleCryEffect;
	private SpellEffect originallyDeathRattleEffect;

	private TurnEffect startTurnEffect;
	private TurnEffect endTurnEffect;

	private TurnEffect originallyStartTurnEffect;
	private TurnEffect originallyEndTurnEffect;

	private int attackAmount;
	private boolean restoredThisTurn;

	public Minion(int type, String name, int minionType, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury, boolean cannotAttack, boolean noSpellTarget, boolean stealth, boolean stealthTemporary, DamageEffect damageEffect, EnrageEffect enrageEffect, SpellEffect battleCryEffect, SpellEffect deathRattleEffect, TurnEffect startTurnEffect, TurnEffect endTurnEffect) {
		this.type = type;

		this.name = name;
		this.minionType = minionType;

		normalAttack = attack;
		normalMaxHealth = health;

		originallyTaunt = taunt;
		originallyCharge = charge;
		originallyDivineShield = divineShield;
		originallyWindfury = windfury;
		originallyCannotAttack = cannotAttack;
		originallyNoSpellTarget = noSpellTarget;
		originallyStealth = stealth;
		originallyStealthTemporary = stealthTemporary;

		originallyBattleCryEffect = battleCryEffect;
		originallyDamageEffect = damageEffect;
		originallyEnrageEffect = enrageEffect;
		originallyDeathRattleEffect = deathRattleEffect;

		originallyStartTurnEffect = startTurnEffect;
		originallyEndTurnEffect = endTurnEffect;

		initSpecialStats();
		unenrage();

		tempAttack = 0;

		restoredThisTurn = false;

		if (charge) {
			prepareMinion(false);
		} else {
			attackAmount = -1;
		}
	}

	public void restore() {
		initSpecialStats();

		restoredThisTurn = true;
	}

	public void initSpecialStats() {
		taunt = originallyTaunt;
		charge = originallyCharge;
		divineShield = originallyDivineShield;
		windfury = originallyWindfury;
		cannotAttack = originallyCannotAttack;
		noSpellTarget = originallyNoSpellTarget;
		stealth = originallyStealth;
		stealthTemporary = originallyStealthTemporary;

		battleCryEffect = originallyBattleCryEffect;
		damageEffect = originallyDamageEffect;
		enrageEffect = originallyEnrageEffect;
		deathRattleEffect = originallyDeathRattleEffect;

		startTurnEffect = originallyStartTurnEffect;
		endTurnEffect = originallyEndTurnEffect;

		currentAttack = normalAttack;

		setHealth(normalMaxHealth);
	}

	public void prepareMinion(boolean startOfTurn) {
		attackAmount = (hasWindfury() ? 2 : 1);

		if (stealthTemporary && startOfTurn) {
			stealth = false;
			stealthTemporary = false;
		}
	}

	public void endTurnAction() {
		tempAttack = 0;
		restoredThisTurn = false;
	}

	public void silence() {
		currentAttack = normalAttack;
		tempAttack = 0;

		currentMaxHealth = normalMaxHealth;
		if (currentHealth > currentMaxHealth) {
			currentHealth = currentMaxHealth;
		}

		if (attackAmount > 0) {
			attackAmount = 1;
		} else {
			attackAmount = 0;
		}

		taunt = false;
		charge = false;
		divineShield = false;
		windfury = false;
		cannotAttack = false;
		noSpellTarget = false;
		stealth = false;
		stealthTemporary = false;

		damageEffect = null;

		enrageEffect = null;

		battleCryEffect = null;
		deathRattleEffect = null;

		startTurnEffect = null;
		endTurnEffect = null;

		// restoredThisTurn;
	}

	public void unenrage() {
		enrageAttack = 0;
		enraged = false;

		enrageTaunt = false;
		enrageCharge = false;
		enrageDivineShield = false;

		setEnrageWindfury(false);
	}

	public int attack() {
		attackAmount--;

		if (stealth) {
			stealth = false;
			stealthTemporary = false;
		}

		return getCurrentAttack();
	}

	public boolean canAttack() {
		return attackAmount > 0 && !cannotAttack;
	}

	public String reasonForNotAttacking() {
		if (attackAmount == -1) {
			return name + " cannot attack, minion has summoning-sickness!";
		} else if (attackAmount == 0) {
			return name + " cannot attack, minion has no more attacks this turn!";
		} else {
			return name + " cannot attack, something is Albinoso wrongo :O";
		}
	}

	public boolean takeDamage(int damageAmount) {
		if (divineShield) {
			divineShield = false;
			return false;
		}

		if (damageAmount <= 0) {
			return false;
		}

		currentHealth -= damageAmount;

		return true;
	}

	public void heal(int healAmount) {
		boolean fullyHealed = (currentHealth + healAmount) >= currentMaxHealth;

		if (fullyHealed) {
			currentHealth = currentMaxHealth;

			unenrage();
		} else {
			currentHealth = (currentHealth + healAmount);
		}
	}

	public void addAttack(int add) {
		currentAttack += add;
	}

	public void setAttack(int newAttack) {
		currentAttack = newAttack;
	}

	public void addTempAttack(int attack) {
		tempAttack += attack;
	}

	public void addEnrageAttack(int attack) {
		enrageAttack += attack;
	}

	public void addHealth(int add) {
		currentHealth += add;
		currentMaxHealth += add;
	}

	public void setHealth(int newHealth) {
		currentHealth = newHealth;
		currentMaxHealth = newHealth;
	}

	public void kill() {
		currentHealth = 0;
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public void setDivineShield(boolean divineShield) {
		this.divineShield = divineShield;
	}

	public void setWindfury(boolean windfury) {
		if (this.windfury != windfury) {
			if (windfury) { attackAmount++; }
			else { attackAmount--; }
		}
		this.windfury = windfury;
	}

	public void setEnrageTaunt(boolean taunt) {
		enrageTaunt = taunt;
	}

	public void setEnrageCharge(boolean charge) {
		enrageCharge = charge;
	}

	public void setEnrageDivineShield(boolean divineShield) {
		enrageDivineShield = divineShield;
	}

	public void setEnrageWindfury(boolean windfury) {
		if (enrageWindfury != windfury && !this.windfury) {
			if (windfury) { attackAmount++; }
			else { attackAmount--; }
		}
		enrageWindfury = windfury;
	}

	public void setCannotAttack(boolean cannotAttack) {
		this.cannotAttack = cannotAttack;
	}

	public void setNoSpellTarget(boolean noSpellTarget) {
		this.noSpellTarget = noSpellTarget;
	}

	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}

	public void setStealthTemporary(boolean stealthTemporary) {
		this.stealthTemporary = stealthTemporary;
	}

	public void setRestoredThisTurn(boolean restoredThisTurn) {
		this.restoredThisTurn = restoredThisTurn;
	}

	public void setEnrage(boolean enraged) {
		this.enraged = enraged;
	}

	public boolean isAlive() {
		return currentHealth > 0;
	}

	public boolean isBuffed() {
		return normalAttack < getCurrentAttack() || normalMaxHealth < currentMaxHealth;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public int getMinionType() {
		return minionType;
	}

	public int getNormalAttack() {
		return normalAttack;
	}

	public int getCurrentAttack() {
		return currentAttack + tempAttack + enrageAttack;
	}

	public int getTempAttack() {
		return tempAttack;
	}

	public int getEnrageAttack() {
		return enrageAttack;
	}

	public int getNormalMaxHealth() {
		return normalMaxHealth;
	}

	public int getCurrentMaxHealth() {
		return currentMaxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public DamageEffect getDamageEffect() {
		return damageEffect;
	}

	public EnrageEffect getEnrageEffect() {
		return enrageEffect;
	}

	public SpellEffect getBattleCryEffect() {
		return battleCryEffect;
	}

	public SpellEffect getDeathRattleEffect() {
		return deathRattleEffect;
	}

	public TurnEffect getStartTurnEffect() {
		return startTurnEffect;
	}

	public TurnEffect getEndTurnEffect() {
		return endTurnEffect;
	}

	public boolean hasTaunt() {
		return taunt || enrageTaunt;
	}

	public boolean hasCharge() {
		return charge || enrageCharge;
	}

	public boolean hasDivineShield() {
		return divineShield || enrageDivineShield;
	}

	public boolean hasWindfury() {
		return windfury || enrageWindfury;
	}

	public boolean hasCannotAttack() {
		return cannotAttack;
	}

	public boolean hasNoSpellTarget() {
		return noSpellTarget;
	}

	public boolean hasStealth() {
		return stealth;
	}

	public boolean hasStealthTemporary() {
		return stealthTemporary;
	}

	public boolean isEnraged() {
		return enraged;
	}

	public boolean hasDamageEffect() {
		return damageEffect != null;
	}

	public boolean hasEnrageEffect() {
		return enrageEffect != null;
	}

	public boolean hasBattleCry() {
		return battleCryEffect != null;
	}

	public boolean hasDeathRattle() {
		return deathRattleEffect != null;
	}

	public boolean hasStartTurnEffect() {
		return startTurnEffect != null;
	}

	public boolean hasEndTurnEffect() {
		return endTurnEffect != null;
	}

	public boolean restoredThisTurn() {
		return restoredThisTurn;
	}

	public boolean enemyBoardAreaEffect() {
		if (damageEffect == null) {
			return false;
		}
		return damageEffect.enemyBoardAreaEffect();
	}

	public boolean friendlyBoardAreaEffect() {
		if (damageEffect == null) {
			return false;
		}
		return damageEffect.friendlyBoardAreaEffect();
	}
}