package cims;

public class CoffeeCandy extends CoffeeProduct {
	private int noOfCandy;
	private int caloriesPerCandy;

	public CoffeeCandy(int productID, String name, int noOfCandy, int caloriesPerCandy) {
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
	
	public String toString() {
		if (CIMSTool.isPrintAll) {
			return super.toString()+String.format("\t%d candy per package (%d calories each) ", noOfCandy,caloriesPerCandy);
		} else {
			return super.toString()+String.format("\nNumber of candies per package: %d\nCalories Per candy: %d", noOfCandy,caloriesPerCandy);
		}
	}

}
