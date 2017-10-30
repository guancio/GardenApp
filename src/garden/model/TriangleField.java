package garden.model;

import garden.model.exceptions.MalformedTriangleException;

public class TriangleField implements Field {
	private float l1;
	private float l2;
	private float l3;

	public TriangleField(float l1, float l2, float l3) throws MalformedTriangleException {
		float p = l1 + l2 + l3;
		if (p/2 < l1) {
			throw new MalformedTriangleException(1);
		}
		else if (p/2 < l2) {
			throw new MalformedTriangleException(2);
		}
		else if (p/2 < l3) {
			throw new MalformedTriangleException(3);
		}
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}
	
	public float getPerimeter()  {
		float p = l1+l2+l3;
		return p;
	}
	public float getArea() {
		float p = getPerimeter()/2;
		float x = p * (p - l1) * (p - l2) * (p - l3);
		return (float) Math.sqrt(x);
	}
	
	public float getL1() {
		return l1;
	}
	public float getL2() {
		return l2;
	}
	public float getL3() {
		return l3;
	}
}
