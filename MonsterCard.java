public class MonsterCard extends PlayCard {
	private String name;

	private int cost;
	private int attack;
	private int health;

	public MonsterCard(String name, int cost, int attack, int health) {
		this.name = name;
		this.cost = cost;
		this.attack = attack;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

	public Minion toMinion() {
		return new Minion(name, attack, health, false, false, false, false);
	}
}