package cims.command;

import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memento.Memento;

public class RedoCommand implements Command {
	private Stack<String> undoList;
	private Stack<String> redoList;
	private Stack<Memento> undoStatus;
	private Stack<Memento> redoStatus;
	private Stack<CoffeeProduct> undoProducts;
	private Stack<CoffeeProduct> redoProducts;
	private Vector<CoffeeProduct> products;

	public RedoCommand(Stack<String> undoList, Stack<String> redoList, Stack<Memento> undoStatus,
			Stack<Memento> redoStatus, Stack<CoffeeProduct> undoProducts, Stack<CoffeeProduct> redoProducts,
			Vector<CoffeeProduct> products) {
		super();
		this.undoList = undoList;
		this.redoList = redoList;
		this.undoStatus = undoStatus;
		this.redoStatus = redoStatus;
		this.undoProducts = undoProducts;
		this.redoProducts = redoProducts;
		this.products = products;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		redo();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		if (redoList.size() > 0) {

			undoList.push(redoList.pop());

			if (undoList.peek().contains("Added")) {
				undoProducts.push(redoProducts.pop());
				products.add(undoProducts.peek());
			} else {
				undoStatus.push(redoStatus.pop());
				undoStatus.peek().restore();
			}
			System.out.println("redo completed.");
		}else {
			System.out.println("redo fail. (Redo list is empty)");
		}
	}

}
