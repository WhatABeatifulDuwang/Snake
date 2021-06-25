package Model;

public class Snake {

	private final int DEFAULT_START_X = 4;
	private final int DEFAULT_START_Y = 6;
	private final int BODY_COUNT = 5;
	private BodyPart[] body;
	private int positionX;
	private int positionY;
	
	public Snake() {
		positionX = DEFAULT_START_X;
		positionY = DEFAULT_START_Y;
		body = new BodyPart[BODY_COUNT]; 
	}
	
	public boolean isHead(int x, int y) {
		if (positionX == x && positionY == y) {
			return true;
		}
		
		return false;
	}
	
	public BodyPart[] getBody() {
		return body;
	}
	
	public void setBody(BodyPart[] body) {
		this.body = body;
	}
	
	public void setX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getX() {
		return positionX;
	}
	
	public void setY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getY() {
		return positionY;
	}
}
