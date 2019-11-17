package cims.memoento;

import cims.CoffeeProduct;

public class Memoento {
	CoffeeProduct cp;
	private String name;
	private int productID;
	private int qty;
	public Memoento(CoffeeProduct cp) {
		this.cp = cp;
		name = cp.getName();
		productID = cp.getProductID();
	}
	public void restore() {
		cp.setName(name);
		cp.setProductID(productID);
		cp.setQty(qty);
	}
}
