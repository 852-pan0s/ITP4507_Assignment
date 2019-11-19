package cims.command;

import java.util.Stack;

public class ShowListCommand implements Command {

	private Stack<String> undoList;
	private Stack<String> redoList;

	public ShowListCommand(Stack<String> undoList, Stack<String> redoList) {
		super();
		this.undoList = undoList;
		this.redoList = redoList;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("\nUndo List");
		if (undoList.size() > 0) {
			for (String s : undoList) {
				System.out.println(s);
			}
		} else {
			System.out.println("Empty");
		}

		System.out.println("\nRedo List");
		if (redoList.size() > 0) {
			for (String s : redoList) {
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
