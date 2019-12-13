package cims;

public class CoffeeCandy extends CoffeeProduct {
	private int noOfCandy;
	private int caloriesPerCandy;

	public CoffeeCandy(String name, int productID, int noOfCandy, int caloriesPerCandy) {
		super(name, productID);
		this.noOfCandy = noOfCandy;
		this.caloriesPerCandy = caloriesPerCandy;
	}

	public int getNoOfCandy() {
		return noOfCandy;
	}

	public void setNoOfCandy(int noOfCandy) {
		this.noOfCandy = noOfCandy;
	}

	public int getCaloriesPerCandy() {
		return caloriesPerCandy;
	}

	public void setCaloriesPerCandy(int caloriesPerCandy) {
		this.caloriesPerCandy = caloriesPerCandy;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nNumber of candies per package: %d\nCalories Per candy: %d",
				noOfCandy, caloriesPerCandy);
	}

}
