package garden.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import garden.model.Field;

public class DBTest {
	@Test
	public void testFindLargetInEmpty() {
		Database db = new Database();
		Field f = db.findLargest();
		assertNull("No field in a empty database", f);
	}
}
