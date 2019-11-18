package cims.command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.factory.*;
import cims.memoento.Memoento;

public class AddCommand implements Command {

	Stack<String> undoList;
	Stack<Memoento> undoSaves;
	Stack<CoffeeProduct> undoProducts;
	Vector<CoffeeProduct> products;
	Scanner sc;

	public AddCommand(Stack<String> undoList, Stack<Memoento> undoSaves, Stack<CoffeeProduct> undoProducts,
			Vector<CoffeeProduct> products, Scanner sc) {
		super();
		this.undoList = undoList;
		this.undoSaves = undoSaves;
		this.undoProducts = undoProducts;
		this.products = products;
		this.sc = sc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		CoffeeFactory cf = null;

		System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder/cm=Coffee Mug):");
		String in = sc.nextLine();
		if (in.equals("cc")) {
			cf = new CoffeeCandyCreator(sc);
		} else if (in.equals("cp")) {
			cf = new CoffeePowderCreator(sc);
		} else if (in.equals("cm")) {
			cf = new CoffeeMugCreator(sc);
		}
		else {
			System.out.println("No such type");
			return;
		}
		CoffeeProduct cp = cf.create();
		undoProducts.push(cp);
		undoSaves.push(new Memoento(cp));
		products.add(cp);
		undoList.push(String.format("Added %d %s", cp.getProductID(), cp.getName()));
		System.out.println("New product record created.");

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
