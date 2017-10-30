package garden.model.exceptions;

public class MalformedSquareException extends MalformedGeometryException {
	public MalformedSquareException() {
		super(" negative edge");
	}
}
