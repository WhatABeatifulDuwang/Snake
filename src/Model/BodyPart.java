package Model;

public class BodyPart {

	private int[][] position;
	private Direction direction;
	
	public BodyPart() {
		
	}
	
	public int[][] getPosition() {
		return position;
	}
	
	public void setPosition(int[][] position) {
		this.position = position;
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
