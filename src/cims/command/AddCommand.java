package cims.command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.factory.*;
import cims.memoento.Memoento;

public class AddCommand implements Command {

	Stack<String> doneList;
	Stack<Memoento> save = new Stack<Memoento>();
	Stack<CoffeeProduct> sProdusts;
	Vector<CoffeeProduct> vProducts;
	Scanner sc;

	

	public AddCommand(Stack<String> doneList, Stack<Memoento> save, Stack<CoffeeProduct> sProdusts,
			Vector<CoffeeProduct> vProducts, Scanner sc) {
		super();
		this.doneList = doneList;
		this.save = save;
		this.sProdusts = sProdusts;
		this.vProducts = vProducts;
		this.sc = sc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		CoffeeFactory cf = null;
		
		System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder):");
		String in = sc.nextLine();
		if (in.equals("cc")) {
			cf = new CoffeeCandyCreator(sc);
		} else if (in.equals("cp")) {
			cf = new CoffeePowderCreator(sc);
		} else {
			System.out.println("");
		}
		CoffeeProduct cp = cf.create();;
		sProdusts.push(cp);
		vProducts.add(cp);
		doneList.push(String.format("Added %d %s", cp.getProductID(),cp.getName()));
		
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
