public abstract class PlayCard {
	public abstract void changeCost(int costChange);
	public abstract void setCost(int newCost);
	public abstract String getName();
	public abstract int getCost();
	public abstract int getOriginalCost();
	public abstract SpellEffect getCostEffect();
	public abstract boolean hasCostEffect();
}