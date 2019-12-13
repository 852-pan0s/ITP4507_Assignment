package cims.command;

import cims.Caretaker;
import cims.CoffeeProduct;
import cims.factory.*;
import cims.memento.Memento;

public class AddCommand implements Command {

	private Caretaker c;

	public AddCommand(Caretaker c) {
		super();
		 this.c = c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		CoffeeFactory cf = null;

		System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder/cm=Coffee Mug):");
		String in = c.getSc().nextLine();
		if (in.equals("cc")) {
			cf = new CoffeeCandyCreator(c.getSc());
		} else if (in.equals("cp")) {
			cf = new CoffeePowderCreator(c.getSc());
		} else if (in.equals("cm")) {
			cf = new CoffeeMugCreator(c.getSc());
		} else {
			System.out.println("No such type");
			return;
		}
		CoffeeProduct cp = cf.create();
//		c.getUndoProducts().push(cp);
		c.saveProducts(cp);
//		c.getUndoStatus().push(new Memento(cp));
		c.saveStatus(new Memento(cp));
//		c.getUndoList().push(String.format("Added %d %s", cp.getProductID(), cp.getName()));
		c.saveRecord(String.format("Added %d %s", cp.getProductID(), cp.getName()));
		System.out.println("New product record created.");

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
