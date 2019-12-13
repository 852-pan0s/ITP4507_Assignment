package cims;

public class CoffeePowder extends CoffeeProduct {
	private double weight;

	public CoffeePowder(String name, int productID, double weight) {
		super(name, productID);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String toString() {
		return super.toString() + String.format("\nWeight: %.0fg", weight);

	}
}
