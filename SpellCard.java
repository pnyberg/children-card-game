public class SpellCard extends PlayCard {
	public static final int	DRAGON_POWER = 1,
							EMERALD_SCALE = 2,
							STAFF_OF_THE_EMPEROR = 3;

	private String name;

	private int cost;
	private int type;

	private SpellEffect spellEffect;

	public SpellCard(int type) {
		setStats(type);
	}

	private void setStats(int type) {
		if (type == DRAGON_POWER) {
			name = "Dragon Power";
			cost = 2;
			this.type = type;
			spellEffect = new SpellEffect_BuffAllOfOneSide(1, 1);
		} else if (type == EMERALD_SCALE) {
			name = "Emerald Scale";
			cost = 2;
			this.type = type;
			spellEffect = new SpellEffect_BuffSingleMinionOfOneSide(2, 2, false, false, false, false);
		} else if (type == STAFF_OF_THE_EMPEROR) {
			name = "Staff of the Emperor";
			cost = 4;
			this.type = type;
			spellEffect = new SpellEffect_BuffSingleMinionOfOneSide(3, 3, true, false, true, false);
		}
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getType() {
		return type;
	}

	public SpellEffect getSpellEffect() {
		return spellEffect;
	}
}