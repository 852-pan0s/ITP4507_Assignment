package cims.command;

import java.util.Scanner;
import java.util.Stack;

import cims.*;

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
			System.out.println("\nCoffee Product information: ");
			System.out.println("ID\tName\t\t\tQuantity\tOther Info");
			for (CoffeeProduct cp : undoProducts) {
				String s = "";
				String t = cp.getName().length() > 15 ? "\t" : "\t\t";
				s = String.format("%d\t%s%s%d", cp.getProductID(), cp.getName(), t,cp.getQty());
				if(cp instanceof CoffeeCandy) {
					CoffeeCandy cc = (CoffeeCandy) cp;
					s+= String.format("\t\t%d candy per package (%d calories each) ", cc.getNoOfCandy(), cc.getCaloriesPerCandy());
				}else if(cp instanceof CoffeePowder) {
					CoffeePowder cpd = (CoffeePowder) cp;					
					s+=String.format("\t\t%.0fg", cpd.getWeight());
				}else if (cp instanceof CoffeeMug) {
					CoffeeMug cm = (CoffeeMug) cp;
					s+=  String.format("\t\t%s (%.0fg)  ", cm.getSize(), cm.getWeigth());
				}
				System.out.println(s);
			}
		} else {
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
