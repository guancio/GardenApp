package garden.model;

import garden.model.exceptions.MallformedCircleException;

public class CircleField implements Field {
	private float radius;

	public CircleField(float radius) throws MallformedCircleException {
		if (radius < 0) 
			throw new MallformedCircleException();
		this.radius = radius;
	}

	@Override
	public float getPerimeter() {
		return (float) (Math.PI * 2 * radius);
	}

	@Override
	public float getArea() {
		return (float) (Math.PI * radius * radius);
	}

	public float getRadius() {
		return this.radius;
	}
}
