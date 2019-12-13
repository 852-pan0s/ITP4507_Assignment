package cims;

import java.util.Scanner;
import java.util.Stack;

import cims.command.*;
import cims.memento.Memento;

public class CIMSTool {

	public void showChoices() {
		System.out.println("Coffee Inventroy Managemet System");
		System.out.println("Please enter command:[a | v | c | s | u | r | sl | x]");
		System.out.println("a = add product,  v = view products,  c = collect product,  s = ship product, ");
		System.out.println("u = undo,  r = redo,  sl = show list undo/redo,  x = exit system");
		System.out.println();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		Command c = null;
		Stack<String> undoList = new Stack<String>();
		Stack<String> redoList = new Stack<String>();
		Stack<Memento> undoStatus = new Stack<Memento>();
		Stack<Memento> redoStatus = new Stack<Memento>();
		Stack<CoffeeProduct> undoProducts = new Stack<CoffeeProduct>();
		Stack<CoffeeProduct> redoProducts = new Stack<CoffeeProduct>();
		while (true) {
			showChoices();
			input = sc.nextLine();
			if (input.equals("a")) {
				c = new AddCommand(undoList, undoStatus, undoProducts, sc);
			} else if (input.equals("v")) {
				c = new ViewCommand(undoProducts, sc);
			} else if (input.equals("c")) {
				c = new CollectCommand(undoList, undoStatus, undoProducts, sc);
			} else if (input.equals("s")) {
				c = new ShipCommand(undoList, undoStatus, undoProducts, sc);
			} else if (input.equals("u")) {
				c = new UndoCommand(undoList, redoList, undoStatus, redoStatus, undoProducts, redoProducts);
			} else if (input.equals("r")) {
				c = new RedoCommand(undoList, redoList, undoStatus, redoStatus, undoProducts, redoProducts);
			} else if (input.equals("sl")) {
				c = new ShowListCommand(undoList, redoList);
			} else if (input.equals("x")) {
				break;
			}
			c.execute();
			System.out.println();
		}
		sc.close();
		System.out.println("Thanks for using Coffee Inventory Management System!! ");
	}

}
