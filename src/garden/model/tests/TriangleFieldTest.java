package garden.model.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import garden.model.TriangleField;
import garden.model.exceptions.MalformedTriangleException;

public class TriangleFieldTest {
	void goodTriangle(float a , float b, float c) {
		try {
			TriangleField t = new TriangleField(a, b, c);
			assertNotNull("Ok the object is not null", t);
		} catch (MalformedTriangleException e) {
			fail("This was a good triangle");
		}
	}
	@Test
	public void testGoodTriangle1() {
		goodTriangle(1,1,1);
	}
	@Test
	public void testGoodTriangle2() {
		goodTriangle(1.5f,1,1);
	}
	@Test(expected=MalformedTriangleException.class)
	public void testWrongTriangle() throws MalformedTriangleException {
		TriangleField t = new TriangleField(1, 1, 10);
		fail("This triangle was wrong");
	}
	@Test
	public void testWrongTriangle2() {
		try {
			TriangleField t = new TriangleField(1, 1, 10);
			fail("This triangle was wrong");
		} catch (MalformedTriangleException e) {
			assertEquals("The wrong edge is the third one", e.getWrongEdge(), 3);
		}
	}

	@Test
	public void testArea() throws MalformedTriangleException {
		TriangleField t = new TriangleField(1, 1, (float) Math.sqrt(2));
		assertEquals("The area should be 0.5", t.getArea(), 0.6f, 0.001);
	}
}
