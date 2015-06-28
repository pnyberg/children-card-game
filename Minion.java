public class Minion {
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

	private int attackAmount;

	public Minion(String name, int type, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury, SpellEffect battleCryEffect) {
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

 /*HERE*/
	public String reasonForNotAttacking() {
		if (attackAmount == -1) {
			return "minion has summoning-sickness";
		} else if (attackAmount == 0) {
			return "minion has no more attacks this turn";
		} else {
			return "something is Albinoso wrongo :O";
		}
	}

	public boolean handleDamage(int damage) {
		if (divineShield) {
			divineShield = false;
			return true;
		}

		currentHealth -= damage;

		return isAlive();
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
}