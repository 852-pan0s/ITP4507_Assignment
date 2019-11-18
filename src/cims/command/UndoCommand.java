package cims.command;

import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memoento.Memoento;

public class UndoCommand implements Command {
	Stack<String> undoList;
	Stack<String> redoList;
	Stack<Memoento> undoSaves;
	Stack<Memoento> redoSaves;
	Stack<CoffeeProduct> undoProducts;
	Stack<CoffeeProduct> redoProducts;
	Vector<CoffeeProduct> products;

	public UndoCommand(Stack<String> undoList, Stack<String> redoList, Stack<Memoento> undoSaves,
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
		undo();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if (undoList.size()>0) {
			redoList.push(undoList.pop());
			if (redoList.peek().contains("Added")) {
				redoProducts.push(undoProducts.pop());
				products.remove(redoProducts.peek());
			} else {
				redoSaves.push(undoSaves.pop());
				for (int i = undoSaves.size() - 1; i >= 0; i--) {
//				System.out.println("Debug:"+undoSaves.get(i).getCoffeeProduct().getProductID()+",qty:"+undoSaves.get(i).getQty());
					if (undoSaves.get(i).getCoffeeProduct().getProductID() == redoSaves.peek().getCoffeeProduct()
							.getProductID()) {
						undoSaves.get(i).restore();
						break;
					}
				}
			}
			System.out.println("undo completed.");
		} else {
			System.out.println("undo failed. (Undo list is empty)");
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
