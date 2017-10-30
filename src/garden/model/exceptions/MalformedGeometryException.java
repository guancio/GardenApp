package garden.model.exceptions;

public class MalformedGeometryException extends Exception {
	public MalformedGeometryException(String msg) {
		super("Wrong Geometry " + msg);
	}
}
