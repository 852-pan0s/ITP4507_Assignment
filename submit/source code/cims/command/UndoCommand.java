package cims.command;

import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memento.Memento;

public class UndoCommand implements Command {
	private Stack<String> undoList;
	private Stack<String> redoList;
	private Stack<Memento> undoStatus;
	private Stack<Memento> redoStatus;
	private Stack<CoffeeProduct> undoProducts;
	private Stack<CoffeeProduct> redoProducts;
	private Vector<CoffeeProduct> products;

	public UndoCommand(Stack<String> undoList, Stack<String> redoList, Stack<Memento> undoStatus,
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
				redoStatus.push(undoStatus.pop());
				for (int i = undoStatus.size() - 1; i >= 0; i--) {
//				System.out.println("Debug:"+undoStatus.get(i).getCoffeeProduct().getProductID()+",qty:"+undoStatus.get(i).getQty());
					if (undoStatus.get(i).getCoffeeProduct().getProductID() == redoStatus.peek().getCoffeeProduct()
							.getProductID()) {
						undoStatus.get(i).restore();
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
