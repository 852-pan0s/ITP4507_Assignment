package cims.factory;

import java.util.Scanner;

import cims.CoffeeProduct;

public abstract class CoffeeFactory {
	Scanner sc;
	
	public CoffeeFactory(Scanner sc) {
		this.sc = sc;
	}

	public abstract CoffeeProduct create();
}
