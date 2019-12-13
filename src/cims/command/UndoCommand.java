package cims.command;

import cims.Caretaker;

public class UndoCommand implements Command {

	private Caretaker c;

	public UndoCommand(Caretaker c) {
		super();
		 this.c = c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		undo();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		if (c.getUndoList().size() > 0) {
			c.getRedoList().push(c.getUndoList().pop());
			if (c.getRedoList().peek().contains("Added")) {
				c.getRedoProducts().push(c.getUndoProducts().pop());
			} else {
				c.getRedoStatus().push(c.getUndoStatus().pop());
				int productID = c.getRedoStatus().peek().getCoffeeProduct().getProductID();
				for (int i = c.getUndoStatus().size() - 1; i >= 0; i--) {
					if (c.getUndoStatus().get(i).getCoffeeProduct().getProductID() == productID) {
						c.getUndoStatus().get(i).restore();
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
