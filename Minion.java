public class Minion extends Character {
	public static final int	NONE = 0,
							BEAST = 1,
							MURLOC = 2,
							DEMON = 3,
							MECH = 4,
							DRAGON = 5,
							TOTEM = 6;

	private int type;

	private String name;
	private int minionType;

	private int normalAttack;
	private int currentAttack;
	private int tempAttack;

	private int normalMaxHealth;
	private int currentMaxHealth;
	private int currentHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;
	private boolean cannotAttack;

	private boolean originallyTaunt;
	private boolean originallyCharge;
	private boolean originallyDivineShield;
	private boolean originallyWindfury;
	private boolean originallyCannotAttack;

	private DamageEffect damageEffect;

	private DamageEffect originallyDamageEffect;

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

	public Minion(int type, String name, int minionType, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury, boolean cannotAttack, DamageEffect damageEffect, SpellEffect battleCryEffect, SpellEffect deathRattleEffect, TurnEffect startTurnEffect, TurnEffect endTurnEffect) {
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

		originallyBattleCryEffect = battleCryEffect;
		originallyDamageEffect = damageEffect;
		originallyDeathRattleEffect = deathRattleEffect;

		originallyStartTurnEffect = startTurnEffect;
		originallyEndTurnEffect = endTurnEffect;

		initSpecialStats();

		tempAttack = 0;

		restoredThisTurn = false;

		if (charge) {
			prepareMinion();
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

		battleCryEffect = originallyBattleCryEffect;
		damageEffect = originallyDamageEffect;
		deathRattleEffect = originallyDeathRattleEffect;

		startTurnEffect = originallyStartTurnEffect;
		endTurnEffect = originallyEndTurnEffect;

		currentAttack = normalAttack;

		setHealth(normalMaxHealth);
	}

	public void prepareMinion() {
		attackAmount = (windfury ? 2 : 1);
	}

	public void endTurnAction() {
		tempAttack = 0;
		restoredThisTurn = false;
	}

	public int attack() {
		attackAmount--;
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

		System.out.println(name + " takes " + damageAmount + " damage!");

/*		if (damageHandler == null) {
			System.out.println("Something is wrong, there is no damagehandler!");
		} else {
			damageHandler.manageAllDamageEffects(minionIndex, turnIndex);
		}*/

		return true;
	}

	public void heal(int healAmount) {
		currentHealth = (currentHealth + healAmount) > currentMaxHealth ? currentMaxHealth : (currentHealth + healAmount);
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

	public void setCannotAttack(boolean cannotAttack) {
		this.cannotAttack = cannotAttack;
	}

	public void setRestoredThisTurn(boolean restoredThisTurn) {
		this.restoredThisTurn = restoredThisTurn;
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
		return currentAttack + tempAttack;
	}

	public int getTempAttack() {
		return tempAttack;
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
		return taunt;
	}

	public boolean hasCharge() {
		return charge;
	}

	public boolean hasDivineShield() {
		return divineShield;
	}

	public boolean hasWindfury() {
		return windfury;
	}

	public boolean hasCannotAttack() {
		return cannotAttack;
	}

	public boolean hasDamageEffect() {
		return damageEffect != null;
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