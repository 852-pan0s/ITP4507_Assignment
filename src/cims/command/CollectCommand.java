package cims.command;

import java.util.Scanner;
import java.util.Stack;

import cims.CoffeeProduct;
import cims.memento.Memento;

public class CollectCommand implements Command {
	private Stack<String> undoList;
	private Stack<Memento> undoStatus;
	private Stack<CoffeeProduct> undoProducts;
	private Scanner sc;

	public CollectCommand(Stack<String> undoList, Stack<Memento> undoStatus, Stack<CoffeeProduct> undoProducts,
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
				System.out.println("Quantity of deposit:");
				in = sc.nextLine();
//				undoStatus.push(new Memoento(cp));
				cp.setQty(cp.getQty() + Integer.parseInt(in));
				undoStatus.push(new Memento(cp));
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
