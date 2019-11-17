package cims.command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import cims.CoffeeProduct;
import cims.memoento.Memoento;

public class CollectCommand implements Command {
	Stack<String> doneList;
	Stack<Memoento> save = new Stack<Memoento>();
	Stack<CoffeeProduct> sProdusts;
	Vector<CoffeeProduct> vProducts;
	Scanner sc;
	

	public CollectCommand(Stack<String> doneList, Stack<Memoento> save, Stack<CoffeeProduct> sProdusts,
			Vector<CoffeeProduct> vProducts, Scanner sc) {
		super();
		this.doneList = doneList;
		this.save = save;
		this.sProdusts = sProdusts;
		this.vProducts = vProducts;
		this.sc = sc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

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
