package cims.command;

import cims.Caretaker;

public class ShowListCommand implements Command {

	private Caretaker c;

	public ShowListCommand(Caretaker c) {
		super();
		 this.c = c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("\nUndo List");
		if (c.getUndoList().size() > 0) {
			for (String s : c.getUndoList()) {
				System.out.println(s);
			}
		} else {
			System.out.println("Empty");
		}

		System.out.println("\nRedo List");
		if (c.getRedoList().size() > 0) {
			for (String s : c.getRedoList()) {
				System.out.println(s);
			}
		} else {
			System.out.println("Empty");
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
