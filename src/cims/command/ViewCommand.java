package cims.command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.CIMSTool;
import cims.CoffeeProduct;
import cims.memoento.Memoento;

public class ViewCommand implements Command {
	Stack<String> doneList;
	Stack<Memoento> save = new Stack<Memoento>();
	Stack<CoffeeProduct> sProdusts;
	Vector<CoffeeProduct> vProducts;
	Scanner sc;
	
	
	public ViewCommand(Stack<String> doneList, Stack<Memoento> save, Stack<CoffeeProduct> sProdusts,
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
		System.out.println("Enter product Id. (* to show all): ");
		String in = sc.nextLine();
		if (in.equals("*")) {
			CIMSTool.isPrintAll = true;
			System.out.println("\nCoffee Product information: ");
			System.out.println("ID\tName\t\tQuantity\tOther Info");
			for (CoffeeProduct cp : vProducts) {
				System.out.println(cp.toString());
			}
		} else {
			CIMSTool.isPrintAll = false;
			for (CoffeeProduct cp : vProducts) {
				if (cp.getProductID() == Integer.parseInt(in)) {
					System.out.println("\nProuct information: ");
					System.out.println(cp.toString());
				}
			}
		}
		System.out.println();

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
