package cims.command;

import java.util.Scanner;
import java.util.Vector;

import cims.CIMSTool;
import cims.CoffeeProduct;

public class ViewCommand implements Command {

	private Vector<CoffeeProduct> products;
	private Scanner sc;

	public ViewCommand(Vector<CoffeeProduct> products, Scanner sc) {
		super();
		this.products = products;
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
			for (CoffeeProduct cp : products) {
				System.out.println(cp.toString());
			}
		} else {
			CIMSTool.isPrintAll = false;
			for (CoffeeProduct cp : products) {
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
