package cims.command;

import java.util.Scanner;
import java.util.Stack;

import cims.CoffeeProduct;
import cims.factory.*;
import cims.memento.Memento;

public class AddCommand implements Command {

	private Stack<String> undoList;
	private Stack<Memento> undoStatus;
	private Stack<CoffeeProduct> undoProducts;
	private Scanner sc;

	public AddCommand(Stack<String> undoList, Stack<Memento> undoStatus, Stack<CoffeeProduct> undoProducts,
			Scanner sc) {
		super();
		this.undoList = undoList;
		this.undoStatus = undoStatus;
		this.undoProducts = undoProducts;
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
		} else {
			System.out.println("No such type");
			return;
		}
		CoffeeProduct cp = cf.create();
		undoProducts.push(cp);
		undoStatus.push(new Memento(cp));
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
