package cims;

public class CoffeeProduct {
	private int productID;
	private String name;
	private int qty;

	public CoffeeProduct(String name, int productID) {
		super();
		this.name = name;
		this.productID = productID;
	}

	public String toString() {
		String s = String.format("ID: %d\nName: %s\nQuantity: %d", productID, name, qty);
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
