package cims.factory;

import java.util.Scanner;

import cims.CoffeeCandy;
import cims.CoffeeProduct;

public class CoffeeCandyCreator extends CoffeeFactory {

	public CoffeeCandyCreator(Scanner sc) {
		super(sc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CoffeeProduct create() {
		// TODO Auto-generated method stub
		System.out.println("Enter product Id, name, number of candy and calories per candy:");
		String[] in = sc.nextLine().split(", ");
//		for (String s : in) {
//			System.out.println(s);
//		}
		return new CoffeeCandy(in[1], Integer.parseInt(in[0]), Integer.parseInt(in[2]), Integer.parseInt(in[3]));
	}

}
