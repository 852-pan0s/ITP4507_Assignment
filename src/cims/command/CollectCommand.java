package cims.command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memoento.Memoento;

public class CollectCommand implements Command {
	Stack<String> undoList;
	Stack<Memoento> undoSaves;
	Stack<CoffeeProduct> undoProducts;
	Vector<CoffeeProduct> products;
	Scanner sc;

	public CollectCommand(Stack<String> undoList, Stack<Memoento> undoSaves, Stack<CoffeeProduct> undoProducts,
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
		System.out.println("Enter code:");
		String in = sc.nextLine();
		for (CoffeeProduct cp : products) {
			if (cp.getProductID() == Integer.parseInt(in)) {
				System.out.println("Quantity of deposit:");
				in = sc.nextLine();
//				undoSaves.push(new Memoento(cp));
				cp.setQty(cp.getQty() + Integer.parseInt(in));
				undoSaves.push(new Memoento(cp));
				undoList.push(String.format("Received %s %s (%d) ", in, cp.getName(), cp.getProductID()));
				System.out.println(String.format("Received %s packs of %s. Current quantity is %d.", in, cp.getName(),
						cp.getQty()));
				break;
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
