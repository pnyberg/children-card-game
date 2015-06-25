public class Minion {
	private String name;

	private int attack;
	private int health;

	private boolean taunt;
	private boolean charge;
	private boolean divineShield;
	private boolean windfury;

	public Minion(String name, int attack, int health, boolean taunt, boolean charge, boolean divineShield, boolean windfury) {
		this.name = name;
		this.attack = attack;
		this.health = health;
		this.taunt = taunt;
		this.charge = charge;
		this.divineShield = divineShield;
		this.windfury = windfury;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
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