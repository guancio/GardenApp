package garden.controller;

import java.util.Comparator;

import garden.model.Field;

public class ComparatorByArea implements Comparator<Field> {
	public int compare(Field arg0, Field arg1) {
		float a1 = arg0.getArea();
		float a2 = arg1.getArea();
		if (a1 < a2)
			return 1;
		if (a1 == a2)
			return 0;
		return -1;
	}

}
