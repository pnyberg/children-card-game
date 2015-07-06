public class Minion extends Character {
	private String name;
	private int type;

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

	public Minion(String name, int type, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury, boolean cannotAttack, SpellEffect battleCryEffect, SpellEffect deathRattleEffect, TurnEffect startTurnEffect, TurnEffect endTurnEffect) {
		this.name = name;
		this.type = type;

		normalAttack = attack;
		normalMaxHealth = health;

		originallyTaunt = taunt;
		originallyCharge = charge;
		originallyDivineShield = divineShield;
		originallyWindfury = windfury;
		originallyCannotAttack = cannotAttack;

		originallyBattleCryEffect = battleCryEffect;
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
		deathRattleEffect = originallyDeathRattleEffect;

		startTurnEffect = originallyStartTurnEffect;
		endTurnEffect = originallyEndTurnEffect;

		currentAttack = normalAttack;

		currentMaxHealth = normalMaxHealth;
		currentHealth = normalMaxHealth;
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

	public boolean handleDamage(int damage) {
		if (divineShield) {
			divineShield = false;
			return true;
		}

		takeDamage(damage);

		return isAlive();
	}

	public void takeDamage(int damageAmount) {
		currentHealth -= damageAmount;

		System.out.println(name + " takes " + damageAmount + " damage!");	
	}

	public void heal(int healAmount) {
		currentHealth = (currentHealth + healAmount) > currentMaxHealth ? currentMaxHealth : (currentHealth + healAmount);
	}

	public void addAttack(int add) {
		currentAttack += add;
	}

	public void addTempAttack(int attack) {
		tempAttack += attack;
	}

	public void addHealth(int add) {
		currentHealth += add;
		currentMaxHealth += add;
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
}