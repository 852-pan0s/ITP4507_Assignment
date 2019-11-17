package cims;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.command.*;
import cims.memoento.Memoento;

public class CIMSTool {

	public void showChoices() {
		System.out.println("Coffee Inventroy Managemet System");
		System.out.println("Please enter command:[a | v | c | s | u | r | sl | x]");
		System.out.println("a = add product,  v = view products,  c = collect product,  s = ship product, ");
		System.out.println("u = undo,  r = redo,  sl = show list undo/redo,  x = exit system\n");

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		Command c = null;
		Stack<String> doneList = new Stack<String>();
		Stack<Memoento> save = new Stack<Memoento>();
		Stack<CoffeeProduct>  undoList = new Stack<CoffeeProduct>();
		Vector<CoffeeProduct> products = new Vector<CoffeeProduct>();
		while (true) {
			showChoices();
			input = sc.nextLine();
			if (input.equals("a")) {
				c = new AddCommand(doneList,save,undoList,products,sc);
			} else if (input.equals("v")) {
				c = new ViewCommand(doneList,save,undoList,products,sc);
			} else if (input.equals("c")) {
				c = new CollectCommand(doneList,save,undoList,products,sc);
			} else if (input.equals("s")) {

			} else if (input.equals("u")) {
				c.undo();
			} else if (input.equals("r")) {
				c.redo();
			} else if (input.equals("sl")) {

			} else if(input.equals("x")) {
				break;
			}
			c.execute();
		}
		sc.close();
		System.out.println("\nThanks for using Coffee Inventory Management System!! ");
	}
	
	public static boolean isPrintAll = false;

	
}

