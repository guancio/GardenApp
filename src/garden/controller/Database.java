package garden.controller;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import garden.model.Field;

public class Database {
	private List<Field> gardens;

	public Database() {
		this.gardens = new Vector<Field>();
	}
	
	public void addGarden(Field garden) {
		this.gardens.add(garden);
	}
	
	public Field getL() {
		Iterator<Field> it = this.gardens.iterator();
		Field largest = this.gardens.get(0);
		while (it.hasNext()) {
			Field g = it.next();
			if (g.getArea() > largest.getArea())
				largest = g;
		}
		/*
		this.gardens.sort(new ComparatorByArea());
		this.gardens.sort(new Comparator<Field>() {
			public int compare(Field arg0, Field arg1) {
				float a1 = arg0.getArea();
				float a2 = arg1.getArea();
				if (a1 < a2)
					return 1;
				if (a1 == a2)
					return 0;
				return -1;
			}
		});*/
		return largest;
	}
	
	
	public Field findLargest() {
		Iterator<Field> it = this.gardens.iterator();
		if (! it.hasNext())
			return null;
		Field largest = it.next();
		while (it.hasNext()) {
			Field field = it.next();
			if (field.getArea() > largest.getArea())
				largest = field;
		}
		return largest;
	}
	
	public float getProfit( float fenceCostPerMeter,
							float carrotRevenuePerMeter) {
		float cost = 0;
		float revenue = 0;
		Iterator<Field> it = this.gardens.iterator();
		while (it.hasNext()) {
			Field field = it.next();
			cost += field.getPerimeter() * fenceCostPerMeter;
			revenue += field.getArea() * carrotRevenuePerMeter;
		}
		return revenue - cost;
	}

	public List<Field> getAllGardens() {
		return this.gardens;
	}
}
