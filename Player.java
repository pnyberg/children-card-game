public class Player extends Character {
	private int maxHealth;
	private int health;
	private int armor;
	private String name;

	public Player(String name, int maxHealth) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;

		armor = 0;
	}

	public boolean takeDamage(int damageAmount) {
		if (armor > 0) {
			armor -= damageAmount;

			if (armor < 0) {
				damageAmount = -armor;
				armor = 0;
			} else {
				damageAmount = 0;
			}
		}

		health -= damageAmount;

		return health > 0;
	}

	public void heal(int healAmount) {
		health = (health + healAmount) > maxHealth ? maxHealth : (health + healAmount);
	}

	public void setHealth(int healthAmount) {
		health = healthAmount;
	}

	public void addArmor(int addArmor) {
		armor += addArmor;
	}

	public int getHealth() {
		return health;
	}

	public int getArmor() {
		return armor;
	}

	public String getName() {
		return name;
	}
}