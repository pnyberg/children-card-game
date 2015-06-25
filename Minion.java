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
	}

	public boolean takeDamage(int damage) {
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

	public boolean isAlive() {
		return currentHealth > 0;
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