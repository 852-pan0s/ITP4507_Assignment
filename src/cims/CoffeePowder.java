package cims;

public class CoffeePowder extends CoffeeProduct {
	private double weight;

	public CoffeePowder(int productID, String name, double weight) {
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
		if (CIMSTool.isPrintAll) {
			return super.toString() + String.format("\t%.0fg", weight);
		} else {
			return super.toString() + String.format("\nWeight: %.0fg", weight);
		}

	}
}
