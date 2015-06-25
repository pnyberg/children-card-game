public class Minion {
	private String name;

	private int normalAttack;
	private int currentAttack;
	private int normalHealth;
	private int currentHealth;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public Minion(String name, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.name = name;
		this.normalAttack = attack;
		this.currentAttack = normalAttack;
		this.normalHealth = health;
		this.currentHealth = normalHealth;
		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public boolean takeDamage(int damage) {
		currentHealth -= damage;

		return isAlive();
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

	public int getNormalHealth() {
		return normalHealth;
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