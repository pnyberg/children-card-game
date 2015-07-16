public class SpellCard extends PlayCard {
	public static final int	DRAGON_POWER = 1,
							EMERALD_SCALE = 2,
							STAFF_OF_THE_EMPEROR = 3,
							FEATHER_OF_THE_FEATHER = 4,
							DRAGONS_BLOOD = 5;

	private String name;

	private int cost;
	private int originalCost;
	private int type;

	private SpellEffect costEffect;
	private SpellEffect spellEffect;

	public SpellCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		costEffect = null;

		if (type == DRAGON_POWER) {
			name = "Dragon Power";
			cost = 2;
			this.type = type;
			spellEffect = new BuffAllMinionsOfOneSide(1, 1);
		} else if (type == EMERALD_SCALE) {
			name = "Emerald Scale";
			cost = 2;
			this.type = type;
			spellEffect = new BuffSingleMinion(2, 2, false, false, false, false, false);
		} else if (type == STAFF_OF_THE_EMPEROR) {
			name = "Staff of the Emperor";
			cost = 4;
			this.type = type;
			spellEffect = new BuffSingleMinion(3, 3, true, false, true, false, false);
		} else if (type == FEATHER_OF_THE_FEATHER) {
			name = "Feather of the Feather";
			cost = 1;
			this.type = type;
			spellEffect = new BuffSingleMinion(0, 0, false, false, false, true, false);
		} else if (type == DRAGONS_BLOOD) {
			name = "Dragons Blood";
			cost = 1;
			this.type = type;
			spellEffect = new BuffSingleMinion(4, 0, false, false, false, false, true);
		}

		originalCost = cost;
	}

	public void changeCost(int costChange) {
		cost = (cost + costChange) < 0 ? 0 : cost + costChange;
	}

	public void setCost(int newCost) {
		cost = newCost < 0 ? 0 : newCost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getOriginalCost() {
		return originalCost;
	}

	public int getType() {
		return type;
	}

	public boolean hasCostEffect() {
		return costEffect != null;
	}

	public SpellEffect getCostEffect() {
		return costEffect;
	}

	public SpellEffect getSpellEffect() {
		return spellEffect;
	}
}