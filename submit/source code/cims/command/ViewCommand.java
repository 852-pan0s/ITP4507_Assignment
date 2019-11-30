package cims.command;

import java.util.Scanner;
import java.util.Stack;

import cims.CIMSTool;
import cims.CoffeeProduct;

public class ViewCommand implements Command {

	private Stack<CoffeeProduct> undoProducts;
	private Scanner sc;

	public ViewCommand(Stack<CoffeeProduct> undoProducts, Scanner sc) {
		super();
		this.undoProducts = undoProducts;
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
			System.out.println("ID\tName\t\t\tQuantity\tOther Info");
			for (CoffeeProduct cp : undoProducts) {
				System.out.println(cp.toString());
			}
		} else {
			CIMSTool.isPrintAll = false;
			for (CoffeeProduct cp : undoProducts) {
				if (cp.getProductID() == Integer.parseInt(in)) {
					System.out.println("\nProuct information: ");
					System.out.println(cp.toString());
				}
			}
		}
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
