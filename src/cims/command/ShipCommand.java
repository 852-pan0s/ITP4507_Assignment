package cims.command;

import cims.Caretaker;
import cims.CoffeeProduct;
import cims.memento.Memento;

public class ShipCommand implements Command {
	private Caretaker c;

	public ShipCommand(Caretaker c) {
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
				System.out.println("Quantity to ship:");
				in = c.getSc().nextLine();
				if (cp.getQty() >= Integer.parseInt(in)) {
					cp.setQty(cp.getQty() - Integer.parseInt(in));
//					c.getUndoStatus().push(new Memento(cp));
					c.saveStatus(new Memento(cp));
//					c.getUndoList().push(String.format("Shipped %s %s (%d) ", in, cp.getName(), cp.getProductID()));
					c.saveRecord(String.format("Shipped %s %s (%d) ", in, cp.getName(), cp.getProductID()));
					System.out.println(String.format("Shipped %s packs of %s. Current quantity is %d.", in,
							cp.getName(), cp.getQty()));
					break;
				} else {
					System.out
							.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
				}

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
