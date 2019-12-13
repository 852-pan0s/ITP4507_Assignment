package cims.factory;

import java.util.Scanner;

import cims.CoffeeMug;
import cims.CoffeeProduct;

public class CoffeeMugCreator extends CoffeeFactory {

	public CoffeeMugCreator(Scanner sc) {
		super(sc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CoffeeProduct create() {
		// TODO Auto-generated method stub
		System.out.println("Enter product Id, name, size, weight:");
		String[] in = sc.nextLine().split(", ");
//		for (String s : in) {
//			System.out.println(s);
//		}
		return new CoffeeMug(in[1],Integer.parseInt(in[0]), in[2], Double.parseDouble(in[3]));
	}

}
