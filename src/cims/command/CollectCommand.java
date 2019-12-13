package cims.command;

import cims.Caretaker;
import cims.CoffeeProduct;
import cims.memento.Memento;

public class CollectCommand implements Command {
	private Caretaker c;

	public CollectCommand(Caretaker c) {
		super();
		 this.c = c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Enter code:");
		String in = c.getSc().nextLine();
		for (CoffeeProduct cp : c.getUndoProducts()) {
			if (cp.getProductID() == Integer.parseInt(in)) {
				System.out.println("Quantity of deposit:");
				in = c.getSc().nextLine();
				cp.setQty(cp.getQty() + Integer.parseInt(in));
//				c.getUndoStatus().push(new Memento(cp));
				c.saveStatus(new Memento(cp));
//				c.getUndoList().push(String.format("Received %s %s (%d) ", in, cp.getName(), cp.getProductID()));
				c.saveRecord(String.format("Received %s %s (%d) ", in, cp.getName(), cp.getProductID()));
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
