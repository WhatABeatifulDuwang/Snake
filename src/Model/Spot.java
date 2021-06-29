package Model;

import java.util.ArrayList;
import java.util.Random;

public class Spot {
	
	private Marker marker;
	private Random random;
	
	private int positionX;
	private int positionY;
	
	public Spot(Marker marker, ArrayList<Integer[]> possibleSpots) {
		this.marker = marker;
		random = new Random();
		int randomNumber = random.nextInt(possibleSpots.size());
		positionX = possibleSpots.get(randomNumber)[0];
		positionY = possibleSpots.get(randomNumber)[1];
	}
	
	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
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
