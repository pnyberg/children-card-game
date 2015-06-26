public class Minion {
	private String name;

	private int normalAttack;
	private int currentAttack;
	private int normalMaxHealth;
	private int currentMaxHealth;
	private int currentHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	private int attackAmount;

	public Minion(String name, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.name = name;
		this.normalAttack = attack;
		this.currentAttack = normalAttack;
		this.normalMaxHealth = health;
		this.currentMaxHealth = normalMaxHealth;
		this.currentHealth = normalMaxHealth;

		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;

		if (charge) {
			prepareMinion();
		} else {
			attackAmount = -1;
		}
	}

	public void prepareMinion() {
		attackAmount = (windfury ? 2 : 1);
	}

	public int attack() {
		attackAmount--;
		return currentAttack;
	}

	public boolean canAttack() {
		return attackAmount > 0;
	}

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

	public void addAttack(int add) {
		currentAttack += add;
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
		return normalAttack < currentAttack || normalMaxHealth < currentMaxHealth;
	}

	public String getName() {
		return name;
	}

	public int getNormalAttack() {
		return normalAttack;
	}

	public int getCurrentAttack() {
		return currentAttack;
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