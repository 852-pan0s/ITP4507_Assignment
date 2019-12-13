package cims.command;

import cims.Caretaker;

public class RedoCommand implements Command {
	private Caretaker c;

	public RedoCommand(Caretaker c) {
		super();
		 this.c = c;
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
		if (c.getRedoList().size() > 0) {

			c.getUndoList().push(c.getRedoList().pop());

			if (c.getUndoList().peek().contains("Added")) {
				//save the action.
				c.saveProduct(c.getRedoProducts().pop());
			} else {
				//save the action.
				c.saveStatus(c.getRedoStatus().pop());
				//restore the status of product
				c.getUndoStatus().peek().restore();
				
			}
			System.out.println("redo completed.");
		} else {
			System.out.println("redo fail. (Redo list is empty)");
		}
	}

}
