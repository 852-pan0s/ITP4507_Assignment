package cims.command;

import java.util.Scanner;
import java.util.Stack;

import cims.CoffeeProduct;
import cims.memento.Memento;

public class ShipCommand implements Command {
	private Stack<String> undoList;
	private Stack<Memento> undoStatus;
	private Stack<CoffeeProduct> undoProducts;
	private Scanner sc;

	public ShipCommand(Stack<String> undoList, Stack<Memento> undoStatus, Stack<CoffeeProduct> undoProducts,
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
		System.out.println("Enter code:");
		String in = sc.nextLine();
		for (CoffeeProduct cp : undoProducts) {
			if (cp.getProductID() == Integer.parseInt(in)) {
				System.out.println("Quantity to ship:");
				in = sc.nextLine();
				if (cp.getQty() >= Integer.parseInt(in)) {
					cp.setQty(cp.getQty() - Integer.parseInt(in));
					undoStatus.push(new Memento(cp));
					undoList.push(String.format("Shipped %s %s (%d) ", in, cp.getName(), cp.getProductID()));
					System.out.println(String.format("Shipped %s packs of %s. Current quantity is %d.", in,
							cp.getName(), cp.getQty()));
					break;
				} else {
					System.out
							.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
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
