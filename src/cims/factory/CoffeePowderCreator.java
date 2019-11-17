package cims.factory;

import java.util.Scanner;

import cims.CoffeePowder;
import cims.CoffeeProduct;

public class CoffeePowderCreator extends CoffeeFactory {

	public CoffeePowderCreator(Scanner sc) {
		super(sc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CoffeeProduct create() {
		// TODO Auto-generated method stub
		System.out.println("Enter product Id , name and weight(g):");
		String[] in = sc.nextLine().split(", ");
//		for(String s : in) {
//			System.out.println(s);
//		}
		return new CoffeePowder(Integer.parseInt(in[0]),in[1],Double.parseDouble(in[2]));
	}

}
