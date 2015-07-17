public class Player extends Character {
	private int maxHealth;
	private int health;
	private String name;

	public Player(String name, int maxHealth) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
	}

	public boolean takeDamage(int damageAmount) {
		health -= damageAmount;

		return health > 0;
	}

	public void heal(int healAmount) {
		health = (health + healAmount) > maxHealth ? maxHealth : (health + healAmount);
	}

	public void setHealth(int healthAmount) {
		health = healthAmount;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}
}