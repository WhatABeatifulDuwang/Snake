package Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Spot {

	private final int MAX_X = 19;
	private final int MAX_Y = 15;
	private final List<Marker> TYPES = Collections.unmodifiableList(Arrays.asList());
	
	private Marker marker;
	private Random random;
	
	private int positionX;
	private int positionY;
	
	public Spot() {
		positionX = random.nextInt(MAX_X);
		positionY = random.nextInt(MAX_Y);
		marker = TYPES.get(random.nextInt(TYPES.size()));
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
