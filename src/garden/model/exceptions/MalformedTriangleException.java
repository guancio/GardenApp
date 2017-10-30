package garden.model.exceptions;

public class MalformedTriangleException extends MalformedGeometryException {
	int wrongEdge;
	public MalformedTriangleException(int i) {
		super(" Wrong triangle edge: " + i);
		wrongEdge = i;
	}
	
	public int getWrongEdge(){
		return this.wrongEdge;
	}
}
