package garden.model;

import garden.model.exceptions.MalformedSquareException;

public class SquareField implements Field {
	private float edge;

	public SquareField(float edge) throws MalformedSquareException {
		if (edge < 0)
			throw new MalformedSquareException();
		this.edge = edge;
	}
	
	public float getPerimeter() {
		return 4*edge;
	}
	public float getArea() {
		return edge*edge;
	}

	public float getEdge() {
		return this.edge;
	}
}
