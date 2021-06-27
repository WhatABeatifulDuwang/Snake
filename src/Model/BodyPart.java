package Model;

public class BodyPart {

	protected Direction direction;
	
	protected int positionX;
	protected int positionY;
	
	public BodyPart() {
		
	}
	
	public void move() {
		switch(direction) {
		case UP:
			positionY--;			
			break;
		case RIGHT:
			positionX++;
			break;
		case DOWN:
			positionY++;
			break;
		case LEFT:
			positionX--;
			break;
		}
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

	public boolean isPosition(int x, int y) {
		return positionX == x && positionY == y; 
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		switch(direction) {
		case UP:
			this.direction = Direction.UP;
			break;
		case RIGHT:
			this.direction = Direction.RIGHT;
			break;
		case DOWN:
			this.direction = Direction.DOWN;
			break;
		case LEFT:
			this.direction = Direction.LEFT;
			break;
		default:
			break;
		}
	}
}
