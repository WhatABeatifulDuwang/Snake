package Model;

public class Spot {

	private int[][] position;
	private Marker marker;
	
	public Spot(int[][] position, Marker marker) {
		
	}
	
	public int[][] getPosition() {
		return position;
	}
	
	public void setPosition(int[][] position) {
		this.position = position;
	}
	
	public Marker getMarker() {
		return marker;
	}
	
	public void setMarker(Marker marker) {
		switch(marker) {
		case MOUSE:
			this.marker = Marker.MOUSE;
			break;
		case BEAR:
			this.marker = Marker.BEAR;
			break;
		case FIRE:
			this.marker = Marker.FIRE;
			break;
		default:
			break;
		}
	}
}
