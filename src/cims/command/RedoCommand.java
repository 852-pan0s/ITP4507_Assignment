package cims.command;

import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memoento.Memoento;

public class RedoCommand implements Command {
	Stack<String> undoList;
	Stack<String> redoList;
	Stack<Memoento> undoSaves;
	Stack<Memoento> redoSaves;
	Stack<CoffeeProduct> undoProducts;
	Stack<CoffeeProduct> redoProducts;
	Vector<CoffeeProduct> products;

	public RedoCommand(Stack<String> undoList, Stack<String> redoList, Stack<Memoento> undoSaves,
			Stack<Memoento> redoSaves, Stack<CoffeeProduct> undoProducts, Stack<CoffeeProduct> redoProducts,
			Vector<CoffeeProduct> products) {
		super();
		this.undoList = undoList;
		this.redoList = redoList;
		this.undoSaves = undoSaves;
		this.redoSaves = redoSaves;
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
				undoSaves.push(redoSaves.pop());
				undoSaves.peek().restore();
			}
			System.out.println("redo completed.");
		}else {
			System.out.println("redo fail. (Redo list is empty)");
		}
	}

}
