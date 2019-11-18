package cims;

public class CoffeeMug extends CoffeeProduct {
	private String size;
	private double weigth;

	public CoffeeMug(String name, int productID, String size, double weigth) {
		super(name, productID);
		this.size = size;
		this.weigth = weigth;
	}

	@Override
	public String toString() {
		if (CIMSTool.isPrintAll) {
			return super.toString() + String.format("\t\t%s (%.0fg)  ", size, weigth);
		} else {
			return super.toString() + String.format("\nSize: %s\nWeigth: %.0fg", size, weigth);
		}
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

}
