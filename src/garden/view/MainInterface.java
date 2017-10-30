package garden.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import garden.controller.Database;
import garden.model.CircleField;
import garden.model.Field;
import garden.model.SquareField;
import garden.model.TriangleField;
import garden.model.exceptions.MalformedTriangleException;

public class MainInterface {
	private Database db;
	private BufferedReader reader;

	public MainInterface() {
		db = new Database();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private void mainLoop() throws MalformedTriangleException {
		while (true) {
			printMainHelp();
			String line;
			try {
				line = reader.readLine();
				if ("l".equals(line))
					listView();
				else if ("a".equals(line))
					addView();
				else if ("p".equals(line))
					profitView();
				else if ("L".equals(line))
					largestView();
				else if ("q".equals(line))
					break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	
	private void largestView() {
		Field f = db.findLargest();
		displayField(f);
	}

	private void profitView() throws IOException {
		System.out.println("Profit fence cost and carrot cost");
		String line = reader.readLine();
		float cost = Float.parseFloat(line);
		line = reader.readLine();
		float revenue = Float.parseFloat(line);
		System.out.println("Total profit " + db.getProfit(cost, revenue));
	}

	private void addView() throws IOException {
		System.out.println("Add a field");
		System.out.println(" s <edge> - square");
		System.out.println(" c <radius> - radius");
		System.out.println(" t <l1> <l2> <l3>- triangle");
		System.out.println(" q - back");
		String line = reader.readLine();
		if ("t".equals(line)) {
			line = reader.readLine();
			float l1 = Float.parseFloat(line);
			line = reader.readLine();
			float l2 = Float.parseFloat(line);
			line = reader.readLine();
			float l3 = Float.parseFloat(line);
			TriangleField field;
			try {
				field = new TriangleField(l1, l2, l3);
				db.addGarden(field);
			} catch (MalformedTriangleException e) {
				System.out.println("Your input for the edge " + e.getWrongEdge() + " was wrong");
			}
			System.out.println("Hello");
		}
		else if ("q".equals(line))
			return;
	}

	private void listView() {
		for (Field field : db.getAllGardens()) {
			displayField(field);
		}
	}

	private void displayField(Field field) {
		if (field instanceof SquareField) {
			System.out.println("Square edge=" + ((SquareField)field).getEdge());
		}
		else if (field instanceof CircleField) {
			System.out.println("Square radius=" + ((CircleField)field).getRadius());
		}
		else if (field instanceof TriangleField) {
			TriangleField f1 = (TriangleField) field;
			System.out.println("Triangle l1=" + f1.getL1() + " l2=" + f1.getL2() + " l3=" + f1.getL3());
		}
	}

	private void printMainHelp() {
		System.out.println("Garden manager 0.1 pre-alpha");
		System.out.println(" l - list gardens");
		System.out.println(" a - add a new garden");
		System.out.println(" p - get profit");
		System.out.println(" L - display largest");
		System.out.println(" q - quit");
	}

	public static void main(String args[]) throws MalformedTriangleException {
		MainInterface main = new MainInterface();
		main.mainLoop();
	}

}
