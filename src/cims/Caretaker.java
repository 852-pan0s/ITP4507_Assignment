package cims;

import java.util.Scanner;
import java.util.Stack;

import cims.command.*;
import cims.memento.Memento;

public class Caretaker {

	private Scanner sc;
	//Save the record(String)
	private Stack<String> undoList;
	private Stack<String> redoList;
	//Save the status of products
	private Stack<Memento> undoStatus;
	private Stack<Memento> redoStatus;
	// Save the products object
	private Stack<CoffeeProduct> undoProducts;
	private Stack<CoffeeProduct> redoProducts;

	public Caretaker() {
		super();
		sc = new Scanner(System.in);
		undoList = new Stack<String>();
		redoList = new Stack<String>();
		undoStatus = new Stack<Memento>();
		redoStatus = new Stack<Memento>();
		undoProducts = new Stack<CoffeeProduct>();
		redoProducts = new Stack<CoffeeProduct>();

	}

	public Scanner getSc() {
		return sc;
	}

	public Stack<String> getUndoList() {
		return undoList;
	}

	public Stack<String> getRedoList() {
		return redoList;
	}

	public Stack<Memento> getUndoStatus() {
		return undoStatus;
	}

	public Stack<Memento> getRedoStatus() {
		return redoStatus;
	}

	public Stack<CoffeeProduct> getUndoProducts() {
		return undoProducts;
	}

	public Stack<CoffeeProduct> getRedoProducts() {
		return redoProducts;
	}

	public void showChoices() {
		System.out.println("Coffee Inventroy Managemet System");
		System.out.println("Please enter command:[a | v | c | s | u | r | sl | x]");
		System.out.println("a = add product,  v = view products,  c = collect product,  s = ship product, ");
		System.out.println("u = undo,  r = redo,  sl = show list undo/redo,  x = exit system");
		System.out.println();

	}

	public void run() {

		String input = "";
		Command c = null;
		while (true) {
			showChoices();
			input = sc.nextLine();
			if (input.equals("a")) {
				c = new AddCommand(this);
			} else if (input.equals("v")) {
				c = new ViewCommand(this);
			} else if (input.equals("c")) {
				c = new CollectCommand(this);
			} else if (input.equals("s")) {
				c = new ShipCommand(this);
			} else if (input.equals("u")) {
				c = new UndoCommand(this);
			} else if (input.equals("r")) {
				c = new RedoCommand(this);
			} else if (input.equals("sl")) {
				c = new ShowListCommand(this);
			} else if (input.equals("x")) {
				break;
			}
			c.execute();
			System.out.println();
		}
		sc.close();
		System.out.println("Thanks for using Coffee Inventory Management System!! ");
	}
	
	public void saveStatus(Memento m) {
		undoStatus.push(m);
	}
	
	public void saveProducts(CoffeeProduct cp) {
		undoProducts.push(cp);
	}
	
	public void saveRecord(String s) {
		undoList.push(s);
	}

}
