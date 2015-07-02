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

	private SpellEffect battleCryEffect;
	private SpellEffect deathRattleEffect;

	private TurnEffect startTurnEffect;
	private TurnEffect endTurnEffect;

	private int attackAmount;

	public Minion(String name, int type, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury, SpellEffect battleCryEffect, SpellEffect deathRattleEffect, TurnEffect startTurnEffect, TurnEffect endTurnEffect) {
		this.name = name;
		this.type = type;

		normalAttack = attack;
		currentAttack = attack;
		tempAttack = 0;

		normalMaxHealth = health;
		currentMaxHealth = health;
		currentHealth = health;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;

		this.battleCryEffect = battleCryEffect;
		this.deathRattleEffect = deathRattleEffect;

		this.startTurnEffect = startTurnEffect;
		this.endTurnEffect = endTurnEffect;

		if (charge) {
			prepareMinion();
		} else {
			attackAmount = -1;
		}
	}

	public void prepareMinion() {
		attackAmount = (windfury ? 2 : 1);
	}

	public void endTurnAction() {
		tempAttack = 0;
	}

	public int attack() {
		attackAmount--;
		return getCurrentAttack();
	}

	public boolean canAttack() {
		return attackAmount > 0;
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
}