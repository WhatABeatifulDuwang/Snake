package Model;

import java.util.Random;

public class Spot {

	private final int MAX_X = 19;
	private final int MAX_Y = 15;
	
	private Marker marker;
	private Random random;
	
	private int positionX;
	private int positionY;
	
	public Spot(Marker marker) {
		this.marker = marker;
		random = new Random();
		positionX = random.nextInt(MAX_X);
		positionY = random.nextInt(MAX_Y);
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
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
