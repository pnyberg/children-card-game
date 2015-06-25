public class SpellCard extends PlayCard {
	private String name;

	private int cost;

	public SpellCard(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
}